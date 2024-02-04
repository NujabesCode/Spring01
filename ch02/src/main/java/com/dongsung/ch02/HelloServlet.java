package com.dongsung.ch02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//�������̵��� �Ѵ� source -> Override/Implement Methods -> service �����
//             GenericServlet - > init() destory()


@WebServlet("/hello") //��������� �ȴ�.
//������ HttpServlet�� ��� �޾ƾ� �ȴ�.
public class HelloServlet extends HttpServlet {
  
	@Override
	public void init() throws ServletException {
		// ������ �ʱ�ȭ�ɶ� �ڵ� ȣ��Ǵ� �޼���
		// 1.������ �ʱ�ȭ �۾��� ���
		System.out.println("[HelloServlet] init() is called.");
	}
	

	@Override
	//������ �۾��� ó���ϴ� �޼���
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. �Է�
		//2. ó��
		//3. ���
		
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override
	public void destroy() {
		//3. ������ - ������ �޸𸮿��� ���ŵɶ� ���� �����̳ʿ� ���ؼ� �ڵ� ȣ��. //��Ʈ���� ������ �ּ�â�� �� �ϳ���ġ�� ��. 
		System.out.println("[HelloServlet] destroy() is called.");
	}



}

//1. run �ϸ� ���� �ƹ��ŵ� �ȶߴµ� �ܼ�â�� println ȣ��.
//2. ���ΰ�ħ ��� �ϸ� init()�� ȣ�� �ȵǰ� service()�� ��� ȣ�� �ȴ�.
//3. ���� init�� destory�� ȣ��Ǵ��� �˾ƺ��� ��. ppt�� �̵�