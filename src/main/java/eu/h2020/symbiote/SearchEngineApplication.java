package eu.h2020.symbiote;

import eu.h2020.symbiote.messaging.MessagingSubscriptions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by mateuszl on 22.09.2016.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SearchEngineApplication {

    private static Log log = LogFactory.getLog(SearchEngineApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SearchEngineApplication.class, args);
        try {
            MessagingSubscriptions.subscribeForSearchService();
        } catch (Exception e) {
            log.error("Error occured during subscribing to search service", e);
        }
    }
}
