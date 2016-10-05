package eu.h2020.symbiote.controller;

import eu.h2020.symbiote.model.Sensor;
import eu.h2020.symbiote.repository.SensorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
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
    private SensorRepositoryImpl sensorRepositoryInterfaceImpl;

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
                                                     @RequestParam(value = "location_point", required = false) GeoJsonPoint locationPoint,
                                                     @RequestParam(value = "max_distance", required = false) Integer maxDistance,
                                                     @RequestParam(value = "observed_property", required = false) String observedProperty
    ) {

        List<Sensor> listOfSensors = sensorRepositoryInterfaceImpl.search(platformId, platformName, owner, name,
                id, description, locationName, locationPoint, maxDistance, observedProperty);

        List<String> listOfResourcesIds = listOfSensors.stream()
                .map(Sensor::getId)
                .collect(Collectors.toList());

        return new ResponseEntity<List<String>>(listOfResourcesIds, HttpStatus.OK);
    }
}
