package com.drone.driver;

import com.drone.common.Directions;

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
	 * @param coordinateX
	 * @param coordinateY
	 * @return the identifier of the urbanization corresponding to the coordinates.
	 */
	public String getUrbanizationId(Double coordinateX, Double coordinateY);
	
	/**
	 * Given an identifier and adjacency address returns the identifier of the adjacent urbanization.
	 * 
	 * @param id
	 * @param direction
	 * @return The identifier of the urbanization corresponding to the coordinates 
	 */
	public String getAdjacent(String urbanizationId, Directions direction);
	
	/**
	 * Given some coordinates and a range, it returns us the identifier of all the urbanizations that should visit the drone.
	 * 
	 * @param coordinateX
	 * @param coordinateY
	 * @param range
	 * @return the identifier of the urbanization that corresponds with the address and urbanization identifier.
	 */
	public String[] getUrbanizations(Double coordinateX, Double coordinateY, Integer range);
}
