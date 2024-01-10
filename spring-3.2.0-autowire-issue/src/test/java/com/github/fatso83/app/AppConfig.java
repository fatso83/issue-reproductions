package com.github.fatso83.app;

import com.github.fatso83.common.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.github.fatso83"}) // this will pick up multiple beans in the commons project
public class AppConfig { }
