package eu.h2020.symbiote.model;

/**
 * Created by mateuszl on 07.10.2016.
 */
public class SensorFactory {

    public static SensorResponse createResponseFromSensor (Sensor sensor) {

        SensorResponse responseSensor = new SensorResponse(sensor.getId(), sensor.getName(), sensor.getOwner(),
                sensor.getDescription(), sensor.getObservedProperties(), sensor.getPlatform().getId(),
                sensor.getPlatform().getName(), sensor.getLocation().getName(), sensor.getLocation().getPoint().getY(),
                sensor.getLocation().getPoint().getX(), sensor.getLocation().getAltitude());

        return responseSensor;
    }
}
