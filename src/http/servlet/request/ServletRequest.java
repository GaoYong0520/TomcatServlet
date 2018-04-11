package http.servlet.request;

import beanutils.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ServletRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        String name = request.getParameter("username");
//        String pwd = request.getParameter("pwd");
//        String sex = request.getParameter("sex");
//        String city = request.getParameter("city");
//        String[] hobbies = request.getParameterValues("hobby");
//
//        System.out.println(city);
//        System.out.println(sex);
//        for (int i = 0; hobbies != null && i < hobbies.length; i++) {
//            System.out.println(hobbies[i]);
//        }
//
//        System.out.println("==========================");
        try {
            Reflection(request);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpServletRequest
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(request.getContextPath());
        System.out.println(request.getQueryString());
        System.out.println("-----------------------------");
        System.out.println(request.getHeader("User-Agent"));
    }

    private void Reflection(HttpServletRequest request) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();

        Map<String,String[]> map = request.getParameterMap();
        System.out.println(map.size());
        for (Map.Entry<String, String[]> m :
                map.entrySet()) {
            String property = m.getKey();
            String[] hobbies = m.getValue();

            //属性描述器
            PropertyDescriptor descriptor = new PropertyDescriptor(property,Person.class);
            //获取setter属性
            Method setter = descriptor.getWriteMethod();
            System.out.println(setter.toString());
            if (hobbies.length == 1) {
                setter.invoke(person,hobbies[0]);
            } else {
                setter.invoke(person,(Object)hobbies);
            }
        }

        System.out.println(person.toString());
    }
}
