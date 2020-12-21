package com.thang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.TaiKhoanDao;

@WebServlet(urlPatterns = "/kiemdinh/taikhoan/delete")
public class DeleteTKController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tk = Integer.parseInt(req.getParameter("id_tk"));
		TaiKhoanDao tkDao = new TaiKhoanDaoImpl();
		tkDao.deleteTK(id_tk);
		System.out.println("xoa user id:" + id_tk);
		resp.sendRedirect(req.getContextPath() + "/kiemdinh/taikhoan?mess=delete");
	}
}
