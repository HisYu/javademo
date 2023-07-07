package controller.monitor;

import Dao.MonitorDao.NotificationListDAO;
import bean.Monitor.Notification;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ServletseeTongzhi")
public class ServletseeTongzhi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        NotificationListDAO notificationListDAO = new NotificationListDAO();

        try {
            List<Notification> notificationList1 = notificationListDAO.getNotificationList();
            String s = JSON.toJSONString(notificationList1);
            response.getWriter().write(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 将通知列表存储为请求属性

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
