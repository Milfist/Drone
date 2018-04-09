package com.drone.common;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class RangeTest {

	final static Integer ONE = 1;
	final static Integer TWO = 1;
	
	@Test
	void shouldBeReturnAllDirections() {
		assertEquals(ONE, Range.ONE.getValue());
		assertEquals(TWO, Range.TWO.getValue());			
	}

}
