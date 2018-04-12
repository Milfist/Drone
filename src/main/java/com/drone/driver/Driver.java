package com.drone.driver;

import java.util.*;

import com.drone.common.Directions;
import com.drone.common.Range;

/**
 * driver for a drone (vehicle unmanned aerial) to fly over a set of developments with the aim of
 * know how many chalets have a pool.
 * @author mAnguita
 *
 */
public interface Driver {

	/**
	 * Given some coordinates, return the identifier of the urbanization in which they are enclosed coordinates.
	 * 
	 * @param coordinateX coordinate on the x axis
	 * @param coordinateY coordinate on the y axis
	 * @return the identifier of the urbanization corresponding to the coordinates.
	 */
	String getUrbanizationId(Double coordinateX, Double coordinateY);
	
	/**
	 * Given an identifier and adjacency address returns the identifier of the adjacent urbanization.
	 * 
	 * @param urbanizationId urbanization identifier
	 * @param direction address in which the adjacent urbanization is located
	 * @return The identifier of the urbanization corresponding to the coordinates 
	 */
	String getAdjacent(String urbanizationId, Directions direction);
	
	/**
	 * Given some coordinates and a range, it returns us the identifier of all the urbanizations that should visit the drone.
	 * 
	 * @param coordinateX coordinate on the x axis
	 * @param coordinateY coordinate on the y axis
	 * @param range number that indicates the search range
	 * @return the identifier of the urbanization that corresponds with the address and urbanization identifier.
	 * @throws Exception 
	 */
	default String[] getUrbanizations(OptionalDouble coordinateX, OptionalDouble coordinateY, Optional <Range> range) {

		List<String> urbanizations = new ArrayList<>();
		
		if (coordinateX.isPresent() && coordinateY.isPresent() && range.isPresent()) {

			String urbanizationId = this.getUrbanizationId(coordinateX.getAsDouble(), coordinateY.getAsDouble());

			urbanizations.add(urbanizationId);
	
			for (Directions dir : Directions.values()) {
				this.getUrbanizationsForDirectionAndRange(urbanizationId, urbanizations, dir, range.get());
			}
			
		}
		 
		return urbanizations.stream().sorted(Comparator.comparing(Integer::valueOf)).toArray(String[]::new);
	}

	/**
	 * Algorithm that looks for the number of urbanizations in the given address and adds them to the list of urbanizations for the drone.
	 *
	 * @param urbanizationId urbanization identifier
	 * @param urbanizations list of urbanizations to explore
	 * @param direction address in which the adjacent urbanization is located
	 * @param range number that indicates the search range
	 */
	private void getUrbanizationsForDirectionAndRange(String urbanizationId, List<String> urbanizations, Directions direction, Range range) {

		String aux;

		for (int i = 0; i < range.getValue(); i++) {
			aux = this.getAdjacent(urbanizationId, direction);
			urbanizations.add(aux);
			if (direction.equals(Directions.UP) || direction.equals(Directions.DOWN)) {
				this.getUrbanizationsForDirectionAndRange(aux, urbanizations, Directions.LEFT, range);
				this.getUrbanizationsForDirectionAndRange(aux, urbanizations, Directions.RIGHT, range);
			}
			urbanizationId = aux;
		}
	}
}
