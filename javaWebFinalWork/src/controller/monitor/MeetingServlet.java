package controller.monitor;

import Dao.MonitorDao.MeetingDAO;
import bean.Monitor.Meeting;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/MeetingServlet")
public class MeetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingDAO meetingDAO;

    public void init() {
        // 初始化 MeetingDAO 对象
        meetingDAO = new MeetingDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 防止乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取前端提交的表单数据
        String title = request.getParameter("title");
        String timeStr = request.getParameter("time");
        String spot = request.getParameter("spot");

        // 将时间字符串解析为 Date 对象
        Date time = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            time = dateFormat.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format");
            return;
        }

        // 创建 Meeting 对象
        Meeting meeting = new Meeting();
        meeting.setTitle(title);
        meeting.setTime(time);
        meeting.setSpot(spot);

        try {
            // 保存班会信息
            meetingDAO.addMeeting(meeting);

            // 重定向到班会列表页面
            response.sendRedirect(request.getContextPath() + "/jsp/Monitor/meetingList.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
