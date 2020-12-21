package com.thang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TieuChuanDaoImpl;
import com.thang.dao.TieuChuanDao;

@WebServlet(urlPatterns = "/kiemdinh/tieuchuan/delete")
public class DeleteTieuChuanController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchuan = Integer.parseInt(req.getParameter("id_tieuchuan"));
		TieuChuanDao tieuChuanDao = new TieuChuanDaoImpl();
		tieuChuanDao.deleteTieuChuan(id_tieuchuan);
		resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchuan?mess=delete");
	}
}
