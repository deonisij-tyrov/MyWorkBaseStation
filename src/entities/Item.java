package entities;


public class Item {
    private long id;
    private long serialBoard;
    private long idBaseStation;

    public Item(long serialBoard, long idBaseStation) {

        this.serialBoard = serialBoard;
        this.idBaseStation = idBaseStation;
    }

    public Item(long id, long serialBoard, long idBaseStation) {

        this.id = id;
        this.serialBoard = serialBoard;
        this.idBaseStation = idBaseStation;
    }

    public Item() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSerialBoard() {

        return serialBoard;
    }

    public void setSerialBoard(long serialBoard) {
        this.serialBoard = serialBoard;
    }

    public long getIdBaseStation() {
        return idBaseStation;
    }

    public void setIdBaseStation(long idBaseStation) {
        this.idBaseStation = idBaseStation;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", serialBoard=" + serialBoard +
                ", idBaseStation=" + idBaseStation +
                '}';
    }
}
