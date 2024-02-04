<%@ page contentType="text/html; charset=utf-8" %>  <!-- 한글 깨지면 인코딩 -->
<!-- 먼저 한글 깨지는거 시범 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>


year<%=request.getParameter("year") %>
<P> ${year}년 ${month}월 ${day} 일은 ${dow} 입니다. </P>
</body>
</html>
