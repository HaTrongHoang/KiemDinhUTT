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
import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.PhuLucDao;
import com.thang.dao.TaiKhoanDao;
import com.thang.library.Pagination;
import com.thang.model.PhuLuc;
import com.thang.model.TaiKhoan;
@WebServlet(urlPatterns = "/kiemdinh/phuluc")
public class PhuLucController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		PhuLucDao phulucDao = new PhuLucDaoImpl();

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

		int total = phulucDao.totalPhuLuc();
		int totalPage = pagination.totalPage(total, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<PhuLuc> phuluc = phulucDao.getAll(limit, offset);
		req.setAttribute("phuluc", phuluc);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/phuluc.jsp");
		dispatcher.forward(req, resp);
	}
}
