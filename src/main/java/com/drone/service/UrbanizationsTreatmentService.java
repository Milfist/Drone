package com.drone.service;

import com.drone.common.Directions;

public interface UrbanizationsTreatmentService {

    /**
     * Given an identifier and adjacency address returns the identifier of the adjacent urbanization.
     *
     * @param urbanizationId urbanization identifier
     * @param direction address in which the adjacent urbanization is located
     * @return The identifier of the urbanization corresponding to the coordinates
     */
    String getAdjacent(String urbanizationId, Directions direction);

    /**
     * Simulates a call by which a position is obtained based on coordinates.
     * @param X axis coordinate
     * @param Y axis coordinate
     * @return the result of the call obtained by the center of a two-dimensional array
     */
    String getPositionByCoordinate(Double X, Double Y);

}
