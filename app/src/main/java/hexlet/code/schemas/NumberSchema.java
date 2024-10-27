package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class NumberSchema extends BaseSchema<Number> {
    private boolean positive;
    private int[] range;

    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        this.setPositive(true);
        return this;
    }

    public NumberSchema range(int from, int to) {
        int[] rangeValues = {from, to};
        this.setRange(rangeValues);
        return this;
    }

    public boolean getPositive() {
        return positive;
    }

    @Override
    public boolean isValid(Number value) {
        if (this.getRequired() && value == null) {
            return false;
        }

        if (this.getPositive() && value != null && (int) value <= 0) {
            return false;
        }

        if (this.getRange() != null && value != null) {
            return (int) value >= this.getRange()[0] && (int) value <= this.getRange()[1];
        }

        return true;
    }
}
