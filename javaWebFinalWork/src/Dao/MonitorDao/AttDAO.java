package Dao.MonitorDao;

import bean.Monitor.Attendance;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttDAO {
    public void saveAttendance(Attendance attendance) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = c3p0utils.getDataSource().getConnection();
            String sql = "INSERT INTO monitor_attendance (studentId, attendanceDate, attendanceStatus) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, attendance.getStudentId());
            stmt.setDate(2, new java.sql.Date(attendance.getAttendanceDate().getTime()));
            stmt.setString(3, attendance.getAttendanceStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public List<Attendance> getAttendances(Date fromDate, Date toDate) {
        List<Attendance> attendances = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = c3p0utils.getDataSource().getConnection();
            String sql = "SELECT * FROM monitor_attendance WHERE attendanceDate BETWEEN ? AND ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(fromDate.getTime()));
            stmt.setDate(2, new java.sql.Date(toDate.getTime()));
            rs = stmt.executeQuery();

            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setId(rs.getInt("id"));
                attendance.setStudentId(rs.getString("studentId"));
                attendance.setAttendanceDate(rs.getDate("attendanceDate"));
                attendance.setAttendanceStatus(rs.getString("attendanceStatus"));
                attendances.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return attendances;
    }
}
