package controller;

import bean.User;
import Dao.UserDao;
import dbutils.c3p0utils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controllerLogin")
public class ControllerLogin extends HttpServlet {
    UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");

        // 登录验证
        boolean isValid = validateForm(request, username, userpassword);

        if (isValid) {
            User user = userDao.findUserByName(username);

            // 判断用户是否存在
            if (user == null || !username.equals(user.getUsername())) {
                request.setAttribute("noUserError", "查无此人，请点击注册");
                // 数据回显
                request.setAttribute("username", username);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                if (!userpassword.equals(user.getUserpwd())) {
                    request.setAttribute("passwordError", "密码错误");
                    // 数据回显
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    // 把名字放到session中
                    request.getSession().setAttribute("loginName", username);
                    response.sendRedirect(request.getContextPath() + "/jsp/successtest.jsp");
                }
            }
        } else {
            request.setAttribute("hasError", true);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    // 输入合法判断
    private boolean validateForm(HttpServletRequest request, String username, String password) {
        boolean isValid = true;
        // 空字符串
        if (username == null || username.trim().isEmpty()) {
            request.setAttribute("nameError", "请输入姓名");
            isValid = false;
        }

        if (password == null || password.trim().isEmpty()) {
            request.setAttribute("passwordError", "请输入密码");
            isValid = false;
        } else if (password.length() < 6 || password.length() > 12) {
            request.setAttribute("passwordError", "密码长度必须为6-12个字符");
            isValid = false;
        }

        // 数据回显
        request.setAttribute("username", username);
        request.setAttribute("userpassword", password);
        return isValid;
    }
}


