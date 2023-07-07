package bean.prefect;

public class Score {
    //创建分数bean类，用其dao类访问数据库

    private int studentid;
    private String studentsName;
    private double java;
    private double javaweb;
    private double datastruct;


    public Score(double java) {
        this.java = java;
    }
    public Score() {
    }


    public Score(int studentid, String studentsName, double java, double javaweb, double datastruct) {
        this.studentid = studentid;
        this.studentsName = studentsName;
        this.java = java;
        this.javaweb = javaweb;
        this.datastruct = datastruct;
    }

    public Score(String studentsName, double datastruct, double java, double javaweb) {
        this.studentsName = studentsName;
        this.java = java;
        this.javaweb = javaweb;
        this.datastruct = datastruct;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getJavaweb() {
        return javaweb;
    }

    public void setJavaweb(double javaweb) {
        this.javaweb = javaweb;
    }

    public double getDatastruct() {
        return datastruct;
    }

    public void setDatastruct(double datastruct) {
        this.datastruct = datastruct;
    }
}