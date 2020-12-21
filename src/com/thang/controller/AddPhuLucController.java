package com.thang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.dao.PhuLucDao;
import com.thang.model.PhuLuc;

@WebServlet(urlPatterns = "/kiemdinh/phuluc/add")
public class AddPhuLucController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/addPhuLuc.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenphuluc = req.getParameter("tenphuluc");
		String tieude_phuluc = req.getParameter("tieude_phuluc");
		String noidung_phuluc = req.getParameter("noidung_phuluc");
		PhuLuc phuluc = new PhuLuc();

		PhuLucDao phulucDao = new PhuLucDaoImpl();
		if (phulucDao.getTenPhuLuc(tenphuluc) == null) {
			phuluc.setTenphuluc(tenphuluc);
			phuluc.setTieude_phuluc(tieude_phuluc);
			phuluc.setNoidung_phuluc(noidung_phuluc);
			phulucDao.addPhuLuc(phuluc);
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/phuluc?mess=success");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/phuluc/add?mess=exist");
		}
	}
}
