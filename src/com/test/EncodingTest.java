package com.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncodingTest {

    @Test
    public void stringEncodingTest() {
        Main tester = new Main();

        // tests
        assertEquals(tester.encode(1, "abcd9876DCBcbz"),"bcde9876EDCdca");
        assertEquals(tester.encode(-1, "abcd9876DCBcbz"),"zabc9876CBAbay");


        assertEquals(tester.encode(26, "abcd9876DCBcbz"),"abcd9876DCBcbz");
        assertEquals(tester.encode(-26, "abcd9876DCBcbz"),"abcd9876DCBcbz");

        assertEquals(tester.encode(1000, "abcd9876DCBcbz"),"mnop9876PONonl");
        assertEquals(tester.encode(-1000, "abcd9876DCBcbz"),"opqr9876RQPqpn");

    }
}
