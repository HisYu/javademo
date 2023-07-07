package controller;

import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/controllerMenu")
public class ControllerMenu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取用户名的权限值再来判断职位，跳转到不同的界面
        try {
            getFunction(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void getFunction(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        //获取所有用户的权限
        UserDao userdao = new UserDao();
        String name = (String) request.getSession().getAttribute("loginName");
//直接获取
        int index = userdao.seeAllQuanxianByName(name);
        if (index != 0) {
            //一个用户只有一个
            switch (index) {
                case 1: {
                    System.out.println("1");
                    response.sendRedirect("/javaWebFinalWork/jsp/counselor/counselorMenu.jsp");

                    //跳转到辅导员界面
                    break;
                }
                case 2: {
                    System.out.println("2");
                    //跳转到班长界面
                    response.sendRedirect("/javaWebFinalWork/jsp/Monitor/main.jsp");

                    break;
                }
                case 3: {
                    System.out.println("3");
                    response.sendRedirect("/javaWebFinalWork/jsp/prefect/prefectMenu.jsp");

                    //跳转学委员界面
                    break;
                }
                case 4: {
                    System.out.println("4");
                    //跳转生活委员员界面
                    response.sendRedirect("/javaWebFinalWork/jsp/Committee/committeeMenu.jsp");
                    break;
                }
                case 5: {
                    System.out.println("5");
                    //跳转学生员界面
                    response.sendRedirect("/javaWebFinalWork/jsp/student/studentMenu.jsp");
                    break;
                }


                default: {


                }
            }


        }


    }


}
