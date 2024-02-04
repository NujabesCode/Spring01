package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

//YoilProgram�� ��¥. ������� �Է��ϸ� �� �ش� ��¥�� � �������� �˷��ִ� ���α׷��̴�.

public class YoilProgram {
   //���� �޼ҵ��� �Ű����� args�� String ���ڿ� ���� ���� ������ �� ���� year,month,day ���ٰ�
   //����
	public static void main(String[] args) {
		// �Է�
		String year = args[0];
		String month = args[1];
		String day = args[2];
		//���ڿ��̴ϱ� ���ڷ� �ٲ�.		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. �۾�
		//��¥ �����ϰ�	
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		//DAY_OF_WEEK�� �����̴�.	
		//DAY_OF_WEEK�� ���ڷ� ����.
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);   //1:�Ͽ���, 2:������ ...
		char dow = " �Ͽ�ȭ������� ".charAt(dayOfTheWeek);    //�Ͽ����̸� dayOfWeek�� 1�Ϸ� �ٲ��
													    //"�Ͽ�ȭ�������" �߿� "��"�� ��.
		
		//3. ���
		System.out.println(year + "��" + month + "��" + day + "����");
		System.out.println(dow + "�����Դϴ�.");
	}

}


//������ ���Ѻ���. �Ű������� �޾ƾߵǱ� ������ �ֿܼ��� ������ �Ҳ���.
//���� target ������ �����ϵ� ����� ����� ����.
//���� target ���� ��Ŭ�� �ϰ� Show In -> Terminal

//1. ���� cd classes �Է� 

//2. �� ���� java com.dongsung.ch02.YoilProgram 2021 10 1 �Է�.

//3. �ѱ��� ������ Terminalâ�� ����.

//4. ��α� ���� �� ���� �޼ҵ� �۵� ���� �׸����� �׷��� ������ ��
//   ppt ���� ������.