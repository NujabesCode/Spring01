package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgramMVC {
    @RequestMapping("/getYoilProMVC") // http://localhost:8080/ch02/getYoilMVC?year=2021&month=10&day=1
    
    
    	//1.원래는 아래와 같이 메인메서드가 만들어 졌었다.
        //public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
     
        //2.그렇지만 아래와 같이 바꿔 주면 1. 입력부분과 2. 형변환 부분이 필요가 없어져서 삭제해주면 된다.
        //public void main(String year, String month, String day, HttpServletResponse response) throws IOException{
        public void main(int year, int month, int day, HttpServletResponse response) throws IOException{
       
    	
        //처리
        Calendar cal = Calendar.getInstance();

        cal.set(year, month -1, day);

        int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        char dotw = " 일월화수목금토".charAt(dayOfTheWeek);   // 일요일:1, 월요일:2, ... 

        
        
        //response 객체를 이용해서 브라우저에 출력
        response.setContentType("text/html");    // 응답의 형식을 html로 지정
        response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
        PrintWriter out = response.getWriter();  // 브라우저로의 출력 스트림(out)을 얻는다.
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println(year + "년 " + month + "월 " + day + "일은 ");
        out.println(dotw + "요일입니다.");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}