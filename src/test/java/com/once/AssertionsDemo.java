package com.once;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {

    private Calculator calculator = new Calculator();

    @Test
    void standardAssertions() {
        assertEquals(3, calculator.sub(7, 4));
        assertEquals(8, calculator.add(2, 6));
        assertTrue("abc".contains("b"), () -> "current string contains character b");
    }

    @Test
    void groupAssertions() {
        assertAll("calculator",
                () -> assertEquals(32, calculator.add(16, 16)),
                () -> assertEquals(40, calculator.sub(100, 60)),
                () -> assertEquals(16, calculator.mul(2, 8)),
                () -> assertEquals(3, calculator.div(27, 9)));
    }

    @Test
    void dependentAssertions() {
        assertAll("calculators",
                () -> {
                    Calculator c = new Calculator();
                    assertNotNull(c);
                    assertAll("calculator 1",
                            () -> assertEquals(23, c.add(20, 3)),
                            () -> assertEquals(14, c.sub(30, 16))
                    );
                },
                () -> {
                    Calculator c = new Calculator();
                    assertNotNull(c);
                    assertAll("calculator 2",
                            () -> assertEquals(40, c.mul(5, 8)),
                            () -> assertEquals(4, c.div(20, 5))
                            );
                }
                );
    }

    @Test
    void exceptionTest() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.div(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMinutes(3), () -> {
            Thread.sleep(1000);
        });
    }

}
