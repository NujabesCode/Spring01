<%@ page contentType="text/html; charset=utf-8" %>  <!-- 한글 깨지면 인코딩 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

year<%=request.getParameter("year") %>
<P> ${myDate.year}년 ${myDate.month}월 ${myDate.day} 일은 ${dow} 입니다. </P>
</body>
</html>
