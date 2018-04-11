package http.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletRedirectSource extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("重定向源");
        //response.setStatus(302);
        //重定向URL
        //response.setHeader("location","/source/redirect");

        response.sendRedirect("/source/redirect");

        System.out.println("-------------");



    }
}
