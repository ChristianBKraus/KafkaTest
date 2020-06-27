package jupiterpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class TestData implements IData {
    int id;
    String name;

    public String getKey() { return String.format("%d",id); }
}
