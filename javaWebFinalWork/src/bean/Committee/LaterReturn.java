package bean.Committee;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LaterReturn {
    private int id;
    private String name;
    private int studentId;
    private Timestamp returnTime;

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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public LaterReturn() {
    }

    public LaterReturn(int id, String name, int studentId, Timestamp returnTime) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.returnTime = returnTime;
    }

    public LaterReturn(String name, int studentId, Timestamp returnTime) {
        this.name = name;
        this.studentId = studentId;
        this.returnTime = returnTime;
    }


}



