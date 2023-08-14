package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
    @SpringBootTest: Spring test annotation
        classes: Used when the Spring Test Class and Spring Main Class are in different classes
*/
@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    @Test
    void basicTest() {

    }

}
