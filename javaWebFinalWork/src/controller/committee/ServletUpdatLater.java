package controller.committee;

import Dao.CommitteeDao.CommitteeDao;
import Dao.CommitteeDao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/ServletUpdatLater")
public class ServletUpdatLater extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String studentid = request.getParameter("studentId");
        System.out.println("桂清"+studentid);
        String returntime = request.getParameter("returntime");
        if (studentid != null && !studentid.isEmpty() && returntime != null && !returntime.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(returntime, formatter);
            Timestamp dbDateTime = Timestamp.valueOf(dateTime);
            int i = Integer.parseInt(studentid);
            StudentDAO letur = new StudentDAO();
            try {
                letur.updateReturnTime(i,dbDateTime);
                response.sendRedirect("/javaWebFinalWork/jsp/Committee/lateReturn.jsp");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
