package hexlet.code.schemas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MapSchema extends BaseSchema<Map<String, String>> {
    private Integer size;
    private Map<String, BaseSchema<String>> keySchemas;

    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int size) {
        this.setSize(size);
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
        this.setKeySchemas(new HashMap<>(schemas));
    }


    @Override
    public boolean isValid(Map<String, String> value) {
        if (this.getKeySchemas() != null) {
            for (String key : this.getKeySchemas().keySet()) {
                if (!this.getKeySchemas().get(key).isValid(value.getOrDefault(key, null))) {
                    return false;
                }
            }

            return true;
        }

        if (this.getRequired() && value == null) {
            return false;
        }

        if (this.getSize() != null) {
            return value.size() == this.getSize();
        }

        return true;
    }
}
