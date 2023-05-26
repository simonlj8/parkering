package com.example.parkering;

import org.geolatte.geom.json.GeolatteGeomModule;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
    
    @Bean
    GeolatteGeomModule geolatteGeomModule() {
        return new GeolatteGeomModule();
    }

}
