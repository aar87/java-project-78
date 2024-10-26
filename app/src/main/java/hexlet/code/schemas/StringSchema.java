package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StringSchema implements Schema {
    private int minLength;
    private String contains;
    private boolean required = false;

    public boolean getRequired() {
        return this.required;
    }

    public StringSchema required() {
        this.setRequired(true);
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
    public boolean isValid(Object value) {
        String string = (String) value;
        int length = string != null ? string.length() : 0;

        if (this.getRequired() && (string == null || string.isEmpty())) {
            return false;
        }

        if (this.getMinLength() > 0 && length < getMinLength()) {
            return false;
        }

        if (this.getContains() != null && !this.getContains().isEmpty()) {
            return string != null && string.contains(this.getContains());
        }

        return true;
    }
}
