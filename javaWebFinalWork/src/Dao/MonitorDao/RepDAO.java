package Dao.MonitorDao;

import bean.Monitor.Report;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepDAO {
    public void saveReport(Report report) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 获取数据库连接
            conn = c3p0utils.getDataSource().getConnection();

            // 创建 SQL 语句
            String sql = "INSERT INTO monitor_report (reptime, repevent) VALUES (?, ?)";

            // 创建 PreparedStatement 对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, new java.sql.Timestamp(report.getReportTime().getTime()));
            pstmt.setString(2, report.getReportContent());

            // 执行插入操作
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源

        }
    }
}
