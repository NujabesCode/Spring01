package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



//1. 먼저 Controller 등록.
//2. 주사위 이미지 공유폴더에 공유해주기.
//3. 주사위 이미지 불러오기: src 폴더 아래 -> webapp -> resources 아래에 주사위 이미지 컨트롤 v
@Controller  //ctrl + shif + o는 자동 import
public class Dice{
	@RequestMapping("/Dice")
	//4.브라우저에 출력하려면 HttpServletResponse가 필요하다
	//5.IOExcepion을 해주는 이유는. 파일을 읽거나 쓸 때 파일이 존재하지 않거나 권한이 없는 경우나
	//  네트워크 통신 중 연결이 끊어진 경우 등. 다양한 입출력 상황에서 IOException이 발생할 수 있다.
	//7.IOException: 입출력 동작 중에 발생하는 다양한 예외를 포함하는 일반적인 입출력 예외 클래스.
	
	public void main(HttpServletResponse response) throws IOException{
		//8. 브라우저에 출력하려면 writer를 얻어와야 된다.
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		//9. 지금은 고정된 문자열이다. 매번 내용이 똑같다.
		//10.새로고침 마다 다른 주사위가 나오려면 dice1.jpg가 바껴야 된다.
		//11.TowDice2로 이동
		out.println("<img src='resources/img/diceimg1.jpg'>");
		out.println("<img src='resources/img/diceimg2.jpg'>");
		out.println("</body>");
		out.println("</html>");
	}

}

//TwoDice1 끝났으면
//TwoDice2 이동.