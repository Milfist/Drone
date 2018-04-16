package com.drone.service;

import com.drone.common.Directions;

import java.util.Arrays;

/**
 * Interface UrbanizationsTreatmentService implementation.
 * This service, that we will add by composition to the implementation of the driver, simulates all the logic that an
 * authentic service should do that it will consult by coordinates in GoogleMaps or something similar.
 */
public class UrbanizationsTreatmentSimulatedServiceImpl implements UrbanizationsTreatmentService, UrbanizationsTreatmentSimulatedService {

    private String[][] data;
    private Integer size;

    /**
     * Class constructor
     * @param size of the x-axis and y-axis of the simulated array.
     */
    public UrbanizationsTreatmentSimulatedServiceImpl(Integer size) {
        this.data = this.createUrbanizationsData(size);
        this.size = size;
    }

    /**
     * @see UrbanizationsTreatmentSimulatedService#getCenterOfArray()
     */
    @Override
    public String getCenterOfArray() {
        return data.length%2 == 0 ? data[data.length/2 -1][data.length/2 -1] : data[data.length/2][data.length/2];
    }

    /**
     * @see UrbanizationsTreatmentService#getPositionByCoordinate(Double, Double)
     */
    @Override
    public String getPositionByCoordinate(Double coordinateX, Double coordinateY) {
        return this.getCenterOfArray();
    }

    /**
     * @see UrbanizationsTreatmentService#getAdjacent(String, String)
     */
    @Override
    public String getAdjacent(String urbanizationId, String direction) {

        String r = "";
        loop:
        for (int x = 0; x < this.getSize(); x++) {
            for (int y = 0; y < this.getSize(); y++) {
                if (urbanizationId.equals(this.data[x][y])) {
                    switch (direction) {
                        case "UP":
                            r = this.data[x -1][y];
                            break loop;
                        case "DOWN":
                            r = this.data[x + 1][y];
                            break loop;
                        case "LEFT":
                            r = this.data[x][y - 1];
                            break loop;
                        case "RIGHT":
                            r = this.data[x][y + 1];
                            break loop;
                        default:
                            throw new IllegalArgumentException("unhandled enum value: " + direction);
                    }
                }
            }
        }
        return r;
    }

    public Integer getSize() {
        return size;
    }
}
