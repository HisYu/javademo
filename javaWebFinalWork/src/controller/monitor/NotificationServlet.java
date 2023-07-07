package controller.monitor;

import Dao.MonitorDao.NotificationDAO;
import bean.Monitor.Notification;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NotificationServlet")
public class NotificationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NotificationDAO notificationDAO;

    public void init() {
        // 初始化NotificationDAO对象
        notificationDAO = new NotificationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 防止乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取前端数据
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        try {
            // 创建通知对象
            Notification notification = new Notification(title, content);

            // 添加新通知
            notificationDAO.addNotification(notification);

            // 重定向到发布通知页面或其他页面
            response.sendRedirect(request.getContextPath() + "/jsp/Monitor/notification.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
