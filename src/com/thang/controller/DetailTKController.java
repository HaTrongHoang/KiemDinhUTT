package com.thang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.TaiKhoanDao;
import com.thang.model.TaiKhoan;

@WebServlet(urlPatterns = "/kiemdinh/taikhoan/chitiet")
public class DetailTKController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tk = Integer.parseInt(req.getParameter("id_tk"));
		TaiKhoanDao tkDao = new TaiKhoanDaoImpl();
		TaiKhoan tk = tkDao.getIdTK(id_tk);
		req.setAttribute("tkDetail", tk);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/detailTK.jsp");
		requestDispatcher.forward(req, resp);
	}
}
