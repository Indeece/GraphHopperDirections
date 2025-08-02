package ru.indeece.graphhopperdirections.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Properties {
    private List<Point> points = new ArrayList<>(); // List of points in the route
    private String profile; // e.g., "car", "foot", "bike"
    private String locale; // e.g., "en", "ru", "fr"
    private String elevation; // e.g., "true" or "false" to include elevation data
}
