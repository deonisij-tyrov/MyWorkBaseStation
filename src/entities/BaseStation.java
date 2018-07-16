package entities;


import java.util.List;

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

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseStation() {

    }
}
