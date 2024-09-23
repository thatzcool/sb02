package com.ssg.sb02.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.awt.SystemColor.info;


@Configuration
public class SwaggerConfig {

      @Bean
      public GroupedOpenApi restAPI() {
            return GroupedOpenApi.builder()
                    .pathsToMatch("/api/**")
                    .group("REST API")
                    .build();
      }

      @Bean
      public GroupedOpenApi commonApi(){
            return GroupedOpenApi.builder()
                    .pathsToMatch("/*")
                    .group("Common API")
                    .build();
      }
}
