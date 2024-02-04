package com.dongsung.ch02;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller 
public class RegisterFoward {

	
	//34�� ���Ŀ� RequestMapping���� �ٲ� ��.
	@RequestMapping(value="/register/add5", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm2";
	}
	
	@PostMapping("/register/save2") 
	public String save(User user,Model m) throws Exception{
		
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.","utf-8");
			
//			return "redirect:/register/add5";
			
			//23.ó������ redirect �׽�Ʈ �ϰ� ���߿� foward�� �ٲ�
			//24.�ٽ� http://localhost:8080/ch02/register/add3 ��
			//25.�ٽ� �Է��ϰ� ȸ������ �غ�
			//26.�׷��� ���� �ߴµ�. �� �׷��ĸ� save�� POST�� ���±� ������
			//27.�׷� �� ��û�� foward�� �� post�� foward�� ��
			//28. ���� ���̳ĸ� register/save2��
			//29./register/add5�� fowar�ϴ°ǵ�
			//30./register/add5������ GET�ۿ� ó���� ���Ѵ�.
			//31. �׷��� ������ ������ ���°Ŵ�.
			//32. �׷��� ������ ���� servlect-context.xml���� �����.
			//33. �ֳ��ϸ� �ű� �����ִ°� GET���� �ۿ� ���ޱ� �����̴�.
			//34. ���� GetMapping�� RequestMapping���� �������ش�.
			//35. �ٲ��ִ� ������ ���� RequestMapping���� get post �� ������ �� �� ���� �� �ֱ� �����̴�.
			//36. �� ���� �ٽ� ȸ�������ؼ� ��û�� �� ����
			//37. save ��û�� ���� Reponse Headers ������ 200���� �� �Դ�
			//38. �ּ�â�� ���� register/save �״�� �� �����ϰ� �ִ�.
			//39. �� ���� ���� ȭ���� register/add�̴�
			//40. ��û�� save��. �� save�� �� ��û�� add�� foward �� �����ѰŴ�.
			//41. foward�� �ѹ� �ۿ� ��û�� ���ϱ� ������ �ȹٲ�Ŵ�. 
			//42. ���� �ι� ��û������ �ٲ�����? �� �� �˾Ƶα� �ٶ���.
			m.addAttribute("msg",msg);
			//ó���� redirect. �״��� forward�� �ٲ�.
			return "forward:/register/add5";
		
		
		}
		
		
		
		return "registerInfo3";
	}
	
	//1.�׽�Ʈ�� ���� return�� false��. �׷� ���� isValid�� ture�� ��.
	//2.�׷� �ڵ����� ���� �ּҷ� redirect ��
	//3.���� ��ŸƮ�ϰ� loacalhost/ch2/register/add5�� ��.
	//4.F12������ network ����
	//5.�� ���¿��� ȸ�������� �غ�.
	//6.ȸ�������� ������ save�� �ٷ� ��.
	//7.���� ���� �˰�����, �츮�� redirect �׽�Ʈ�� �ϰ��ִ� ����
	//8.���� ��û�� 1���ε� �ΰ��� ��û�� ����.
	//9.�Ʊ� �����Ѱ� ó�� redirect�� ��û�� �ι� ���� ������.
	//10.ù��°�δ� save�� �����͸� ���� ����.
	//12.�ٵ� ������ 300����� ����.
	//13.300����� redirect��� ����.
	//14. �׸��� ���� redirect �ϳĸ�. �װ� location�� ��������
	//15.location�� �� ��û�� URL�� ���� ����.
	//16.�츮�� ��û�� save�� �ߴ���. ����� �ٽ� ��û�϶�� ����.
	//17.�׷��� �������� �ڵ����� ��û�� �ع���
	//18.�װ� �ٷ� �ؿ� �ִ� add?msg=��
	//19.�츮�� 2�� ��û�� �� ���� ���µ�. �������� 300���� ������ �޾ұ� ������
	//20.�ڵ����� location���� ��û�� �Ѱ���.
	//21.�ٵ� ���� �ּ�â�� ���� localhost/ch2/register/add?msg�� url�� �ٲ�����
	//22.���� ���̳ĸ� �츮�� ȸ������ �����ڸ��� save�� ��û�� �Ǵµ�[
	//23.�����̷�Ʈ �Ǽ� �ڵ����� add?�� �ٲ����. �ٵ� foward�� �ȹٲ�
	//21.�״��� ���� �ö󰡼� return "redirect:�� foward:�� �ٲ�"
	//22.
	private boolean isValid(User user) {
		return false;
	}
}
