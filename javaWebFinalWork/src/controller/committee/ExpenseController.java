package controller.committee;

import Dao.CommitteeDao.ExpenseDAO;
import bean.Committee.Expense;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/ExpenseController")
public class ExpenseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");

        ExpenseDAO expenseDAO = new ExpenseDAO();
        try {
            ArrayList expenses = expenseDAO.getExpenses();
            String s = JSON.toJSONString(expenses);
            response.getWriter().write(s);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
