package com.dongsung.ch02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller //원격 호출 가능한 프로그램으로 등록
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//URL과 메서드 연결(맵핑,mapping)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	@RequestMapping(value ="/LoginLast", method = RequestMethod.GET)
	public String home3() {
		
		return "indexLast";
	}
	
}

//1.runas로 실행해 본다.
//localhost:8080/ch2/ 입력하면 웹에 HelloWord가 나온다.

//그 다음 원격 프로그램을 직접 만들어 보기 위해 com.dongsung.ch02로 가서 우클릭 해서 javaclass 하나 만든다.
//파일명 Hello