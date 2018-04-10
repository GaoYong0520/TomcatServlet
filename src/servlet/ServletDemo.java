package servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo implements Servlet {
    //Servlet生命周期方法

    //实例化
    public ServletDemo() {
        System.out.println("ServletDemo()");
        System.out.println("Servlet Created");
    }

    //初始化
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    //服务
    //service方法是多线程的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello, tomcat");
        //this.destroy();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //销毁
    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
