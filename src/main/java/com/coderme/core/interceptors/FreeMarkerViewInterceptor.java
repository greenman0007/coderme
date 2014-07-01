package com.coderme.core.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.coderme.core.annotation.Permission;

public class FreeMarkerViewInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//处理Permission Annotation，实现方法级权限控制  
        HandlerMethod method = (HandlerMethod)handler;  
        Permission permission = method.getMethodAnnotation(Permission.class);  
          
        //如果为空在表示该方法不需要进行权限验证  
        if (permission == null) {  
            return true;  
        }  
          
//        //验证是否具有权限  
//        if (!WebUtil.hasPower(request, permission.value())) {  
//            response.sendRedirect(request.getContextPath()+"/business/nopermission.html");  
//            return false;  
//        }  
        return true;  
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String contextPath = request.getContextPath();  
        if (modelAndView != null) {  
            request.setAttribute("base", contextPath);  
        }  
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
