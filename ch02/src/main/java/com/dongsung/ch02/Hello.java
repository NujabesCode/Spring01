package com.dongsung.ch02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//�ڽ����ϸ� ���� �ƹ��͵� �ȳ����°� ������. �������� ����� ������ �Է� ���߱� ������. �ܼ�â���� ������ ��.
//1. ���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {
		
		//4 
		int iv = 10; //�ν��Ͻ� ����
		static int cv = 20; //����ƽ ����
	
	
		//2. URL�� �޼��带 ����
		@RequestMapping("/hello")
		//3. �Ʒ��� �ִ� public void main()�� static�� �پ����� ����.
		//5. �� ���� �ｼ pubic void mian()�� �ν��Ͻ� �޼����� ����.
		//6. �׷��� �ν��Ͻ� �޼���� ��ü ���� �� ȣ���� ������.
		//7. �ν��Ͻ� �޼��尡 ��ü ���� ���� ȣ�� �����ϴٴ°�. �߰����� ������ ��ü ������ �� �شٴ� ����.
		//8. ��ü ������ URL�� �������α׷��� ȣ���ϸ�. ��Ĺ�� ��ü ������ �� ��.
		//9. �� ������ �޼��尡 ȣ�� ��.
		
		
		//�ν��Ͻ� �޼��尡 �� ������.
		
		//9. ���߿� public void main()�� private void main���� �ٲٰ� main.java�� �Ѿ.
		//10. private�� ���� �ܺο��� ȣ�� �Ұ���. �׷��� ȣ��Ǵ� ������ RequestMapping�� �˾Ƽ� ȣ�� ���ֱ� ������.
		//private void maiin()
		public void main() {    //�ν��Ͻ� �޼��� -iv, cv �� �� ��� ����
			System.out.println("Hello");
			System.out.println(cv); //ok �ν��Ͻ��ϱ� �� �� ��
			
		}
		
		
		//11. //static �޼��� cv(����ƽ ����)�� ��� ���� 
		public static void main2() { 
			
			System.out.println(cv); //ok
			//12.
			//System.out.println(iv); // ����ƽ �޼����, �ν��Ͻ� ������ ȣ����� �ʾƼ� ������ �߻���. 
			
			
			
		}
	}


// http://localhost:8080/ch02/hello ġ�� ���� Hello�� ���;ߵǴµ� �ȳ��´�.
// �ȳ����� �Ʒ� �ܼ�â�� ���´�. �� ���°Ŵ�.


//1~6������ �� �ϰ� Main Ŭ���� �ٽ� �ϳ� �� �����