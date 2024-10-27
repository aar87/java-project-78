package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestMapSchema {
    private static final int EXACT_MAP_SIZE = 2;

    @Test
    public void testUnsetAll() {
        var s = new MapSchema();

        assertTrue(s.isValid(null));
        assertTrue(s.isValid(new HashMap<>()));

        var data = new HashMap<String, String>();
        data.put("key", "value");
        assertTrue(s.isValid(data));
    }

    @Test
    public void testRequired() {
        var s = new MapSchema();
        s.required();

        assertFalse(s.isValid(null));
        assertTrue(s.isValid(new HashMap<>()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(s.isValid(data));
    }

    @Test
    public void testSizeOfSet() {
        var s = new MapSchema();
        s.sizeof(EXACT_MAP_SIZE);
        var data = new HashMap<String, String>();
        assertFalse(s.isValid(data), "Empty not allowed");

        data.put("key1", "value1");
        assertFalse(s.isValid(data), "Lesser than size not allowed");

        data.put("key2", "value2");
        assertTrue(s.isValid(data), "Only exact size allowed");

        data.put("key3", "value3");
        assertFalse(s.isValid(data), "Oversize not allowed");
    }

    @Test
    public void testAllRestricts() {
        var s = new MapSchema();
        s.required().sizeof(EXACT_MAP_SIZE).required();

        assertFalse(s.isValid(null));
        assertFalse(s.isValid(new HashMap<>()));

        var data = new HashMap<String, String>();
        assertFalse(s.isValid(data), "Empty not allowed");

        data.put("key1", "value1");
        assertFalse(s.isValid(data), "Lesser than size not allowed");

        data.put("key2", "value2");
        assertTrue(s.isValid(data), "Only exact size allowed");

        data.put("key3", "value3");
        assertFalse(s.isValid(data), "Oversize not allowed");
    }

    @Test
    public void testShape() {
        var v = new Validator();
        var s = new MapSchema();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        s.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(s.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(s.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(s.isValid(human3));

        Map<String, String> empty = new HashMap<>();
        assertFalse(s.isValid(empty));
    }
}
