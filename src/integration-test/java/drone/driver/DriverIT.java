package drone.driver;

import com.drone.common.Range;
import com.drone.driver.Driver;
import com.drone.driver.DriverImpl;
import com.drone.service.UrbanizationsTreatmentSimulatedServiceImpl;
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.Assert.*;

public class DriverIT {

	private static final Double COORDINATE_X = 38.56889;
	private static final Double COORDINATE_Y = 40.511107;
	private static final String[] EXPECTED_1 = {"7", "8", "9", "12", "13", "14", "17", "18", "19"};

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationsWithRealService() {

		Driver driver = new DriverImpl(new UrbanizationsTreatmentSimulatedServiceImpl(5));

		String[] result = driver.getUrbanizations(OptionalDouble.of(COORDINATE_X), OptionalDouble.of(COORDINATE_Y), Optional.of(Range.ONE));

		assertNotNull(result);
		assertArrayEquals(EXPECTED_1, result);

	}
}
