<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>id=${param.id}</h1>
<h1>pwd=${param.pwd}</h1>
<h1>name=${param.name}</h1>
<h1>email=${param.email}</h1>
<h1>birth=${param.birth}</h1>
<h1>sns=${paramValues.sns}</h1> <!-- 실행하면 스트링 배열이라는 뜻의 코드 나온다 -->
<h1>sns=${paramValues.sns[0]}</h1>
<h1>sns=${paramValues.sns[1]}</h1>
<h1>sns=${paramValues.sns[2]}</h1>
<!-- 1.paramValues.sns 로 바꿔준다 -->

<!-- 2.다시 registerForm으로 이동. -->


<!-- 3. id=${user.id} 밑에거도 user로 다 바꿔주고 sns=${user.sns} 하나만 남김-->
</body>
</html>