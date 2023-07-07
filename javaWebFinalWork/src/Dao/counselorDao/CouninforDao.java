package Dao.counselorDao;

import bean.Committee.Announcement;
import bean.counselor.Counifor;
import dbutils.c3p0utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouninforDao {
    public List<Announcement> getAllAnnouncements() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Announcement> announcements = new ArrayList<>();
        connection = dbutils.c3p0utils.getDataSource().getConnection();
        Announcement announcement = null;

        try {
            String sql = "SELECT * FROM couninfro";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                Timestamp date = rs.getTimestamp(4);
                announcement = new Announcement(id, title, content, date);
                announcements.add(announcement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return announcements;
    }

    public boolean deleteAnn(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;


        conn = c3p0utils.getDataSource().getConnection();
        String sql = "DELETE FROM couninfro WHERE id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int i = pstmt.executeUpdate();
        if (i < 1) {
            return false;
        }
        return true;
    }

    public boolean saveAnnouncement(Counifor counifor) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = dbutils.c3p0utils.getDataSource().getConnection();
        try {
            String sql = "insert into couninfro (title, text,gonggaotime ) VALUES (?, ?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, counifor.getTile());
            statement.setString(2, counifor.getText());
            statement.setTimestamp(3, counifor.getTime());
            int i = statement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
