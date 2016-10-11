package eu.h2020.symbiote.model;

import java.util.List;

/**
 * Created by mateuszl on 07.10.2016.
 */
public class SensorResponse extends AbstractSensor {

    private String id;
    private String platformId;
    private String platformName;
    private String locationName;
    private Double locationLatitude;
    private Double locationLongitude;
    private Double locationAltitude;

    public SensorResponse() {
    }

    public SensorResponse(String name, String owner, String description, List<String> observedProperties, String platformId, String platformName, String locationName, Double locationLatitude, Double locationLongitude, Double locationAltitude) {
        setName(name);
        setOwner(owner);
        setDescription(description);
        setObservedProperties(observedProperties);
        this.platformId = platformId;
        this.platformName = platformName;
        this.locationName = locationName;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationAltitude = locationAltitude;
    }

    public SensorResponse(String id, String name, String owner, String description, List<String> observedProperties, String platformId, String platformName, String locationName, Double locationLatitude, Double locationLongitude, Double locationAltitude) {
        this.id = id;
        setName(name);
        setOwner(owner);
        setDescription(description);
        setObservedProperties(observedProperties);
        this.platformId = platformId;
        this.platformName = platformName;
        this.locationName = locationName;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationAltitude = locationAltitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public Double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public Double getLocationAltitude() {
        return locationAltitude;
    }

    public void setLocationAltitude(Double locationAltitude) {
        this.locationAltitude = locationAltitude;
    }
}
