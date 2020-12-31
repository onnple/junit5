package com.once;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderDemo {

    @Test
    @Order(2)
    void testAbs() {
        assertEquals(1, Math.abs(-1), "abs(-1) = 1");
    }

    @Test
    @Order(1)
    void testPow() {
        assumeTrue(27 == Math.pow(3, 3));
    }

    @Test
    @Order(3)
    void testString() {
        assertAll("math", () -> {
            assertEquals(2, Math.abs(-2));
            assertEquals(2, Math.log10(100));
        });
    }

}
