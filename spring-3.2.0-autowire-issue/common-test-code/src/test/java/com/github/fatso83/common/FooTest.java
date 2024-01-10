package com.github.fatso83.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@WebAppConfiguration
@ContextConfiguration(
        classes = {TestBeanConfig.class})
@RunWith(SpringRunner.class)
public class FooTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private Foo myFoo;

    @Test
    public  void some_lib_test() {
        assertEquals(myFoo.name(), "test bean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
