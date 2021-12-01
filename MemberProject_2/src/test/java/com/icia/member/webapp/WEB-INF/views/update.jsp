<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <script>
  /* 비밀번호 입력 창에서 비밀번호를 입력받고 DB에서 가져온 비밀번호와 비교해서 일치하면 업데이트 처리 일치하지않으면 비밀번호가 일치하지 않습니다. alert 출력
  */
  
  function update(){
	  console.log('update 함수 호출')
	  // 이 문장이 아래 form을 전송하는 문장
	  // update_form.submit();
	  const pw= document.getElementById('m_password').value;
	  console.log(pw)
	  const pwDB = '${member.m_password}';
	  console.log(pwDB);
	  if(pw==pwDB) {
		  update_form.submit();
	  }else {
		  alert('비밀번호가 틀립니다.');
	  }

  }
  </script> 
</head>
<body>
    <form action="update" method="post" name="update_form">
    	<input tyep="hidden" name="m_number" value="${member.m_number}" readonly>
        ID : <input type="text" name="m_id" value="${member.m_id}" readonly>
        PW : <input type="password" name="m_password" value="${member.m_password}" readonly>
        이름 : <input type="text" name="m_name" value="${member.m_name}" readonly>
        email : <input type="text" name="m_email" value="${member.m_email}">
        phone : <input type="text" name="m_phone" value="${member.m_phone}">
        <input type="button" value="수정" onclick="update()">
</body>
</html>