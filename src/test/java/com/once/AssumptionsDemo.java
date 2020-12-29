package com.once;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsDemo {

    @Test
    void simpleTest() {
        assumeTrue("abc".contains("b2"));
    }

    @Test
    void groupTest() {
        assumingThat(1 < 2, () -> {
            assumeTrue(2 < 3);
        });
    }

}
