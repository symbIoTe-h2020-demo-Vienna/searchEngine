package eu.h2020.symbiote.repository;

import eu.h2020.symbiote.model.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mateuszl on 22.09.2016.
 */

@RepositoryRestResource(collectionResourceRel = "sensor", path = "sensor")
public interface SensorRepository extends MongoRepository<Sensor, String>,
        QueryDslPredicateExecutor<Sensor> {

    @Query("{'platform.id' : ?0 }")
    public List<Sensor> findByPlatformId(String platformId);

    @Query("{'owner' : ?0 }")
    public List<Sensor> findByOwner (String owner);

    @Query("{'name' : ?0 }")
    public List<Sensor> findByName (String name);
}
