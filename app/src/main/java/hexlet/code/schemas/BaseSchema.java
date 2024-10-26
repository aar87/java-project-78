package hexlet.code.schemas;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
public class BaseSchema {
    private boolean required = false;

    public boolean isValid(Object value) {
        return true;
    }

    public boolean getRequired() {
        return this.required;
    }

    public BaseSchema required() {
        this.setRequired(true);
        return this;
    }
}
