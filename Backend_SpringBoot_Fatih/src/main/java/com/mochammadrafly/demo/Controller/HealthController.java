package com.mochammadrafly.demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HealthController {
    @GetMapping("/health")
    public Map<String, Object> healthCheck() {
        Map<String, Object> object = new HashMap<>();
        object.put("status", "UP");
        object.put("message", "Jetpack Joyride Backend is running!");
        object.put("timestamp", System.currentTimeMillis());
        return object;
    }
    @GetMapping("/info")
    public Map<String, Object> info(){
        Map<String, Object> object = new HashMap<>();
        object.put("appName","CS6_MochammadRaflyFatihRabbani_Backend");
        object.put("version","1.2.3");
        object.put("description","Backend for Jetpack Joyride developed in Spring Boot");

        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("players", "/api/players");
        endpoints.put("scores", "/api/scores");
        endpoints.put("leaderboard", "/api/scores/leaderboard");
        endpoints.put("health", "/api/health");

        object.put("endpoints", endpoints);

        return object;
    }


}
