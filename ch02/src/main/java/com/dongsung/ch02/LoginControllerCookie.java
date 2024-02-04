package com.dongsung.ch02;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/loginCookie")
public class LoginControllerCookie {
	@GetMapping("/loginCookie")
	public String loginForm() {
		return "loginForm";
				
	}
	

	
	@PostMapping("/loginCookie")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception {
		
		//1. �� �ܼ�â�� �� ������ Ȯ��
		//2. rememberId�� ���� boolean Ÿ������ �ٲ���. �׷��� on�� �ƴ϶� ture flase�� ����
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		if(!loginCheck(id, pwd)) {
			

			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			
			
			return "redirect:/login/login?msg"+msg;
			
		}
		
		
	
		
		
		
		if(rememberId) { //����� ���̵� üũ�Ǿ� ������)
			Cookie cookie = new Cookie("id", id);
			//��Ű�� ����
			// 4.���信 ���� (�� �ּ�â���� HttpServletResponse reponse �߰� ����)
			response.addCookie(cookie);
			
		}else {
			//��Ű�� ����
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); //�ָ� �־��ָ� ��Ű ���� ��.
			response.addCookie(cookie);
		}
		
		
		
		
		return "redirect:/indexCookie";
	}

	private boolean loginCheck(String id, String pwd) {
	
		return "asdf".equals(id) && "1234".equals(pwd);
		
	}
}
