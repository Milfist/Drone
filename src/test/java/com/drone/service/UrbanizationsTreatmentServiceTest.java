package com.drone.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UrbanizationsTreatmentServiceTest {

	static final String[][] array3x3 = {
		{"1","2","3"},
		{"4","5","6"},
		{"7","8","9"}
	};

	static final String[][] array5x5 = {
		{"1","2","3","4","5"},
		{"6","7","8","9","10"},
		{"11","12","13","14","15"},
		{"16","17","18","19","20"},
		{"21","22","23","24","25"}
	};

	static final String[][] array8x8 = {
		{"1","2","3","4","5","6","7","8"},
		{"9","10","11","12","13","14","15","16"},
		{"17","18","19","20","21","22","23","24"},
		{"25","26","27","28","29","30","31","32"},
		{"33","34","35","36","37","38","39","40"},
		{"41","42","43","44","45","46","47","48"},
		{"49","50","51","52","53","54","55","56"},
		{"57","58","59","60","61","62","63","64"}
	};

	UrbanizationsTreatmentService service = new UrbanizationsTreatmentServiceImpl();

	@Test
	public void shouldBeOkForSizeArrayAsInteger() {
		String[][] result;
		result = service.createUrbanizationsData(5);
		assertArrayEquals(array5x5, result);
	}

	@Test
	public void shouldReturnCenterOfArray3x3() {
		String result;
		result = service.getCenterOfArray(array3x3);
		assertEquals("5", result);
	}

	@Test
	public void shouldReturnCenterOfArray5x5() {
		String result;
		result = service.getCenterOfArray(array5x5);
		assertEquals("13", result);
	}

	@Test
	public void shouldReturnCenterOfArray8x8() {
		String result;
		result = service.getCenterOfArray(array8x8);
		assertEquals("28", result);
	}


}
