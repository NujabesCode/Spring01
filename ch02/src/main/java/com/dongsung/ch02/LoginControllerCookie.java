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
		
		//1. 값 콘솔창에 잘 나오나 확인
		//2. rememberId는 위에 boolean 타입으로 바꿔줌. 그래야 on이 아니라 ture flase로 나옴
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		if(!loginCheck(id, pwd)) {
			

			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			
			
			return "redirect:/login/login?msg"+msg;
			
		}
		
		
	
		
		
		
		if(rememberId) { //리멤버 아이디가 체크되어 있으면)
			Cookie cookie = new Cookie("id", id);
			//쿠키를 생성
			// 4.응답에 저장 (위 주소창에도 HttpServletResponse reponse 추가 해줌)
			response.addCookie(cookie);
			
		}else {
			//쿠키를 삭제
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); //애만 넣어주면 쿠키 삭제 됨.
			response.addCookie(cookie);
		}
		
		
		
		
		return "redirect:/indexCookie";
	}

	private boolean loginCheck(String id, String pwd) {
	
		return "asdf".equals(id) && "1234".equals(pwd);
		
	}
}
