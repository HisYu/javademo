package Dao.prefect;

import bean.prefect.StudentsS;
import dbutils.c3p0utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class KaoqingDao {

    //写成方法 查询成功返回score集合对象
    public ArrayList<StudentsS> kaoqing() throws SQLException {
//创建score对象 先赋值空
        StudentsS studentsS = null;
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        conn = c3p0utils.getDataSource().getConnection();
        String sql = "select * from studentinfor";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        ArrayList<StudentsS> kaoqing = new ArrayList<StudentsS>();
        while (rs.next()) {
            //这是根数据库中的数据是对应的
            int id = rs.getInt(1);
            String student = rs.getString(2);
            Date time = rs.getDate(6);
            String thing = rs.getString(7);
            //创建score对象 并调用构造方法方法赋值
            //这个时候有值了
            studentsS = new StudentsS(id, student, time, thing);
            //吧对象放进集合中
            kaoqing.add(studentsS);

        }
        return kaoqing;
    }

    public void updatekao(Timestamp time, String thing, int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = c3p0utils.getDataSource().getConnection();
            String sql = "UPDATE studentinfor SET datatime = ?, text = ? WHERE studentid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(3, id);
            pstmt.setTimestamp(1, time);
            pstmt.setString(2, thing);

            int i = pstmt.executeUpdate();

            if (i > 0) {
                System.out.println("修改成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {


        }
    }

    public void addKaoqing(String name, Timestamp time, String text) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = c3p0utils.getDataSource().getConnection();
            String sql = "INSERT INTO studentinfor (studentname, datatime, text) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setTimestamp(2, time);
            pstmt.setString(3, text);

            int i = pstmt.executeUpdate();

            if (i > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {


        }

    }

    public void delectKaoqing(int i) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;


        conn = c3p0utils.getDataSource().getConnection();
        String sql = "DELETE FROM studentinfor WHERE studentid = ? ";
        pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, i);
        int i1 = pstmt.executeUpdate();
    }
}