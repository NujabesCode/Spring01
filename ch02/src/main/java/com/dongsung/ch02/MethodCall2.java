package com.dongsung.ch02;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

//methodCall1 예제는 컨트롤러를 직접 생성하고, 메서드를 호출했는데
//이번 예제는 리플렉션API를 사용해서 컨트롤러를 생성하고 메서드를 호출하는 예제다
public class MethodCall2 {
	public static void main(String[] args) throws Exception{
		
		// 1. YoilTellerMVC 객체 생성
		Class clazz = Class.forName("com.dongsung.ch02.YoilTellerMVC4");
		Object obj = clazz.newInstance();
		
		// 2. main 메서드의 정보를 가져옴.
		//                                  메인메서드가 있고  매개변수가 인티저값 3개 받고 모델 받는거임.
		//                                  메인 메서드가 여러개일 수 있으니까. 즉 오버로딩 될 수 있으니까 매개변수 값 적어주는거.
		//                                  getDeclaredMethod: 특정 이름과 매개변수 타입을 가진 메서드를 가져오는 메서드
		//                                  가져오려는 메서드의 이름이 main
		//                                  int의 래퍼 클래스는 Integer이며, 따라서 int.class는 Integer 클래스의 클래스 객체를 나타냄
		//                                  int.class는 int가 클래스라는거다. 리프렉션 api를 사용할떄는 이렇게 명시해줘야 된다. 코드의 명시성 때문에.
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);
		
		// 3. 모델 생성.
		//BindingAwareModelMap()은 스프링에서 실제로 사용하는거다.
		//모델은 인터페이스다. 인터페이스니까 객체를 생성할 수 없다
		//그래서 그 구현체가 BindingAwareModelMap이다.
		Model model = new BindingAwareModelMap();
		System.out.println("[before] model="+model);
		
		// 4. 메인 메서드 호출
		// 리프렉션 api로 호출하려면 invoke라는 메서드를 사용해야 됨.
		//obj 객체의 메인메서드 호출. 위에 Object obj = clazz.newInstance(); 있음.
		
		//나머지는 비슷하고 이번 예제에서 달라진점은 리프렉션api를 사용해서 호출했다는 점임
		// String viewName = obj.main(2021, 10, 1, model); //이전 예제에서는 이렇게 호출
		String viewName = (String)main.invoke(obj, new Object[] { 2021, 10, 1, model }); //Reflection API를 이용한 호출
		System.out.println("viewName="+viewName);	
		
		// Model의 내용을 출력 
		System.out.println("[after] model="+model);
				
		// 텍스트 파일을 이용한 rendering
		render(model, viewName);			
	} // main
	
	static void render(Model model, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. model을 map으로 변환 
		Map map = model.asMap();
		
		// 3.key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}
		
		// 5.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}