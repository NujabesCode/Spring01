//package com.dongsung.ch02;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
////실행하며 한글이 꺠지는데 인코딩이 안맞아서 그렇다.
////왜냐하면 preferences WEB 밑에 파일들에 인코딩이 안되어있어서 그렇다
////그래서 하나씩 ISO 10646/Unicode(UTF-8)로 바꿔준다
////그리고 aa두개만 쳐도 메세지가 안나온다.
////왜냐하면 registerForm.jsp 맨 아래에 있는 ${msg}가 el이 아니라 
////Template litereal이라 그렇다. EL이랑 생긴게 똑같다.
////EL은 서버에서 돌아가는거고, Templateliteral은 브라우저에서 돌아간다
////서버가 먼저일까? 브라우저가 먼저일까? 당연히 서버가 먼저다. 그래서 서버가 템플릿리터럴을 el로 인식한다.
////그래서 바꿔줘야 된다.'  '로 감싼 다음에 %{ }el로 한번 더 감싸야 된다. 
////${'${msg}'}
//@Controller 
//public class RegisterContorller {
//	@RequestMapping("/register/add")
//	public String register() {
//		return "registerForm"; //WEB-INF/views/registerForm.jsp
//		                       //views에 registerForm.html 복사해서 
//		                       //registerForm.jsp 생성
//		                       //다른 jsp파일에서 제일 상단 복사해서 붙여넣기.
//	}
//	
//	@RequestMapping("/register/save")
//	public String save() {
//		return "registerInfo2";
//	}
//}
