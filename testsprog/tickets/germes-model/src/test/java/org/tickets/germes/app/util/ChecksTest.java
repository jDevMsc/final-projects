package org.tickets.germes.app.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tickets.germes.app.exception.flow.InvalidParameterException;

public class ChecksTest {

    @Test
    public void testCheckParameterGetException() {
        try {
            Checks.checkParameter(false, "test");
            assertTrue(false);
        } catch (Exception ex) {
            assertSame(ex.getClass(), InvalidParameterException.class);
            assertEquals(ex.getMessage(), "test");
        }
    }

    @Test
    public void testCheckParameterNoException() {
        Checks.checkParameter(true, "test");
        assertTrue(true);
    }
}