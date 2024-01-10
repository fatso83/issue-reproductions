package com.github.fatso83.app;

import com.github.fatso83.common.BeanConfig;
import com.github.fatso83.common.Foo;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@TestConfiguration
@ComponentScan(
        basePackages = {
                "com.github.fatso83"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = AppConfig.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BeanConfig.class),
        })
public class AppTestConfig {

    @Bean
    AppConfig.Bar myTestBarBean(Foo moofoo){
        return new AppConfig.Bar("my app bar using: " + moofoo.name());
    }
}
