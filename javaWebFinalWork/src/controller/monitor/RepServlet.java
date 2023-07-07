package controller.monitor;

import bean.Monitor.Report;
import Dao.MonitorDao.RepDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/RepServlet")
public class RepServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 防止乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取表单数据
        String reportTimeStr = request.getParameter("reportTime");
        String reportContent = request.getParameter("reportContent");

        // 将日期时间字符串解析为 Date 对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date reportTime = null;
        try {
            reportTime = sdf.parse(reportTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 创建 Report 对象
        Report report = new Report();
        report.setReportTime(reportTime);
        report.setReportContent(reportContent);

        // 调用 DAO 类进行保存
        RepDAO repDAO = new RepDAO();
        repDAO.saveReport(report);

        // 跳转到成功页面或其他操作
        response.sendRedirect("/javaWebFinalWork/jsp/Monitor/cg.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 防止乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        doPost(request, response);
    }
}
