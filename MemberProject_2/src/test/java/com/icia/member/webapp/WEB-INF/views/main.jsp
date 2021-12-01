<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer>
	function logout(){
		location.href="logout"
	}
</script>
</head>
<body>
	<h2>main.jsp</h2>
	<table class="table table-dark table-hover text-center">
	${sessionScope.loginId}<br>
	<button class="btn btn-danger mt-3" onclick="logout()">로그아웃</button><br>
	
	
	
	
	<!--  아래 링크를 클릭하면 전체회원목록을 조회하여 find.All.jsp에 출력 -->
	<!--  아이디가 admin 인 관리자가 로그인 했을 때만 목록 링크가 보이도록 -->
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="findAll">회원목록(관리자)</a>
	</c:if>
	<a href="findAll" class="btn btn-warning mt-3 mb-3">회원목록</a>
	</table>
</body>
</html>