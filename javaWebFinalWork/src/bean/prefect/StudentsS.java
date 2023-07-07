package bean.prefect;

import javax.xml.crypto.Data;
import java.util.Date;

public class StudentsS {
    private int id;
    private String strudentName;
    private Date datatime;
    private String text;

    public StudentsS(int id, String strudentName, Date datatime, String text) {
        this.id = id;
        this.strudentName = strudentName;
        this.datatime = datatime;
        this.text = text;
    }

    public StudentsS() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrudentName() {
        return strudentName;
    }

    public void setStrudentName(String strudentName) {
        this.strudentName = strudentName;
    }

    public Date getDatatime() {
        return  datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
