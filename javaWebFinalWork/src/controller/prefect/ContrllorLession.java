package controller.prefect;

import Dao.prefect.LessionDao;
import bean.prefect.Lession;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/contrllorLession")
public class ContrllorLession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LessionDao lessionDao = new LessionDao();
        try {
            ArrayList<Lession> lessions = lessionDao.seeClass();
            String str = JSON.toJSONString(lessions);
            response.getWriter().write(str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
