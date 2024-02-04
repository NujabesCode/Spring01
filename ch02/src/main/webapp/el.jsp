<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.dongsung.ch02.*" %>
<%
    //Person 객체 만들고
    //person은 지역변수 lv이다.
	Person person = new Person();
	//Person 객체를 request 저장소에 저장함.
	//el에서는 지역변수를 사용할 수 없기 때문에 request 객체에 저장해야 쓸 수 있음.
	request.setAttribute("person", person);
	request.setAttribute("name", "스프링");
	//ArrayList를 저장했는데, 아무것도 없는 내용을 저장한거.
	request.setAttribute("list", new java.util.ArrayList());	
%>
<html>  
<head>   
	<title>EL</title>   
</head>  
<body>   
<!-- Person이 Car를 가지고 있고 getCar를 호출하면 Car의 getColor red출력 -->
person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
<!-- 이렇게 EL표현식 쓸 수 있지만 -->
person.getCar().getColor()=${person.getCar().getColor()} <br>
<!-- 아래 EL표현식이 훨씬 간결함 car라고 썼지만 결국 getCar를 호출한거임. 생략해도 됨 -->
person.getCar().getColor()=${person.car.color} <br>    
name=<%=request.getAttribute("name")%> <br>   
name=${requestScope.name} <br>
<!-- name도 이렇게 간략하게 쓸 수 있으니 너무 편하다. -->
<!-- 이렇게 쓸 수 있는 이유는 scope가 4개가 있다. page,request,session,application -->
<!-- el 굳이 이렇게까지 햇갈리게 하고싶지 않은데, 알아서 구글에 찾아봐라 그냥 설명만 해준다. -->
<!-- name은 지금 pageContext에 저장 되어있다. -->
name=${name} <br>
<!-- jsp 는 null로 나옴 -->
id=<%=request.getParameter("id")%> <br>
<!-- el은 아무것도 안나옴. el은 null이 나오지 않는 차이가 있음-->
id=${pageContext.request.getParameter("id")} <br>
id=${param.id} <br>
<!-- 문자열 + 숫자는 자바에서 "11" 이렇게 된다 -->
<!-- 근데 el에서는 숫자로 바껴서 2가 된다. -->
"1"+1 = ${"1"+1} <br>
"1"+="1" = ${"1"+="1"} <br>
<!-- 비교연산도 "2"가 숫자로 바뀜 -->
"2">1 = ${"2">1} <br>   
<!-- null아난옴 -->
null = ${null}<br>
<!-- 계산할때는 null이 0으로 바뀜 -->
null+1 = ${null+1} <br>
<!-- 0+0이니까 0나옴 -->
null+null = ${null+null} <br>
"" + null = ${""+null} <br>   
""-1 = ${""-1} <br> 
<!-- empty는 null인지 비었는지 확인함. -->
empty null=${empty null} <br>
<!-- 비었을때도 true가 나온다. 아까 ArrayList 빈거 넣음 -->
empty list=${empty list} <br>
null==0 = ${null==0} <br>
null eq 0 = ${null eq 0} <br>
name == "스프링"=${name=="스프링"} <br>
name != "스프링"=${name!="스프링"} <br>
name eq "스프링"=${name eq "스프링"} <br>  
name ne "스프링"=${name ne "스프링"} <br>  
name.equals("스프링")=${name.equals("스프링")} <br>   
</body>
</html>

[실행결과]
person.getCar().getColor()=red
person.getCar().getColor()=red
person.car.color=red
name=스프링
name=스프링
name=스프링
id=asdf
id=asdf
id=asdf
"1"+1 = 2
"1"+="1" = 11
"2">1 = true
null =
null+1 = 1
null+null = 0
"" + null = 0
""-1 = -1
empty null=true
empty list=true
null==0 = false
null eq 0 = false
name == ""=true
name != "스프링"=false
name eq "스프링"=true
name ne "스프링"=false
name.equals("스프링")=true