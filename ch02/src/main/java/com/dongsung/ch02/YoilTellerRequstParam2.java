package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Year Month Day를 하나로 합치는 예제.

@Controller
public class YoilTellerRequstParam2 {

	@ExceptionHandler(Exception.class)
	
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	
    @RequestMapping("/getYoilMVC6") // http://localhost:8090/ch02/getYoilMVC5?year=2021&month=10&day=1
    	
        //Year Month Day를 Mydate로 합침
        //너무 많은 매개변수가 있을때는 새로운 클래스를 하나 정의해서 매개변수 개수를 줄일 수 있음
        //MyDate 작성후 빨간줄 나오는데
        //MyDate 위에 마우스 올리고 create class 클릭해서 클래스 만들어 줌.
        //파일이름 신경쓰지말고 finish 클릭.
        public String main(MyDate date, Model model) {
       
    	
       //얘는 제일 마지막. 새로 메서드 생성해줘야 됨.
    	if(!isValid(date)) {
    		return "yoilError";
    	}
    	
    	
    	//매개변수가 date인 메서드도 하나 만들어 줘야 됨.
        char yoil = getYoil(date);  

        
        
        model.addAttribute("MyDate", date);
        model.addAttribute("yoil", yoil);
        
        //yoil2로 수정
        return "yoil2";
        
       
        
    }
    
    private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}


	private char getYoil(MyDate date) {
    	// TODO 얘는 특정메서드가 아직 안만들어 졌으니까 내용 만들란 이야기임
		// TODO Auto-generated method stub
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}


	private boolean isValid(int year, int month, int day) {
		
		return true;
	}


	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    
        return  " 일월화수목금토".charAt(dayOfWeek);
		
	}
}


