package ru.indeece.graphhopperdirections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {
    private String latitude;
    private String longitude;
}
