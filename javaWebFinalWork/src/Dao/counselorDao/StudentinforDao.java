package Dao.counselorDao;

import bean.User;
import bean.counselor.Studentinfor;
import bean.prefect.StudentsS;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentinforDao {
    public ArrayList<Studentinfor> seeAllInfor() throws SQLException {
//创建score对象 先赋值空
        Studentinfor studentinfor = null;
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        conn = c3p0utils.getDataSource().getConnection();
        String sql = "select * from studentinfor";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        ArrayList<Studentinfor> infor = new ArrayList<Studentinfor>();
        while (rs.next()) {
            //这是根数据库中的数据是对应的
            int id = rs.getInt(1);
            String student = rs.getString(2);
            String sex = rs.getString(3);
            String tell = rs.getString(4);
            String address = rs.getString(5);

            studentinfor = new Studentinfor(id, student, sex, tell, address);
            //吧对象放进集合中
            infor.add(studentinfor);

        }
        return infor;
    }

    public boolean seeByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        {

            conn = c3p0utils.getDataSource().getConnection();
            String sql = "select *  from studentinfor where studentid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;

        }
    }

    public void updateInforByid(int id, String name, String sex, String tell) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        {
            try {
                conn = c3p0utils.getDataSource().getConnection();
                String sql = "UPDATE studentinfor SET studentsex = ?, studenttell = ? ,studentaddress = ? WHERE studentid = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(4, id);
                pstmt.setString(1, name);
                pstmt.setString(2, sex);
                pstmt.setString(3, tell);
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("修改成功");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void addStudent(int id, String name, String sex, String tell, String address) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        {
            try {
                conn = c3p0utils.getDataSource().getConnection();
                String sql = "insert into studentinfor(studentid,studentname,studentsex,studenttell,studentaddress) values (?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, sex);
                pstmt.setString(4, tell);
                pstmt.setString(5, address);
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("插入成功");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void delectStudentByid(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        {
            try {
                conn = c3p0utils.getDataSource().getConnection();
                String sql = "DELETE FROM studentinfor WHERE studentid = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("删除成功");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
