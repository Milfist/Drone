package com.drone.service;

public interface UrbanizationsTreatmentService {

    /**
     * Given an identifier and adjacency address returns the identifier of the adjacent urbanization.
     *
     * @param urbanizationId urbanization identifier
     * @param direction address in which the adjacent urbanization is located
     * @return The identifier of the urbanization corresponding to the coordinates
     */
    String getAdjacent(String urbanizationId, String direction);

    /**
     * Simulates a call by which a position is obtained based on coordinates.
     * @param coordinateX axis coordinate
     * @param coordinateY axis coordinate
     * @return the result of the call obtained by the center of a two-dimensional array
     */
    String getPositionByCoordinate(Double coordinateX, Double coordinateY);

}
