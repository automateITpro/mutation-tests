package uk.co.zenitech;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelTest {

    @Test
    void test1() {
        System.out.println("Test1: " + Thread.currentThread().getName());
    }

    @Test
    void test2() {
        System.out.println("Test2: " + Thread.currentThread().getName());
    }

    @Test
    void test3() {
        System.out.println("Test3: " + Thread.currentThread().getName());
    }

    @Test
    void test4() {
        System.out.println("Test4: " + Thread.currentThread().getName());
    }

    @Test
    void test5() {
        System.out.println("Test5: " + Thread.currentThread().getName());
    }
}
