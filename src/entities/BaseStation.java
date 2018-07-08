package entities;


import java.util.List;
import java.util.Objects;

public class BaseStation {
    private long id;
    private String name;
    private List<Cell> cells;

    public BaseStation(long id, String name, List<Cell> cells) {
        this.id = id;
        this.name = name;
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

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BaseStation that = (BaseStation) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(cells, that.cells);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, name, cells);
    }
}
