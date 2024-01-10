package com.github.fatso83.app;

import com.github.fatso83.common.Bar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext
public class SomeTest  {
    @Autowired
    private Bar testBar;

    @Test
    public  void some_app_test() {
        Assertions.assertEquals("foo name = normal bean", testBar.getFooName());
    }
}
