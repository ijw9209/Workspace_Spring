package com.hello.mvc03.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		//Filter는 Interceptor가 호출되기 이전, 그리고 DispatcherServlet에 요청이 들어오기 전에 먼저 거치게 되는 클래스를 말한다.
		String remoteAddr = StringUtils.defaultString(req.getRemoteAddr()+"");		//getRemoteAddr():요청을 보낸 클라이언트 또는 마지막 프록시의 인터넷 프로토콜 (IP) 주소를 반환
								//defaultString : str이 null이면 ""를 반환하고 아니면 str을 반환한다
		String uri = StringUtils.defaultString(req.getRequestURI());			//getRequestURI() 메소드는 쿼리문자열을 잘라버리고 출력
		String url = StringUtils.defaultString(req.getRequestURI().toString());	//전체 url 출력
		String queryString = StringUtils.defaultString(req.getQueryString()); // 쿼리스트링 출력
		
		String referer = StringUtils.defaultString(req.getHeader("referer"));  //이전 페이지 URL
		String agent = StringUtils.defaultString(req.getHeader("User-Agent")); //웹 브라우져 확인하기
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n remoteAddr : ")
		  .append(remoteAddr)		//ip v4 로 들가려면 localhost대신에 ip넣으면됨
		  .append("\t uri : ")
		  .append(uri)				// root 부터 요청 end포인트까지
		  .append("| url : ")
		  .append(url)				// location이기때문에 처음부터끝까지
		  .append("| queryString : ")
		  .append(queryString)		// queryString ? 뒤에나오는값
		  .append("\n referer :")
		  .append(referer)			// 이전페이지 url
		  .append("\t agent : ")
		  .append(agent);			// 사용자 브라우저 정보
		
		logger.info("[LOG FILTER]" + sb.toString());
		
		//체인의 다음 필터가 호출되도록하거나 호출 필터가 체인의 마지막 필터 인 경우 체인 끝의 리소스가 호출됩니다.
		chain.doFilter(req, response);		// chain.doFilter를 통해 다음 필터의 doFilter를 호출
	}										//모든 필터가 호출이 된 다음에는 DispatcherServlet이 마지막으로 호출된다

	@Override
	public void destroy() {
		
	}

}
