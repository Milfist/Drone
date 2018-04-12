package com.drone.service;

import com.drone.common.Directions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrbanizationsTreatmentSimulatedServiceTest {

	private UrbanizationsTreatmentSimulatedService service;
	private UrbanizationsTreatmentService rService;

	@Test
	public void shouldReturnCenterOfArray3x3() {
		String result;

		service = new UrbanizationsTreatmentSimulatedServiceImpl(3);

		result = service.getCenterOfArray();
		assertEquals("5", result);
	}

	@Test
	public void shouldReturnCenterOfArray5x5() {
		String result;
		service = new UrbanizationsTreatmentSimulatedServiceImpl(5);
		result = service.getCenterOfArray();
		assertEquals("13", result);
	}

	@Test
	public void shouldReturnCenterOfArray8x8() {
		String result;
		service = new UrbanizationsTreatmentSimulatedServiceImpl(8);
		result = service.getCenterOfArray();
		assertEquals("28", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForDOWNDirection() {
		rService = new UrbanizationsTreatmentSimulatedServiceImpl(3);
		String result = rService.getAdjacent("5", Directions.DOWN);
		assertEquals("8", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForUPDirection() {
		rService = new UrbanizationsTreatmentSimulatedServiceImpl(3);
		String result = rService.getAdjacent("5", Directions.UP);
		assertEquals("2", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForLEFTDirection() {
		rService = new UrbanizationsTreatmentSimulatedServiceImpl(3);
		String result = rService.getAdjacent("5", Directions.LEFT);
		assertEquals("4", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForRIGHTDirection() {
		rService = new UrbanizationsTreatmentSimulatedServiceImpl(3);
		String result = rService.getAdjacent("5", Directions.RIGHT);
		assertEquals("6", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForOtherDirection() {
		rService = new UrbanizationsTreatmentSimulatedServiceImpl(3);
		String result = rService.getAdjacent("5", Directions.DEFAULT);
		assertEquals("", result);
	}

	@Test
	public void shouldBeOkInGetPositionByCoordinateCallForAnythingParams() {
		rService = new UrbanizationsTreatmentSimulatedServiceImpl(3);
		String result = rService.getPositionByCoordinate(null, null);
		assertEquals("5", result);
	}

}
