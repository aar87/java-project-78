package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestStringSchema {
    private static final int MIN_LENGTH_VALUE = 2;
    private static final String CONTAINS_VALUE = "est";

    @Test
    public void testUnsetAll() {
        var s = new StringSchema();

        assertTrue(s.isValid(""));
        assertTrue(s.isValid("Same"));
        assertTrue(s.isValid(null));
    }

    @Test
    public void testRequiredSet() {
        var s = new StringSchema();
        s.required();

        assertFalse(s.isValid(""));
        assertFalse(s.isValid(null));
        assertTrue(s.isValid("Same"));
    }

    @Test
    public void testMinLengthSet() {
        var s = new StringSchema();
        s.minLength(MIN_LENGTH_VALUE);

        assertFalse(s.isValid(null), "Null is always lesser than -> " + MIN_LENGTH_VALUE);
        assertFalse(s.isValid(""), "Empty string is always lesser than -> " + MIN_LENGTH_VALUE);

        assertTrue(s.isValid("Some long string"), "Much longer than min length -> " + MIN_LENGTH_VALUE);
        assertTrue(s.isValid("AB"), "Exact as min length -> " + MIN_LENGTH_VALUE);
        assertTrue(s.isValid("ABC"), "Exact as min length +1 -> " + MIN_LENGTH_VALUE + 1);
    }

    @Test
    public void testContainsSet() {
        var s = new StringSchema();
        s.contains(CONTAINS_VALUE);

        assertFalse(s.isValid(""));
        assertFalse(s.isValid(null));
        assertFalse(s.isValid("Some long string"));
        assertFalse(s.isValid("Short"));

        assertTrue(s.isValid("est"));
        assertTrue(s.isValid("Test"));
        assertTrue(s.isValid("Best"));
        assertTrue(s.isValid("Real example of testing"));
    }

    @Test
    public void testAllRestricts() {
        var s = new StringSchema();
        s.required().contains(CONTAINS_VALUE).minLength(MIN_LENGTH_VALUE).minLength(MIN_LENGTH_VALUE);

        assertFalse(s.isValid(""));
        assertFalse(s.isValid(null));
        assertFalse(s.isValid("Some long string"));
        assertFalse(s.isValid("Short"));

        assertTrue(s.isValid("est"));
        assertTrue(s.isValid("Test"));
        assertTrue(s.isValid("Best"));
        assertTrue(s.isValid("Real example of testing"));
    }
}
