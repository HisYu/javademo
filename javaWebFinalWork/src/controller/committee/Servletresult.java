package controller.committee;

import Dao.CommitteeDao.CommitteeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Servletresult")
public class Servletresult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset= utf-8");
        String studentId = request.getParameter("studentId");
        String statu = request.getParameter("statu");
        if (studentId != null && !studentId.isEmpty() && statu!= null&&!statu.isEmpty()) {
            int i = Integer.parseInt(studentId);
            CommitteeDao committeeDao = new CommitteeDao();
            try {
                committeeDao.updateStatu(i, statu);
                response.sendRedirect("/javaWebFinalWork/jsp/CommitteeDao/repair_view.jsp");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
