package com.example.authclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthclientApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder
            .routes()
            .route(r -> r.path("/")
                .filters(GatewayFilterSpec::tokenRelay)
                .uri("http://localhost:8081"))
            .build();
    }
}
