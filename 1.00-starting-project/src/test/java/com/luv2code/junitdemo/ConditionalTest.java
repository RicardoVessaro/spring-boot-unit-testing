package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

// Conditional test @annotations can be set in the class or method level
class ConditionalTest {

    @Test
    // The following test is disabled
    @Disabled("Don't run until JIRA#123 is resolve ")
    void basicTest() {
        // execute method and perform test
    }

    @Test
    // The following only run in Windows OS
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {
        // execute method and perform test
    }

    @Test
    // The following only run in Mac OS
    @EnabledOnOs(OS.MAC)
    void testForMacOnly() {
        // execute method and perform test
    }

    @Test
    // The following only run in Linux OS
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly() {
        // execute method and perform test
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    // The following only run in Linux and Mac OS
    void testForMAcLinuxOnly() {
        // execute method and perform test
    }

}
