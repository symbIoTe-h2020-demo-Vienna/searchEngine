package eu.h2020.symbiote.controller;

import eu.h2020.symbiote.model.Sensor;

import java.util.List;

/**
 * Created by mateuszl on 22.09.2016.
 */
public interface QueryInterface {

    @org.springframework.data.mongodb.repository.Query("{'platform.id' : ?0 }")
    List<Sensor> findSensorByPlatformId(String platformId);



}
