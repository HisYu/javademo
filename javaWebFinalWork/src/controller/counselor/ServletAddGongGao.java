package controller.counselor;

import Dao.counselorDao.CouninforDao;
import bean.counselor.Counifor;

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

@WebServlet("/ServletAddGongGao")
public class ServletAddGongGao extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset= utf-8");
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String time = request.getParameter("time");
        System.out.println();
        if (title != null && !title.isEmpty() && content != null && !content.isEmpty() && time != null && !time.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
            Timestamp dbDateTime = Timestamp.valueOf(dateTime);

            Counifor counifor = new Counifor(title, content, dbDateTime);
            CouninforDao coun = new CouninforDao();
            try {
                boolean b = coun.saveAnnouncement(counifor);
                response.sendRedirect("/javaWebFinalWork/jsp/counselor/declear.jsp");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
