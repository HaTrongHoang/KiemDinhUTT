package com.thang.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.TaiKhoanDao;
import com.thang.library.Pagination;
import com.thang.model.TaiKhoan;

@WebServlet(urlPatterns = "/kiemdinh/taikhoan/search")
public class SearchTKController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		req.setAttribute("key", key);
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		TaiKhoanDao tkDao = new TaiKhoanDaoImpl();

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

		int total = tkDao.totalSearch(key);
		int totalPage = pagination.totalPage(total, limit);
		req.setAttribute("totalPage", totalPage);
		int offset = pagination.offset(page, limit, totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);
		List<TaiKhoan> sv = tkDao.searchTK(key, limit, offset);
		req.setAttribute("tkListSearch", sv);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/searchTK.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		if (key == "") {
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/taikhoan");
		} else {
//			resp.sendRedirect(req.getContextPath() + "/kiemdinh/taikhoan/search?key=" + URLEncoder.encode(key, "UTF-8"));
			doGet(req, resp);
		}
	}

}
