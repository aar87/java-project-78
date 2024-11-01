package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public final class MapSchema extends BaseSchema<Map<String, String>> {
    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int sizeValue) {
        addCheck("size", value -> value.size() == sizeValue);
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> shapeMap) {
        addCheck("shape", value -> shapeMap.entrySet()
                .stream()
                .allMatch(entry -> entry.getValue().isValid(value.get(entry.getKey()))));
    }
}
