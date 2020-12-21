package com.thang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TieuChuanDaoImpl;
import com.thang.dao.TieuChuanDao;
import com.thang.model.TieuChuan;

@WebServlet(urlPatterns = "/kiemdinh/tieuchuan/update")
public class UpdateTieuChuanController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchuan = Integer.parseInt(req.getParameter("id_tieuchuan"));
		TieuChuanDao tieuChuanDao = new TieuChuanDaoImpl();
		TieuChuan tiauChuanId = tieuChuanDao.getTieuChuanById(id_tieuchuan);
		req.setAttribute("tieuchuan", tiauChuanId);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateTieuChuan.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tentieuchuan = req.getParameter("tentieuchuan");
		String noidung_tieuchuan=req.getParameter("noidung_tieuchuan");
		int id_tieuchuan = Integer.parseInt(req.getParameter("id_tieuchuan"));
		TieuChuanDao tieuChuanDao = new TieuChuanDaoImpl();
		if (tieuChuanDao.getTenTieuChuan(tentieuchuan) != null) {
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchuan/update?id_tieuchuan="+id_tieuchuan+"&mess=exist");
		} else {
			TieuChuan tieuchuan = new TieuChuan();
			tieuchuan.setTentieuchuan(tentieuchuan);
			tieuchuan.setId_tieuchuan(id_tieuchuan);
			tieuchuan.setNoidung_tieuchuan(noidung_tieuchuan);
			tieuChuanDao.updateTieuChuan(tieuchuan);
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchuan?mess=update");
		}
	}
}
