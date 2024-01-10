package com.github.fatso83.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Foo myFoo() {
        return new Foo("normal bean");
    }
}
