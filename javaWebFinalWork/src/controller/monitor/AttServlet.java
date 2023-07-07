package controller.monitor;

import Dao.MonitorDao.AttDAO;
import bean.Monitor.Attendance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/AttServlet")
public class AttServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String attendanceDate = request.getParameter("attendanceDate");
        String attendanceStatus = request.getParameter("attendanceStatus");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(attendanceDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Attendance attendance = new Attendance();
        attendance.setStudentId(studentId);
        attendance.setAttendanceDate(date);
        attendance.setAttendanceStatus(attendanceStatus);

        AttDAO attendanceDAO = new AttDAO();
        attendanceDAO.saveAttendance(attendance);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromDateStr = request.getParameter("fromDate");
        String toDateStr = request.getParameter("toDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = null;
        Date toDate = null;
        try {
            fromDate = dateFormat.parse(fromDateStr);
            toDate = dateFormat.parse(toDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        AttDAO attendanceDAO = new AttDAO();
        List<Attendance> attendances = attendanceDAO.getAttendances(fromDate, toDate);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(convertAttendancesToJson(attendances));
    }

    private String convertAttendancesToJson(List<Attendance> attendances) {
        StringBuilder json = new StringBuilder("[");
        for (Attendance attendance : attendances) {
            json.append("{");
            json.append("\"studentId\": \"").append(attendance.getStudentId()).append("\",");
            json.append("\"attendanceDate\": \"").append(attendance.getAttendanceDate()).append("\",");
            json.append("\"attendanceStatus\": \"").append(attendance.getAttendanceStatus()).append("\"");
            json.append("},");
        }
        if (attendances.size() > 0) {
            json.deleteCharAt(json.length() - 1); // Remove the last comma
        }
        json.append("]");
        return json.toString();
    }
}
