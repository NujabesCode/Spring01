package com.dongsung.ch02;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


//jsp ����
//��Ʈ�ѷ��� ���� �����ϰ� �޼��带 ȣ���ϴ� ����.

//��¥ ��Ʈ�ѷ��� �ƴѵ�, ��Ʈ�ѷ�ó�� �ڵ带 �ۼ��ѰŴ�.
//map�� model ����

class ModelController { //�� ��Ʈ�ѷ���� Ŭ������ �ְ�
	public String main(HashMap map) { //�ȿ� �޼��尡 �ִ�.
		                              //�Ű������� map ����
		//�۾� ����� map�� ����
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView2"; //�� �̸� ��ȯ.
	}
}


public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map = new HashMap(); //���� ���� ����
		System.out.println("before:"+map);

		ModelController mc = new ModelController(); //��Ʈ�ѷ� ����
		String viewName = mc.main(map); //���� �޼��� ȣ���ϸ鼭 map�� �Ѱ� ��.
		
		System.out.println("after :"+map);
		
		render(map, viewName);
	}
	
	static void render(HashMap map, String viewName) throws IOException {
		String result = "";
		
		// 1. ���� ������ ���پ� �о �ϳ��� ���ڿ��� �����.
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. map�� ��� key�� �ϳ��� �о template�� ${key}�� value�ٲ۴�.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 3. replace()�� key�� value ġȯ�Ѵ�.
			result = result.replace("${"+key+"}", (String)map.get(key));
		}
		
		// 4.������ ����� ����Ѵ�.
		System.out.println(result);
	}
}

