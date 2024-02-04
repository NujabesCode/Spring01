package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

//YoilProgram은 날짜. 년월일을 입력하면 그 해당 날짜가 어떤 요일인지 알려주는 프로그램이다.

public class YoilProgram {
   //메인 메소드의 매개변수 args로 String 문자열 값을 받은 다음에 그 값을 year,month,day 에다가
   //저장
	public static void main(String[] args) {
		// 입력
		String year = args[0];
		String month = args[1];
		String day = args[2];
		//문자열이니까 숫자로 바꿈.		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. 작업
		//날짜 세팅하고	
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		//DAY_OF_WEEK가 요일이다.	
		//DAY_OF_WEEK는 숫자로 나옴.
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);   //1:일요일, 2:월요일 ...
		char dow = " 일월화수목금토 ".charAt(dayOfTheWeek);    //일요일이면 dayOfWeek가 1일로 바뀌고
													    //"일월화수목금토" 중에 "일"이 들어감.
		
		//3. 출력
		System.out.println(year + "년" + month + "월" + day + "일은");
		System.out.println(dow + "요일입니다.");
	}

}


//실행을 시켜보자. 매개변수로 받아야되기 때문에 콘솔에서 실행을 할꺼다.
//왼쪽 target 폴더에 컴파일된 결과가 만들어 진다.
//왼쪽 target 폴더 우클릭 하고 Show In -> Terminal

//1. 먼저 cd classes 입력 

//2. 그 다음 java com.dongsung.ch02.YoilProgram 2021 10 1 입력.

//3. 한글이 깨져서 Terminal창에 나옴.

//4. 블로그 참조 후 메인 메소드 작동 원리 그림으로 그려서 보여준 후
//   ppt 파일 보여줌.