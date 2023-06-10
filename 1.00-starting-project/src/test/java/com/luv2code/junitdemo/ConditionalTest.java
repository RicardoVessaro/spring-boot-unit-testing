package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

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

    @Test
    // This test only run in Java 17 version
    @EnabledOnJre(JRE.JAVA_17)
    void testOnlyForJava17() {
        // execute method and perform test
    }

    @Test
    // This test only run in Java 13 version
    @EnabledOnJre(JRE.JAVA_13)
    void testOnlyForJava13() {
        // execute method and perform test
    }

    @Test
    // This test only run in Java 13 to Java 18 version
    @EnabledForJreRange(min=JRE.JAVA_13, max=JRE.JAVA_18)
    void testOnlyForJavaRange() {
        // execute method and perform test
    }

    @Test
    // This test only run in Java 11 version or higher
    @EnabledForJreRange(min=JRE.JAVA_11)
    void testOnlyForJavaRangeMin() {
        // execute method and perform test
    }

    @Test
    // This test only runs if the environment variable named 'LUV2CODE_ENV' is set as 'DEV'
    @EnabledIfEnvironmentVariable(named="LUV2CODE_ENV", matches="DEV")
    void testOnlyForDevEnvironment() {
        // execute method and perform test
    }

    @Test
    // This test only runs if the system property named 'LUV2CODE_SYS_PROP' is set as 'CI_CD_DEPLOY'
    @EnabledIfSystemProperty(named="LUV2CODE_SYS_PROP", matches="CI_CD_DEPLOY")
    void testOnlyForSystemProperty() {
        // execute method and perform test
    }

}
