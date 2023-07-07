package controller.prefect;

import Dao.prefect.ScoreDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ControllerUpdate")
public class ControllerUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        try {
            String studentId = request.getParameter("studentId");
            String java = request.getParameter("java1");
            String javaweb = request.getParameter("javaweb2");
            String datastruct = request.getParameter("datastruct3");
            System.out.println("studentId: " + studentId);
            if (studentId != null && !studentId.isEmpty()) {
                int studentsId = Integer.parseInt(studentId);
                System.out.println("studentsId: " + studentsId);
                ScoreDao scoreDao = new ScoreDao();

                System.out.println("java: " + java + ", javaweb: " + javaweb + ", datastruct: " + datastruct);

                if (java != null && !java.isEmpty() && javaweb != null && !javaweb.isEmpty() && datastruct != null && !datastruct.isEmpty()) {
                    double Java = Double.parseDouble(java);
                    double Javaweb = Double.parseDouble(javaweb);
                    double Datastruct = Double.parseDouble(datastruct);
                    System.out.println("Java: " + Java + ", Javaweb: " + Javaweb + ", Datastruct: " + Datastruct);
                    scoreDao.updateScore(Java, Javaweb, Datastruct, studentsId);
                    response.sendRedirect("/javaWebFinalWork/jsp/prefect/student_form.jsp");
                }
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
