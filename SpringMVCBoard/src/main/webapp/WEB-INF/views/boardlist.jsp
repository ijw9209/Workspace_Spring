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
	
	<h1>글 목록</h1>
	<table border="1">
		<col width="50"/>
		<col width="100"/>
		<col width="100"/>
		<col width="500"/>
		<tr>
			<th>번  호</th>
			<th>작성자</th>
			<th>제  목</th>
			<th>작성일</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">------------------작성된 글이 존재하지 않습니다------------</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td><input type="checkbox" name="chk" value="${dto.seq }"></td>
						<td>${dto.seq }</td>
						<td>${dto.writer }</td>
						<td><a href="selectone.do?seq=${dto.seq}">${dto.title }</a></td>
						<td>${dto.regdate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>	
		</c:choose>
		
				<tr>
					<td colspan = "5">
						<input type="button" value="글 작성" onclick="location.href='./insertform.do'">
						<input type="submit" value="멀티삭제" >
					</td>	
				</tr>
	</table>
	</form>


</body>
</html>