package eu.h2020.symbiote.controller;

import eu.h2020.symbiote.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mateuszl on 26.09.2016.
 */

@CrossOrigin
@RestController
public class QueryController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/core_api/resources", method = RequestMethod.GET)
    public
    @ResponseBody
    HttpEntity<List<String>> searchResourcesByParams(@RequestParam(value = "platform_id", required = false) String platformId,
                                                     @RequestParam(value = "platform_name", required = false) String platformName,
                                                     @RequestParam(value = "owner", required = false) String owner,
                                                     @RequestParam(value = "name", required = false) String name,
                                                     @RequestParam(value = "id", required = false) String id,
                                                     @RequestParam(value = "description", required = false) String description,
                                                     @RequestParam(value = "location_name", required = false) String locationName,
                                                     @RequestParam(value = "observed_property", required = false) String observedProperty
    ) {
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
            query.addCriteria(Criteria.where("observed_property").is(observedProperty));
        }

        List<Sensor> listOfSensors = mongoTemplate.find(query, Sensor.class);

        List<String> listOfResourcesIds = getSensorsIds(listOfSensors);
        return new ResponseEntity<List<String>>(listOfResourcesIds, HttpStatus.OK);
    }

    private List<String> getSensorsIds(List<Sensor> listOfSensors) {
        return listOfSensors.stream()
                .map(Sensor::getId)
                .collect(Collectors.toList());
    }
}
