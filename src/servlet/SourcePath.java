package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SourcePath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet资源路径
        String path1 = "/WEB-INF/test.pro";
        path1 = "/WEB-INF/classes/test.pro";
        String absolutePath = this.getServletContext().getRealPath(path1);
        System.out.println(absolutePath);
        //创建Properties
        Properties properties = new Properties();
        properties.load(new FileInputStream(absolutePath));
        System.out.println(properties.getProperty("name"));
    }
}
