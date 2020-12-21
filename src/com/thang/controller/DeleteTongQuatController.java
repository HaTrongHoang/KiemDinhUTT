package com.thang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.DaoImpl.TongQuatDaoImpl;
import com.thang.dao.PhuLucDao;
import com.thang.dao.TongQuatDao;

@WebServlet(urlPatterns = "/kiemdinh/tongquat/delete")
public class DeleteTongQuatController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tongquat = Integer.parseInt(req.getParameter("id_tongquat"));
		TongQuatDao tongquatDao = new TongQuatDaoImpl();
		tongquatDao.deleteTongQuat(id_tongquat);

		resp.sendRedirect(req.getContextPath() + "/kiemdinh/tongquat?mess=delete");
	}
}
