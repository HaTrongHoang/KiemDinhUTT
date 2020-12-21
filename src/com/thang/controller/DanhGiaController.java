package com.thang.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.DanhGiaDaoImpl;
import com.thang.DaoImpl.TieuChiDaoImpl;
import com.thang.dao.DanhGiaDao;
import com.thang.dao.TieuChiDao;
import com.thang.library.Pagination;
import com.thang.model.DanhGia;
import com.thang.model.TieuChi;
@WebServlet(urlPatterns = "/kiemdinh/tieuchi/danhgia")
public class DanhGiaController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchi = Integer.parseInt(req.getParameter("id_tieuchi"));
		req.setAttribute("id_tieuchi", id_tieuchi);
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		DanhGiaDao danhgiaDao = new DanhGiaDaoImpl();

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

		int total = danhgiaDao.totalGetAll(id_tieuchi);
		int totalPage = pagination.totalPage(total, limit);
		req.setAttribute("totalPage", totalPage);
		int offset = pagination.offset(page, limit, totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);
		List<DanhGia> danhgia = danhgiaDao.getAll(id_tieuchi, limit, offset);
		req.setAttribute("danhgiaList", danhgia);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/danhgia.jsp");
		requestDispatcher.forward(req, resp);
	}
}
