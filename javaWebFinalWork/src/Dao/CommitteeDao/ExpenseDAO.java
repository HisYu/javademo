package Dao.CommitteeDao;

import bean.Committee.Expense;
import dbutils.c3p0utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    public ArrayList getExpenses() throws SQLException {
        Expense expense = null;
        ArrayList<Expense> zhichu = new ArrayList<>();
        c3p0utils c3p0utils = new c3p0utils();
        Connection conn = c3p0utils.getDataSource().getConnection();
        String sql = "select * from committee ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {

            int anInt = rs.getInt(1);
            String content = rs.getString(2);
            int amount = rs.getInt(3);
            int total_amount = rs.getInt(4);
            expense = new Expense(anInt, content, amount, total_amount);
            zhichu.add(expense);
        }
        return zhichu;
    }

    //过得总共金额
    public void getTotalAmount() throws SQLException {
        Connection conn = null;
        conn = c3p0utils.getDataSource().getConnection();
        String sql = "SELECT * FROM committee ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
//得到最后的总额
        while (rs.next()) {
            Double totalAmount = rs.getDouble(3) - rs.getDouble(2);
            String sql2 = "UPDATE expenses SET total_amount; ?";
            pstmt = conn.prepareStatement(sql2);
            pstmt.setDouble(1, totalAmount);
            pstmt.executeUpdate();

        }

    }

    //增加消费
    public void addExpense(Expense expense) throws SQLException {

        PreparedStatement pstmt = null;
        Connection conn = c3p0utils.getDataSource().getConnection();
        String sql = "insert into committee (description, amount,total_amount) VALUES (?, ?,?)";
        pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery("SELECT total_amount FROM committee ORDER BY id DESC LIMIT 1");

        if (resultSet.next()) {
            pstmt.setString(1, expense.getDescription());
            pstmt.setDouble(2, expense.getAmount());
            pstmt.setDouble(3, resultSet.getInt("total_amount") - expense.getAmount());

        }

        int i = pstmt.executeUpdate();

    }


}
