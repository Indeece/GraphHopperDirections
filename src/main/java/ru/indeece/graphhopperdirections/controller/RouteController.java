package ru.indeece.graphhopperdirections.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.indeece.graphhopperdirections.dto.RouteInfoDto;
import ru.indeece.graphhopperdirections.model.Properties;
import ru.indeece.graphhopperdirections.service.GraphhopperService;

import java.io.IOException;

@RestController
@RequestMapping("/api/route")
@RequiredArgsConstructor
public class RouteController {

    private final GraphhopperService service;

    @PostMapping
    public RouteInfoDto getRoute(@RequestBody Properties properties) throws IOException {
        return service.getRoute(properties);
    }
}
