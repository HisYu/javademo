package bean.counselor;

import java.util.Date;

// 汇报
public class Look {
    private int id;
    private Date reptime;
    private String repevent;

    public Look() {
    }

    public Look(int id, Date reptime, String repevent) {
        this.id = id;
        this.reptime = reptime;
        this.repevent = repevent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReptime() {
        return reptime;
    }

    public void setReptime(Date reptime) {
        this.reptime = reptime;
    }

    public String getRepevent() {
        return repevent;
    }

    public void setRepevent(String repevent) {
        this.repevent = repevent;
    }

    public String getReportContent() {
        return repevent;
    }

    public void setReportContent(String repevent) {
        this.repevent = repevent;
    }

    public Date getReportTime() {
        return reptime;
    }

    public void setReportTime(Date reptime) {
        this.reptime = reptime;
    }
}
