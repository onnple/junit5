package com.once;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StartTest {

    @Test
    @DisplayName("shouldEquals3")
    public void test() {
        assertEquals(3, 3);
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("before all methods");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("before each method");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each method");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all methods");
    }

    @Test
    @DisplayName("test 3 equals 2")
    public void testEquals() {
        assertEquals(3, 2);
    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    public void testArray(String s) {
        assertTrue(s.contains("a"));
    }

    @RepeatedTest(3)
    public void repeatedTest() {
        System.out.println("repeat test");
    }

    @Test
    public void sampleTest() {
        Assumptions.assumeTrue("abc".contains("d"));
    }

    @Test
    public void shouldFailed() {
        fail("should fail");
    }


}
