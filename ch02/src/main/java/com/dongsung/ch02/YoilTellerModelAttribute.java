package com.dongsung.ch02;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


//Year Month Day�� �ϳ��� ��ġ�� ����.

@Controller
public class YoilTellerModelAttribute {

	@ExceptionHandler(Exception.class)
	
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	
    @RequestMapping("/YoilTellerModelAttribute") // http://localhost:8090/ch02/getYoilMVC5?year=2021&month=10&day=1
    	//1.���� �޼��忡 ModelAttribute �޼��带 ���δ�
        //public String main(@ModelAttribute("myDate")MyDate date, Model model) {
         public String main(@ModelAttribute MyDate date, Model model) { //("myDate")���� ����
    	
   
    	if(!isValid(date)) {
    		return "yoilError";
    	}
    	
    	//3. 2������ @ModelAttribute ������� ������ ���� ȣ�� �κ� �ʿ� ����
        //char yoil = getYoil(date);  

        
    	//4.�굵 �ʿ� ����
        //model.addAttribute("MyDate", date);
        //model.addAttribute("yoil", yoil);
        
  
        return "yoil2";
        
       
        
    }
    
    private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

   //2.getYoil�޼��� �տ� @ModelAttribute ����
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
    
        return  " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
	}
}

//�� �ϸ� PPT�� �̵�.
