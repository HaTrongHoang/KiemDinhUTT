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
import com.thang.library.Pagination;
import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;

@WebServlet(urlPatterns = "/kiemdinh/tieuchi")
public class TieuChiController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		int id_tieuchuan = Integer.parseInt(req.getParameter("id_tieuchuan"));
		req.setAttribute("id_tieuchuan", id_tieuchuan);
		int page;
		int limit = 10;
		TieuChiDao tieuChiDao = new TieuChiDaoImpl();

		if (pageParam != null) {
			if (pageParam == "") {
				page = 1;
			} else {
				page = Integer.parseInt(pageParam);
			}

		} else {
			page = 1;

		}
		req.setAttribute("page", page);
		Pagination pagination = new Pagination();

		int totalTieuChuan = tieuChiDao.totalTieuChi(id_tieuchuan);
		int totalPage = pagination.totalPage(totalTieuChuan, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<TieuChi> tieuChi = tieuChiDao.getAll(id_tieuchuan, limit, offset);
		req.setAttribute("tieuChiList", tieuChi);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/tieuchi.jsp");
		requestDispatcher.forward(req, resp);
	}
}
