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
<%-- uploadform.jsp

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
Spring Form Tag는 Spring Web MVC와 연동된 태그 라이브러리로써,
커맨드 객체 및 컨트롤러의 데이터에 접근할 수 있습니다.

multipart/form-data
모든 문자를 인코딩하지 않음을 명시함.
이 방식은 <form> 요소가 파일이나 이미지를 서버로 전송할 때 주로 사용함.

modelAttribute 
폼에 있는 요소들의 값을 채우기 위해서 사용될 객체를 
request 로부터 찾을때 사용할 이름을 지정합니다.

<input type="file" name="file"/>
파일선택 버튼을 만들어줌

<form:errors path="file" />
폼태그에 file 부분에서 에러가 날시 지정한 메세지 출력


applicationContext.xml

Multipart 지원 기능을 사용하려면 먼저 MultipartResolver를 스프링 설정 파일에 등록.
스프링에서 기본으로 제공하는 MultipartResolver는 CommonsMultipartResolver이다. 
CommonsMultipartResolver를 MultipartResolver로 사용하려면 
다음과 같이 빈 이름으로 "multipartResolver"를 사용해서 등록.

maxUploadSize - 최대 업로드 가능한 바이트 크기, -1은 제한이 없음을 의미, 기본값은 -1 

defaultEncoding -    요청을 파싱할 때 사용할 캐릭터 인코딩. 지정하지 않을 경우, 
HttpServletRequest.setCharacterEncoding() 메서드로 지정한 캐릭터 셋이 사용. 
아무 값도 없을 경우 ISO-8859-1을 사용.



form tag의 enctype 속성
1. application/www-form-urlencoded : (default 설정) 모든 문자들을 encoding
2. multipart/form-data : file upload 가능 (post로 보내야함)
3. text/plain : encoding 하지 않고 보내겠다


form:erros = Errors, BindingResult를 사용할 때 
command객채의 특정 filed에서 발생하는 에러 메세지 출력

response.setContentType("image/jpeg");
// tomcat web.xml 확인(mime-type)


mime(Multipurpose Internet Mail Extension) type : 
request header에 지정되는, 데이터가 어떤 종류의 stream인지를 나타내는 프로토콜 
      
   ex) hwp
   <mime-mapping>
      <extension>hwp</extension>
      <mime-type>application/unknown</mime-type> --%>

</body>
</html>
