package com.dongsung.ch02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//★실행하면 웹에 아무것도 안나오는게 정상임. 브라우저에 출력할 정보를 입력 안했기 때문임. 콘솔창에만 나오면 됨.
//1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
		
		//4 
		int iv = 10; //인스턴스 변수
		static int cv = 20; //스태틱 변수
	
	
		//2. URL과 메서드를 연결
		@RequestMapping("/hello")
		//3. 아래에 있는 public void main()은 static이 붙어있지 않음.
		//5. 그 말인 즉슨 pubic void mian()은 인스턴스 메서드라는 뜻임.
		//6. 그런데 인스턴스 메서드는 객체 생성 후 호출이 가능함.
		//7. 인스턴스 메서드가 객체 생성 없이 호출 가능하다는건. 중간에서 누군가 객체 생성을 해 준다는 말임.
		//8. 객체 생성은 URL로 원격프로그램을 호출하면. 톰캣이 객체 생성을 해 줌.
		//9. 그 다음에 메서드가 호출 됨.
		
		
		//인스턴스 메서드가 더 유용함.
		
		//9. 나중에 public void main()을 private void main으로 바꾸고 main.java로 넘어감.
		//10. private는 원래 외부에서 호출 불가임. 그러나 호출되는 이유는 RequestMapping이 알아서 호출 해주기 때문임.
		//private void maiin()
		public void main() {    //인스턴스 메서드 -iv, cv 둘 다 사용 가능
			System.out.println("Hello");
			System.out.println(cv); //ok 인스턴스니까 둘 다 됨
			
		}
		
		
		//11. //static 메서드 cv(스태틱 변수)만 사용 가능 
		public static void main2() { 
			
			System.out.println(cv); //ok
			//12.
			//System.out.println(iv); // 스태틱 메서드라, 인스턴스 변수가 호출되지 않아서 에러가 발생함. 
			
			
			
		}
	}


// http://localhost:8080/ch02/hello 치면 웹에 Hello가 나와야되는데 안나온다.
// 안나오고 아래 콘솔창에 나온다. 잘 나온거다.


//1~6번까지 다 하고 Main 클래스 다시 하나 더 만든다