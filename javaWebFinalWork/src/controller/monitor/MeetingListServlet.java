package controller.monitor;

import Dao.MonitorDao.MeetingListDAO;
import bean.Monitor.Meeting;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Date;

@WebServlet("/MeetingListServlet")
public class MeetingListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingListDAO meetingListDAO;
    private static final Logger LOGGER = Logger.getLogger(MeetingListServlet.class.getName());

    public void init() {
        // 初始化 MeetingListDAO 对象
        meetingListDAO = new MeetingListDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // 获取班会列表
            List<Meeting> meetingList = meetingListDAO.getMeetingList();

            // 设置响应的内容类型为 JSON
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            // 将 JSON 数据作为响应发送回前端
            response.getWriter().write(buildJson(meetingList));
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to get meeting list from the database", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to get meeting list");
        }
    }

    private String buildJson(List<Meeting> meetingList) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for (int i = 0; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"id\":").append(meeting.getId()).append(",");
            jsonBuilder.append("\"title\":\"").append(meeting.getTitle()).append("\",");
            jsonBuilder.append("\"time\":\"").append(formatDate(meeting.getTime())).append("\",");
            jsonBuilder.append("\"spot\":\"").append(meeting.getSpot()).append("\"");
            jsonBuilder.append("}");
            if (i < meetingList.size() - 1) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
