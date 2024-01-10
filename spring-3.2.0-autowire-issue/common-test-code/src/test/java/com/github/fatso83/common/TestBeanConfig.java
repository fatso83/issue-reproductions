package com.github.fatso83.common;

import com.github.fatso83.common.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.github.fatso83.common"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BeanConfig.class)
        })
public class TestBeanConfig {
    @Bean
    public Foo testFoo() {
        return new Foo("test bean");
    }
}
