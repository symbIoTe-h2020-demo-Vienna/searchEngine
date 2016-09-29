package eu.h2020.symbiote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mateuszl on 22.09.2016.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SearchEngineApplication {

    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Config.xml");

    public static void main(String[] args) {
        SpringApplication.run(SearchEngineApplication.class, args);
    }
}
