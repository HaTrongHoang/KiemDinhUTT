package com.thang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TieuChuanDaoImpl;
import com.thang.dao.TieuChuanDao;
import com.thang.library.Pagination;
import com.thang.model.TieuChuan;

@WebServlet(urlPatterns = "/kiemdinh/tieuchuan")
public class TieuChuanController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		TieuChuanDao tieuChuanDao = new TieuChuanDaoImpl();

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

		int totalTieuChuan = tieuChuanDao.totalTieuChuan();
		int totalPage = pagination.totalPage(totalTieuChuan, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<TieuChuan> tieuChuan = tieuChuanDao.getAll(limit, offset);
		req.setAttribute("tieuChuanList", tieuChuan);
		tieuChuan.size();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/tieuchuan.jsp");
		requestDispatcher.forward(req, resp);
	}
}
