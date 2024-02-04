package com.dongsung.ch02;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//�����ϸ� �ѱ��� �����µ� ���ڵ��� �ȸ¾Ƽ� �׷���.
//�ֳ��ϸ� preferences WEB �ؿ� ���ϵ鿡 ���ڵ��� �ȵǾ��־ �׷���
//�׷��� �ϳ��� ISO 10646/Unicode(UTF-8)�� �ٲ��ش�
//�׸��� aa�ΰ��� �ĵ� �޼����� �ȳ��´�.
//�ֳ��ϸ� registerForm.jsp �� �Ʒ��� �ִ� ${msg}�� el�� �ƴ϶� 
//Template litereal�̶� �׷���. EL�̶� ����� �Ȱ���.
//EL�� �������� ���ư��°Ű�, Templateliteral�� ���������� ���ư���
//������ �����ϱ�? �������� �����ϱ�? �翬�� ������ ������. �׷��� ������ ���ø����ͷ��� el�� �ν��Ѵ�.
//�׷��� �ٲ���� �ȴ�.'  '�� ���� ������ %{ }el�� �ѹ� �� ���ξ� �ȴ�. 
//${'${msg}'}
@Controller 
public class RegisterContorller2 {
	
	//10. ���� ���ο� �ƹ��͵� �� ���ָ� GET�� POST �Ѵ� ����Ѵٴ� ���� �ȴ�.
	//11. �ٷ� �ؿ� �༮�� �ű�ȸ�� ���� ȭ���̴�.
	//12. �ű� ȸ�� ���Կ����� POST ������� �� ���� ����
	//13. �׷��� GetMapping ���� �ٲ��ش�.
	//14. ���� run �ؼ� save �ڿ� �Է°� ���� ���� �Ǵ��� ����.
	//15. �׸��� ��� ��� �Ƚ��൵ �ȴ�. �ּ�ó���ϰ� servlet-context.xml�� ����
	//(src-main-spirng-appServlet)
	//16. <view-controller path="/register/add" view-name="registerForm"/> �߰�
	//17. ����� �� ���ĸ�. ��� ��� �������ִ°� ����� �ϴ� ���� ���� �����̴�
	@GetMapping("/register/add3")
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
		                       //views�� registerForm.html �����ؼ� 
	                       //registerForm.jsp ����
		                       //�ٸ� jsp���Ͽ��� ���� ��� �����ؼ� �ٿ��ֱ�.
	}
	
	//0.���� �ּ��� �κ� �ù� �� 2�� �̵�
	//1.�̷��� �ϸ� GET������� ȸ������ �� �� ���� �ȴ�.

//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
//	public String save() {
//		return "registerInfo";
//	}
	
	//2.�ٵ� �� ��� ������ �� �� �ִ°� POST �����̴�
	@PostMapping("/register/save") //3.PostMapping�� ������ �ߴµ� 4.3���� ���� �����ϱ� �����̴�
								   //4.Maven Dependencies ���� ������ ������ ���´�
	                               //5.���� ������ 3.1.1�̴�.
	//6.�̰� �ٲٷ��� pom.xml ���ߵȴ�.
	//7.pom.xml ���� ������ ������ 5.0.7 �������� �ٲ۴�.
	//8.�� ���� project update �� �ش�.
	//9. �� ���� IMPORT �� �ָ� ������ ��������.
	
	//19. �ϴ� ���� ���� ���� �����ؾ� �Ǳ� ������ save �ȿ�
	//20. save(String id, String pwd)��� �־���� ��. �ٵ� �ʹ� ����.
	//21. �׷��� �׳� user�� ����
	//22. Create User
	public String save(User user,Model m) throws Exception{
		//23. ��ȿ�� �˻�
		if(!isValid(user)) { //24.��ȿ���� ������ ȸ������ ȭ������ ���ư�
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.","utf-8");
			
			return "redirect:/register/add3?msg="+msg;//25.���� ����� URL ���ۼ��̶�� �θ�(rewriting)
													  //26.�ѱ� ������ �����µ�, URL���ڴ� �Ἥ ���ڵ� ����� �ȴ�
		
			//27.�Ʒ�ó�� ���ִ°� �� ����. �𵨾�Ʈ����Ʈ�� ��Ƽ� �ϴ°���.
			//28.���� ���� �信 �����ϱ� ���Ѱǵ�. ������ �����̷�Ʈ�� �Ἥ �����ϴ°���
			//29.�׷��� �𵨷� ���� �� ���� ����. redirect�� ���û�� �ǹ̶� �׷�.
			//30.���� �ִ� Model�� /register/save�� ���� ����.
			//31.�׷��� �������� �ڵ����� �ٲ���. ����  return "redirect:/register/add3?msg="+msg; ��ó��
		//	m.addAttribute("msg",msg);
		//	return "redirect:/register/add";
			//32.���������� registerInfo2.jsp ���� param�� user�� �ٲ���.
		
		
		}
		
		
		
		//19. DB�� �ű�ȸ�� ������ ���� ( �̰� ���߿� �Ұ�)
		return "registerInfo2";
	}

	private boolean isValid(User user) {
		return false;
	}
}
