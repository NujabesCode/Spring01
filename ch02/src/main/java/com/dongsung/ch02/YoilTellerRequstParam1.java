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
		//<2>예외처리 추가 (RequestParam) 테스트 이후에
	//Excpetion클래스는 모든 예외의 최고 조상이라 모든 예외를 다 잡음.
	@ExceptionHandler(Exception.class)
	//케쳐라는 메서드가 잡음
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	
    @RequestMapping("/getYoilMVC5") // http://localhost:8090/ch02/getYoilMVC5?year=2021&month=10&day=1
    	
    	//<1>RequestParam 추가 
        public String main(@RequestParam(required=true) int year, @RequestParam(required=true) int month, @RequestParam(required=true) int day, Model model) throws IOException{
       
    	
        //1. 유효성 검사 - year. month. day 값이 잘 들어왔는지 모르기 때문에 해주어야 된다.
    	//isvalid 빨간줄 생기는데, 마우스 대고 createMethod 누르면 됨.
    	if(!isValid(year, month, day)) {
    		return "yoilError";
    	}
    	
    	//2.요일 계산
        char yoil = getYoil(year, month, day);   // 일요일:1, 월요일:2, ... 

        
        //3. 계산한 결과를 모델에 저장
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        
        //WEB-INF/views/yoil.jsp가 어떻게 yoil로 바뀌는지 설정을 확인.
        //spring폴더 -> appServlet -> servlet-context.xml 가면
        //맨 아래에 view의 경로 지정하는 부분 있음.
        
        //4.Dispatcher-Servlet이 view에다 model을 전달.
        return "yoil"; //WEB-INF/views/yoil.jsp를 이용해서 작업 결과를 보여주라는 뜻.
        
       
        
    }
    
    private boolean isValid(int year, int month, int day) {
		
		return true;
	}

	//자동으로 private 메서드가 만들어 짐.
    //void가 아니라 char 반환하게 바꿔 줌
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //리턴으로 바꿔주고 
        return  " 일월화수목금토".charAt(dayOfWeek);
		
	}
}


//참고로 여러가지 방법이 존재하는데, 이 방법을 제일 많이 쓴다.
//public String을 public void로 바꾼 다음 return 문을 없애는 방법도 있다.
//그렇게 되면 @RequestMapping("/getYoilMVC") 매핑된 URL 이름이 view의 이름으로 결정된다.
//모델엔뷰 방식도 있다.
//이거 다 하면 PPT로 이동