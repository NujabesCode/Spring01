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
		//1.게시물 목록 보여줌
		public String list(HttpServletRequest request) {
			//2.로그인을 안해도 게시판으로 접근할 수 있었기 때문에
			//3.로그인을 해야만 게시판이 보이게 수정해줌
			if(!loginCheck(request))
				//4.로그인 체크를 해서 로그인 안했으면 로그인 화면으로 이동
				return "redirect:/login/login";
			
			
			return "board"; //로그인을 한 상태이면, 게시판 화면으로 이동
		}

		private boolean loginCheck(HttpServletRequest request) {
			//1. 세션을 얻어서
			HttpSession session = request.getSession();
			//2. 세션에 id가 있는지 확인
//			if(session.getAttribute("id")!=null)
//				return true;
//			else
//				return false;
//			return false;
			
			//3.이 한줄이 위 4줄과 같음.
			return session.getAttribute("id")!=null;
		}
	}


