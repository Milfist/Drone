package com.drone.service;

public interface UrbanizationsTreatmentSimulatedService {

    /**
     * Returns the center of the bidemensional array in case the size is odd. If it is even, it will subtract 1 from the size and treat it as odd.
     * @return the id of the central position
     */
    String getCenterOfArray();

    /**
     * Create a two-dimensional array that simulates the parcels to be explored by a drone.
     * @param size that indicates the number of positions on the x axis and y axis
     * @return a two-dimensional array
     */
    default String[][] createUrbanizationsData(Integer size) {

        String[][] data = new String[size][size];
        Integer id = 1;

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {

                data[x][y] = id.toString();
                id++;
            }
        }
        return data;
    }
}
