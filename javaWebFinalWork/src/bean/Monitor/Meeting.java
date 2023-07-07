package bean.Monitor;

import java.util.Date;

public class Meeting {
    private int id;
    private String title;
    private Date time;
    private String spot;

    public Meeting() {}

    public Meeting(int id, String title, Date time, String spot) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.spot = spot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }
}
