package com.thang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TieuChiDaoImpl;
import com.thang.DaoImpl.TieuChuanDaoImpl;
import com.thang.dao.TieuChiDao;
import com.thang.dao.TieuChuanDao;
import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;

@WebServlet(urlPatterns = "/kiemdinh/tieuchi/add")
public class AddTieuChiController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchuan = Integer.parseInt(req.getParameter("id_tieuchuan"));
		req.setAttribute("id_tieuchuan", id_tieuchuan);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/addTieuChi.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchuan = Integer.parseInt(req.getParameter("id_tieuchuan"));
		String tentieuchi = req.getParameter("tentieuchi");
		String noidung_tieuchi = req.getParameter("noidung_tieuchi");
		TieuChi tieuchi = new TieuChi();
		tieuchi.setTentieuchi(tentieuchi);
		tieuchi.setNoidung_tieuchi(noidung_tieuchi);

		TieuChuanDao tieuChuanDao = new TieuChuanDaoImpl();
		TieuChuan tieuchuan = tieuChuanDao.getTieuChuanById(id_tieuchuan);
		tieuchi.setTieuchuan(tieuchuan);
		TieuChiDao tieuChiDao = new TieuChiDaoImpl();
		if (tieuChiDao.getTenTieuChi(tentieuchi) != null) {
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchi/add?mess=exist");
		} else {
			tieuChiDao.addTieuChi(tieuchi);
			resp.sendRedirect(
					req.getContextPath() + "/kiemdinh/tieuchi?id_tieuchuan=" + id_tieuchuan + "&mess=addsuccess");
		}
	}
}
