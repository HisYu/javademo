package controller.counselor;

import Dao.prefect.KaoqingDao;
import bean.prefect.StudentsS;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/ServletseeKaoqing")
public class ServletseeKaoqing extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        KaoqingDao s = new KaoqingDao();
        try {
            ArrayList<StudentsS> kaoqing = s.kaoqing();
            String str = JSON.toJSONString(kaoqing);
            response.getWriter().write(str);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
