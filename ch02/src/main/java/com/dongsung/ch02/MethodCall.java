package com.dongsung.ch02;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


//jsp 형태
//컨트롤러를 직접 생성하고 메서드를 호출하는 예제.

//진짜 컨트롤러는 아닌데, 컨트롤러처럼 코드를 작성한거다.
//map이 model 역할

class ModelController { //모델 컨트롤러라는 클래스가 있고
	public String main(HashMap map) { //안에 메서드가 있다.
		                              //매개변수로 map 선언
		//작업 결과를 map에 저장
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView2"; //뷰 이름 반환.
	}
}


public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map = new HashMap(); //맵을 먼저 생성
		System.out.println("before:"+map);

		ModelController mc = new ModelController(); //컨트롤러 생성
		String viewName = mc.main(map); //메인 메서드 호출하면서 map을 넘겨 줌.
		
		System.out.println("after :"+map);
		
		render(map, viewName);
	}
	
	static void render(HashMap map, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 3. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", (String)map.get(key));
		}
		
		// 4.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}

