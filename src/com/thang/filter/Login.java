package com.thang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.model.TaiKhoan;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter("/kiemdinh/*")
public class Login implements Filter {

	/**
	 * Default constructor.
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		TaiKhoan tk = (TaiKhoan) session.getAttribute("loginTaiKhoan");
		if (tk != null) {
			if (tk.getRole() == 0) {
				req.setAttribute("disabledAdmin", "disabled");
				chain.doFilter(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/login-admin");
			}

		} else {
			resp.sendRedirect(req.getContextPath() + "/login-admin");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
