package http.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletResponse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置服务器编码
        //resp.setCharacterEncoding("UTF-8");
        //客户端编码
        //resp.setHeader("content-type","charset=UTF-8");

        resp.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = resp.getWriter();
        //out.write("你好 Response from tomcat");

        ServletOutputStream sos = resp.getOutputStream();
        String hello = "你好，hello.";
        sos.write(hello.getBytes("UTF-8"));
    }
}
