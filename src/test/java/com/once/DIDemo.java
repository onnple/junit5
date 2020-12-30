package com.once;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

@DisplayName("Dependency Injection Demo")
public class DIDemo {

    // TestInfo: DI for constructor
    public DIDemo (TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    // TestInfo: DI for method
    @Tag("TestTag")
    @Test
    void simpleTest(TestInfo testInfo) {
        System.out.println(testInfo.getTestMethod() + " =>[tag] " + testInfo.getTags().size());
    }

    // TestReporter
    @Test
    void testReporter (TestReporter testReporter) {
        Map<String, String> p = new HashMap<>();
        p.put("hume", "causality");
        p.put("kant", "transcendental categories");
        p.put("descartes", "thinking");
        testReporter.publishEntry(p);
    }



}
