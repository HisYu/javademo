package Dao.prefect;

import bean.prefect.Lession;
import dbutils.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LessionDao {

    public ArrayList<Lession> seeClass() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Lession lession = null;
        ArrayList<Lession> lessions = new ArrayList<>();
        c3p0utils c3p0utils = new c3p0utils();
        conn = c3p0utils.getDataSource().getConnection();
        String sql = "select * from classlession";
        pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String anInt = rs.getString(2);
            String anInt2 = rs.getString(3);
            String anInt3 = rs.getString(4);
            String anInt4 = rs.getString(5);
            String anInt5 = rs.getString(6);
            lession = new Lession(id, anInt, anInt2, anInt3, anInt4, anInt5);
            lessions.add(lession);
        }
        return lessions;
    }

    public void updateLession(String x1, String x2, String x3, String x4, String x5, int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Lession lession = null;
        ArrayList<Lession> lessions = new ArrayList<>();
        c3p0utils c3p0utils = new c3p0utils();
        conn = c3p0utils.getDataSource().getConnection();
        String sql = "UPDATE classlession SET x1 = ?,x2 = ?,x3 = ?,x4 = ?,x5 = ? WHERE id = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, x1);
        pstmt.setString(2, x2);
        pstmt.setString(3, x3);
        pstmt.setString(4, x4);
        pstmt.setString(5, x5);
        pstmt.setInt(6, id);

        int i = pstmt.executeUpdate();

    }

}