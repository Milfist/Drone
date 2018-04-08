package com.drone.driver;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Optional;
import java.util.OptionalDouble;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drone.common.Range;

public class DriverTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	Driver driver = new DriverImpl();

	static final OptionalDouble X = OptionalDouble.of(38.56889);
	static final OptionalDouble Y = OptionalDouble.of(40.511107);
	static final Optional<Range> RANGE = Optional.of(Range.ONE);

	String[] expected = { "7", "8", "9", "12", "13", "14", "17", "18", "19" };

	@Test
	public void shouldBeOkForRangeOne() {

		String[] result;

		result = driver.getUrbanizations(X, Y, RANGE);
		assertArrayEquals(expected, result);

	}

	@Test
	public void shouldBeEmptyArrayWithParan1Empty() {
		String[] result = driver.getUrbanizations(OptionalDouble.empty(), Y, RANGE);
		assertTrue(result.length == 0);
	}

	@Test
	public void shouldBeEmptyArrayWithParan2Empty() throws Exception {
		String[] result = driver.getUrbanizations(X, OptionalDouble.empty(), RANGE);
		assertTrue(result.length == 0);
	}

	@Test
	public void shouldBeEmptyArrayWithParan3Empty() throws Exception {
		String[] result = driver.getUrbanizations(X, Y, Optional.ofNullable(null));
		assertTrue(result.length == 0);
	}

	@Test
	public void shouldBeEmptyArrayWithAllParansEmpty() throws Exception {
		String[] result = driver.getUrbanizations(OptionalDouble.empty(), OptionalDouble.empty(), Optional.ofNullable(null));
		assertTrue(result.length == 0);
	}
	
	@Test(expected = Exception.class)
	public void espectedExceptionWithParam1Null() throws Exception {
		driver.getUrbanizations(null, Y, RANGE);
	}
	
	@Test(expected = Exception.class)
	public void espectedExceptionWithParam2Null() throws Exception {
		driver.getUrbanizations(X, null, RANGE);
	}
	
	@Test(expected = Exception.class)
	public void espectedExceptionWithParam3Null() throws Exception {
		driver.getUrbanizations(X, Y, null);
	}
	@Test(expected = Exception.class)
	public void espectedExceptionWithAllParamsNull() throws Exception {
		driver.getUrbanizations(null, null, null);
	}
}
