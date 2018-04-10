package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletConfigDemo extends HttpServlet {
    private ServletConfig config = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("init()");
        String encoding = config.getInitParameter("encoding");
        System.out.println(encoding);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
