package entities;



import java.util.Objects;


public class Cell {
    private long id;
    private String name;
    private int sector;
    private int power;
    private long bsNumber;
    private int band;

    public Cell(String name, int sector, int power, long bsNumber, int band) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.power = power;
        this.bsNumber = bsNumber;
        this.band = band;
    }

    public Cell(long id, String name, int sector, int power, long bsNumber, int band) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.power = power;
        this.bsNumber = bsNumber;
        this.band = band;
    }

    public Cell() {
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

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public long getBsNumber() {
        return bsNumber;
    }

    public void setBsNumber(long bsNumber) {
        this.bsNumber = bsNumber;
    }

    public int getBand() {
        return band;
    }

    public void setBand(int band) {
        this.band = band;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cell cell = (Cell) o;
        return id == cell.id &&
                sector == cell.sector &&
                power == cell.power &&
                bsNumber == cell.bsNumber &&
                band == cell.band &&
                Objects.equals(name, cell.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, name, sector, power, bsNumber, band);
    }

    @Override
    public String toString() {

        return "Cell{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sector=" + sector +
                ", power=" + power +
                ", bsNumber=" + bsNumber +
                ", band=" + band +
                '}';
    }
}
