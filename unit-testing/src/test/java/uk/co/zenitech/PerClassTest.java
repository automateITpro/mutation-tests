package uk.co.zenitech;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PerClassTest {
    @Test
    void test1() {
        System.out.println(this.toString());
    }

    @Test
    void test2() {
        System.out.println(this.toString());
    }
}
