package controller.prefect;

import Dao.prefect.ScoreDao;
import bean.prefect.Score;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/ServletSelectFaildScore")
public class ServletSelectFaildScore extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreDao scoreDao = new ScoreDao();
        response.setContentType("application/json; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        try {
            ArrayList<Score> scores =scoreDao.seeScore();

            String str = JSON.toJSONString(scores);
           response.getWriter().write(str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
