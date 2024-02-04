<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <style>
       * { box-sizing:border-box; }
       a { text-decoration: none; }
        form {
            width:400px;
            height:500px;
            display : flex;
            flex-direction: column;
            align-items:center;
            position : absolute;
            top:50%;
            left:50%;
            transform: translate(-50%, -50%) ;
            border: 1px solid rgb(89,117,196);
            border-radius: 10px;
        }
        input[type='text'], input[type='password'] {
            width: 300px;
            height: 40px;
            border : 1px solid rgb(89,117,196);
            border-radius:5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }
        button {
            background-color: rgb(89,117,196);
            color : white;
            width:300px;
            height:50px;
            font-size: 17px;
            border : none;
            border-radius: 5px;
            margin : 20px 0 30px 0;
        }
        #title {
            font-size : 50px;
            margin: 40px 0 30px 0;
        }
        #msg {
            height: 30px;
            text-align:center;
            font-size:16px;
            color:red;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
 <!-- 전송하기 버튼을 누르면 POST 방식으로 /login/login으로 가게 되어있다. 만들어 줘야된다 나중에 -->
    <form action="<c:url value='loginCookie/loginCookie'/>" method="post" onsubmit="return formCheck(this);">
        <h3 id="title">Login</h3>
        <div id="msg">
	    <c:if test="${not empty param.msg}">
		<i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>            
	    </c:if>        
	</div>
			<!-- 1. ${cookie.id.value}  -->
        <input type="text" name="id" value="${cookie.id.value}" placeholder="이메일 입력" autofocus>
        <input type="password" name="pwd" placeholder="비밀번호">
        <button>로그인</button>
        <div>
        	<!-- 2. 쿠키.id.벨류가 없으면 빈문자열. 있으면 checked -->
            <label><input type="checkbox" ${empty cookie.id.value ? "":"checked" } name="rememberId"> 아이디 기억</label> |
            <a href="">비밀번호 찾기</a> |
            <a href="">회원가입</a>
        </div>
        <script>
            function formCheck(frm) {
                 let msg ='';
     
                 if(frm.id.value.length==0) {
                     setMessage('id를 입력해주세요.', frm.id);
                     return false;
                 }
     
                 if(frm.pwd.value.length==0) {
                     setMessage('password를 입력해주세요.', frm.pwd);
                     return false;
                 }

                 return true;
            }
     
            function setMessage(msg, element){
                 document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
     
                 if(element) {
                     element.select();
                 }
            }
        </script>
    </form>
</body>
</html>