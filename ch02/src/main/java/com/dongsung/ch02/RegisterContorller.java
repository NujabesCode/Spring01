//package com.dongsung.ch02;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
////�����ϸ� �ѱ��� �����µ� ���ڵ��� �ȸ¾Ƽ� �׷���.
////�ֳ��ϸ� preferences WEB �ؿ� ���ϵ鿡 ���ڵ��� �ȵǾ��־ �׷���
////�׷��� �ϳ��� ISO 10646/Unicode(UTF-8)�� �ٲ��ش�
////�׸��� aa�ΰ��� �ĵ� �޼����� �ȳ��´�.
////�ֳ��ϸ� registerForm.jsp �� �Ʒ��� �ִ� ${msg}�� el�� �ƴ϶� 
////Template litereal�̶� �׷���. EL�̶� ����� �Ȱ���.
////EL�� �������� ���ư��°Ű�, Templateliteral�� ���������� ���ư���
////������ �����ϱ�? �������� �����ϱ�? �翬�� ������ ������. �׷��� ������ ���ø����ͷ��� el�� �ν��Ѵ�.
////�׷��� �ٲ���� �ȴ�.'  '�� ���� ������ %{ }el�� �ѹ� �� ���ξ� �ȴ�. 
////${'${msg}'}
//@Controller 
//public class RegisterContorller {
//	@RequestMapping("/register/add")
//	public String register() {
//		return "registerForm"; //WEB-INF/views/registerForm.jsp
//		                       //views�� registerForm.html �����ؼ� 
//		                       //registerForm.jsp ����
//		                       //�ٸ� jsp���Ͽ��� ���� ��� �����ؼ� �ٿ��ֱ�.
//	}
//	
//	@RequestMapping("/register/save")
//	public String save() {
//		return "registerInfo2";
//	}
//}
