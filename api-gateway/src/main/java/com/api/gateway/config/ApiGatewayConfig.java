package com.api.gateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 *
 */
@Configuration
public class ApiGatewayConfig {


  /*  @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**").filters(f->f.stripPrefix(1))
                        .uri("lb://currency-exchange"))
                .build();
    }*/


    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**").filters(f->f.stripPrefix(1))
                        .uri("lb://currency-exchange-service"))
                .route(p -> p.path("/currency-conversion/**").filters(f->f.stripPrefix(1))
                        .uri("lb://currency-conversion-service"))
                .build();
    }


}
