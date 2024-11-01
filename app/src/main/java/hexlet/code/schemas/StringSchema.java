package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public final class StringSchema extends BaseSchema<String> {
    @Override
    public StringSchema required() {
        addCheck("requiredNotEmpty", value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLengthValue) {
        this.addCheck("length", value -> value != null && value.length() >= minLengthValue);
        return this;
    }

    public StringSchema contains(String substring) {
        this.addCheck("contains", value -> value != null && value.contains(substring));
        return this;
    }
}
