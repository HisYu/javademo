package Dao.CommitteeDao;

import bean.Committee.RepairBean;
import dbutils.c3p0utils;

import java.sql.*;
import java.util.ArrayList;

public class CommitteeDao {
    c3p0utils c3p0 = new c3p0utils();


    public ArrayList seeInformAll() throws SQLException {

        RepairBean repairBean = null;
        ArrayList<RepairBean> repair = new ArrayList<>();

        Connection conn = c3p0utils.getDataSource().getConnection();
        String sql = "select * from repair";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String type = rs.getString(3);

            String leirong = rs.getString(4);
            Date time = rs.getDate(5);

            String statu = rs.getString(6);
            repairBean = new RepairBean(id, name, type, leirong, time, statu);
            repair.add(repairBean);

        }
        return repair;
    }

    public void updateStatu(int studentId, String statu) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = c3p0utils.getDataSource().getConnection();

        String sql = "UPDATE repair SET statu = ? WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, statu);
            pstmt.setInt(2, studentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
