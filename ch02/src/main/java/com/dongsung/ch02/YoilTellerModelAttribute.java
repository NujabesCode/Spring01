package com.dongsung.ch02;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


//Year Month Day를 하나로 합치는 예제.

@Controller
public class YoilTellerModelAttribute {

	@ExceptionHandler(Exception.class)
	
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	
    @RequestMapping("/YoilTellerModelAttribute") // http://localhost:8090/ch02/getYoilMVC5?year=2021&month=10&day=1
    	//1.먼저 메서드에 ModelAttribute 메서드를 붙인다
        //public String main(@ModelAttribute("myDate")MyDate date, Model model) {
         public String main(@ModelAttribute MyDate date, Model model) { //("myDate")생략 가능
    	
   
    	if(!isValid(date)) {
    		return "yoilError";
    	}
    	
    	//3. 2번에서 @ModelAttribute 적어줬기 때문에 이제 호출 부분 필요 없음
        //char yoil = getYoil(date);  

        
    	//4.얘도 필요 없음
        //model.addAttribute("MyDate", date);
        //model.addAttribute("yoil", yoil);
        
  
        return "yoil2";
        
       
        
    }
    
    private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

   //2.getYoil메서드 앞에 @ModelAttribute 붙임
	private @ModelAttribute("yoil")char getYoil(MyDate date) {
    
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

//다 하면 PPT로 이동.
