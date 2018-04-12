package com.drone.driver;

import com.drone.common.Directions;
import com.drone.service.UrbanizationsTreatmentService;

/**
 * @see com.drone.driver.Driver
 */
public class DriverImpl implements Driver {

    private UrbanizationsTreatmentService service;

    /**
     * Driver class constructor
     * @param service instance of the service to be used. It can be a simulated or real service.
     */
    public DriverImpl(UrbanizationsTreatmentService service) {
        this.service = service;
    }

    /**
     * @see Driver#getUrbanizationId(Double, Double)
     */
    public String getUrbanizationId(Double coordinateX, Double coordinateY) {
        return this.service.getPositionByCoordinate(coordinateX, coordinateY);
    }

    /**
     * @see Driver#getAdjacent(String, Directions)
     */
    public String getAdjacent(String urbanizationId, Directions direction) {
        return this.service.getAdjacent(urbanizationId,direction);
    }
}
