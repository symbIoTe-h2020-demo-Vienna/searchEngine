package eu.h2020.symbiote.controller;

import eu.h2020.symbiote.model.Sensor;
import eu.h2020.symbiote.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mateuszl on 26.09.2016.
 */

@CrossOrigin
@RestController
public class QueryController {

    @Autowired
    private SensorRepository sensorRepo;

    @RequestMapping(value = "/core_api/resources", method = RequestMethod.GET)
    public
    @ResponseBody
    HttpEntity<List<String>> queryResourcesWithParams(@RequestParam(value = "platform_id", required = false) String platform_id,
                                                      @RequestParam(value = "owner", required = false) String owner,
                                                      @RequestParam(value = "name", required = false) String name
    ) {

        List<String> listOfResourcesIds = new ArrayList<>();
        List<Sensor> listOfSensors = new ArrayList<>();
        List<Sensor> listOfPossibleSensors = new ArrayList<>();

        if (platform_id != null) {
            if (listOfSensors.isEmpty()) {
                listOfSensors.addAll(sensorRepo.findByPlatformId(platform_id));
                listOfResourcesIds = getSensorsIds(listOfSensors);
                System.out.println(listOfSensors);
            }
        }
        if (owner != null) {
            if (listOfSensors.isEmpty()) {
                System.out.println("111111111111111111");
                listOfSensors.addAll(sensorRepo.findByOwner(owner));
                listOfResourcesIds = getSensorsIds(listOfSensors);
            } else {
                listOfPossibleSensors.addAll(sensorRepo.findByOwner(owner));
                System.out.println(sensorRepo.findByOwner(owner));
            }
        }
        if (name != null) {
            if (listOfSensors.isEmpty())
                listOfSensors.addAll(sensorRepo.findByName(name));
            else
                listOfSensors.retainAll(sensorRepo.findByName(name));
        }

        return new ResponseEntity<List<String>>(listOfResourcesIds, HttpStatus.OK);
    }

    private List<String> getSensorsIds(List<Sensor> listOfSensors) {
        return listOfSensors.stream()
                .map(Sensor::getId)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/core_api2/resources", method = RequestMethod.GET)
    public
    @ResponseBody
    HttpEntity<List<String>> queryResourcesWithParams2(@RequestParam(value = "platform_id", required = false) String platform_id,
                                                      @RequestParam(value = "owner", required = false) String owner,
                                                      @RequestParam(value = "name", required = false) String name
    ) {

        List<String> listOfResourcesIds = new ArrayList<>();



        return new ResponseEntity<List<String>>(listOfResourcesIds, HttpStatus.OK);
    }
}

