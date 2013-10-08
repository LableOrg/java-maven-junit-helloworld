package com.example.hellowithtests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 * Unit test for HelloApp.
 * <p/>
 * A unit test aims to test all code and code paths of a specific class.
 */
public class HelloAppTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testMain() {
        String[] args = {"1"};
        HelloApp.main(args);
    }

    @Test
    public void testHelloError() {
        exit.expectSystemExitWithStatus(HelloApp.EXIT_STATUS_HELLO_FAILED);
        String[] args = {"21"};
        HelloApp.main(args);
    }

    @Test
    public void testWrongArgument() {
        exit.expectSystemExitWithStatus(HelloApp.EXIT_STATUS_PARAMETER_NOT_UNDERSTOOD);
        String[] args = {"bicycle"};
        HelloApp.main(args);
    }

    @Test
    public void testDefaultArgument() {
        // Passing no arguments should work.
        String[] args = {};
        HelloApp.main(args);
    }

    @Test
    public void classInstanceForCodeCoverageTest() {
        // Strictly speaking this test doesn't achieve anything, because HelloApp contains only a single static
        // method, but for purposes of full code coverage it is included. In general,
        // it is easier to aim for full code coverage and be done with it, than to remember why class X is stuck at
        // 95% code coverage.
        new HelloApp();
    }
}
