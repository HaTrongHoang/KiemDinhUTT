package com.thang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.DanhGiaDaoImpl;
import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.dao.DanhGiaDao;
import com.thang.dao.PhuLucDao;
import com.thang.model.DanhGia;
@WebServlet(urlPatterns = "/kiemdinh/phuluc/delete")
public class DeletePhuLucController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_phuluc = Integer.parseInt(req.getParameter("id_phuluc"));
		PhuLucDao phulucDao = new PhuLucDaoImpl();
		phulucDao.deletePhuLuc(id_phuluc);

		resp.sendRedirect(req.getContextPath() + "/kiemdinh/phuluc?mess=delete");
	}
}
