/**
 * 
 */
package com.litchi.litchi_ctf.util.csrf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * CSRF Token管理
 *
 */
final class CSRFTokenManager {
	/**
	 * The token parameter name
	 */
	static final String CSRF_PARAM_NAME = "litchi_csrf_token";

	/**
	 * The location on the session which stores the token
	 */
	private final static String CSRF_TOKEN_FOR_SESSION_ATTR_NAME = CSRFTokenManager.class.getName() + ".tokenval";

	static String createNewTokenForSession(HttpSession session) {
		String token = null;
		// I cannot allow more than one token on a session - in the case of two requests trying to
		// init the token concurrently
		synchronized (session) {
			token = (String) session.getAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME);
			if (null==token) {
			token=UUID.randomUUID().toString();
			session.setAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME, token);
			}
		}
		return token;
	}

	/**
	 * Extracts the token value from the session
	 * @param request
	 * @return
	 */
	static String getTokenFromRequest(HttpServletRequest request) {
		return request.getParameter(CSRF_PARAM_NAME);
	}
	
	static String getCurrentSessionToken(HttpSession session) {
		return (String) session.getAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME);
	}

	private CSRFTokenManager() {};
}
