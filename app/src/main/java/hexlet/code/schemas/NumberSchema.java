package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class NumberSchema extends BaseSchema<Integer> {
    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        this.addCheck("positive", value -> value == null || value > 0);
        return this;
    }

    public NumberSchema range(int from, int to) {
        this.addCheck("range", value -> value != null && value >= from && value <= to);
        return this;
    }
}
