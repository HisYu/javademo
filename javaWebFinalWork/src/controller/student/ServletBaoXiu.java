package controller.student;

import Dao.StudentDao.repairDao;
import bean.Student.Student;

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

@WebServlet("/ServletBaoXiu")
public class ServletBaoXiu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset= utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String leirong = request.getParameter("leirong");
        String time = request.getParameter("time");
        System.out.println(id);
        if (id != null && !id.isEmpty() && name != null && !name.isEmpty() && type != null && !type.isEmpty() && leirong != null && !leirong.isEmpty() && time != null && !time.isEmpty()) {
            int i = Integer.parseInt(id);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
            Timestamp dbDateTime = Timestamp.valueOf(dateTime);
            repairDao repairDao = new repairDao();
            Student student = new Student(i, name, type, leirong, dbDateTime);
            System.out.println("nihao");
            try {
                boolean getrepair = repairDao.getrepair(student);
                if (getrepair) {
                    response.sendRedirect("/javaWebFinalWork/jsp/student/repair_form.jsp-");
                    response.getWriter().write("提交成功");
                } else {

                    response.getWriter().write("提交失败");

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        } else {
            response.getWriter().write("年后");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
