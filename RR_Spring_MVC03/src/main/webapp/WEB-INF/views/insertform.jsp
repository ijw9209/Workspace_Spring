<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="insertres.do" method="get">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>		
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td colspan="3">
				<input type="submit" value="생성">
				<input type="button" value="목록" onclick="location.href='list.do'">
			</tr>
		</table>
	</form>

</body>
</html>