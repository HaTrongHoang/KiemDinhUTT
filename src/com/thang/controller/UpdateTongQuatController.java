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

@WebServlet(urlPatterns = "/kiemdinh/tongquat/update")
public class UpdateTongQuatController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tongquat = Integer.parseInt(req.getParameter("id_tongquat"));
		TongQuatDao tongquatDao = new TongQuatDaoImpl();
		TongQuat tongquat = tongquatDao.getIdTongQuat(id_tongquat);
		req.setAttribute("tongquat", tongquat);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateTongQuat.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tongquat = Integer.parseInt(req.getParameter("id_tongquat"));
		String tieude_tongquat = req.getParameter("tieude_tongquat");
		String noidung_tongquat = req.getParameter("noidung_tongquat");
		TongQuat tongquat = new TongQuat();
		tongquat.setId_tongquat(id_tongquat);
		TongQuatDao tongquatDao = new TongQuatDaoImpl();
		TongQuat gettieude = tongquatDao.getIdTongQuat(id_tongquat);
		if (tieude_tongquat.equals(gettieude.getTieude_tongquat())) {
			tongquat.setTieude_tongquat(tieude_tongquat);
			tongquat.setNoidung_tongquat(noidung_tongquat);
			tongquatDao.updateTongQuat(tongquat);
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tongquat?mess=update");
		} else {
			if (tongquatDao.getTieuDeTongQuat(tieude_tongquat) != null) {
				resp.sendRedirect(
						req.getContextPath() + "/kiemdinh/tongquat/update?id_tongquat=" + id_tongquat + "&mess=exist");
			} else {
				tongquat.setTieude_tongquat(tieude_tongquat);
				tongquat.setNoidung_tongquat(noidung_tongquat);
				tongquatDao.updateTongQuat(tongquat);
				resp.sendRedirect(req.getContextPath() + "/kiemdinh/tongquat?&mess=update");
			}
		}
	}
}
