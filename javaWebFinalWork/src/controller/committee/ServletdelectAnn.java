package controller.committee;

import Dao.CommitteeDao.AnnouncementDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ServletdelectAnn")
public class ServletdelectAnn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        System.out.println(studentId);
        AnnouncementDAO announcementDAO = new AnnouncementDAO();
        if (studentId != null && !studentId.isEmpty()) {
            int i = Integer.parseInt(studentId);
            try {
                announcementDAO.deleteAnn(i);
                response.sendRedirect("/javaWebFinalWork/jsp/Committee/announcement.jsp");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
