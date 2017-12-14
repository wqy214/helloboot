package cn.hello.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 基础控制器

 */
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	protected HttpSession session;

	@Autowired
	protected ServletContext application;

	/**
	 * 重定向至地址 url
	 * 
	 * @param url
	 *            请求地址
	 * @return
	 */
	protected String redirectTo( String url ) {
		StringBuffer rto = new StringBuffer("redirect:");
		rto.append(url);
		return rto.toString();
	}



}
