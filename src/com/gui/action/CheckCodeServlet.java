package com.gui.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
			doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setHeader("Pragma", "No-cache");

		response.setHeader("Cache-Control", "no-cache");

		response.setHeader("P3P", "CP=CAO PSA OUR");
		
		response.setDateHeader("Expires", 0);

		//告诉浏览器这是图片形式来显示
		response.setContentType("image/jpeg");
		int width = 60;
		int height = 20;

		BufferedImage imgCode = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		OutputStream out = response.getOutputStream();

		Graphics g = imgCode.getGraphics();

		Random random = new Random();

		g.setColor(Color.GRAY);

		// 填充背景
		g.fillRect(0, 0, width, height);

		g.setColor(new Color(255, 255, 255));
		//绘制干扰线
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(40);
			int y1= random.nextInt(40);
			g.drawLine(x, y, x1 + x, y1 +y);
		}
		
		String sRand = "";
		//设置字体样式
		g.setFont(new Font("宋体", Font.ITALIC,18));
		for (int i = 0; i <4; i++) {
			//随机生产一个0~9的随机数
			String rand = String.valueOf(random.nextInt(10));
			//追加字符串
				sRand += rand; 
			g.setColor(new Color(0,0,0));
			g.drawString(rand,14*i, 18);
		}

		g.dispose();
		//把图片写到浏览器
		ImageIO.write(imgCode, "jpeg",out);
		//把验证码保存在session中国
		request.getSession().setAttribute("checkcode", sRand);
		System.out.println("验证码 :" + sRand);
		response.flushBuffer();
		out.flush();
		out.close();
		
		
	}

}
