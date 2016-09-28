package eu.h2020.symbiote.controller;

import eu.h2020.symbiote.model.Platform;
import eu.h2020.symbiote.model.Sensor;
import eu.h2020.symbiote.repository.PlatformRepository;
import eu.h2020.symbiote.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mateuszl on 22.09.2016.
 */
@CrossOrigin
@RestController
public class ResourceController {

    @Autowired
    private PlatformRepository platformRepo;

    @Autowired
    private SensorRepository sensorRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/core_api/platforms/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    HttpEntity<Platform> findPlatform(@PathVariable(value = "id") String platformId) {

        Platform foundPlatform = platformRepo.findOne(platformId);

        System.out.println("Response send with id: " + foundPlatform.getId());

        return new ResponseEntity<Platform>(foundPlatform, HttpStatus.OK);
    }

    @RequestMapping(value = "/core_api/platforms/{id}/sensors", method = RequestMethod.GET)
    public
    @ResponseBody
    HttpEntity<List<Sensor>> findSensors(@PathVariable(value = "id") String platformId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("platform.id").is(platformId));

        List<Sensor> foundSensors = mongoTemplate.find(query, Sensor.class);

        System.out.println("Response send! Found sensors: ");
        System.out.println(foundSensors);
        return new ResponseEntity<List<Sensor>>(foundSensors, HttpStatus.OK);
    }

//    @RequestMapping(value = {"sensor", "/platform", "/core_api/sensors", "/core_api/platforms", "/core_api"})
//    public
//    @ResponseBody
//    HttpEntity<String> error() {
//        String message = "Method not allowed";
//        return new ResponseEntity<String>(message, HttpStatus.METHOD_NOT_ALLOWED);
//    }
}
