package com.drone.service;

import com.drone.common.Directions;

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
     * @see UrbanizationsTreatmentService#getAdjacent(String, Directions)
     */
    @Override
    public String getAdjacent(String urbanizationId, Directions direction) {
        String response = "";
        for (int x = 0; x < this.getSize(); x++) {
            for (int y = 0; y < this.getSize(); y++) {
                if (urbanizationId.equals(this.data[x][y])) {
                    switch (direction) {
                        case UP:
                            response = this.data[x -1][y];
                            break;
                        case DOWN:
                            response = this.data[x + 1][y];
                            break;
                        case LEFT:
                            response = this.data[x][y - 1];
                            break;
                        case RIGHT:
                            response = this.data[x][y + 1];
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return response;
    }

    public Integer getSize() {
        return size;
    }
}
