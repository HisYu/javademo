package controller.prefect;

import Dao.UserDao;
import Dao.prefect.ScoreDao;
import bean.prefect.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/controlleradd")
public class Controlleradd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        request.setCharacterEncoding("utf-8");
        this.doPost(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("stuid");
        String java = request.getParameter("java");
        String studentName = request.getParameter("studentName");
        String javaweb = request.getParameter("javaweb");
        String datastruct = request.getParameter("datastruct");

        if (id != null && !id.isEmpty() &&
                java != null && !java.isEmpty() &&
                studentName != null && !studentName.isEmpty() &&
                javaweb != null && !javaweb.isEmpty() &&
                datastruct != null && !datastruct.isEmpty()
        ) {
            int nid = Integer.parseInt(id);

            Double njava = Double.parseDouble(java);
            Double njavaweb = Double.parseDouble(javaweb);
            Double datas = Double.parseDouble(datastruct);
            Score score = new Score(nid, studentName, datas, njava, njavaweb);

            ScoreDao scoreDao = new ScoreDao();
            try {
                boolean seeid = scoreDao.seeid(nid);
                if (seeid) {
                    scoreDao.addScore(score);
                    response.sendRedirect("/javaWebFinalWork/jsp/prefect/student_form.jsp");
                } else {
                    request.setAttribute("sugs","学生id重复请重新输入");
                    request.getRequestDispatcher("/jsp/prefect/addScore.jsp").forward(request,response);
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }

}
