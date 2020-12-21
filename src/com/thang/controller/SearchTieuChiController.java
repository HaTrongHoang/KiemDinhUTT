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
import com.thang.dao.TieuChiDao;
import com.thang.library.Pagination;
import com.thang.model.TieuChi;
@WebServlet(urlPatterns = "/kiemdinh/tieuchi/search")
public class SearchTieuChiController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		int id_tieuchuan = Integer.parseInt(req.getParameter("id_tieuchuan"));
		req.setAttribute("key", key);
		req.setAttribute("id_tieuchuan", id_tieuchuan);
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		TieuChiDao tieuchiDao = new TieuChiDaoImpl();

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

		int total = tieuchiDao.totalSearch(key, id_tieuchuan);
		int totalPage = pagination.totalPage(total, limit);
		req.setAttribute("totalPage", totalPage);
		int offset = pagination.offset(page, limit, totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);
		List<TieuChi> tieuchi = tieuchiDao.searchTieuChi(key, id_tieuchuan, limit, offset);
		req.setAttribute("tieuchiListSearch", tieuchi);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/searchTieuChi.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("key") == "") {
			int id_tieuchuan = Integer.parseInt(req.getParameter("id_tieuchuan"));
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tieuchi?id_tieuchuan="+id_tieuchuan);
		} else {
			doGet(req, resp);
		}
	}
}
