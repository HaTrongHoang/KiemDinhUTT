package com.thang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.DaoImpl.TongQuatDaoImpl;
import com.thang.dao.PhuLucDao;
import com.thang.dao.TongQuatDao;
import com.thang.library.Pagination;
import com.thang.model.PhuLuc;
import com.thang.model.TongQuat;
@WebServlet(urlPatterns = "/kiemdinh/tongquat/search")
public class SearchTongQuatController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		req.setAttribute("key", key);
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		TongQuatDao tongquatDao = new TongQuatDaoImpl();

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

		int total = tongquatDao.totalSearch(key);
		int totalPage = pagination.totalPage(total, limit);
		req.setAttribute("totalPage", totalPage);
		int offset = pagination.offset(page, limit, totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);
		List<TongQuat> tongquat = tongquatDao.searchTongQuat(key, limit, offset);
		req.setAttribute("tongquatListSearch", tongquat);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/searchTongQuat.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		if (key == "") {
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/tongquat");
		} else {
			doGet(req, resp);
		}
	}
}
