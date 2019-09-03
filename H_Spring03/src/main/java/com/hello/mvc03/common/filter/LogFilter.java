package com.hello.mvc03.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = StringUtils.defaultString(req.getRemoteAddr()+"");
		
		String uri = StringUtils.defaultString(req.getRequestURI());
		String url = StringUtils.defaultString(req.getRequestURL().toString());
		String queryString = StringUtils.defaultString(req.getQueryString());
		
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
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
		
	}

}
