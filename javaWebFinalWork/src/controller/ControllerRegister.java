package controller;

import bean.User;
import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controllerRegister")
public class ControllerRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String rusername = request.getParameter("rusername");
        String ruserpassword = request.getParameter("ruserpassword");
        UserDao userdao = new UserDao();
        User userd = userdao.findUserByName(rusername);
        String selectedOption = request.getParameter("positions");

        // 判断职位
        int index = 0;
        if (selectedOption.equals("prefect")) {
            index = 1;
            response.getWriter().write("辅导员");
        } else if (selectedOption.equals("monitor")) {
            index = 2;
            response.getWriter().write("班长");
        } else if (selectedOption.equals("counselor")) {
            index = 3;
            response.getWriter().write("学委");
        } else if (selectedOption.equals("committee")) {
            index = 4;
            response.getWriter().write("生活委员");
        }else if (selectedOption.equals("student")) {
            index = 5;
        }

        // 验证表单
        boolean isValid = validateForm(request, rusername, ruserpassword);
        if (isValid) {
            ArrayList<String> allName = userdao.seeAllUser();
            // 遍历判断是否用户名重复
            for (String it : allName) {
                if (rusername.equals(it)) {
                    request.setAttribute("rnameErro", "用户名重复请重新输入");
                    request.setAttribute("rname", rusername);
                    request.setAttribute("psts",selectedOption );

                    request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
                    return;  // 终止当前请求处理，防止继续执行后续的重定向操作
                }
            }

            // 注册用户并执行重定向
            request.getSession().setAttribute("loginName", rusername);
            userdao.addUser(rusername, ruserpassword, index);
            response.sendRedirect("jsp/successtest.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private boolean validateForm(HttpServletRequest request, String name, String password) {
        boolean isValid = true;

        // 验证用户名和密码是否合法
        if (name == null || name.trim().isEmpty()) {
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
        request.setAttribute("name", name);
        request.setAttribute("upwd", password);
        return isValid;
    }
}
