<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<h2>detail</h2>
	<table class="table table-dark table-hover text-center">
			<tr>
			<th>번호</th>
			<th>ID</th>
			<th>PW</th>
			<th>이름</th>
			<th>이메일</th>
			<th>휴대폰 번호</th>
			</tr>
			<br>
			<tr>
				<td>${member.m_number}</td>
				<td>${member.m_id}</td>
				<td>${member.m_password}</td>
				<td>${member.m_name}</td>
				<td>${member.m_email}</td>
				<td>${member.m_phone}</td>


</tr>
		</table>
</body>
</html>