package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgram3 {
    @RequestMapping("/YoilProgram3") // http://localhost:8080/ch02/YoilProgram3?year=2021&month=10&day=1
    
    //  1. �������� ������ �Ϸ��� request �ߴ� �� ó��, response ��ü�� �Ű������� ������� �ȴ�.
    //  2. HttpServletResponse response��  �Ű������� ���⸸�ϸ� ��Ĺ�� ��ü�� ����� �ش�.
    /*  HttpServletRequest request ��ü�� Ŭ���̾�Ʈ�� �������� ������ �����ͳ� ��û�� ���õ� ������ �о���̴� �� ���Ǹ�
        HttpServletResponse response ��ü�� �������� Ŭ���̾�Ʈ�� �����͸� �����ϰų� ������ ���¸� �����ϴ� �� ����.*/
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. �Է�
    	//String year =  args[0];
    	//String month = args[1];
    	//String day =   args[2];
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. ó��
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        char dow = " �Ͽ�ȭ�������".charAt(dayOfTheWeek);   // �Ͽ���:1, ������:2, ... 

        // 3. ���
        // System.out.println(year + "�� " + month + "�� " + day + "���� ");
        // System.out.println(yoil + "�����Դϴ�.");
        
        
        //response ��ü�� �̿��ؼ� �������� ���
        response.setContentType("text/html");    // ������ ������ html�� ����
        response.setCharacterEncoding("utf-8");  // ������ ���ڵ��� utf-8�� ����
        PrintWriter out = response.getWriter();  /* HttpServletResponse���� Ŭ���̾�Ʈ�� �ؽ�Ʈ�� ����ϱ� ����
         											PrintWriter ��ü�� ��� �ڵ���. */
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println(year + "�� " + month + "�� " + day + "���� ");
        out.println(dow + "�����Դϴ�.");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}