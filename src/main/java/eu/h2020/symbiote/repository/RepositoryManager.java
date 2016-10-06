package eu.h2020.symbiote.repository;

import eu.h2020.symbiote.model.Platform;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by mateuszl on 04.10.2016.
 *
 * for future use
 *
 */
@Component
public class RepositoryManager {

    private static Log log = LogFactory.getLog(RepositoryManager.class);

    private static PlatformRepository platformRepository;

    @Autowired
    public RepositoryManager(PlatformRepository platformRepository){
        Assert.notNull(platformRepository, "Platform repository can not be nulL!");
        this.platformRepository=platformRepository;
    }

    public static void saveToDatabase(Platform platform) {
        platformRepository.save(platform);
        log.info("Platform saved!");
    }
}
