package jupiterpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TestData implements IData {
    int id;
    String name;

    public String getKey() { return String.format("%d",id); }
}
