package com.drone.common;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class DirectionsTest {

	final static String UP = "UP";
	final static String DOWN = "DOWN";
	final static String RIGHT = "RIGHT";
	final static String LEFT = "LEFT";
	
	@Test
	void shouldBeReturnAllDirections() {
		assertEquals(DOWN, Directions.DOWN.getValue());
		assertEquals(UP, Directions.UP.getValue());
		assertEquals(RIGHT, Directions.RIGHT.getValue());
		assertEquals(LEFT, Directions.LEFT.getValue());				
	}

}
