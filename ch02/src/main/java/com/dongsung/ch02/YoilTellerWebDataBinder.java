package com.dongsung.ch02;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


//Year Month Day�� �ϳ��� ��ġ�� ����.


@Controller
public class YoilTellerWebDataBinder {
	
	//9 �ּ� ó��.
//	@ExceptionHandler(Exception.class)
//	
//	public String catcher(Exception ex) {
//		ex.printStackTrace();
//		return "yoilError";
//	}
	
	
	@ExceptionHandler(Exception.class)
	
	public String catcher(Exception ex, BindingResult result) {
		System.out.println("result="+result);
		//�޼��� ��ȯ ���� FieldError��, ��ü�� ����س���
		//FieldError�� ������ �ִ� �޼��带 Ȱ���ϸ� �� �ڼ��� ���� �޼����� �� �� ����.
		FieldError error = result.getFieldError();
		
		System.out.println("code="+error.getCode());
		System.out.println("code="+error.getField());
		System.out.println("code="+error.getDefaultMessage());
		ex.printStackTrace();
		return "yoilError";
	}
	
	
	
	
    @RequestMapping("/YoilTellerWebDataBinder") // http://localhost:8090/ch02/getYoilMVC5?year=2021&month=10&day=1
    	//1.ModelAttribute ���� �����ϴϱ� ���� �����. 
    	//2.�𵨵� �ʿ� ��� �����.
        //3.BindingResult �־��ش�.
         public String main(MyDate date, BindingResult result) { 
    	//4.Print ������ reulst�� ����
    	System.out.println("result="+result);
    	//5.�׸��� http://localhost:8080/ch02/YoilTellerWebDataBinder?year=2021&month=10&day=aa ȣ���ϴµ�
    	//6.�Ϻη� ������ �� ����.
    	//7.�׷� ���� ȭ���� ���´�. �߸��� ��û�Դϴٶ��. �̰� ���� �ִ� ExceptionHandler���� �����°ű� ������
    	//8.ExceptionHandler�� �ּ�ó�� �Ѵ�.
    	//10.�׷��� 500���� ������ ����.
    	//11.���� �ڵ带 ������ ���� BindingResult��� �޼����� ���´�
    	//12.�ܼ�â�� ���� BindingResult �˻��غ��� �ȳ��´�. �ֳ��ϸ� ��Ʈ�ѷ����� ������ ������ �����̴�.
    	//13.9�� �ּ�ó���Ѱ� �ٽ� ����� BindingResult�� �޾ƺ���.
    	//14.���ΰ�ħ �ϸ� Excpetion �ڵ鷯�� ó���Ѱ� Ȯ���Ҽ� �ִ�.
    	//15. �� ���� �ܼ�â �α׿��� ��Ʈ�� f ������ result=�� Ȯ�� �ϸ� ������ ���´�
    	//16.
    	if(!isValid(date)) {
    		return "yoilError";
    	}
    	
    	
        
  
        return "yoil2";
        
       
        
    }
    
    private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

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