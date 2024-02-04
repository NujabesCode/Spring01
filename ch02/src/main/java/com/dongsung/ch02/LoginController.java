package com.dongsung.ch02;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//0.여기서부터 작성
@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
				
	}
	
	//1.여기까지 치고 화면으로 가서 잘 나오나 테스트 해본다.
	//2.주소창에 http://localhost:8080/ch02/login/login
	//3.이제 아이디 비번 입력한 후 쿠키를 이용해서 아이디기억 기능을 만들꺼다.
	
	@PostMapping("/login")
	public String login(String id, String pwd, String rememberId) throws Exception {
		

		
		
		//1.id와 pwd 확인
		if(!loginCheck(id, pwd)) {
			
			//2-1 일치하지 않으면, loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			
			//redirect 하는 경우에는 get으로 가니까 GetMapping이 받음.
			return "redirect:/login/login?msg"+msg;
			
		}
		//2.id와 pwd가 일치하면, 홈으로 이동.
		//3.그럼 홈이 있어야 되니까 맨 마지막에 index.jsp 를 만들어 줌.
		//4.index.jsp 만든 다음 아이디 asdf 비번 1234 치면 
		//5.Hello World!라고 뜸.
		//6.HomeController가 받아서 그런거니까
		//7.HomController 가서 retun 값을 index로 바꿔줌
		//8.그 다음 실행하면 css 꺠지는데 css도 만들어줌
		//9.css경로: src->main->webapp->resources->css폴더 생성
		//10.이제 쿠키를 배운 다음에 아이디 기억하기 버튼을 활성화 해 볼거다. PPT로 이동.
		
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		//나중에는 데이터베이스 통해서 할거임.
		//원래는 기본적으로 매개변수 검사를 해줘야 되는데
		//그냥 간단히 해줌.
		return "asdf".equals(id) && "1234".equals(pwd);
		
	}
	

}
