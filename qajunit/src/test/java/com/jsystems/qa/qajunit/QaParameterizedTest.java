package com.jsystems.qa.qajunit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertTrue;


public class QaParameterizedTest {


    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(ints = {5, 15, 25})
    public void firstParameterizedTest(int number) {


        assertTrue(number % 5 == 0);

//        int[] ints = {5, 15, 25};
//        for (int i=0; i<ints.length; i++){
//        }

    }


    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(strings = {"Hello", "Hello junit", "Hello students"})
    public void secondParameterizedTest(String text) {

        assertTrue(text.contains("Hello"));

    }

    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @CsvSource(value = {"Hello, 5", "Hello junit 5, 15", "'Hello students 5!', 25"}, delimiter = ',')
    public void nextParameterizedTest(String text, int number) {

        assertTrue(text.contains("Hello"));
        assertTrue(number % 5 == 0);

    }

    @ParameterizedTest(name = "Parameter test with value {0} and {1}")
    @CsvFileSource(resources = "/plik.csv")
    public void fileParameterizedTest(String text, int number) {


    }

}