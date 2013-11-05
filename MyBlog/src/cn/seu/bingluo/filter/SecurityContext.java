package cn.seu.bingluo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.seu.bingluo.entity.User;

public class SecurityContext {
	private HttpServletRequest httpRequest;
	private HttpSession httpSession;
	private HttpServletResponse httpResponse;
	private User user;

	/**
	 * @return the httpRequest
	 */
	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

	/**
	 * @param httpRequest
	 *            the httpRequest to set
	 */
	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

	/**
	 * @return the httpServletResponse
	 */
	public HttpServletResponse getHttpResponse() {
		return httpResponse;
	}

	/**
	 * @param httpServletResponse
	 *            the httpServletResponse to set
	 */
	public void setHttpResponse(HttpServletResponse httpResponse) {
		this.httpResponse = httpResponse;
	}

	/**
	 * @return the httpSession
	 */
	public HttpSession getHttpSession() {
		return httpSession;
	}

	/**
	 * @param httpSession
	 *            the httpSession to set
	 */
	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		if (httpSession != null && user != null) {
			httpSession.setAttribute("userId", user.getUserId());
		}
		this.user = user;
	}
}
