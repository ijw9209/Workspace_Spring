<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>update</h1>
	<form action="updateres.do" method="post">
	<input type="hidden" name="id" value="${dto.id }">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="password" value="${dto.password}"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${dto.name}"></td>
		</tr>
		<tr>
			<td colspan="3">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href='list.do'">
		</tr>
	</table>
	</form>

</body>
</html>