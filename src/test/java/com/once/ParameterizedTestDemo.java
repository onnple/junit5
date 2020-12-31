package com.once;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTestDemo {

    // 1. @ValueSource

    @ParameterizedTest
    @ValueSource(ints = {10, 3, 8, 4, 7})
    void testDaysNumber(int day) {
        assertTrue(day > 0 && day < 8);
    }

    @ParameterizedTest
    @ValueSource(floats = {2.3f, 3.4f, 2.03f, 7.8f})
    void testFloats(float f) {
        assertTrue(f > 3 && f < 6);
    }


    // 2. null & empty

    @ParameterizedTest
    @NullSource
    @EmptySource
    @NullAndEmptySource
    void testEmpty(String t) {
        assertTrue(t == null || t.isEmpty());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {" ", "  ", "\n", "\t"})
    void testEmptyWithValueSource(String t) {
        assertTrue(t == null || t.trim().isEmpty());
    }


    // 3. @MethodSource

    @ParameterizedTest
    @MethodSource("getFromStream")
    void testStreamMethod(String t) {
        assertNotNull(t);
    }

    static Stream<String> getFromStream() {
        return Stream.of("a", "b", null, " ", "\n");
    }

    @ParameterizedTest
    @MethodSource("getFromArguments")
    void testArguments(int a, String t, List<String> strings) {
        assertTrue(a < 10);
        assertNotNull(t);
        assertEquals(2, strings.size());
    }

    static Stream<Arguments> getFromArguments() {
        return Stream.of(
                Arguments.of(3, "abc", Arrays.asList("r", "b")),
                Arguments.of(10, null, Arrays.asList("bs", "op", "oop")),
                Arguments.of(7, "q", Arrays.asList("a", "2"))
        );
    }


    // 4. @CsvSource

    @ParameterizedTest
    @CsvSource({
            "1,     'abc',  ,   2.3f",
            "3,     try,    b,  7.0f",
            "2,     ozm,    d,  9.0f"
    })
    void testCSV(int a, String str, String text, float f) {
        assertTrue(a < 3);
        assertEquals(3, str.length());
        assertNotNull(text);
        assertTrue(f < 10);
    }

    @ParameterizedTest
    @CsvSource({
            "3,     2,      9",
            "1,     5,      6",
            "8,     3,      512"
    })
    void testMath(int a, int b, int c) {
        assertEquals(c, Math.pow(a, b));
    }


    @Test
    void writeItemsToFile(@TempDir File file) throws IOException {
        System.out.println(file.toString());
    }

}
