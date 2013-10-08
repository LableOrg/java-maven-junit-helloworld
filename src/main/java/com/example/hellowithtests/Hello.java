package com.example.hellowithtests;

import java.io.PrintStream;

/**
 * Simple class that says "Hello!".
 */
public class Hello {

    static final String HELLO = "Hello!";
    private short times;

    /**
     * Construct a new Hello instance.
     *
     * @param times How many times should this class say "Hello!"? The value should be no larger than 20.
     * @throws IllegalArgumentException Thrown when times is larger than 20 or a negative number.
     */
    public Hello(int times) {
        if (times < 0 || times > 20) {
            throw new IllegalArgumentException("Parameter «times» should be a positive integer no larger than 20.");
        }
        this.times = (short) times;
    }

    /**
     * Say "Hello!".
     *
     * @param printer PrintStream to write output to.
     */
    public void sayHello(PrintStream printer) {
        for (short i = 0; i < times; i++) {
            printer.println(HELLO);
        }
    }

}
