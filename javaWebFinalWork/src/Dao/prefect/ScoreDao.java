package Dao.prefect;

import bean.prefect.Score;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {
    //使用c3p0
    //创建连接
    //创建c3p0工具类对象
    c3p0utils c3p0utils = new c3p0utils();

    //写成方法 查询成功返回score集合对象
    public ArrayList<Score> seeScore() throws SQLException {
//创建score对象 先赋值空
        Score score = null;
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;

        //获取连接

        conn = c3p0utils.getDataSource().getConnection();
        //写sql 语句查询学生
        String sql = "select * from score";
        //执行sql语句,利用conn的方法
        pstmt = conn.prepareStatement(sql);
        //获得结果集
        rs = pstmt.executeQuery();
        //遍历结果集
        //返回的有多个对象所以放在对象数组中要想获得长度可以定义零时变量

        ArrayList<Score> Scores = new ArrayList<>();
        while (rs.next()) {
            //这是根数据库中的数据是对应的
            int id = rs.getInt(1);
            String student = rs.getString(2);
            double datastruct = rs.getDouble(3);
            double java = rs.getDouble(4);
            double javaweb = rs.getDouble(5);
            //创建score对象 并调用构造方法方法赋值
            //这个时候有值了
            score = new Score(id, student, datastruct, java, javaweb);
            //吧对象放进集合中
            Scores.add(score);

        }
        return Scores;
    }

    public boolean updateScore(Double java, Double javaweb, Double datastruct, int studentId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        System.out.println("s" + studentId);


        conn = c3p0utils.getDataSource().getConnection();
        String sql = "UPDATE score SET datastruct=?, java=?, javaweb=? WHERE id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, datastruct);
        pstmt.setDouble(2, java);
        pstmt.setDouble(3, javaweb);
        pstmt.setInt(4, studentId);
        int i = pstmt.executeUpdate();
        System.out.println("你好" + i);
        if (i < 1) {
            return false;
        } else {
            return true;
        }

    }


    // 删除成绩
    public boolean deleteScore(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;


        conn = c3p0utils.getDataSource().getConnection();
        String sql = "DELETE FROM score WHERE id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int i = pstmt.executeUpdate();
        if (i < 1) {
            return false;
        }
        return true;
    }

    public void addScore(Score score) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = c3p0utils.getDataSource().getConnection();
        String sql = "INSERT INTO score (id, studentName, datastruct, java, javaweb) VALUES (?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, score.getStudentid());
        pstmt.setString(2, score.getStudentsName());
        pstmt.setDouble(4, score.getJava());
        pstmt.setDouble(5, score.getJavaweb());
        pstmt.setDouble(3, score.getDatastruct());
        pstmt.executeUpdate();

    }

    public boolean seeid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = c3p0utils.getDataSource().getConnection();
        String sql = "select  id from score";
        pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id1 = rs.getInt("id");
            if (id == id1) {

                return false;

            }
        }
        return true;
    }





}


