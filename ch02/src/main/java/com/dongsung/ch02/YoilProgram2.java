package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8080/ch02/YoilProgram2?year=2021&month=21&day=31
@Controller
public class YoilProgram2 {
    @RequestMapping("/YoilProgram2") 
    //ó������ �Ű������� (String[] args) ��Ʈ�� �迭�̾��µ�
    //�̹����� �Ű������� (HttpServletRequest request)��.
    //�Ű������� (HttpServletRequest request)��� ���� �ָ�. ��Ĺ�� HttpServletRequest ��ü�� ���� ��
    //URL�� �Է°��� ��ü�� ��Ƽ� �Ű������� �Ѱ� ��.
    public void main(HttpServletRequest request) {
    	
    	/*request.getParameter*/
    	//�� ��û���� ���� ���ڿ�(query string)�� �Ķ���� ���� �������� �� ����
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
        System.out.println(year + "�� " + month + "�� " + day + "���� ");
        System.out.println(dow + "�����Դϴ�.");
       
    }
}