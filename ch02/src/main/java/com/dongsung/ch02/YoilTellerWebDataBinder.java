package com.dongsung.ch02;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


//Year Month Day를 하나로 합치는 예제.


@Controller
public class YoilTellerWebDataBinder {
	
	//9 주석 처리.
//	@ExceptionHandler(Exception.class)
//	
//	public String catcher(Exception ex) {
//		ex.printStackTrace();
//		return "yoilError";
//	}
	
	
	@ExceptionHandler(Exception.class)
	
	public String catcher(Exception ex, BindingResult result) {
		System.out.println("result="+result);
		//메세지 반환 값이 FieldError라서, 객체로 등록해놓고
		//FieldError가 가지고 있는 메서드를 활용하면 더 자세한 에러 메세지를 볼 수 있음.
		FieldError error = result.getFieldError();
		
		System.out.println("code="+error.getCode());
		System.out.println("code="+error.getField());
		System.out.println("code="+error.getDefaultMessage());
		ex.printStackTrace();
		return "yoilError";
	}
	
	
	
	
    @RequestMapping("/YoilTellerWebDataBinder") // http://localhost:8090/ch02/getYoilMVC5?year=2021&month=10&day=1
    	//1.ModelAttribute 생략 가능하니까 먼저 지운다. 
    	//2.모델도 필요 없어서 지운다.
        //3.BindingResult 넣어준다.
         public String main(MyDate date, BindingResult result) { 
    	//4.Print 문으로 reulst를 찍어본다
    	System.out.println("result="+result);
    	//5.그리고 http://localhost:8080/ch02/YoilTellerWebDataBinder?year=2021&month=10&day=aa 호출하는데
    	//6.일부러 에러를 내 본다.
    	//7.그럼 에러 화면이 나온다. 잘못된 요청입니다라고. 이건 위에 있는 ExceptionHandler에서 나오는거기 때문에
    	//8.ExceptionHandler를 주석처리 한다.
    	//10.그러면 500번대 에러가 난다.
    	//11.에러 코드를 웹에서 보면 BindingResult라고 메세지가 나온다
    	//12.콘솔창에 가서 BindingResult 검색해보면 안나온다. 왜냐하면 컨트롤러까지 가지도 못헀기 때문이다.
    	//13.9번 주석처리한걸 다시 살려서 BindingResult를 받아본다.
    	//14.새로고침 하면 Excpetion 핸들러가 처리한걸 확인할수 있다.
    	//15. 그 다음 콘솔창 로그에서 컨트롤 f 누르고 result=를 확인 하면 에러가 나온다
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
    
        return  " 일월화수목금토".charAt(dayOfWeek);
		
	}
}