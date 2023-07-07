package bean.Student;

import java.sql.Timestamp;
import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String type;
    private String leirong;
    private Timestamp time;

    public Student() {
    }

    public Student(int id, String name, String type, String leirong, Timestamp time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.leirong = leirong;
        this.time = time;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLeirong() {
        return leirong;
    }

    public void setLeirong(String leirong) {
        this.leirong = leirong;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
