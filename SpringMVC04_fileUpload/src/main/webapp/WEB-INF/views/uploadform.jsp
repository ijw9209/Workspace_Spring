<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- form enctype="multipart/form-data" 을 꼭 적어줘야 함 안적으면 form 이 안감 -->

	<!-- spring에서의 form tag에서는 input 값이나 password로 생성한 이 부분을 java object와 mapping 하도록 되어 있다. -->
	<!-- 위 코드의 form tag에서 modelAttribute="user" 를 넣어주면,(여기에서 user는 앞서 지정한 addAttribute의 이름이다.) form tag에서 User.class에 있는 set method와 get method를 이용해서 각각의 속성들과 mapping을 자동으로 해준다. -->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h3>업로드 할 파일 선택</h3>
		파일 : <input type="file" name="file"/><br/>
		<p style="color: red; font-weight: bold;">
			<form:errors path="file" />
		</p><br/>
		설명 : <br/>
		<textarea rows="10" cols="40" name="desc"></textarea><br/>
		<input type="submit" value="전송"/>
	</form:form>

</body>
</html>
