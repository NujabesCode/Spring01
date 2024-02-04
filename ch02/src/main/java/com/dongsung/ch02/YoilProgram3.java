package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgram3 {
    @RequestMapping("/YoilProgram3") // http://localhost:8080/ch02/YoilProgram3?year=2021&month=10&day=1
    
    //  1. 브라우저에 나오게 하려면 request 했던 것 처럼, response 객체를 매개변수로 적어줘야 된다.
    //  2. HttpServletResponse response도  매개변수로 적기만하면 톰캣이 객체를 만들어 준다.
    /*  HttpServletRequest request 객체는 클라이언트가 서버에게 전송한 데이터나 요청과 관련된 정보를 읽어들이는 데 사용되며
        HttpServletResponse response 객체는 서버에서 클라이언트로 데이터를 전송하거나 응답의 상태를 조작하는 데 사용됨.*/
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 입력
    	//String year =  args[0];
    	//String month = args[1];
    	//String day =   args[2];
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. 처리
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        char dow = " 일월화수목금토".charAt(dayOfTheWeek);   // 일요일:1, 월요일:2, ... 

        // 3. 출력
        // System.out.println(year + "년 " + month + "월 " + day + "일은 ");
        // System.out.println(yoil + "요일입니다.");
        
        
        //response 객체를 이용해서 브라우저에 출력
        response.setContentType("text/html");    // 응답의 형식을 html로 지정
        response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
        PrintWriter out = response.getWriter();  /* HttpServletResponse에서 클라이언트로 텍스트를 출력하기 위한
         											PrintWriter 객체를 얻는 코드임. */
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println(year + "년 " + month + "월 " + day + "일은 ");
        out.println(dow + "요일입니다.");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}