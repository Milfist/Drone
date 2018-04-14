package com.drone.service;

import com.drone.common.Directions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class UrbanizationsTreatmentSimulatedServiceUTest {

	private UrbanizationsTreatmentSimulatedService service;
	private UrbanizationsTreatmentService rService;


	@Before
	public void setup() {
        rService = new UrbanizationsTreatmentSimulatedServiceImpl(3);
	}



/**/
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
		String result = rService.getAdjacent("5", Directions.DOWN);
		assertEquals("8", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForUPDirection() {
		String result = rService.getAdjacent("5", Directions.UP);
		assertEquals("2", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForLEFTDirection() {
		String result = rService.getAdjacent("5", Directions.LEFT);
		assertEquals("4", result);
	}

	@Test
	public void shouldBeOkInGetAdjacentCallForRIGHTDirection() {
		String result = rService.getAdjacent("5", Directions.RIGHT);
		assertEquals("6", result);
	}

	@Ignore
	@Test(expected = IllegalArgumentException.class)
	@PrepareForTest(Directions.class)
	public void shouldBeOkInGetAdjacentCallForOtherDirection() {

		Directions[] origValues = Directions.values();
		Directions invalidValue = PowerMockito.mock(Directions.class);

		Whitebox.setInternalState(invalidValue, "name", "-");
		Whitebox.setInternalState(invalidValue, "ordinal", origValues.length);

		Directions[] newValues = Arrays.copyOf(origValues, origValues.length+1);
		newValues[newValues.length-1] = invalidValue;

		PowerMockito.mockStatic(Directions.class);
		PowerMockito.when(Directions.values()).thenReturn(newValues);

		rService.getAdjacent("5", invalidValue);

	}

	@Test
	public void shouldBeOkInGetPositionByCoordinateCallForAnythingParams() {
		String result = rService.getPositionByCoordinate(null, null);
		assertEquals("5", result);
	}

}
