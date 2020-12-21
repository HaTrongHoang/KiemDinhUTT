package com.thang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.DaoImpl.TongQuatDaoImpl;
import com.thang.dao.PhuLucDao;
import com.thang.dao.TongQuatDao;
import com.thang.model.PhuLuc;
import com.thang.model.TongQuat;

@WebServlet(urlPatterns = "/kiemdinh/tongquat/add")
public class AddTongQuatController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/addTongQuat.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tieude_tongquat = req.getParameter("tieude_tongquat");
		String noidung_tongquat = req.getParameter("noidung_tongquat");
		TongQuat tongquat = new TongQuat();
		TongQuatDao tongquatDao = new TongQuatDaoImpl();
		if (tongquatDao.getTieuDeTongQuat(tieude_tongquat) == null) {
			tongquat.setTieude_tongquat(tieude_tongquat);
			tongquat.setNoidung_tongquat(noidung_tongquat);

			tongquatDao.addTongQuat(tongquat);
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tongquat?mess=success");
		} else {
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tongquat/add?mess=exist");
		}
	}
}
