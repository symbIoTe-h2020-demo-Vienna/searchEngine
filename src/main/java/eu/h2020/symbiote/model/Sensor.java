package eu.h2020.symbiote.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.List;

/**
 * Created by jawora on 22.09.16.
 */
@Document
public class Sensor extends AbstractSensor {

    @Id
    private String id;
    private Location location;
    private Platform platform;
    private URL resourceURL;

    public Sensor() {
    }

    public Sensor(String name, String owner, String description, Location location, List<String> observedProperties,
                  Platform platform, URL resourceURL) {
        setName(name);
        setOwner(owner);
        setDescription(description);
        this.location = location;
        setObservedProperties(observedProperties);
        this.platform = platform;
        this.resourceURL = resourceURL;
    }

    public Sensor(String id, String name, String owner, String description, Location location,
                  List<String> observedProperties, Platform platform, URL resourceURL) {
        this.id = id;
        setName(name);
        setOwner(owner);
        setDescription(description);
        this.location = location;
        setObservedProperties(observedProperties);
        this.platform = platform;
        this.resourceURL = resourceURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public URL getResourceURL() {
        return resourceURL;
    }

    public void setResourceURL(URL resourceURL) {
        this.resourceURL = resourceURL;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
