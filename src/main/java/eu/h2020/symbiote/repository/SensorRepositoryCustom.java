package eu.h2020.symbiote.repository;

import eu.h2020.symbiote.model.Sensor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.List;

/**
 * Created by mateuszl on 28.09.2016.
 */
public interface SensorRepositoryCustom {

    List<Sensor> search(String platformId, String platformName, String owner, String name, String id,
                        String description, String locationName, GeoJsonPoint locationPoint, Integer maxDistance, String observedProperty);
}