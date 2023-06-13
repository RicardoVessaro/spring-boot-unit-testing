package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // If number is divisible by 3, print Fizz
    @DisplayName("Divisible by Three")
    @Test
    @Order(1)
    void testForDivisibleByThree() {
//        fail("fail"); // Used to fail a test (good for new tests).

        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    // If number is divisible by 5, print Buzz
    @DisplayName("Divisible by Five")
    @Test
    @Order(2)
    void testForDivisibleByFive() {
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    // If number is divisible by 3 and 5, print FizzBuzz
    @DisplayName("Divisible by Three and Five")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    // If number is NOT divisible by 3 or 5, then print the number
    @DisplayName("Not Divisible by Three or Five")
    @Test
    @Order(4)
    void testForNotDivisibleByThreeOrFive() {
        String expected = "1";

        assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
    }

    @DisplayName("Testing with Small data file")
    /*
        With @ParameterizedTest annotation: behind the scenes,
        JUnit will run the test multiple times and supply the
        data for the parameters.

        So, now the test method has parameters.

        JUnit does the looping for you.

        You can define the name of loop invocation given the parameter 'name' in the annotation

        To see more about parameterized tests see:
        https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests.
     */
    @ParameterizedTest(name="value={0}, expected={1}")
    /*
    To get the values we define a source for our test using the following annotations:
    @ValueSource: Array of values: Strings, ints, doubles, floats etc
    @CsvSource: Array of CSV String values
    @CsvFileSource: CSV values read from a file
        To use @CsvFileSource we created a file named 'small-test-data.csv' in the resource folder of the test directory
    @EnumSource: Enum constant values
     */
    @CsvFileSource(resources="/small-test-data.csv")
    @Order(5)
    void testSmallDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }


}
