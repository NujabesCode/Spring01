package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



//1. ���� Controller ���.
//2. �ֻ��� �̹��� ���������� �������ֱ�.
//3. �ֻ��� �̹��� �ҷ�����: src ���� �Ʒ� -> webapp -> resources �Ʒ��� �ֻ��� �̹��� ��Ʈ�� v
@Controller  //ctrl + shif + o�� �ڵ� import
public class Dice{
	@RequestMapping("/Dice")
	//4.�������� ����Ϸ��� HttpServletResponse�� �ʿ��ϴ�
	//5.IOExcepion�� ���ִ� ������. ������ �аų� �� �� ������ �������� �ʰų� ������ ���� ��쳪
	//  ��Ʈ��ũ ��� �� ������ ������ ��� ��. �پ��� ����� ��Ȳ���� IOException�� �߻��� �� �ִ�.
	//7.IOException: ����� ���� �߿� �߻��ϴ� �پ��� ���ܸ� �����ϴ� �Ϲ����� ����� ���� Ŭ����.
	
	public void main(HttpServletResponse response) throws IOException{
		//8. �������� ����Ϸ��� writer�� ���;� �ȴ�.
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		//9. ������ ������ ���ڿ��̴�. �Ź� ������ �Ȱ���.
		//10.���ΰ�ħ ���� �ٸ� �ֻ����� �������� dice1.jpg�� �ٲ��� �ȴ�.
		//11.TowDice2�� �̵�
		out.println("<img src='resources/img/diceimg1.jpg'>");
		out.println("<img src='resources/img/diceimg2.jpg'>");
		out.println("</body>");
		out.println("</html>");
	}

}

//TwoDice1 ��������
//TwoDice2 �̵�.