package com.thang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.DanhGiaDaoImpl;
import com.thang.DaoImpl.TieuChiDaoImpl;
import com.thang.dao.DanhGiaDao;
import com.thang.dao.TieuChiDao;
import com.thang.model.DanhGia;
import com.thang.model.TieuChi;

@WebServlet(urlPatterns = "/kiemdinh/tieuchi/danhgia/delete")
public class DeleteDanhGiaController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_danhgia = Integer.parseInt(req.getParameter("id_danhgia"));
		DanhGiaDao danhgiaDao = new DanhGiaDaoImpl();
		DanhGia danhgia = danhgiaDao.getDanhGia(id_danhgia);
		danhgiaDao.deleteDanhGia(id_danhgia);

		resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchi/danhgia?id_tieuchi="
				+ danhgia.getTieuchi().getId_tieuchi() + "&mess=delete");
	}
}
