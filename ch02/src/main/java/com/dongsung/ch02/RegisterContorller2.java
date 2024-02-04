package com.dongsung.ch02;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//실행하며 한글이 꺠지는데 인코딩이 안맞아서 그렇다.
//왜냐하면 preferences WEB 밑에 파일들에 인코딩이 안되어있어서 그렇다
//그래서 하나씩 ISO 10646/Unicode(UTF-8)로 바꿔준다
//그리고 aa두개만 쳐도 메세지가 안나온다.
//왜냐하면 registerForm.jsp 맨 아래에 있는 ${msg}가 el이 아니라 
//Template litereal이라 그렇다. EL이랑 생긴게 똑같다.
//EL은 서버에서 돌아가는거고, Templateliteral은 브라우저에서 돌아간다
//서버가 먼저일까? 브라우저가 먼저일까? 당연히 서버가 먼저다. 그래서 서버가 템플릿리터럴을 el로 인식한다.
//그래서 바꿔줘야 된다.'  '로 감싼 다음에 %{ }el로 한번 더 감싸야 된다. 
//${'${msg}'}
@Controller 
public class RegisterContorller2 {
	
	//10. 만약 매핑에 아무것도 안 써주면 GET과 POST 둘다 허용한다는 뜻이 된다.
	//11. 바로 밑에 녀석은 신규회원 가입 화면이다.
	//12. 신규 회원 가입에서는 POST 방식으로 할 일이 없다
	//13. 그래서 GetMapping 으로 바꿔준다.
	//14. 직접 run 해서 save 뒤에 입력값 넣은 다음 되는지 본다.
	//15. 그리고 사실 얘는 안써줘도 된다. 주석처리하고 servlet-context.xml로 가서
	//(src-main-spirng-appServlet)
	//16. <view-controller path="/register/add" view-name="registerForm"/> 추가
	//17. 저기로 왜 빼냐면. 얘는 사실 매핑해주는거 말고는 하는 일이 없기 때문이다
	@GetMapping("/register/add3")
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
		                       //views에 registerForm.html 복사해서 
	                       //registerForm.jsp 생성
		                       //다른 jsp파일에서 제일 상단 복사해서 붙여넣기.
	}
	
	//0.먼저 주석된 부분 시범 후 2번 이동
	//1.이렇게 하면 GET방식으로 회원가입 할 수 없게 된다.

//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
//	public String save() {
//		return "registerInfo";
//	}
	
	//2.근데 좀 길기 때문에 쓸 수 있는게 POST 매핑이다
	@PostMapping("/register/save") //3.PostMapping에 빨간줄 뜨는데 4.3버전 부터 가능하기 때문이다
								   //4.Maven Dependencies 가면 스프링 버전이 나온다
	                               //5.지금 버전이 3.1.1이다.
	//6.이걸 바꾸려면 pom.xml 가야된다.
	//7.pom.xml 가서 스프링 버전을 5.0.7 버전으로 바꾼다.
	//8.그 다음 project update 해 준다.
	//9. 그 다음 IMPORT 해 주면 빨간줄 없어진다.
	
	//19. 일단 전송 받은 값을 저장해야 되기 때문에 save 안에
	//20. save(String id, String pwd)등등 넣어줘야 됨. 근데 너무 많음.
	//21. 그래서 그냥 user로 받음
	//22. Create User
	public String save(User user,Model m) throws Exception{
		//23. 유효성 검사
		if(!isValid(user)) { //24.유효하지 않으면 회원가입 화면으로 돌아감
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8");
			
			return "redirect:/register/add3?msg="+msg;//25.전문 영어로 URL 재작성이라고 부름(rewriting)
													  //26.한글 깨져서 나오는데, URL인코더 써서 인코딩 해줘야 된다
		
			//27.아래처럼 해주는게 더 좋음. 모델어트리뷰트에 담아서 하는거임.
			//28.원래 모델은 뷰에 전달하기 위한건데. 지금은 리다이렉트를 써서 응답하는거임
			//29.그러면 모델로 전달 할 수가 없음. redirect는 재요청의 의미라서 그럼.
			//30.위에 있는 Model은 /register/save에 쓰는 모델임.
			//31.그래서 스프링이 자동으로 바꿔줌. 위에  return "redirect:/register/add3?msg="+msg; 얘처럼
		//	m.addAttribute("msg",msg);
		//	return "redirect:/register/add";
			//32.마지막으로 registerInfo2.jsp 가서 param을 user로 바꿔줌.
		
		
		}
		
		
		
		//19. DB에 신규회원 정보를 저장 ( 이건 나중에 할거)
		return "registerInfo2";
	}

	private boolean isValid(User user) {
		return false;
	}
}
