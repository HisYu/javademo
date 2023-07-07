package bean.Committee;

import java.sql.Date;
import java.sql.Time;

public class RepairBean {
    private int id;
    private String name;
    private Date time;
    private String leirong;
    private String type;
    private String statu;

    public RepairBean() {
    }

    public RepairBean(int id, String name, String type, String leirong, Date time, String statu) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.leirong = leirong;
        this.time = time;
        this.statu = statu;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLeirong() {
        return leirong;
    }

    public void setLeirong(String leirong) {
        this.leirong = leirong;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
}
