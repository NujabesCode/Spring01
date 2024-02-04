package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerRequstParam1 {
		//<2>����ó�� �߰� (RequestParam) �׽�Ʈ ���Ŀ�
	//ExcpetionŬ������ ��� ������ �ְ� �����̶� ��� ���ܸ� �� ����.
	@ExceptionHandler(Exception.class)
	//���Ķ�� �޼��尡 ����
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	
    @RequestMapping("/getYoilMVC5") // http://localhost:8090/ch02/getYoilMVC5?year=2021&month=10&day=1
    	
    	//<1>RequestParam �߰� 
        public String main(@RequestParam(required=true) int year, @RequestParam(required=true) int month, @RequestParam(required=true) int day, Model model) throws IOException{
       
    	
        //1. ��ȿ�� �˻� - year. month. day ���� �� ���Դ��� �𸣱� ������ ���־�� �ȴ�.
    	//isvalid ������ ����µ�, ���콺 ��� createMethod ������ ��.
    	if(!isValid(year, month, day)) {
    		return "yoilError";
    	}
    	
    	//2.���� ���
        char yoil = getYoil(year, month, day);   // �Ͽ���:1, ������:2, ... 

        
        //3. ����� ����� �𵨿� ����
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        
        //WEB-INF/views/yoil.jsp�� ��� yoil�� �ٲ���� ������ Ȯ��.
        //spring���� -> appServlet -> servlet-context.xml ����
        //�� �Ʒ��� view�� ��� �����ϴ� �κ� ����.
        
        //4.Dispatcher-Servlet�� view���� model�� ����.
        return "yoil"; //WEB-INF/views/yoil.jsp�� �̿��ؼ� �۾� ����� �����ֶ�� ��.
        
       
        
    }
    
    private boolean isValid(int year, int month, int day) {
		
		return true;
	}

	//�ڵ����� private �޼��尡 ����� ��.
    //void�� �ƴ϶� char ��ȯ�ϰ� �ٲ� ��
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //�������� �ٲ��ְ� 
        return  " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
	}
}


//����� �������� ����� �����ϴµ�, �� ����� ���� ���� ����.
//public String�� public void�� �ٲ� ���� return ���� ���ִ� ����� �ִ�.
//�׷��� �Ǹ� @RequestMapping("/getYoilMVC") ���ε� URL �̸��� view�� �̸����� �����ȴ�.
//�𵨿��� ��ĵ� �ִ�.
//�̰� �� �ϸ� PPT�� �̵�