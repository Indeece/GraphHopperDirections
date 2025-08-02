package ru.indeece.graphhopperdirections;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphHopperDirectionsApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("GRAPHOPPER_API_KEY", dotenv.get("GRAPHOPPER_API_KEY"));
        SpringApplication.run(GraphHopperDirectionsApplication.class, args);
    }
}
