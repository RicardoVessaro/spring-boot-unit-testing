package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// "In general tests classes are not public"
/* About @DisplayNameGeneration
 ReplaceUnderscores: Replace method name underscores to space
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
 Simple: Remove trailing parentheses
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
 IndicativeSentences: Generates sentence based on the test class name and test method name
@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
 You also can create custom display names generators, try to search for: junit display name camel case
*/
/*  About @TestMethodOrder
 MethodName: Sorting by method name, but you can't use @DisplayName to sorting works.
@TestMethodOrder(MethodOrderer.MethodName.class
 DisplayName: Sorting by @DisplayName
@TestMethodOrder(MethodOrderer.DisplayName.class)
 OrderAnnotation: Sorting by the values given in the @Order annotation
  Lowest number has the highest priority
  Accept negative numbers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @DisplayName("Multiply")
    @Test
    void testMultiply() {

        assertEquals(12, demoUtils.multiply(4, 3), "4*3 must be 12");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    @Order(1)
    void testEqualsAndNotEquals() {

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    @Order(0)
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {
        String str = "luv2code";

        // Assert Same and Not Same checks if the given objects references are the same or not
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to the same object");
    }

    @DisplayName("True and False")
    @Test
    @Order(30)
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        // Assert the arrays are deeply equals
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");

        // Assert the lists are deeply equals
        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }

    @DisplayName("Lines match")
    @Test
    @Order(50)
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");

        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @DisplayName("Throws and Does Not Throw")
    @Test
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> { demoUtils.throwException(-1); }, "Should throw exception");

        assertDoesNotThrow(() -> { demoUtils.throwException(5); }, "Should not throw exception");
    }

    @DisplayName("Timeout")
    @Test
    void testTimeout() {

        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout(); },
                "Method should execute in 3 seconds");
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
