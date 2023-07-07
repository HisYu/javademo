package controller.prefect;

import Dao.prefect.ScoreDao;
import bean.prefect.Score;
import com.alibaba.fastjson.JSON;
import com.mysql.cj.xdevapi.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/controllerScore")
public class ControllerScore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        request.setCharacterEncoding("utf-8");
        ScoreDao scoreDao = new ScoreDao();
        try {
            ArrayList<Score> scores = scoreDao.seeScore();
            //转化成json的字符串
            String str = JSON.toJSONString(scores);
            response.getWriter().write(str);
// 在这里可以使用 studentId 来执行相应的删除逻辑
            String studentId = (request.getParameter("studentId"));
            if (studentId != null && !studentId.isEmpty()) {
                int studentsId = Integer.parseInt(studentId);
                // 其他逻辑...

                System.out.println("你好" + studentsId);
                boolean b = scoreDao.deleteScore((studentsId));
                response.sendRedirect("/javaWebFinalWork/jsp/prefect/student_form.jsp");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
