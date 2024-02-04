package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgramMVC {
    @RequestMapping("/getYoilProMVC") // http://localhost:8080/ch02/getYoilMVC?year=2021&month=10&day=1
    
    
    	//1.������ �Ʒ��� ���� ���θ޼��尡 ����� ������.
        //public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
     
        //2.�׷����� �Ʒ��� ���� �ٲ� �ָ� 1. �Էºκа� 2. ����ȯ �κ��� �ʿ䰡 �������� �������ָ� �ȴ�.
        //public void main(String year, String month, String day, HttpServletResponse response) throws IOException{
        public void main(int year, int month, int day, HttpServletResponse response) throws IOException{
       
    	
        //ó��
        Calendar cal = Calendar.getInstance();

        cal.set(year, month -1, day);

        int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
        char dotw = " �Ͽ�ȭ�������".charAt(dayOfTheWeek);   // �Ͽ���:1, ������:2, ... 

        
        
        //response ��ü�� �̿��ؼ� �������� ���
        response.setContentType("text/html");    // ������ ������ html�� ����
        response.setCharacterEncoding("utf-8");  // ������ ���ڵ��� utf-8�� ����
        PrintWriter out = response.getWriter();  // ���������� ��� ��Ʈ��(out)�� ��´�.
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println(year + "�� " + month + "�� " + day + "���� ");
        out.println(dotw + "�����Դϴ�.");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}