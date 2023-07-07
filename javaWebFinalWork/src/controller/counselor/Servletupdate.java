package controller.counselor;

import Dao.counselorDao.StudentinforDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Servletupdate")
public class Servletupdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("studentId");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String tell = request.getParameter("tell");
        String address = request.getParameter("address");
        System.out.println(id+ name + sex);
        if (id != null && !id.isEmpty() && name != null && !name.isEmpty() && sex != null && !sex.isEmpty() && tell != null && !tell.isEmpty() && address != null && !address.isEmpty()) {
            int i = Integer.parseInt(id);
            System.out.println(i);
            StudentinforDao studentinforDao = new StudentinforDao();
            try {
                if (studentinforDao.seeByid(i)) {
                    studentinforDao.updateInforByid(i, sex, tell, address);
                    response.sendRedirect("/javaWebFinalWork/jsp/counselor/studentinfor.jsp");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
