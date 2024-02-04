<%@ page contentType="text/html; charset=utf-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import ="java.net.URLDecoder"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <!-- http://localhost:8080/ch02/resources/registerForm.html -->
    <style>
        * { box-sizing:border-box; }

        form {
            width:400px;
            height:600px;
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

        .input-field {
            width: 300px;
            height: 40px;
            border : 1px solid rgb(89,117,196);
            border-radius:5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }
        label {
            width:300px;
            height:30px;
            margin-top :4px;
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

        .title {
            font-size : 50px;
            margin: 40px 0 30px 0;
        }

        .msg {
            height: 30px;
            text-align:center;
            font-size:16px;
            color:red;
            margin-bottom: 20px;
        }
        .sns-chk {
            margin-top : 5px; 
        }
    </style>
    <title>Register</title>
</head>
<body>
    
   <!-- 1. action 안에 적어준 다음에 오른쪽 마우스 소스보기 해서 변경됐나 확인한다. 캐쉬때매 적용 안될 수도 있음. -->
   <!-- 그 다음에 전송 방식을 POST로 바꿔준다. -->
   <!-- 2.. 확인 먼저 하면 POST 방식으로 잘 전송된걸 확인할 수 있는데 sns 값이 facebook 하나 나온다. 
        왜냐하면 checkbox 네임이 다 똑같기 때문이다.
        ?sns=facebook&sns=kakaotalk 
        3.그 다음 registerinfo.jsp 가 보면
        <h1>sns=${param.sns}라고 되어있는데 이걸 ${paramvalues.sns}로 바꿔준다
        paramvalues는 el 표현식에서 사용하는거다. param도 마찬가지이다.
        참고로 pramValues는 배열이다. 그래서 [0][1][2]이런식으로 들어간다.
        4.form태그 안에는 일단 action과 method만 적어주고 onsubmit은
          밑에 formCheck 설명하고 나중에 적어준다
        5.이제 registerinfo.jsp에서 paramvalues로 바꿔준다.
        --> 
        
        <!--onsubmit="return formCheck(this)
        	formCheck는 아까 밑에 있던 함수고. this가 의미하는건 바로 form태그 자기 자신이다.
        	onsubmit= 은 이벤트 등록이다.
        	원래는 function(){return formCheck(this)} 이렇게 써야되는데
        	function(){} 뺴고 써도 된다.
        	
        	그래서 아무튼 onsubmit 전송할 때 formCheck 함수가 호출이 된다.
        	
        	함수의 결과는 true flase 두가지이다. true일떄는 폼전송.
        	                              flase일때는 폼전송을 안한다.
        
          -->
    
    
    
   <!--  <form action="/ch02/registerInfo2.jsp" method="POST" onsubmit="return formCheck(this)"> -->
   <!-- 아래로 나중에 바꿔준다 -->
   <!-- <form action="/ch02/register/save" method="POST" onsubmit="return formCheck(this)"> -->
   <!-- 근데 아래처럼 바꿔주면 더 좋다. c:url이 자동으로 컨텍스트 루트를 추가로 자동으로 해준다 ch02로
  												          session id도 자동으로 추가해준다. 이건 session 강의할떄 알려준다. -->
    <form action="<c:url value="/register/save2"/>" method="POST" onsubmit="return formCheck(this)">                                                                   
    <div class="title">Register</div>
    <!-- 맨위에 임포트문도 써줘야됨 자바 닷넷에 있는거라. -->
    <div id="msg" class="msg">${URLDecoder.decode(param.msg, "utf-8")} </div>
    <label for="">아이디</label>
    <!-- placeholder는 어떤걸 입력해야 되는지 메세지 보여 주는거고 저기다 autofocus 하면 아이디에 깜빡꺼리게 된다-->
    <input class="input-field" type="text" name="id" placeholder="8~12자리의 영대소문자와 숫자 조합" autofocus>
    <label for="">비밀번호</label>
    <input class="input-field" type="text" name="pwd" placeholder="8~12자리의 영대소문자와 숫자 조합">
    <label for="">이름</label>
    <input class="input-field" type="text" name="name" placeholder="홍길동">
    <label for="">이메일</label>
    <input class="input-field" type="text" name="email" placeholder="example@.co.kr">
    <label for="">전화번호</label>
    <input class="input-field" type="text" name="email" placeholder="example@.co.kr">  
    <label for="">생일</label>
    <input class="input-field" type="text" name="birth" placeholder="2020/12/31">
    <div class="sns-chk">
        <label><input type="checkbox" name="sns" value="facebook"/>페이스북</label>
        <label><input type="checkbox" name="sns" value="kakaotalk"/>카카오톡</label>
        <label><input type="checkbox" name="sns" value="instagram"/>인스타그램</label>
    </div>
    <button>회원 가입</button>
   </form> 
   <script>
       
       function formCheck(frm) {
            var msg ='';
            //주석 때문에 안먹힐 수 있으니 주석은 치지말고 말로 설명한다 -->
			/*
			form에 있는 id의 값의 길이를 체크한다. 그래서 길이가 3보다 작으면
			3보다 커야된다고 메세지를 보여준다
			*/	
			
            if(frm.id.value.length<3) {
                setMessage('id의 길이는 3이상이어야 합니다.', frm.id);
                return false;
            }
            
            
            //pwd도 추가.
            if(frm.pwd.value.length<3) {
                setMessage('pwd의 길이는 3이상이어야 합니다.', frm.pwd);
                return false;
            }

           return true; //아무 문제 없으면 form이 전송이 된다
       }
		//메세지 보여주는 함수.
       function setMessage(msg, element){
    	  
            document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'} </i>`;
            //document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'{msg}'}'</i>`; 
			//RegisterController 실행 후에 나중에 바꿔준다. aa 두개쳐도 메세지 안나오는거 확인시켜주고.
            
            
            //select 함수: 값을 잘못 입력했을때, 잘못 입력한 값이 선택되게 보여지게 하는 함수
            if(element) {
                element.select();
            }
       }
   </script>
</body>
</html>

<!-- 실습 다 한 다음에 스프링으로 이걸 똑같이 만들어 본다. -->
<!-- RegisterContorller 생성 -->