<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>select list</h1>
	
	<table border="1">
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td>---------내용이 없습니다-------</td>
				</tr>
			</c:when>
		<c:otherwise>
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td><a href="selectone.do?id=${dto.id}">${dto.id }</td>
					<td>${dto.name }</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="2">
				<input type="button" value="고객 추가" onclick="location.href='insertform.do'">
			</tr>		
		</c:otherwise>
		</c:choose>
	
	</table>

</body>
</html>