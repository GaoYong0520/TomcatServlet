package http.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class ServletFileDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输入流
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/http/servlet/response/xi.jpg");
        System.out.println(path);
        FileInputStream in = new FileInputStream(path);
        //字节输出流
        ServletOutputStream sos = response.getOutputStream();

        //设置消息头
        String filename = path.substring(path.lastIndexOf("\\") + 1);

        //设置编码
        filename = URLEncoder.encode(filename,"UTF-8");

        //response.setHeader("content-disposition","attachment;filename=" + filename);
        //response.setHeader("content-type","image/jpeg");

        //输出
        int length = 1;
        byte[] bytes = new byte[1024];
        while ((length = in.read(bytes)) != -1) {
            sos.write(bytes,0,length);
        }


        sos.close();
        in.close();
    }
}
