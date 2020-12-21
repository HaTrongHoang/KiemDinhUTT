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
@WebServlet(urlPatterns = "/kiemdinh/tongquat/detail")
public class DetailTongQuatController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tongquat = Integer.parseInt(req.getParameter("id_tongquat"));
		TongQuatDao tongquatDao = new TongQuatDaoImpl();
		TongQuat tongquat = tongquatDao.getIdTongQuat(id_tongquat);
		req.setAttribute("tongquat", tongquat);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/detailTongQuat.jsp");
		dispatcher.forward(req, resp);
	}
}
