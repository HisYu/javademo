package controller.counselor;

import Dao.counselorDao.StudentinforDao;
import bean.counselor.Studentinfor;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Servletinfor")
public class Servletinfor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html ;charset = utf-8");
        request.setCharacterEncoding("utf-8");
        StudentinforDao infor = new StudentinforDao();
        try {
            ArrayList<Studentinfor> studentinfors = infor.seeAllInfor();
            String s = JSON.toJSONString(studentinfors);
            response.getWriter().write(s);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
