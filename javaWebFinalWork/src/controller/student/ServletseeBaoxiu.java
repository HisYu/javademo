package controller.student;

import Dao.StudentDao.repairDao;
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

@WebServlet("/ServletseeBaoxiu")
public class ServletseeBaoxiu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            int i = Integer.parseInt(id);
            repairDao repairDao = new repairDao();
            try {
                RepairBean repairBean = repairDao.getrepairByid(i);
                if (repairBean == null) {
                    request.setAttribute("sugs", "用户不存在");
                    request.getRequestDispatcher("/jsp/student/seeBaoxiu.jsp").forward(request, response);

                } else {
                    System.out.println("你好bean");
                    ArrayList<RepairBean> repairBeans = new ArrayList<>();
                    repairBeans.add(repairBean);
                    request.setAttribute("repairBeans", repairBeans);

                    request.getRequestDispatcher("/jsp/student/seeBaoxiu.jsp").forward(request, response);

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
