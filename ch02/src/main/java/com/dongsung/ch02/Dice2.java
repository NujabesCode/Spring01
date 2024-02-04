package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



//1. ���� Controller ���
//2. �ֻ��� �̹��� ���������� �������ֱ�.
//3. �ֻ��� �̹��� �ҷ�����: src ���� �Ʒ� -> webapp -> resources �Ʒ��� �ֻ��� �̹��� ��Ʈ�� v
@Controller  //ctrl + shif + o�� �ڵ� import
public class Dice2{
	
	
	@RequestMapping("/Dice2")
	public void main(HttpServletResponse response) throws IOException{
		//1. ������ ������ ���.
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		//2. dice1,2 �ڿ� idx1,idx2 �Է�.
		//�׷� ���ΰ�ħ �� ������ ���� �޶���.
		//�̷��� �������ҽ���� ��.
		out.println("<img src='resources/img/dice"+idx1+".jpg'>");
		out.println("<img src='resources/img/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
	}

}
