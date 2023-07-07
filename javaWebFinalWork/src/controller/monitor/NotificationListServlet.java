package controller.monitor;

import Dao.MonitorDao.NotificationListDAO;
import bean.Monitor.Notification;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/NotificationListServlet")
public class NotificationListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NotificationListDAO notificationListDAO;

    public void init() {
        // 初始化NotificationListDAO对象
        notificationListDAO = new NotificationListDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 查询通知列表
            List<Notification> notificationList = notificationListDAO.getNotificationList();

            // 将通知列表存储为请求属性
            request.setAttribute("notificationList", notificationList);

            // 转发到notificationList.jsp页面
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Monitor/notificationList.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
