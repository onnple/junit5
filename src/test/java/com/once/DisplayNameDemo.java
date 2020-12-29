package com.once;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("My Demo for DisplayName")
public class DisplayNameDemo {

    @DisplayName("A Description For A Method")
    @Test
    public void myStringMethod() {
        assertEquals("123", "123");
    }

    @DisplayName("°□°")
    @Test
    public void myCharacterTest() {
        assertTrue("°□°".contains("□"));
    }

    @DisplayName("ὣ")
    @Test
    public void shouldEquals() {
        assertEquals("ὣ", "ὣ");
    }

}
