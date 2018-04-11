package beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Beanutil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu = new Student();
        Student student = new Student();

        Map map = new HashMap();
        map.put("name","杨源昌");
        map.put("birthday","1997-1-1");

        try {
            BeanUtils.setProperty(stu,"name","高勇");
            BeanUtils.setProperty(stu,"age","22");

            //注册类型转换器
            ConvertUtils.register(new DateLocaleConverter(),Date.class);
            BeanUtils.setProperty(stu,"birthday","1995-05-20");
            BeanUtils.populate(student,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(stu.toString());
        System.out.println(student.toString());
        try {
            test();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void test() throws InvocationTargetException, IllegalAccessException {
        Student stu = new Student();
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class aClass, Object o) {
                SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
                if (o instanceof String) {
                    String value = (String)o;
                    try {
                        Date date = sdate.parse(value);
                        return date;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        },Date.class);

        BeanUtils.setProperty(stu,"birthday","1996-1-1");
        BeanUtils.setProperty(stu,"name","杜开展");
        BeanUtils.setProperty(stu,"age",22);
        System.out.println(stu.toString());
    }
}
