package entities;

public class Board {
    private long seerial;
    private String type;

    public Board(long seerial, String type) {

        this.seerial = seerial;
        this.type = type;
    }

    public Board() {

    }

    public long getSeerial() {
        return seerial;
    }

    public void setSeerial(long seerial) {
        this.seerial = seerial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Board{" +
                "seerial=" + seerial +
                ", type='" + type + '\'' +
                '}';
    }
}
