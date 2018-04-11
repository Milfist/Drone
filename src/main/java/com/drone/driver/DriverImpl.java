package com.drone.driver;

import com.drone.common.Directions;
import com.drone.service.UrbanizationsTreatmentService;

/**
 * @see com.drone.driver.Driver
 */
public class DriverImpl implements Driver {

    private UrbanizationsTreatmentService service;
    private String[][] totalUrbanizations;
    private Integer size;

    public DriverImpl(UrbanizationsTreatmentService service, Integer size) {
        this.service = service;
        this.totalUrbanizations = service.createUrbanizationsData(size);
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    /**
     * @see com.drone.driver.Driver#getUrbanizationId()
     *
     * We do not use the coordinates at the moment
     *
     */
    public String getUrbanizationId(Double coordinateX, Double coordinateY) {
        return this.service.getCenterOfArray(this.totalUrbanizations);
    }

    /**
     * @see com.drone.driver.Driver#getAdjacent()
     */
    public String getAdjacent(String urbanizationId, Directions direction) {

        String r = "";

        for (int x = 0; x < this.getSize(); x++) {
            for (int y = 0; y < this.getSize(); y++) {

                if (urbanizationId.equals(this.totalUrbanizations[x][y])) {

                    if (direction.equals(Directions.UP))
                        r = this.totalUrbanizations[x -1][y];
                    if (direction.equals(Directions.DOWN))
                        r = this.totalUrbanizations[x + 1][y];
                    if (direction.equals(Directions.LEFT))
                        r = this.totalUrbanizations[x][y - 1];
                    if (direction.equals(Directions.RIGHT))
                        r = this.totalUrbanizations[x][y + 1];
                }
            }
        }
        return r;
    }
}
