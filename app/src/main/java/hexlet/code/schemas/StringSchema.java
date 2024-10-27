package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StringSchema extends BaseSchema<String> {
    private int minLength;
    private String contains;

    public StringSchema required() {
        super.required();
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.setMinLength(minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        this.setContains(substring);
        return this;
    }

    @Override
    public boolean isValid(String value) {
        int length = value != null ? value.length() : 0;

        if (this.getRequired() && (value == null || value.isEmpty())) {
            return false;
        }

        if (this.getMinLength() > 0 && length < getMinLength()) {
            return false;
        }

        if (this.getContains() != null && !this.getContains().isEmpty()) {
            return value != null && value.contains(this.getContains());
        }

        return true;
    }
}
