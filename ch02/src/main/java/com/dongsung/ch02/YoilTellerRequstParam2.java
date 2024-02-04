package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Year Month Day�� �ϳ��� ��ġ�� ����.

@Controller
public class YoilTellerRequstParam2 {

	@ExceptionHandler(Exception.class)
	
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	
    @RequestMapping("/getYoilMVC6") // http://localhost:8090/ch02/getYoilMVC5?year=2021&month=10&day=1
    	
        //Year Month Day�� Mydate�� ��ħ
        //�ʹ� ���� �Ű������� �������� ���ο� Ŭ������ �ϳ� �����ؼ� �Ű����� ������ ���� �� ����
        //MyDate �ۼ��� ������ �����µ�
        //MyDate ���� ���콺 �ø��� create class Ŭ���ؼ� Ŭ���� ����� ��.
        //�����̸� �Ű澲������ finish Ŭ��.
        public String main(MyDate date, Model model) {
       
    	
       //��� ���� ������. ���� �޼��� ��������� ��.
    	if(!isValid(date)) {
    		return "yoilError";
    	}
    	
    	
    	//�Ű������� date�� �޼��嵵 �ϳ� ����� ��� ��.
        char yoil = getYoil(date);  

        
        
        model.addAttribute("MyDate", date);
        model.addAttribute("yoil", yoil);
        
        //yoil2�� ����
        return "yoil2";
        
       
        
    }
    
    private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}


	private char getYoil(MyDate date) {
    	// TODO ��� Ư���޼��尡 ���� �ȸ���� �����ϱ� ���� ����� �̾߱���
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
    
        return  " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
	}
}


