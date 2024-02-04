package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



//1. 먼저 Controller 등록
//2. 주사위 이미지 공유폴더에 공유해주기.
//3. 주사위 이미지 불러오기: src 폴더 아래 -> webapp -> resources 아래에 주사위 이미지 컨트롤 v
@Controller  //ctrl + shif + o는 자동 import
public class Dice2{
	
	
	@RequestMapping("/Dice2")
	public void main(HttpServletResponse response) throws IOException{
		//1. 랜덤값 변수에 담고.
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		//2. dice1,2 뒤에 idx1,idx2 입력.
		//그럼 새로고침 할 때마다 값이 달라짐.
		//이런걸 동적리소스라고 함.
		out.println("<img src='resources/img/dice"+idx1+".jpg'>");
		out.println("<img src='resources/img/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
	}

}
