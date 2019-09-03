<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>select one</h1>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${dto.password }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<td colspan="3">
			<input type="button" value="수정" onclick="location.href='updateform.do?id=${dto.id}'">
			<input type="button" value="삭제" onclick="location.href='delete.do?id=${dto.id}'">
			<input type="button" value="목록" onclick="location.href='list.do'">
			</td>
		</tr>
	</table>

</body>
</html>