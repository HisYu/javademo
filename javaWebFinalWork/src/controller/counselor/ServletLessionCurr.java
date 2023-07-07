package controller.counselor;

import Dao.prefect.LessionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ServletLessionCurr")
public class ServletLessionCurr extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        request.setCharacterEncoding("utf-8");
        String studentId = request.getParameter("studentId");
        String x1 = request.getParameter("x1");
        String x2 = request.getParameter("x2");
        String x3 = request.getParameter("x3");
        String x4 = request.getParameter("x4");
        String x5 = request.getParameter("x5");
        request.setAttribute("x1", x1);
        request.setAttribute("x2", x2);
        request.setAttribute("x3", x3);
        request.setAttribute("x4", x4);
        request.setAttribute("x5", x5);
        if (studentId != null && !studentId.isEmpty() && x1 != null && !x1.isEmpty() && x2 != null && !x2.isEmpty() && x3 != null && !x3.isEmpty() && x4 != null && !x4.isEmpty() && x5 != null && !x5.isEmpty()) {
            int i = Integer.parseInt(studentId);
            LessionDao lessionDao = new LessionDao();
            try {
                lessionDao.updateLession(x1, x2, x3, x4, x5, i);
                response.sendRedirect("/javaWebFinalWork/jsp/counselor/classcurr.jsp");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
