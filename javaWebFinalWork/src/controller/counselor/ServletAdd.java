package controller.counselor;

import Dao.counselorDao.StudentinforDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ServletAdd")
public class ServletAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String tell = request.getParameter("tell");
        String address = request.getParameter("address");
        if (id != null && !id.isEmpty() && name != null && !name.isEmpty() && sex != null && !sex.isEmpty() && tell != null && !tell.isEmpty() && address != null && !address.isEmpty()) {
            int i = Integer.parseInt(id);

            StudentinforDao studentinforDao = new StudentinforDao();
            try {
                if (!studentinforDao.seeByid(i)) {
                    studentinforDao.addStudent(i, name, sex, tell, address);
                    response.sendRedirect("/javaWebFinalWork/jsp/counselor/studentinfor.jsp");
                } else {
                    request.setAttribute("sugs", "学生重复请重新输入");
                    request.getRequestDispatcher("/jsp/counselor/addStudent.jsp").forward(request, response);

                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        request.setCharacterEncoding("utf-8");
        this.doPost(request, response);
    }
}
