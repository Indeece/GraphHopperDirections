package ru.indeece.graphhopperdirections.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.indeece.graphhopperdirections.dto.RouteInfoDto;
import ru.indeece.graphhopperdirections.model.Point;
import ru.indeece.graphhopperdirections.model.Properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GraphhopperService {
    private final OkHttpClient client = new OkHttpClient();

    @Value("${graphhopper.api.key}")
    private String apiKey;

    public RouteInfoDto getRoute(Properties properties) throws IOException {
        List<String> queryParams = new ArrayList<>();

        if (properties.getPoints() != null && !properties.getPoints().isEmpty()) {
            for (Point point : properties.getPoints()) {
                queryParams.add("point=" + point.getLatitude() + "," + point.getLongitude());
            }
        }

        if (properties.getProfile() != null && !properties.getProfile().isBlank()) {
            queryParams.add("profile=" + properties.getProfile());
        }

        if (properties.getLocale() != null && !properties.getLocale().isBlank()) {
            queryParams.add("locale=" + properties.getLocale());
        }

        if (properties.getElevation() != null && !properties.getElevation().isBlank()) {
            queryParams.add("elevation=" + properties.getElevation());
        }

        queryParams.add("calc_points=true");
        queryParams.add("key=" + apiKey);

        String url = "https://graphhopper.com/api/1/route?" + String.join("&", queryParams);
        System.out.println("URL = " + url);

        Request request = new Request.Builder().url(url).get().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();

                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(responseBody);
                JsonNode path = root.path("paths").get(0);

                double distance = path.path("distance").asDouble();
                long time = path.path("time").asLong();

                return new RouteInfoDto(distance, time);
            } else {
                throw new IOException("Error: " + response.code());
            }
        }
    }
}
