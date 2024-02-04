package com.dongsung.ch02;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main();		
		
		//1. Hello �ȿ� �ִ� main �޼��带 ȣ���ϸ� xǥ�� ���鼭 �ڵ� ������ ����.
		//2. �ֳ��ϸ� main �޼���� private�� �ܺ� ȣ���� �Ұ��ϱ� �����̴�.
		//3. �� hello.main �׽�Ʈ �ߴٰ� ���߿� �ּ�.
		
		//�Ʊ� ȣ��Ȱ� Reflection API�� ����߱� �����̴�.
		//Reflection API�� Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� �������ִ� �༮�̴�.
		//java.lang.reflect��Ű���� �����ϴµ� �̰� ���߿� ��� ���̴�.
		
		//Hello Ŭ������ Class ��ü(Ŭ������ ������ ����ִ� ��ü)�� ���´�.
		//���赵�� ������ �ֱ� ������ ���� �� �� �� �ִ�.
		Class helloClass = Class.forName("com.dongsung.ch02.Hello");
		
		//��ü �����
		Hello hello = (Hello)helloClass.newInstance(); //newInstance();���� ��ü ���� ����.
		//helloClass�� ������ �ִ� �޼ҵ带 �ۿ��� ȣ���� �� �ְ� �θ���.
		//getDeclaredMethod�� �ִµ�, �޼ҵ� ȣ�����ִ� �޼����
		//main �޼��带 ������ ���°Ŵ�.
		Method main = helloClass.getDeclaredMethod("main");
		
		//private�� main()�� ȣ�� �����ϰ� �Ѵ�
		main.setAccessible(true);
		
		main.invoke(hello); //hello.main ȣ���� �Ͱ� ����.
		
		
		//�׳� �ܿ� �ʿ䵵 ���� �̷��� �����δٰ� �˸� �ȴ�
		//�ֳ��ϸ� SpringFrameWork�� �̰� ���� ���� �����̴�.
		//�ᱹ private�ε��� ȣ�� �Ȱ� �ڹ��� Reflection API�� �̿��ؼ� ��ü�� ������� �����̴�.
	}

}
