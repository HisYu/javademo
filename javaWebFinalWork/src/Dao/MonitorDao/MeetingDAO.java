package Dao.MonitorDao;

import bean.Monitor.Meeting;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MeetingDAO {
    public void addMeeting(Meeting meeting) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // 获取数据库连接
            conn = c3p0utils.getDataSource().getConnection();

            // 插入班会数据
            String sql = "INSERT INTO monitor_meeting (title, time, spot) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, meeting.getTitle());
            stmt.setDate(2, new java.sql.Date(meeting.getTime().getTime()));
            stmt.setString(3, meeting.getSpot());
            stmt.executeUpdate();
        } finally {
            // 关闭连接和释放资源
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }


}
