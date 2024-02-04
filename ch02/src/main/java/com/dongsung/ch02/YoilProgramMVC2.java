package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//�ش� ������ �����ϸ� ���� �ȳѾ� ���� �׳� �� �� �� �̷��� ���.
//���� ���°� �����ֱ� ���� �����ϴ� ���̰�. response�� �𵨷� �ȹٲ��༭ �׷�
@Controller
public class YoilProgramMVC2 {
    @RequestMapping("/getYoilProMVC2") // http://localhost:8090/ch02/getYoilMVC2?year=2021&month=10&day=1
    
        public String main(int year, int month, int day, HttpServletResponse response) throws IOException{
        //String���� ���ִ� ������ return ���� "yoil" �� String�̱� �����̴�.
    	
        //1. ��ȿ�� �˻�
    	
    
    	
        Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        char dow = " �Ͽ�ȭ�������".charAt(dayOfTheWeek);   // �Ͽ���:1, ������:2, ... 

        return "dow"; //WEB-INF/views/yoil.jsp�� �̿��ؼ� �۾� ����� �����ֶ�� ��.
        
        /* 
        
        ��� �κ� ���� 
        
        1. yoil.jsp�� �̵�.
        
        2. Maven Dependencies - > src -> main -> 
        >WEB-INF - views -> home.jsp ���� ������ ����.
        ���ϸ�:yoil.jsp
    	
    	*/
    }
}