package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TestValidator {

    @Test
    public void mainTest() {
        Validator validator = new Validator();
        assertInstanceOf(Validator.class, validator);
    }

    @Test
    public void testValidatorSchemas() {
        Validator validator = new Validator();

        assertInstanceOf(StringSchema.class, validator.string());
        assertInstanceOf(MapSchema.class, validator.map());
        assertInstanceOf(NumberSchema.class, validator.number());
    }
}
