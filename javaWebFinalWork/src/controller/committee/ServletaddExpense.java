package controller.committee;

import Dao.CommitteeDao.ExpenseDAO;
import bean.Committee.Expense;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ServletaddExpense")
public class ServletaddExpense extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String description = request.getParameter("description");
        double amount = Double.parseDouble(request.getParameter("amount"));
        Expense expense = new Expense(description, amount);
        ExpenseDAO expenseDAO = new ExpenseDAO();
        try {
            expenseDAO.addExpense(expense);


            response.sendRedirect("/javaWebFinalWork/jsp/Committee/ExpenseManager.jsp");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
