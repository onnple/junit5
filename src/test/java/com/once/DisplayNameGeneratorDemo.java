package com.once;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayNameGeneratorDemo {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class add_function_in_calculator {

        @Test
        void test_if_ok() {

        }

        @ParameterizedTest
        @CsvSource({
                "1, 2, 3",
                "3, 4, 7",
                "-9, -2, -11"
        })
        void test_add_with_array(int a, int b, int c) {
            Calculator calculator = new Calculator();
            assertEquals(c, calculator.add(a, b));
        }

    }


    @Nested
    @IndicativeSentencesGeneration(separator = "=>", generator = DisplayNameGenerator.IndicativeSentences.class)
    class SubTest {

        @Test
        void test_if_ok() {

        }

        @ParameterizedTest
        @CsvSource({
                "1, 9, -8",
                "3, 1, 2",
                "10, 7, 3"
        })
        void testSub(int a, int b, int c) {
            Calculator calculator = new Calculator();
            assertEquals(c, calculator.sub(a, b));
        }

    }

}
