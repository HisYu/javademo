package bean.Committee;

import java.sql.Date;
import java.sql.Timestamp;

public class Announcement {
    private int id;
    private String title;
    private String content;
    private Timestamp time;

    public Announcement() {
    }



    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Announcement( int id, String title, String content,Timestamp time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
    }
    public Announcement( String title, String content,Timestamp time) {

        this.title = title;
        this.content = content;
        this.time = time;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
