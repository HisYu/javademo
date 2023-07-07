package controller.committee;

import Dao.CommitteeDao.StudentDAO;
import bean.Committee.LaterReturn;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/LateReturnController")
public class LateReturnController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
       StudentDAO studentDAO = new StudentDAO();

        try {
            List<LaterReturn> laterReturns = studentDAO.getAllStudents();
            String s = JSON.toJSONString(laterReturns);
            response.getWriter().write(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
}
