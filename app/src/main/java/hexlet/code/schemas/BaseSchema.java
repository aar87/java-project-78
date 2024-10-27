package hexlet.code.schemas;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
public abstract class BaseSchema<T> {
    private boolean required = false;

    public boolean isValid(T value) {
        return true;
    }

    public boolean getRequired() {
        return this.required;
    }

    public BaseSchema<T> required() {
        this.setRequired(true);
        return this;
    }
}
