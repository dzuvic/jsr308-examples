package de.w11k.jsr308.examples.nulls;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test is needed to ensure the semantics of the class.
 *
 * Copyright 2016 Dragan Zuvic
 */
public class QueueDelegateTest {

    @Test
    public void queue() throws Exception {
        QueueDelegate d = new QueueDelegate();
        d.push(1);
        d.push(2);

        assertEquals(d.pop().intValue(),1);
        assertEquals(d.pop().intValue(),2);
        assertNull(d.pop());

        // if test project would be checked, too, we would have to write
//        if (!d.isEmpty()) assertEquals(d.pop().intValue(),1); else fail();
//        if (!d.isEmpty()) assertEquals(d.pop().intValue(),2); else fail();
    }
}