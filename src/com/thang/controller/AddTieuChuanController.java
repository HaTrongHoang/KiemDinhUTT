package com.thang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.DaoImpl.TieuChuanDaoImpl;
import com.thang.dao.TieuChuanDao;
import com.thang.model.TieuChuan;
@WebServlet(urlPatterns = "/kiemdinh/tieuchuan/add")
public class AddTieuChuanController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/addTieuChuan.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tentieuchuan = req.getParameter("tentieuchuan");
		String noidung_tieuchuan=req.getParameter("noidung_tieuchuan");
		System.out.println(tentieuchuan);
		TieuChuan tieuchuan = new TieuChuan();
		tieuchuan.setTentieuchuan(tentieuchuan);
		tieuchuan.setNoidung_tieuchuan(noidung_tieuchuan);

		TieuChuanDao tieuChuanDao = new TieuChuanDaoImpl();
		if (tieuChuanDao.getTenTieuChuan(tentieuchuan) != null) {
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchuan/add?mess=exist");
		} else {
			tieuChuanDao.addTieuChuan(tieuchuan);
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchuan?mess=addsuccess");
		}
	}
}
