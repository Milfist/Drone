package com.drone.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrbanizationsTreatmentServiceUT {

	private UrbanizationsTreatmentService service = new UrbanizationsTreatmentServiceImpl();

	@Test
	public void shouldBeOkInGetAdjacentCallForAnythingParams() {
		String result = service.getAdjacent(null, null);
		assertEquals(null, result);
	}

	@Test
	public void shouldBeOkInGetPositionByCoordinateCallForAnythingParams() {
		String result = service.getPositionByCoordinate(null, null);
		assertEquals(null, result);
	}
}
