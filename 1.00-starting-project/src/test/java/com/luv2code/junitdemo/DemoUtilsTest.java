package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// "In general tests classes are not public"
// ReplaceUnderscores: Replace method name underscores to space
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// Simple: Remove trailing parentheses
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
// IndicativeSentences: Generates sentence based on the test class name and test method name
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
// You also can create custom display names generators, try to search for: junit display name camel case
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals() {

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    /*
    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @AfterEach");
        System.out.println();
    }

    @BeforeAll
    // By default, this method must be static
    static void setupBeforeEachClass() {
        System.out.println("@BeforeAll executes only once before all test methods executions in the class");
    }

    @AfterAll
    // By default, this method must be static
    static void tearDownAfterAll() {
        System.out.println("@BeforeAll executes only once before all test methods executions in the class");
    }
    */

}
