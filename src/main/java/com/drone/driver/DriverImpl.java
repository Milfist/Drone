package com.drone.driver;

import java.util.ArrayList;
import java.util.List;

import com.drone.common.Directions;

/**
 * @see com.drone.driver.Driver
 */
public class DriverImpl implements Driver {
	
	/**
	 * @see com.drone.driver.Driver#getUrbanizationId()
	 */
	public String getUrbanizationId(Double coordinateX, Double coordinateY) {
		return "5";
	}

	/**
	 * @see com.drone.driver.Driver#getAdjacent()
	 */
	public String getAdjacent(String urbanizationId, Directions direction) {
		
		String r = "";
		
		if (urbanizationId.equals("5") && direction.equals(Directions.LEFT)) {
			r = "4";
		} else if (urbanizationId.equals("5") && direction.equals(Directions.RIGHT)) {
			r = "6";
		} else if (urbanizationId.equals("5") && direction.equals(Directions.UP)) {
			r = "2";
		} else if (urbanizationId.equals("5") && direction.equals(Directions.DOWN)) {
			r = "8";
		} else if (urbanizationId.equals("2") && direction.equals(Directions.RIGHT)) {
			r = "3";
		} else if (urbanizationId.equals("2") && direction.equals(Directions.LEFT)) {
			r = "1";
		} else if (urbanizationId.equals("8") && direction.equals(Directions.RIGHT)) {
			r = "9";
		} else if (urbanizationId.equals("8") && direction.equals(Directions.LEFT)) {
			r = "7";
		}  
		
		return r;  
	}

	/**
	 * @see com.drone.driver.Driver#getUrbanizations()
	 */
	public String[] getUrbanizations(Double coordinateX, Double coordinateY, Integer range) {

		List<String> urbanizations = new ArrayList<String>();
		
		String urbanizationId = this.getUrbanizationId(coordinateX, coordinateY);
		
		urbanizations.add(urbanizationId);
		
		this.getUrbanizationsForDirectionAndRange(urbanizationId, urbanizations, Directions.LEFT, range);
		this.getUrbanizationsForDirectionAndRange(urbanizationId, urbanizations, Directions.RIGHT, range);
		this.getUrbanizationsForDirectionAndRange(urbanizationId, urbanizations, Directions.UP, range);
		this.getUrbanizationsForDirectionAndRange(urbanizationId, urbanizations, Directions.DOWN, range);
		
		String[] urbanizationsArr = new String[urbanizations.size()];
		
		return urbanizations.toArray(urbanizationsArr);
	}	
	
	/**
	 * Algorithm that looks for the number of urbanizations in the given address and adds them to the list of urbanizations for the drone.
	 * 
	 * @param urbanizationId
	 * @param urbanizations
	 * @param direction
	 * @param range 
	 */
	private void getUrbanizationsForDirectionAndRange(String urbanizationId, List<String> urbanizations, Directions direction, Integer range) {
		
		String aux;
		
		for (int i = 0; i < range; i++) {		
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
