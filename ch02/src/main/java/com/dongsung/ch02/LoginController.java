package com.dongsung.ch02;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//0.���⼭���� �ۼ�
@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
				
	}
	
	//1.������� ġ�� ȭ������ ���� �� ������ �׽�Ʈ �غ���.
	//2.�ּ�â�� http://localhost:8080/ch02/login/login
	//3.���� ���̵� ��� �Է��� �� ��Ű�� �̿��ؼ� ���̵��� ����� ���鲨��.
	
	@PostMapping("/login")
	public String login(String id, String pwd, String rememberId) throws Exception {
		

		
		
		//1.id�� pwd Ȯ��
		if(!loginCheck(id, pwd)) {
			
			//2-1 ��ġ���� ������, loginForm���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			
			//redirect �ϴ� ��쿡�� get���� ���ϱ� GetMapping�� ����.
			return "redirect:/login/login?msg"+msg;
			
		}
		//2.id�� pwd�� ��ġ�ϸ�, Ȩ���� �̵�.
		//3.�׷� Ȩ�� �־�� �Ǵϱ� �� �������� index.jsp �� ����� ��.
		//4.index.jsp ���� ���� ���̵� asdf ��� 1234 ġ�� 
		//5.Hello World!��� ��.
		//6.HomeController�� �޾Ƽ� �׷��Ŵϱ�
		//7.HomController ���� retun ���� index�� �ٲ���
		//8.�� ���� �����ϸ� css �����µ� css�� �������
		//9.css���: src->main->webapp->resources->css���� ����
		//10.���� ��Ű�� ��� ������ ���̵� ����ϱ� ��ư�� Ȱ��ȭ �� ���Ŵ�. PPT�� �̵�.
		
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		//���߿��� �����ͺ��̽� ���ؼ� �Ұ���.
		//������ �⺻������ �Ű����� �˻縦 ����� �Ǵµ�
		//�׳� ������ ����.
		return "asdf".equals(id) && "1234".equals(pwd);
		
	}
	

}
