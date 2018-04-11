package http.servlet.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ServletImage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //禁用浏览器缓存
        response.setHeader("pragma","no-cache");

        int width = 110;
        int height = 25;

        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //画笔
        Graphics g = img.createGraphics();

        //背景色
        g.setColor(Color.PINK);
        g.fillRect(1,1,width-2,height-2);

        //边框
        g.setColor(Color.RED);
        g.drawRect(0,0,width-1,height-1);

        //文本
        g.setColor(Color.BLUE);
        g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
        Random random = new Random();
        int pos = 20;
        for (int i = 0; i < 4; i++) {
            g.drawString(random.nextInt(10) + "",pos,20);
            pos += 20;
        }

        //干扰线
        for (int i = 0; i < 9; i++) {
            g.drawLine(random.nextInt(width),random.nextInt(height),random.nextInt(width),random.nextInt(height));
        }
        //字节流输出
        ImageIO.write(img,"jpg",response.getOutputStream());

        System.out.println("验证码已更改");
    }
}
