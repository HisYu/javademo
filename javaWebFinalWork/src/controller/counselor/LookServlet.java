package controller.counselor;

import Dao.counselorDao.LookDao;
import bean.counselor.Look;
import dbutils.c3p0utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/LookServlet")
public class LookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 调用 Dao 类获取 Look 对象列表
            LookDao lookDao = new LookDao();
            List<Look> lookList = lookDao.getAllLooks();

            // 将 Look 对象列表转换为 JSON 字符串
            String json = convertToJson(lookList);

            // 设置响应的内容类型为 JSON
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // 将 JSON 响应发送给客户端
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理异常情况
            // 可以跳转到错误页面或返回错误信息给客户端
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String convertToJson(List<Look> lookList) {
        // 使用字符串拼接的方式将 Look 对象列表转换为 JSON 字符串
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for (Look look : lookList) {
            jsonBuilder.append("{");
            jsonBuilder.append("\"id\": ").append(look.getId()).append(",");
            jsonBuilder.append("\"reptime\": \"").append(look.getReptime()).append("\",");
            jsonBuilder.append("\"repevent\": \"").append(look.getRepevent()).append("\"");
            jsonBuilder.append("},");
        }
        if (!lookList.isEmpty()) {
            // 移除最后一个逗号
            jsonBuilder.setLength(jsonBuilder.length() - 1);
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}
