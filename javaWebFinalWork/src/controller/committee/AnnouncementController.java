package controller.committee;

import Dao.CommitteeDao.AnnouncementDAO;
import bean.Committee.Announcement;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AnnouncementController")
public class AnnouncementController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理保存公告的逻辑
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            AnnouncementDAO allAnnouncements = new AnnouncementDAO();
            List<Announcement> Announcements = allAnnouncements.getAllAnnouncements();
            String s = JSON.toJSONString(Announcements);
            response.getWriter().write(s);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
