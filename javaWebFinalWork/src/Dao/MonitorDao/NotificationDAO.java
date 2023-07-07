package Dao.MonitorDao;

import bean.Monitor.Notification;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotificationDAO {
    public void addNotification(Notification notification) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // 获取数据库连接
            conn = c3p0utils.getDataSource().getConnection();

            // 添加新通知
            String sql = "INSERT INTO monitor_notification (title, content) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, notification.getTitle());
            stmt.setString(2, notification.getContent());
            stmt.executeUpdate();
        } finally {
            // 关闭连接和释放资源

        }
    }
}
