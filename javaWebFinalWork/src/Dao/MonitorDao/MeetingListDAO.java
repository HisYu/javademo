package Dao.MonitorDao;

import bean.Monitor.Meeting;
import dbutils.c3p0utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingListDAO {
    public List<Meeting> getMeetingList() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Meeting> meetingList = new ArrayList<>();

        try {
            // 获取数据库连接
            conn = c3p0utils.getDataSource().getConnection();

            // 查询班会列表
            String sql = "SELECT * FROM monitor_meeting";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // 将班会列表存储在 List<Meeting> 中
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date time = rs.getDate("time");
                String spot = rs.getString("spot");
                Meeting meeting = new Meeting(id, title, time, spot);
                meetingList.add(meeting);
            }
        } finally {
            // 关闭连接和释放资源
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return meetingList;
    }
}
