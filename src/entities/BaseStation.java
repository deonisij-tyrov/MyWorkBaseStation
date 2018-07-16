package entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BaseStation {
    List<Cell> cells;
    private long id;
    private String name;


    public BaseStation(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BaseStation(long id, String name, List<Cell> cells) {
        this.id = id;
        this.name = name;
        this.cells = cells;
    }

}
