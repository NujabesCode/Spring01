package com.dongsung.ch02;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main();		
		
		//1. Hello 안에 있는 main 메서드를 호출하면 x표시 나면서 코드 에러가 난다.
		//2. 왜냐하면 main 메서드는 private라 외부 호출이 불가하기 때문이다.
		//3. 위 hello.main 테스트 했다가 나중에 주석.
		
		//아까 호출된건 Reflection API를 사용했기 때문이다.
		//Reflection API는 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공해주는 녀석이다.
		//java.lang.reflect패키지를 제공하는데 이건 나중에 배울 것이다.
		
		//Hello 클래스의 Class 객체(클래스의 정보를 담고있는 객체)를 얻어온다.
		//설계도를 가지고 있기 때문에 뭐든 다 할 수 있다.
		Class helloClass = Class.forName("com.dongsung.ch02.Hello");
		
		//객체 만들기
		Hello hello = (Hello)helloClass.newInstance(); //newInstance();쓰면 객체 생성 가능.
		//helloClass가 가지고 있는 메소드를 밖에서 호출할 수 있게 부른다.
		//getDeclaredMethod가 있는데, 메소드 호출해주는 메서드다
		//main 메서드를 가지고 오는거다.
		Method main = helloClass.getDeclaredMethod("main");
		
		//private인 main()을 호출 가능하게 한다
		main.setAccessible(true);
		
		main.invoke(hello); //hello.main 호출한 것과 같다.
		
		
		//그냥 외울 필요도 없고 이렇게 움직인다고 알면 된다
		//왜냐하면 SpringFrameWork가 이걸 많이 쓰기 때문이다.
		//결국 private인데도 호출 된건 자바의 Reflection API를 이용해서 객체를 만들었기 때문이다.
	}

}
