package com.drone.driver;

import com.drone.common.Directions;
import com.drone.common.Range;
import com.drone.service.UrbanizationsTreatmentService;
import com.drone.service.UrbanizationsTreatmentServiceImpl;
import com.drone.service.UrbanizationsTreatmentSimulatedServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DriverTest {

	private static final Double X = 38.56889;
	private static final Double Y = 40.511107;
	private static final Range RANGE = Range.ONE;
	private static final String POSITION = "1";
	private UrbanizationsTreatmentService realServiceMock = mock(UrbanizationsTreatmentServiceImpl.class);
	private UrbanizationsTreatmentService simulatedServiceMock = mock(UrbanizationsTreatmentSimulatedServiceImpl.class);
	private Driver realDriver;
	private Driver simulatedDriver;

	@Before
	public void setup() {
		realDriver = new DriverImpl(realServiceMock);
		simulatedDriver = new DriverImpl(simulatedServiceMock);
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationsWithRealService() {

		when(realServiceMock.getPositionByCoordinate(anyDouble(), anyDouble())).thenReturn(POSITION);
		when(realServiceMock.getAdjacent(anyString(), any(Directions.class))).thenReturn(POSITION);

		String[] result = this.realDriver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.of(Y), Optional.of(RANGE));

		assertNotNull(result);
		assertTrue(result instanceof String[]);

	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationsWithSimulatedService() {

		when(simulatedServiceMock.getPositionByCoordinate(anyDouble(), anyDouble())).thenReturn(POSITION);
		when(simulatedServiceMock.getAdjacent(anyString(), any(Directions.class))).thenReturn(POSITION);

		String[] result = this.simulatedDriver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.of(Y), Optional.of(RANGE));

		assertNotNull(result);
		assertTrue(result instanceof String[]);
	}

	@Test
	public void shouldBeEmptyArrayWhenCallToGetUrbanizationsWithParam1Empty() {
		String[] result = realDriver.getUrbanizations(OptionalDouble.empty(), OptionalDouble.of(Y), Optional.of(RANGE));
		assertTrue(result.length == 0);
	}

	@Test
	public void shouldBeEmptyArrayWhenCallToGetUrbanizationsWithParam2Empty() {
		String[] result = realDriver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.empty(), Optional.of(RANGE));
		assertTrue(result.length == 0);
	}

	@Test
	public void shouldBeEmptyArrayWhenCallToGetUrbanizationsWithParam3Empty() {
		String[] result = realDriver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.of(Y), Optional.empty());
		assertTrue(result.length == 0);
	}

	@Test
	public void shouldBeEmptyArrayWhenCallToGetUrbanizationsWithAllParamsEmpty() {
		String[] result = realDriver.getUrbanizations(OptionalDouble.empty(), OptionalDouble.empty(), Optional.empty());
		assertTrue(result.length == 0);
	}

	@Test
	public void shouldBeOkWhenCallToGetAdjacentWithRealService() {
		when(realServiceMock.getAdjacent(anyString(), any(Directions.class))).thenReturn(POSITION);
		String result = this.realDriver.getAdjacent("13", Directions.RIGHT);
		assertEquals(POSITION, result);
	}

	@Test
	public void shouldBeOkWhenCallToGetAdjacentWithSimulatedService() {
		when(simulatedServiceMock.getAdjacent(anyString(), any(Directions.class))).thenReturn(POSITION);
		String result = this.simulatedDriver.getAdjacent("13", Directions.RIGHT);
		assertEquals(POSITION, result);
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationIdWithRealService() {
		when(realServiceMock.getPositionByCoordinate(anyDouble(), anyDouble())).thenReturn(POSITION);
		String result = this.realDriver.getUrbanizationId(X, Y);
		assertEquals(POSITION, result);
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationIdWithSimulatedService() {
		when(simulatedServiceMock.getPositionByCoordinate(anyDouble(), anyDouble())).thenReturn(POSITION);
		String result = this.simulatedDriver.getUrbanizationId(X, Y);
		assertEquals(POSITION, result);
	}

}
