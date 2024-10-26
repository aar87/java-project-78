package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NumberSchema extends BaseSchema {
    private boolean positive;
    private int[] range;

    public BaseSchema positive() {
        this.setPositive(true);
        return this;
    }

    public BaseSchema range(int from, int to) {
        int[] range = {from, to};
        this.setRange(range);
        return this;
    }

    public boolean getPositive() {
        return positive;
    }

    @Override
    public boolean isValid(Object value) {
        if (this.getRequired() && value == null) {
            return false;
        }

        if (this.getPositive() && value != null && (int)value <= 0) {
            return false;
        }

        if (this.getRange() != null && value != null) {
            return (int)value >= this.getRange()[0] && (int)value <= this.getRange()[1];
        }

        return true;
    }
}
