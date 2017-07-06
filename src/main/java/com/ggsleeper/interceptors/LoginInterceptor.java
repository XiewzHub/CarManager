package com.ggsleeper.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 登录拦截器
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String path=request.getRequestURI();
		Map session = ctx.getSession();
		if (session.get("USER_SESSION") != null ) {
			return invocation.invoke();
		}
		if(path.contains("download")){
			return invocation.invoke();
		}
//		Map<String,Object> paramMap=ctx.getParameters();
//		if(paramMap!=null && paramMap.size()>0){
//			if(paramMap.get("redirect")!=null){
//				HttpServletRequest req=AppUtil.getRequest();
//				String requestURI = req.getRequestURI().substring(
//						req.getRequestURI().indexOf("/", 1),
//						req.getRequestURI().length());
//				paramMap.put("requestURI", requestURI);
//				session.put(Constants.USER_SESSION_REDIRECT, paramMap);
//			}
//		}
		return Action.LOGIN;

	}

}
