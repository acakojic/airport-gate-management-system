package org.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class AirportGateManagementSystemApp extends SpringBootServletInitializer {

    /**
     * The main method for AirportGateManagementSystem application.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(AirportGateManagementSystemApp.class, args);
    }
}
