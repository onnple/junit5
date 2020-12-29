package com.once;


import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("app")
public class AppTest {

    @FastTest
    public void fastTest() {
        assertTrue("abc".contains("a"));
    }

    @FastTest
    public void fastTestEquals() {
        assertEquals(2, 2);
    }

}
