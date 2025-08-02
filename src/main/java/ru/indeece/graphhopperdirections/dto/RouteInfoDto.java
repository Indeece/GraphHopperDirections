package ru.indeece.graphhopperdirections.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RouteInfoDto {
    private double distance;
    private long time;
}
