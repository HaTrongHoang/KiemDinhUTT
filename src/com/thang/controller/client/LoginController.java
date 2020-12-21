package com.thang.controller.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.TaiKhoanDao;
import com.thang.library.MD5Encoder;
import com.thang.model.TaiKhoan;
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MD5Encoder md5 = new MD5Encoder();
		String taikhoan = req.getParameter("taikhoan");
		String matkhau = req.getParameter("matkhau");
		System.out.println(matkhau);
		try {
			String password = md5.md5Encoder(matkhau);
			System.out.println(password);
			TaiKhoanDao tkDao = new TaiKhoanDaoImpl();
			TaiKhoan tk = tkDao.getTK(taikhoan);

			HttpSession session = req.getSession();
			if (tk != null) {
				if (tk.getTaikhoan().equals(taikhoan) && tk.getMatkhau().equals(password)) {
					session.setAttribute("loginClient", tk);
					resp.sendRedirect(req.getContextPath() + "/utt/home");
				} else {
					resp.sendRedirect(req.getContextPath() + "/login");
				}

			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
