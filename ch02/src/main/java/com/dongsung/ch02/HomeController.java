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
@Controller //���� ȣ�� ������ ���α׷����� ���
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//URL�� �޼��� ����(����,mapping)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	@RequestMapping(value ="/LoginLast", method = RequestMethod.GET)
	public String home3() {
		
		return "indexLast";
	}
	
}

//1.runas�� ������ ����.
//localhost:8080/ch2/ �Է��ϸ� ���� HelloWord�� ���´�.

//�� ���� ���� ���α׷��� ���� ����� ���� ���� com.dongsung.ch02�� ���� ��Ŭ�� �ؼ� javaclass �ϳ� �����.
//���ϸ� Hello