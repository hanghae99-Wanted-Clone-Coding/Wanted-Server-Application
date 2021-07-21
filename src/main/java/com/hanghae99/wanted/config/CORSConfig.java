//package com.hanghae99.wanted.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Arrays;
//
//
///**
// * CloneProject.JOB_GROUP_TB와 매핑되는 Entity 클래스입니다. Created by , 21/07/16
// * @author tmddusgood
// */
//@Configuration
//public class CORSConfig {
//    @Bean
//    public CorsFilter corsFilter(){
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:3000");
//        config.addAllowedHeader("*");
//
//        config.addAllowedMethod("*");
//        config.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        source.registerCorsConfiguration("/**",config);
//        return new CorsFilter(source);
//
//    }
//}