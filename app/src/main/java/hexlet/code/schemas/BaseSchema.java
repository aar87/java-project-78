package hexlet.code.schemas;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseSchema<T> {
    private Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public final boolean isValid(T value) {
        return checks.values().stream().allMatch(check -> check.test(value));
    }

    protected final void addCheck(String value, Predicate<T> predicate) {
        checks.put(value, predicate);
    }

    /**
     * Required state config
     * @return void
     */
    protected BaseSchema<T> required() {
        checks.put("required", Objects::nonNull);
        return this;
    }
}
