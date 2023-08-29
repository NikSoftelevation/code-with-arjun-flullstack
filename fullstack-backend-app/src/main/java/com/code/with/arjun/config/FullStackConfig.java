package com.code.with.arjun.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FullStackConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
