package Dao.StudentDao;

import bean.Committee.RepairBean;
import bean.Student.Student;
import dbutils.c3p0utils;

import java.sql.*;

public class repairDao {

    public boolean getrepair(Student student) throws SQLException {
        c3p0utils c3p0utils = new c3p0utils();
        Connection conn = c3p0utils.getDataSource().getConnection();
        String sql = "insert into repair(id,name,type,leirong ,time) values (?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, student.getId());
        pstmt.setString(2, student.getName());
        pstmt.setString(3, student.getType());
        pstmt.setString(4, student.getLeirong());
        pstmt.setTimestamp(5, student.getTime());
        int i = pstmt.executeUpdate();

        if (i < 0) {
            return false;

        }
        return true;
    }

    public RepairBean getrepairByid(int id) throws SQLException {
        c3p0utils c3p0utils = new c3p0utils();
        Connection conn = c3p0utils.getDataSource().getConnection();
        RepairBean repairBean = null;
        String sql = "select * from repair where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {

            int anInt = rs.getInt(1);
            String name = rs.getString(2);
            String type = rs.getString(3);
            String leirong = rs.getString(4);
            Date time = rs.getDate(5);
            String statu = rs.getString(6);
            repairBean = new RepairBean(anInt, name, type, leirong, time, statu);
        }
        return repairBean;
    }

}
