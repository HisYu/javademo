package controller.counselor;

import Dao.counselorDao.StudentinforDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletdelectStu")
public class ServletdelectStu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = (request.getParameter("studentId"));
        if (studentId != null && !studentId.isEmpty()) {
            int studentsId = Integer.parseInt(studentId);
            StudentinforDao studentinforDao = new StudentinforDao();
            studentinforDao.delectStudentByid(studentsId);
            response.sendRedirect("/javaWebFinalWork/jsp/counselor/studentinfor.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
