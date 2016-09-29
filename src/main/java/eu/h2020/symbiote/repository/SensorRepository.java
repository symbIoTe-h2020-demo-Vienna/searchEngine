package eu.h2020.symbiote.repository;

import eu.h2020.symbiote.model.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mateuszl on 22.09.2016.
 */

@RepositoryRestResource(collectionResourceRel = "sensor", path = "sensor")
public interface SensorRepository extends MongoRepository<Sensor, String>, SensorRepositoryCustom {

    @Query("{'platform.id' : ?0 }")
    public List<Sensor> findByPlatformId(@Param("platform_id") String platformId);

    @Query("{'owner' : ?0 }")
    public List<Sensor> findByOwner(@Param("owner") String owner);

    @Query("{'name' : ?0 }")
    public List<Sensor> findByName(@Param("name") String name);

    @Query("{'platform.name' : ?0 }")
    public List<Sensor> findByPlatformName(@Param("platform_name") String platformName);

    @Query("{'id' : ?0 }")
    public List<Sensor> findById(@Param("id") String id);

    @Query("{'description' : ?0 }")
    public List<Sensor> findByDescription(@Param("description") String description);

    @Query("{'location.name' : ?0 }")
    public List<Sensor> findByLocation(@Param("location_name") String location);
    //TODO search by location fields (GeoJson maybe)

    @Query("{'observedProperty' : ?0 }")
    public List<Sensor> findByObservedProperty(@Param("observed_property") String observedProperty);

}