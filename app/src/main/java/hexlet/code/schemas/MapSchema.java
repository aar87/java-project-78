package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MapSchema extends BaseSchema {
    private Integer size;

    public MapSchema sizeof(int size) {
        this.setSize(size);
        return this;
    }

    public boolean isValid(Object value) {
        if (!super.isValid(value)) {
            return false;
        }

        if (this.getSize() != null && value instanceof Map) {
            return ((Map<?, ?>) value).size() == this.getSize();
        }

        return true;
    }
}
