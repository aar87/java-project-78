package hexlet.code.schemas;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
public abstract class BaseSchema<T> {
    private boolean required = false;

    /**
     * @param value
     * @return boolean
     */
    public boolean isValid(T value) {
        return true;
    }

    public final boolean getRequired() {
        return this.required;
    }

    /**
     * @return BaseSchema
     */
    public BaseSchema<T> required() {
        this.setRequired(true);
        return this;
    }
}
