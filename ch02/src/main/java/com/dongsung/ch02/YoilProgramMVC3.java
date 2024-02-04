package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgramMVC3 {
    @RequestMapping("/getYoilProMVC3") // http://localhost:8090/ch02/getYoilMVC2?year=2021&month=10&day=1
    
        public String main(int year, int month, int day, Model model) throws IOException{
        //String으로 해주는 이유는 return 값이 "yoil" 즉 String이기 때문이다.
    	
        //1. 유효성 검사
    	
    
    	
        Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        char dow = " 일월화수목금토".charAt(dayOfTheWeek);   // 일요일:1, 월요일:2, ... 

        
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("dow", dow);
        
        
        
        
        return "yoil"; //WEB-INF/views/yoil.jsp를 이용해서 작업 결과를 보여주라는 뜻.
        
       
        
    }
}