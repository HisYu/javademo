package controller;

import Dao.UserDao;
import bean.User;
import bean.prefect.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/testC3p0")
public class testC3p0 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           UserDao userDao = new UserDao();

        ArrayList<String>  userList = userDao.seeAllUser();
          request.setAttribute("infor", userList);
        request.getRequestDispatcher("/jsp/jdbcTestC/555.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
