package com.dongsung.ch02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingTest {
//  @RequestMapping({"/login/hello.do", "/login/hi.do"}) 
   
	//1.��û�� �ϸ� 404 not found ���´�. �䰡 ��� �׷��� �ܼ�â���� ���.
	@RequestMapping("/login/hello.do") // http://localhost/ch2/login/hello.do
    public void test1(){
        System.out.println("urlpattern=/login/hello.do");
    }
	
	//2.localhost/ch02/login/hello2.dom �Է��ϸ� ��ģ���� ó���Ѵ�.
    @RequestMapping("/login/*")   // /login/hello, /login/hi
    public void test2(){
        System.out.println("urlpattern=/login/*");
    }

    //3.�� �ΰ��� ���� ���� ���� ��ΰ� ���� �ȴٴ� ���̴�.
    @RequestMapping("/login/**/tmp/*.do")   // /login/tmp/hello.do, /login/aaa/tmp/hello.do
    public void test3(){
        System.out.println("urlpattern=/login/**/tmp/*.do");
    }
    //4. ����ǥ �ϳ��� �ѱ���.
    @RequestMapping("/login/??")
    public void test4(){   // /login/hi, /login/my.car
        System.out.println("urlpattern=/login/??");
    }

    @RequestMapping("*.do") // /hello.do, /hi.do, /login/hi.do
    public void test5(){ 
        System.out.println("urlpattern=*.do");
    }
    
    @RequestMapping("/*.???") //  /hello.aaa, /abc.txt
    public void test6(){ 
        System.out.println("urlpattern=*.???");
    }
}
//�� ������ �ٽ� ppt�� �̵�.