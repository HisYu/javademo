package controller.prefect;

import Dao.prefect.KaoqingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/ControllerAddKaoqing")
public class ControllerAddKaoqing extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset= utf-8");
        request.setCharacterEncoding("utf-8");
        KaoqingDao s = new KaoqingDao();
        String dateTimeString = request.getParameter("time");
        String thing = request.getParameter("thing");
        String name = request.getParameter("name");

        if (name !=null && !name.isEmpty()&&dateTimeString != null && !dateTimeString.isEmpty() && thing != null && !thing.isEmpty()) {
            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
                Timestamp dbDateTime = Timestamp.valueOf(dateTime);

                s.addKaoqing(name, dbDateTime, thing);
                response.sendRedirect("/javaWebFinalWork/jsp/prefect/kaoqing.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
