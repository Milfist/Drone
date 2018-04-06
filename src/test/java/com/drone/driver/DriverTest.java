package com.drone.driver;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import com.drone.common.Directions;

public class DriverTest {
	
	@Mock
	Driver driverMock = new DriverImpl();
	
	Driver driver = new DriverImpl();
	
	Double x = 38.56889;
	Double y = 40.511107;
	
	@Test
	public void testGetUrbanizations() {
		
//		when(driver.getUrbanizationId(x, y)).thenReturn(this.getUrbanizationId5());
//		when(driver.getAdjacent("5", Directions.RIGHT)).thenReturn("6");
//		when(driver.getAdjacent("5", Directions.LEFT)).thenReturn("4");
//		when(driver.getAdjacent("5", Directions.UP)).thenReturn("2");
//		when(driver.getAdjacent("5", Directions.DOWN)).thenReturn("8");
//		when(driver.getAdjacent("2", Directions.RIGHT)).thenReturn("3");
//		when(driver.getAdjacent("2", Directions.LEFT)).thenReturn("1");
//		when(driver.getAdjacent("8", Directions.RIGHT)).thenReturn("9");
//		when(driver.getAdjacent("8", Directions.LEFT)).thenReturn("7");	
		
		String[] datos = driver.getUrbanizations(x, y, 1);
		
	}
	
//	private String[][] getData() {
//		String[][] data = new String[3][3];
//		
//		data[0][0] = "1";
//		data[0][1] = "2";
//		data[0][2] = "3";
//		
//		
//		data[1][0] = "4";
//		data[1][1] = "5";
//		data[1][2] = "6";
//		
//		data[2][0] = "7";
//		data[2][1] = "8";
//		data[2][2] = "9";
//		
//		return data;
//	}

	private String getUrbanizationId5() {
		return "5";
	}

	private String getAdjacentMock(String urbanizationId, Directions direction) {
		
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

}
