package bean.counselor;

import java.sql.Timestamp;

public class Counifor {
    private int id;
    private String tile;
    private String text;
    private Timestamp time;

    public Counifor() {
    }

    public Counifor(int id, String tile, String text, Timestamp time) {
        this.id = id;
        this.tile = tile;
        this.text = text;
        this.time = time;
    }
    public Counifor(String tile, String text, Timestamp time) {

        this.tile = tile;
        this.text = text;
        this.time = time;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
