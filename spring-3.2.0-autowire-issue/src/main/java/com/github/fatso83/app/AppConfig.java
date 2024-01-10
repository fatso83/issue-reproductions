package com.github.fatso83.app;

import com.github.fatso83.common.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public record Bar(String name){};

    @Bean
    Bar myBarBean(Foo moofoo){
        return new Bar("my app bar");
    }
}
