package Dao.CommitteeDao;

import bean.Committee.LaterReturn;
import dbutils.c3p0utils;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection conn;
    PreparedStatement statement;
    c3p0utils c3p0utils = new c3p0utils();


    // 初始化数据库连接


    public List<LaterReturn> getAllStudents() throws SQLException {

        conn = c3p0utils.getDataSource().getConnection();
        List<LaterReturn> laterReturns = new ArrayList<>();
        String query = "SELECT * FROM students";
        try {
            statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int studentId = resultSet.getInt("student_id");
                Timestamp returnTime = resultSet.getTimestamp("return_time");
                laterReturns.add(new LaterReturn(id, name, studentId, returnTime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laterReturns;
    }

    public void addStudent(LaterReturn laterReturn) throws SQLException {
        conn = c3p0utils.getDataSource().getConnection();
        PreparedStatement pstmt;
        String sql = "INSERT INTO students (name, student_id, return_time) VALUES (?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, laterReturn.getName());
            pstmt.setInt(2, laterReturn.getStudentId());
            pstmt.setTimestamp(3, laterReturn.getReturnTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReturnTime(int studentId, Timestamp newReturnTime) throws SQLException {
        conn = c3p0utils.getDataSource().getConnection();
        PreparedStatement pstmt;
        String sql = "UPDATE students SET return_time = ? WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, newReturnTime);
            pstmt.setInt(2, studentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
