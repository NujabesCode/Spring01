package com.dongsung.ch02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

		@GetMapping("/list")
		//1.�Խù� ��� ������
		public String list(HttpServletRequest request) {
			//2.�α����� ���ص� �Խ������� ������ �� �־��� ������
			//3.�α����� �ؾ߸� �Խ����� ���̰� ��������
			if(!loginCheck(request))
				//4.�α��� üũ�� �ؼ� �α��� �������� �α��� ȭ������ �̵�
				return "redirect:/login/login";
			
			
			return "board"; //�α����� �� �����̸�, �Խ��� ȭ������ �̵�
		}

		private boolean loginCheck(HttpServletRequest request) {
			//1. ������ ��
			HttpSession session = request.getSession();
			//2. ���ǿ� id�� �ִ��� Ȯ��
//			if(session.getAttribute("id")!=null)
//				return true;
//			else
//				return false;
//			return false;
			
			//3.�� ������ �� 4�ٰ� ����.
			return session.getAttribute("id")!=null;
		}
	}


