package com.thang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TongQuatDaoImpl;
import com.thang.dao.TongQuatDao;
import com.thang.library.Pagination;
import com.thang.model.TongQuat;
@WebServlet(urlPatterns = "/kiemdinh/tongquat")
public class TongQuatController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

		int total = tongquatDao.totalTongQuat();
		int totalPage = Pagination.totalPage(total, limit);
		int offset = Pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = Pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<TongQuat> tongquat = tongquatDao.getAll(limit, offset);
		req.setAttribute("tongquat", tongquat);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/tongquat.jsp");
		dispatcher.forward(req, resp);
	}
}
