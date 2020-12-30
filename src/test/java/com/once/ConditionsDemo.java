package com.once;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionsDemo {

    @Nested
    class OperationSystemConditionsDemo {

        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testOnWind() {
            System.out.println("windows system");
        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC, OS.SOLARIS})
        void testNotOnWind() {
            System.out.println("unix system");
        }

    }

    @Nested
    class RuntimeConditionsDemo {

        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void testOnJava8() {
            System.out.println("java 8");
        }

        @Test
        @DisabledOnJre({JRE.JAVA_9, JRE.JAVA_12})
        void testNotOnJava8OrJava12() {
            System.out.println("not on java 9 or java 12");
        }

    }

    @Nested
    class SystemPropertyConditionsDemo {

        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
        void onlyOn64BitArchitectures() {
            System.out.println("64 bit");
        }
        @Test
        @DisabledIfSystemProperty(named = "ci-server", matches = "true")
        void notOnCiServer() {
            System.out.println("not ci-server");
        }

    }

    @Nested
    class EnvironmentValuesConditionsDemo {
        @Test
        @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
        void onlyOnStagingServer() {
            System.out.println("staging server");
        }
        @Test
        @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
        void notOnDeveloperWorkstation() {
            System.out.println("develop");
        }
    }

    @Nested
    class CustomConditionsDemo {
        @Test
        @EnabledIf("customCondition")
        void enabled() {
            System.out.println("custom enabled");
        }
        @Test
        @DisabledIf("customCondition")
        void disabled() {
            System.out.println("custom disabled");
        }
        boolean customCondition() {
            return true;
        }
    }

}
