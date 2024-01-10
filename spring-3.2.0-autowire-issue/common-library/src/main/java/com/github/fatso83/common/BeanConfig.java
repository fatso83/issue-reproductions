package com.github.fatso83.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Foo myFoo() {
        return new Foo("normal bean");
    }

    @Bean
    public Foo someOtherFoo() {
        return new Foo("some other normal bean");
    }

    // Spring Framework 6.1 requires the `-parameters` flag in Javac for parameter reflection to work
    @Bean Bar myBar(Foo myFoo){ // <--- This should trigger the issue in https://github.com/spring-projects/spring-framework/issues/31998
        return new Bar(myFoo);
    }
}
