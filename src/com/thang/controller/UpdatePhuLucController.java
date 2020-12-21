package com.thang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.DaoImpl.TieuChiDaoImpl;
import com.thang.dao.PhuLucDao;
import com.thang.dao.TieuChiDao;
import com.thang.model.PhuLuc;
import com.thang.model.TieuChi;

@WebServlet(urlPatterns = "/kiemdinh/phuluc/update")
public class UpdatePhuLucController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_phuluc = Integer.parseInt(req.getParameter("id_phuluc"));
		PhuLucDao phulucDao = new PhuLucDaoImpl();
		PhuLuc phuluc = phulucDao.getIdPhuLuc(id_phuluc);
		req.setAttribute("phuluc", phuluc);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updatePhuLuc.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_phuluc = Integer.parseInt(req.getParameter("id_phuluc"));
		String tenphuluc = req.getParameter("tenphuluc");
		String tieude_phuluc = req.getParameter("tieude_phuluc");
		String noidung_phuluc = req.getParameter("noidung_phuluc");
		PhuLuc phuluc = new PhuLuc();
		phuluc.setId_phuluc(id_phuluc);
		PhuLucDao phulucDao = new PhuLucDaoImpl();
		PhuLuc gettenphuluc = phulucDao.getIdPhuLuc(id_phuluc);
		if (tenphuluc.equals(gettenphuluc.getTenphuluc())) {
			phuluc.setTenphuluc(tenphuluc);
			phuluc.setTieude_phuluc(tieude_phuluc);
			phuluc.setNoidung_phuluc(noidung_phuluc);
			phulucDao.updatePhuLuc(phuluc);
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/phuluc?mess=update");
		} else {
			if (phulucDao.getTenPhuLuc(tenphuluc) != null) {
				resp.sendRedirect(
						req.getContextPath() + "/kiemdinh/phuluc/update?id_phuluc=" + id_phuluc + "&mess=exist");
			} else {
				phuluc.setTenphuluc(tenphuluc);
				phuluc.setTieude_phuluc(tieude_phuluc);
				phuluc.setNoidung_phuluc(noidung_phuluc);
				phulucDao.updatePhuLuc(phuluc);
				resp.sendRedirect(req.getContextPath() + "/kiemdinh/phuluc?&mess=update");
			}
		}
	}
}
