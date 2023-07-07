package controller.committee;

import Dao.CommitteeDao.CommitteeDao;
import bean.Committee.RepairBean;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/RepairManagement")
public class RepairManagement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html ; charset= utf-8");
        request.setCharacterEncoding("utf-8");
        CommitteeDao comm = new CommitteeDao();

        try {
            ArrayList<RepairBean> arrayList = comm.seeInformAll();
            String s = JSON.toJSONString(arrayList);
            response.getWriter().write(s);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
