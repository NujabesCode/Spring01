package com.dongsung.ch02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//오버라이딩을 한다 source -> Override/Implement Methods -> service 노란색
//             GenericServlet - > init() destory()


@WebServlet("/hello") //매핑해줘야 된다.
//서블릿은 HttpServlet을 상속 받아야 된다.
public class HelloServlet extends HttpServlet {
  
	@Override
	public void init() throws ServletException {
		// 서블릿이 초기화될때 자동 호출되는 메서드
		// 1.서블릿의 초기화 작업을 담당
		System.out.println("[HelloServlet] init() is called.");
	}
	

	@Override
	//실제로 작업을 처리하는 메서드
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 입력
		//2. 처리
		//3. 출력
		
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override
	public void destroy() {
		//3. 뒷정리 - 서블릿이 메모리에서 제거될때 서블릿 컨테이너에 의해서 자동 호출. //디스트로이 보려면 주석창에 글 하나더치면 됨. 
		System.out.println("[HelloServlet] destroy() is called.");
	}



}

//1. run 하면 웹에 아무거도 안뜨는데 콘솔창에 println 호출.
//2. 새로고침 계속 하면 init()은 호출 안되고 service()만 계쏙 호출 된다.
//3. 언제 init과 destory가 호출되는지 알아보고 끝. ppt로 이동