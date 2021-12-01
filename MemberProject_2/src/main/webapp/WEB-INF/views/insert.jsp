<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input {
	display: block
	}
</style>
</head>
<body>
	<h2>insert.jsp</h2>
	<form action="insert" method="post">
	ID : <input type="text" name="m_id">
	password : <input type="text" name="m_password">
	name : <input type="text" name="m_name">
	email : <input type="text" name="m_email">
	phone : <input type="text" name="m_phone">
	<input type="submit" value="등록">
	</form>

</body>
</html>