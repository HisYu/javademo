package Dao.counselorDao;

import bean.counselor.Look;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LookDao {
    public List<Look> getAllLooks() throws SQLException {
        List<Look> lookList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 获取数据库连接
            conn = c3p0utils.getDataSource().getConnection();

            // 创建 SQL 语句
            String sql = "SELECT * FROM monitor_report";

            // 创建 PreparedStatement 对象
            pstmt = conn.prepareStatement(sql);

            // 执行查询操作
            rs = pstmt.executeQuery();

            // 遍历结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                Date reportTime = rs.getTimestamp("reptime");
                String reportContent = rs.getString("repevent");

                // 创建 Look 对象
                Look look = new Look(id, reportTime, reportContent);

                // 将 Look 对象添加到列表中
                lookList.add(look);
            }
        } finally {
            // 关闭资源

        }

        return lookList;
    }
}
