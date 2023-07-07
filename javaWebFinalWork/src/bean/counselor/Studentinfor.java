package bean.counselor;

public class Studentinfor {
    private int id;
    private String name;
    private String sex;
    private String tell;
    private String address;

    public Studentinfor() {
    }

    public Studentinfor(int id, String name, String sex, String tell, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.tell = tell;
        this.address = address;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
