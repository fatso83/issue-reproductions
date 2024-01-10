package com.github.fatso83.app;

import com.github.fatso83.common.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppTestConfig.class})
@DirtiesContext
public class SomeTest implements ApplicationContextAware  {

    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private Foo myFoo;

    @Autowired
    private AppConfig.Bar testBar;

    @Test
    public  void some_app_test() {
        Assertions.assertEquals("test bean", myFoo.name());
    }

    @Test
    public  void some_app_test2() {
        Assertions.assertEquals("my app bar using: test bean", testBar.name());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
