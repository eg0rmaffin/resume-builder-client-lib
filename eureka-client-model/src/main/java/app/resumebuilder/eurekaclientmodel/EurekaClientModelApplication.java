package app.resumebuilder.eurekaclientmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * doc about class
 */
@Profile("dev")
@SpringBootApplication
public class EurekaClientModelApplication {

    public static void main(String[] args) {

        SpringApplication.run(EurekaClientModelApplication.class, args);
    }

}
