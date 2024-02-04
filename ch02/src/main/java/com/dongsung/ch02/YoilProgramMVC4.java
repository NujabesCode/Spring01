package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//��ȿ���˻�
//���ϰ���ϴ� �κ� ������ �޼���� �̾� ��.
/* Calendar ���� dayOfWeek���� �巡�� �� ��Ŭ�� �� ��
   Refactor -> Extract Method -> �޼��� �̸�: getYoil

*/
@Controller
public class YoilProgramMVC4 {
    @RequestMapping("/getYoilProMVC4") // http://localhost:8090/ch02/getYoilMVC2?year=2021&month=10&day=1
    
        public String main(int year, int month, int day, Model model) throws IOException{
       
    	
        //1. ��ȿ�� �˻� - year. month. day ���� �� ���Դ��� �𸣱� ������ ���־�� �ȴ�.
    	//isvalid ������ ����µ�, ���콺 ��� createMethod ������ ��.
    	if(!Valid(year, month, day)) {
    		return "yoilErrorpage";
    	}
    	
    	//2.���� ���
        char dow = getDow(year, month, day);   // �Ͽ���:1, ������:2, ... 

        
        //3. ����� ����� �𵨿� ����
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("dow", dow);
        
        //WEB-INF/views/yoil.jsp�� ��� yoil�� �ٲ���� ������ Ȯ��.
        //spring���� -> appServlet -> servlet-context.xml ����
        //�� �Ʒ��� view�� ��� �����ϴ� �κ� ����.
        
        //4.Dispatcher-Servlet�� view���� model�� ����.
        return "dow"; //WEB-INF/views/yoil.jsp�� �̿��ؼ� �۾� ����� �����ֶ�� ��.
        
       
        
    }
    
   
	//�ڵ����� private �޼��尡 ����� ��.
    //void�� �ƴ϶� char ��ȯ�ϰ� �ٲ� ��
	private char getDow(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //�������� �ٲ��ְ� 
        return  " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
	}
	
	 private boolean Valid(int year, int month, int day) {    
	    	if(year==-1 || month==-1 || day==-1) 
	    		return false;
	    	
	    	return (1<=month && month<=12) && (1<=day && day<=31); // ������ üũ 
	    }
	}


//����� �������� ����� �����ϴµ�, �� ����� ���� ���� ����.
//public String�� public void�� �ٲ� ���� return ���� ���ִ� ����� �ִ�.
//�׷��� �Ǹ� @RequestMapping("/getYoilMVC") ���ε� URL �̸��� view�� �̸����� �����ȴ�.
//�𵨿��� ��ĵ� �ִ�.
//�̰� �� �ϸ� PPT�� �̵�
