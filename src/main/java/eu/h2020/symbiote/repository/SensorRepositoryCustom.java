package eu.h2020.symbiote.repository;

import eu.h2020.symbiote.model.Sensor;

import java.util.List;

/**
 * Created by mateuszl on 28.09.2016.
 */
public interface SensorRepositoryCustom {

    List<Sensor> search(String platformId, String platformName, String owner, String name, String id,
                        String description, String locationName, String observedProperty);
}