package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//해당 파일을 실행하면 값이 안넘어 오고 그냥 년 월 일 이렇게 뜬다.
//에러 나는거 보여주기 위해 실행하는 것이고. response를 모델로 안바꿔줘서 그럼
@Controller
public class YoilProgramMVC2 {
    @RequestMapping("/getYoilProMVC2") // http://localhost:8090/ch02/getYoilMVC2?year=2021&month=10&day=1
    
        public String main(int year, int month, int day, HttpServletResponse response) throws IOException{
        //String으로 해주는 이유는 return 값이 "yoil" 즉 String이기 때문이다.
    	
        //1. 유효성 검사
    	
    
    	
        Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        char dow = " 일월화수목금토".charAt(dayOfTheWeek);   // 일요일:1, 월요일:2, ... 

        return "dow"; //WEB-INF/views/yoil.jsp를 이용해서 작업 결과를 보여주라는 뜻.
        
        /* 
        
        출력 부분 삭제 
        
        1. yoil.jsp로 이동.
        
        2. Maven Dependencies - > src -> main -> 
        >WEB-INF - views -> home.jsp 같은 폴더에 복붙.
        파일명:yoil.jsp
    	
    	*/
    }
}