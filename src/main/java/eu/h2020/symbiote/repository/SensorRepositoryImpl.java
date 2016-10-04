package eu.h2020.symbiote.repository;

import eu.h2020.symbiote.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mateuszl on 28.09.2016.
 */
@Repository
public class SensorRepositoryImpl implements SensorRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Sensor> search(String platformId, String platformName, String owner, String name, String id,
                               String description, String locationName, String observedProperty) {

        Query query = new Query();

        if (platformId != null) {
            query.addCriteria(Criteria.where("platform.id").is(platformId));
        }
        if (platformName != null) {
            query.addCriteria(Criteria.where("platform.name").is(platformName));
        }
        if (owner != null) {
            query.addCriteria(Criteria.where("owner").is(owner));
        }
        if (name != null) {
            query.addCriteria(Criteria.where("name").is(name));
        }
        if (id != null) {
            query.addCriteria(Criteria.where("id").is(id));
        }
        if (description != null) {
            query.addCriteria(Criteria.where("description").is(description));
        }
        if (locationName != null) {
            query.addCriteria(Criteria.where("location.name").is(locationName));
        }
        if (observedProperty != null) {
            query.addCriteria(Criteria.where("observedProperties").in(observedProperty));
        }

        query.fields().include("_id");
        List<Sensor> listOfSensors = mongoTemplate.find(query, Sensor.class);
        return listOfSensors;
    }
}
