package Dao.MonitorDao;

import bean.Monitor.Notification;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationListDAO {
    public List<Notification> getNotificationList() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Notification> notificationList = new ArrayList<>();

        try {
            // 获取数据库连接
            conn = c3p0utils.getDataSource().getConnection();

            // 查询通知列表
            String sql = "SELECT * FROM monitor_notification";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // 将通知列表存储在List<Notification>中
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Notification notification = new Notification(id, title, content);
                notificationList.add(notification);
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

        return notificationList;
    }
}
