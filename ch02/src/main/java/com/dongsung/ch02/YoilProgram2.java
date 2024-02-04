package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8080/ch02/YoilProgram2?year=2021&month=21&day=31
@Controller
public class YoilProgram2 {
    @RequestMapping("/YoilProgram2") 
    //처음에는 매개변수가 (String[] args) 스트링 배열이었는데
    //이번에는 매개변수가 (HttpServletRequest request)임.
    //매개변수를 (HttpServletRequest request)라고 적어 주면. 톰캣이 HttpServletRequest 객체를 만든 후
    //URL에 입력값을 객체에 담아서 매개변수로 넘겨 줌.
    public void main(HttpServletRequest request) {
    	
    	/*request.getParameter*/
    	//웹 요청에서 쿼리 문자열(query string)의 파라미터 값을 가져오는 데 사용됨
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
        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
        System.out.println(dow + "요일입니다.");
       
    }
}