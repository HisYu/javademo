package Dao;

import bean.User;
import dbutils.c3p0utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    public User user = null;
    c3p0utils cp = new c3p0utils();
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    public User findUserByName(String name) {
        {
            try {
                conn = c3p0utils.getDataSource().getConnection();
                String sql = "select * from posts where username = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    String username = rs.getString(2);
                    String userpwd = rs.getString(3);
                    user = new User(username, userpwd);

                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                return user;
            }
        }


    }

    public User addUser(String username, String upwd, int quanxian) {

        {
            try {
                conn = c3p0utils.getDataSource().getConnection();
                String sql = "insert into posts(username,userpwd,quanxian) values (?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, upwd);
                pstmt.setInt(3, quanxian);
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    System.out.println("插入成功");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                return user;
            }
        }


    }

    public ArrayList seeAllUser() {
        ArrayList<String> name = new ArrayList<>();
        {
            try {
                conn = c3p0utils.getDataSource().getConnection();
                String sql = "select username from posts";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    name.add(username);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                return name;
            }

        }
    }

    public int seeAllQuanxianByName(String name) throws SQLException {


        conn = c3p0utils.getDataSource().getConnection();
        String sql = "select quanxian from posts where username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int userQX = rs.getInt("quanxian");
            return userQX;
        }


        return 0;

    }


}
