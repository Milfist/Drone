package com.drone;

import com.drone.common.Range;
import com.drone.driver.Driver;
import com.drone.driver.DriverImpl;
import com.drone.service.UrbanizationsTreatmentServiceImpl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Driver driver = new DriverImpl(new UrbanizationsTreatmentServiceImpl(), 9);

        String[] result = driver.getUrbanizations(OptionalDouble.of(40.00), OptionalDouble.of(40.00), Optional.of(Range.TWO));

        Arrays.stream(result).forEach(System.out::println);

    }
}
