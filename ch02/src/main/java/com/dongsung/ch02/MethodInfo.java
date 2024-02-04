package com.dongsung.ch02;
/*
 자바의 리플렉션(Reflection)은 실행 중인 프로그램의 클래스, 
 메소드, 필드 등의 정보를 동적으로 검사하고 조작할 수 있도록 하는 
 기능이다.
*/
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

/* 스프링MVC패턴이 어떻게 동작하는지 원리에 대해서 알아보자.
스프링이 내부적으로 어떤 일을 하길래 매개변수로 적어주기만 하면 알아서 처리하는지
궁금했을탠데, 그걸 알아보자.
스프링 소스를 보면 먼저 ReflectionAPI로 매개변수의 이름을 알아내려고 한다.
ReflectionAPI는 jdk1.8 이후부터 가능하다.
근데 스프링은 jdk1.8 이전부터 있었다. 그때는 classfile로부터 얻어왔다.
그러다가 실패를 하면 classfile을 직접 읽어서 매개변수의 이름을 얻어온다.
우리는 첫번째 방법을 통해서 매개변수의 이름을 얻어온거다.
*/

public class MethodInfo {
	public static void main(String[] args) throws Exception{
		
		//YoilTeller3 한 다음 YoilTellerMVC4도 넣어보기.
		
		//1.YoilTeller 클래스의 객체를 생성
		Class ClassNew = Class.forName("com.dongsung.ch02.YoilProgramMVC4");
		Object obj = ClassNew.newInstance();
		
		//2. YoilProgram의 모든 메서드 정보를 가져와서 배열에 저장.
		//3. 메서드가 여러개일 수 있기 때문에, 반환 타입은 배열로 지정.
		Method[] methodArr = ClassNew.getDeclaredMethods();
		
		//4. 반복문으로 메서드 하나씩 읽어서 정보 출력.
		for(Method m : methodArr) {
			String name = m.getName(); // 메서드의 이름
			Parameter[] paramArr = m.getParameters(); //매개변수 목록
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType(); //메서드의 반환타입
			
			//                                        구분자 접두사, 접미사
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) { //매서드의 매개변수도 여러가지일 수 있으니까 반복문 돌림.
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}

/*
  1. 아래 콘솔창을 보면 매개변수 이름이 arg0과 arg1로 되어있다.
  
  2. 실제 요일 텔러를 까 보면  매개변수 이름이 request와 response로 되어있다.
  
  3. 근데 왜  이름이 arg0 arg1로 바뀌었을까?
  
  4. 그 이유는 YoilTeller를 컴파일 할때, 컴파일러는 매개변수 타입은 중요한데
     매개변수 이름은 별로 중요하게 생각 안한다 그래서 컴파일 될때 매개변수 이름은
     저장하지 않는다
  5. 근데 우리는 매개변수의 이름이 필요하다. 그래서 매개변수 이름을 저장하려면
  
  6. 컴파일 옵션에 parameters라고 컴파일 옵션을 줘야된다.
     java c - parameters
              매개변수 이름 저장 옵션 
              
  7. Window - > Prefernces -> compil 검색 -> java -> Compiler
     -> 맨 아래 store information about method parameters(usable via reflextion)
              
  8. 자바 1.8 이상 버전으로 바꿔야 활성화 됨. 
  
  9-1. pom.xml <java-version>11</java-version> 자바 버전 11로 수정
  9-2. maven-compiler-plugin
  
  
  10. pom.xml 파일 수정 끝났으면 프로젝트 우클릭 Maven -> Update Project
  
  11. 지금 우리가 쓰는 MVC프로젝트는 메이븐에서 관리를 함. pom.xml이 메이븐 설정 파일임.
              
  12. 매개변수 이름을 얻어 오는 방법은 두가지가 있는데
  
       1.Reflection API를 이용하는 방법 : parameters 옵션을 넣고 얻어와야 됨
       2.class 파일을 직접 읽는 방법
 
  13. 2번 방법은 window -> show View -> other -> navi검색- >navigator 열기 -> 네비게이터는 탐색기 같은거.
  
  14. src가 있고 target이 있는데 src에는 *.java 파일이 있고 target에는 *.class 파일이 있다
  
  15. yoilTeller3.class 파일을 보면 해석해서 나온다.
  
  16. 원래 class 파일은 바이너리 파일이라 보기 어렵게 되어있다.
  
  17. 쭉 내려보면 Local Variable table:이 있는데 거기에 request와 response가 있다.
  
  18. 스프링은 저걸 읽어서 알아내는거다.
  
  14.  Class clazz = Class.forName("com.dongsung.ch02.YoilTellerMVC");
       변경 후 매개변수 잘 나오나 확인.
 */             



/* [실행결과]
java.lang.String main(java.lang.String year, java.lang.String month, java.lang.String day, org.springframework.ui.Model model)
boolean isValid(int year, int month, int day)
*/