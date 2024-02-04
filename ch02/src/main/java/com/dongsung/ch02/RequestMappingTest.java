package com.dongsung.ch02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingTest {
//  @RequestMapping({"/login/hello.do", "/login/hi.do"}) 
   
	//1.요청을 하면 404 not found 나온다. 뷰가 없어서 그렇지 콘솔창에는 뜬다.
	@RequestMapping("/login/hello.do") // http://localhost/ch2/login/hello.do
    public void test1(){
        System.out.println("urlpattern=/login/hello.do");
    }
	
	//2.localhost/ch02/login/hello2.dom 입력하면 이친구가 처리한다.
    @RequestMapping("/login/*")   // /login/hello, /login/hi
    public void test2(){
        System.out.println("urlpattern=/login/*");
    }

    //3.별 두개가 들어가면 여러 하위 경로가 들어가도 된다는 뜻이다.
    @RequestMapping("/login/**/tmp/*.do")   // /login/tmp/hello.do, /login/aaa/tmp/hello.do
    public void test3(){
        System.out.println("urlpattern=/login/**/tmp/*.do");
    }
    //4. 물음표 하나는 한글자.
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
//다 했으면 다시 ppt로 이동.