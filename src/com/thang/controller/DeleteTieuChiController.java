package com.thang.controller;

import java.io.IOException;

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
@WebServlet(urlPatterns ="/kiemdinh/tieuchi/delete" )
public class DeleteTieuChiController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchi = Integer.parseInt(req.getParameter("id_tieuchi"));
		TieuChiDao tieuChiDao = new TieuChiDaoImpl();
		TieuChi tieuchuanId=tieuChiDao.getTieuChiById(id_tieuchi);
		tieuChiDao.deleteTieuChi(id_tieuchi);
		resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchi?id_tieuchuan="+tieuchuanId.getTieuchuan().getId_tieuchuan()+"&mess=delete");
	}
}
