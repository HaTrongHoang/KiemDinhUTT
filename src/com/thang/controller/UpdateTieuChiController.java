package com.thang.controller;

import java.io.IOException;

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

@WebServlet(urlPatterns = "/kiemdinh/tieuchi/update")
public class UpdateTieuChiController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchi = Integer.parseInt(req.getParameter("id_tieuchi"));
		TieuChiDao tieuChiDao = new TieuChiDaoImpl();
		TieuChi tiauChiId = tieuChiDao.getTieuChiById(id_tieuchi);
		req.setAttribute("tieuchi", tiauChiId);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateTieuChi.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tentieuchi = req.getParameter("tentieuchi");
		String noidung_tieuchi = req.getParameter("noidung_tieuchi");
		int id_tieuchi = Integer.parseInt(req.getParameter("id_tieuchi"));
		TieuChiDao tieuChiDao = new TieuChiDaoImpl();
		TieuChi tieuchiId = tieuChiDao.getTieuChiById(id_tieuchi);
		TieuChi tieuchi = new TieuChi();
		if (tentieuchi.equals(tieuchiId.getTentieuchi())) {
			tieuchi.setTentieuchi(tentieuchi);
			tieuchi.setId_tieuchi(id_tieuchi);
			tieuchi.setNoidung_tieuchi(noidung_tieuchi);
			tieuChiDao.updateTieuChi(tieuchi);
			TieuChi id_tieuchuan = tieuChiDao.getTieuChiById(id_tieuchi);
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchi?id_tieuchuan="
					+ id_tieuchuan.getTieuchuan().getId_tieuchuan() + "&mess=update");
		} else {
			if (tieuChiDao.getTenTieuChi(tentieuchi) != null) {
				resp.sendRedirect(
						req.getContextPath() + "/kiemdinh/tieuchi/update?id_tieuchi=" + id_tieuchi + "&mess=exist");
			} else {
				tieuchi.setTentieuchi(tentieuchi);
				tieuchi.setId_tieuchi(id_tieuchi);
				tieuchi.setNoidung_tieuchi(noidung_tieuchi);
				tieuChiDao.updateTieuChi(tieuchi);
				TieuChi id_tieuchuan = tieuChiDao.getTieuChiById(id_tieuchi);
				resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchi?id_tieuchuan="
						+ id_tieuchuan.getTieuchuan().getId_tieuchuan() + "&mess=update");
			}
		}

	}

}
