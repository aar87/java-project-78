package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNumberSchema {
    private static final int TEST_INT_VALUE = 2;

    @Test
    public void testUnsetAll() {
        var s = new NumberSchema();
        assertTrue(s.isValid(null));
        assertTrue(s.isValid(0));
        assertTrue(s.isValid(TEST_INT_VALUE));
        assertTrue(s.isValid(TEST_INT_VALUE * -1));
    }

    @Test
    public void testRequiredSet() {
        var s = new NumberSchema();
        s.required();

        assertFalse(s.isValid(null));
        assertTrue(s.isValid(0));
        assertTrue(s.isValid(TEST_INT_VALUE));
        assertTrue(s.isValid(TEST_INT_VALUE * -1));
    }

    @Test
    public void testPositiveSet() {
        var s = new NumberSchema();
        s.positive();
        assertFalse(s.isValid(0));
        assertFalse(s.isValid(TEST_INT_VALUE * -1));

        assertTrue(s.isValid(TEST_INT_VALUE));
    }

    @Test
    public void testRangeSet() {
        var s = new NumberSchema();
        s.range(TEST_INT_VALUE * -1, TEST_INT_VALUE);

        assertFalse(s.isValid(TEST_INT_VALUE + 1));
        assertFalse(s.isValid((TEST_INT_VALUE * -1) - 1));

        assertTrue(s.isValid(0));
        assertTrue(s.isValid(TEST_INT_VALUE));
        assertTrue(s.isValid(TEST_INT_VALUE * -1));
    }

    @Test
    public void testAllRestricts() {
        var s = new NumberSchema();
        s.required().positive().range(TEST_INT_VALUE * -1, TEST_INT_VALUE).positive();

        assertFalse(s.isValid(0));
        assertFalse(s.isValid(null));
        assertFalse(s.isValid((TEST_INT_VALUE * -1) - 1));
        assertFalse(s.isValid(TEST_INT_VALUE * -1));
        assertFalse(s.isValid((TEST_INT_VALUE) + 1));

        assertTrue(s.isValid(TEST_INT_VALUE));
    }
}
