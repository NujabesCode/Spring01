package com.dongsung.ch02;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller 
public class RegisterFoward {

	
	//34번 이후에 RequestMapping으로 바꿔 줌.
	@RequestMapping(value="/register/add5", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm2";
	}
	
	@PostMapping("/register/save2") 
	public String save(User user,Model m) throws Exception{
		
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8");
			
//			return "redirect:/register/add5";
			
			//23.처음에는 redirect 테스트 하고 나중에 foward로 바꿈
			//24.다시 http://localhost:8080/ch02/register/add3 감
			//25.다시 입력하고 회원가입 해봄
			//26.그러면 에러 뜨는데. 왜 그러냐면 save가 POST로 보냈기 때문임
			//27.그럼 이 요청을 foward할 때 post로 foward를 함
			//28. 무슨 말이냐면 register/save2가
			//29./register/add5로 fowar하는건데
			//30./register/add5에서는 GET밖에 처리를 못한다.
			//31. 그렇기 때문에 에러가 나는거다.
			//32. 그렇기 때문에 먼저 servlect-context.xml가서 지운다.
			//33. 왜냐하면 거기 적어주는건 GET으로 밖에 못받기 때문이다.
			//34. 위에 GetMapping을 RequestMapping으로 수정해준다.
			//35. 바꿔주는 이유는 위에 RequestMapping으로 get post 다 적으면 둘 다 받을 수 있기 때문이다.
			//36. 그 다음 다시 회원가입해서 요청을 한 다음
			//37. save 요청을 보면 Reponse Headers 응답이 200으로 잘 왔다
			//38. 주소창을 보면 register/save 그대로 잘 유지하고 있다.
			//39. 즉 지금 보는 화면은 register/add이다
			//40. 요청은 save다. 즉 save로 한 요청을 add로 foward 즉 전달한거다.
			//41. foward는 한번 밖에 요청을 안하기 때문에 안바뀐거다. 
			//42. 만약 두번 요청했으면 바꼈겠지? 이 점 알아두길 바란다.
			m.addAttribute("msg",msg);
			//처음에 redirect. 그다음 forward로 바꿈.
			return "forward:/register/add5";
		
		
		}
		
		
		
		return "registerInfo3";
	}
	
	//1.테스트를 위해 return을 false로. 그럼 위에 isValid가 ture로 됨.
	//2.그럼 자동으로 위의 주소로 redirect 됨
	//3.서버 스타트하고 loacalhost/ch2/register/add5로 감.
	//4.F12누르고 network 누름
	//5.이 상태에서 회원가입을 해봄.
	//6.회원가입을 누르면 save로 바로 감.
	//7.지금 보면 알겠지만, 우리가 redirect 테스트를 하고있는 중임
	//8.보면 요청이 1건인데 두개의 요청이 있음.
	//9.아까 설명한거 처럼 redirect는 요청이 두번 가기 때문임.
	//10.첫번째로는 save로 데이터를 전송 했음.
	//12.근데 응답이 300번대로 왔음.
	//13.300번대는 redirect라고 했음.
	//14. 그리고 어디로 redirect 하냐면. 그게 location에 나와있음
	//15.location에 재 요청할 URL이 적혀 있음.
	//16.우리가 요청을 save로 했더니. 저기로 다시 요청하라는 뜻임.
	//17.그러면 브라우저가 자동으로 요청을 해버림
	//18.그게 바로 밑에 있는 add?msg=임
	//19.우리는 2번 요청을 한 적이 없는데. 브라우저가 300번대 응답을 받았기 때문에
	//20.자동으로 location으로 요청을 한거임.
	//21.근데 위에 주소창을 보면 localhost/ch2/register/add?msg로 url이 바껴있음
	//22.무슨 말이냐면 우리는 회원가입 누르자마자 save로 요청이 되는데[
	//23.리다이렉트 되서 자동으로 add?로 바뀐거임. 근데 foward는 안바뀜
	//21.그다음 위로 올라가서 return "redirect:를 foward:로 바꿈"
	//22.
	private boolean isValid(User user) {
		return false;
	}
}
