package com.drone.service;

import com.drone.common.Directions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class UrbanizationsTreatmentSimulatedServiceUTest {

	private UrbanizationsTreatmentSimulatedService service;
	private UrbanizationsTreatmentService rService;

	@Before
	public void setup() {
        rService = new UrbanizationsTreatmentSimulatedServiceImpl(3);
	}

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
		String result = rService.getAdjacent("5", Directions.DOWN.getValue());
		assertEquals("8", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForUPDirection() {
		String result = rService.getAdjacent("5", Directions.UP.getValue());
		assertEquals("2", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForLEFTDirection() {
		String result = rService.getAdjacent("5", Directions.LEFT.getValue());
		assertEquals("4", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForRIGHTDirection() {
		String result = rService.getAdjacent("5", Directions.RIGHT.getValue());
		assertEquals("6", result);
	}

	@Test
	public void shouldBeEmptyInGetAdjacentCallWithValuesOutOfData() {
		String result = rService.getAdjacent("15", "OTHER");
		assertSame("", result);
	}

	@Test
	public void shouldBeOkInGetPositionByCoordinateCallForAnythingParams() {
		String result = rService.getPositionByCoordinate(null, null);
		assertEquals("5", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldBeIllegalArgumentExceptionInGetAdjacentCallForOtherDirection() {
		rService.getAdjacent("5", "OTHER");
	}

}
