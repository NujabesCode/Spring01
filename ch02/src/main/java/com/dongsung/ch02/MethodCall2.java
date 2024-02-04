package com.dongsung.ch02;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

//methodCall1 ������ ��Ʈ�ѷ��� ���� �����ϰ�, �޼��带 ȣ���ߴµ�
//�̹� ������ ���÷���API�� ����ؼ� ��Ʈ�ѷ��� �����ϰ� �޼��带 ȣ���ϴ� ������
public class MethodCall2 {
	public static void main(String[] args) throws Exception{
		
		// 1. YoilTellerMVC ��ü ����
		Class clazz = Class.forName("com.dongsung.ch02.YoilTellerMVC4");
		Object obj = clazz.newInstance();
		
		// 2. main �޼����� ������ ������.
		//                                  ���θ޼��尡 �ְ�  �Ű������� ��Ƽ���� 3�� �ް� �� �޴°���.
		//                                  ���� �޼��尡 �������� �� �����ϱ�. �� �����ε� �� �� �����ϱ� �Ű����� �� �����ִ°�.
		//                                  getDeclaredMethod: Ư�� �̸��� �Ű����� Ÿ���� ���� �޼��带 �������� �޼���
		//                                  ���������� �޼����� �̸��� main
		//                                  int�� ���� Ŭ������ Integer�̸�, ���� int.class�� Integer Ŭ������ Ŭ���� ��ü�� ��Ÿ��
		//                                  int.class�� int�� Ŭ������°Ŵ�. �������� api�� ����ҋ��� �̷��� �������� �ȴ�. �ڵ��� ��ü� ������.
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);
		
		// 3. �� ����.
		//BindingAwareModelMap()�� ���������� ������ ����ϴ°Ŵ�.
		//���� �������̽���. �������̽��ϱ� ��ü�� ������ �� ����
		//�׷��� �� ����ü�� BindingAwareModelMap�̴�.
		Model model = new BindingAwareModelMap();
		System.out.println("[before] model="+model);
		
		// 4. ���� �޼��� ȣ��
		// �������� api�� ȣ���Ϸ��� invoke��� �޼��带 ����ؾ� ��.
		//obj ��ü�� ���θ޼��� ȣ��. ���� Object obj = clazz.newInstance(); ����.
		
		//�������� ����ϰ� �̹� �������� �޶������� ��������api�� ����ؼ� ȣ���ߴٴ� ����
		// String viewName = obj.main(2021, 10, 1, model); //���� ���������� �̷��� ȣ��
		String viewName = (String)main.invoke(obj, new Object[] { 2021, 10, 1, model }); //Reflection API�� �̿��� ȣ��
		System.out.println("viewName="+viewName);	
		
		// Model�� ������ ��� 
		System.out.println("[after] model="+model);
				
		// �ؽ�Ʈ ������ �̿��� rendering
		render(model, viewName);			
	} // main
	
	static void render(Model model, String viewName) throws IOException {
		String result = "";
		
		// 1. ���� ������ ���پ� �о �ϳ��� ���ڿ��� �����.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. model�� map���� ��ȯ 
		Map map = model.asMap();
		
		// 3.key�� �ϳ��� �о template�� ${key}�� value�ٲ۴�.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()�� key�� value ġȯ�Ѵ�.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}
		
		// 5.������ ����� ����Ѵ�.
		System.out.println(result);
	}
}