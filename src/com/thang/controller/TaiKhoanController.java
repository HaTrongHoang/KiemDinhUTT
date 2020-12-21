package com.thang.controller;

import java.io.IOException;
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
@WebServlet(urlPatterns = "/kiemdinh/taikhoan")
public class TaiKhoanController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

		int totalTK = tkDao.totalTaiKhoan();
		int totalPage = pagination.totalPage(totalTK, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<TaiKhoan> tk = tkDao.getAll(limit, offset);
		req.setAttribute("tkList", tk);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/taikhoan.jsp");
		dispatcher.forward(req, resp);
	}
}
