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
        //String���� ���ִ� ������ return ���� "yoil" �� String�̱� �����̴�.
    	
        //1. ��ȿ�� �˻�
    	
    
    	
        Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        char dow = " �Ͽ�ȭ�������".charAt(dayOfTheWeek);   // �Ͽ���:1, ������:2, ... 

        
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("dow", dow);
        
        
        
        
        return "yoil"; //WEB-INF/views/yoil.jsp�� �̿��ؼ� �۾� ����� �����ֶ�� ��.
        
       
        
    }
}