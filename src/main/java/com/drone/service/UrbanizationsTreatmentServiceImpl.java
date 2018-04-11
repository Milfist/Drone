package com.drone.service;

import org.springframework.stereotype.Service;

/**
 * Interface UrbanizationsTreatmentService implementation
 */
@Service
public class UrbanizationsTreatmentServiceImpl implements UrbanizationsTreatmentService {

    @Override
    public String getCenterOfArray(String[][] data) {
        return data.length%2 == 0 ? data[data.length/2 -1][data.length/2 -1] : data[data.length/2][data.length/2];
    }


}
