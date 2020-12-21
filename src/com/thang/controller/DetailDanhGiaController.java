package com.thang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.DanhGiaDaoImpl;
import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.DanhGiaDao;
import com.thang.dao.TaiKhoanDao;
import com.thang.model.DanhGia;
import com.thang.model.TaiKhoan;
@WebServlet(urlPatterns = "/kiemdinh/tieuchi/danhgia/detail")
public class DetailDanhGiaController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_danhgia = Integer.parseInt(req.getParameter("id_danhgia"));
		DanhGiaDao danhgiaDao = new DanhGiaDaoImpl();
		DanhGia danhgia=danhgiaDao.getDanhGia(id_danhgia);
		req.setAttribute("danhgia", danhgia);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/detailDanhGia.jsp");
		requestDispatcher.forward(req, resp);
	}
}
