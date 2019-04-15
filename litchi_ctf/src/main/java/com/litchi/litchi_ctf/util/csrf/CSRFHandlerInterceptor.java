/**
 * 
 */
package com.litchi.litchi_ctf.util.csrf;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Request预处理器，先过滤csrf然后才允许访问对应controller
 *
 * @author Jarvis
 * @date 2016年4月7日
 */
@Component
public class CSRFHandlerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (!request.getMethod().equalsIgnoreCase("POST")) {
			return true;
		} else {
			if (request.getServletPath().equals("/admin/fileUpload")){
				return true;
			}
			HttpSession session = request.getSession();
			String sessionToken = CSRFTokenManager.getCurrentSessionToken(session);
			if (sessionToken==null) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF Token Expired!!");
				return false;
			}
			String requestToken = CSRFTokenManager.getTokenFromRequest(request);
			CSRFTokenManager.createNewTokenForSession(request.getSession());
			if (requestToken!=null && sessionToken.equals(requestToken)) {
				return true;
			} else {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "Bad or missing CSRF value !!");
				return false;
			}
		}
		//return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
