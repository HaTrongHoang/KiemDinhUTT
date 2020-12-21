package com.thang.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TieuChiDaoImpl;
import com.thang.dao.TieuChiDao;
import com.thang.model.TieuChi;
@WebServlet(urlPatterns = "/utt/tieuchi")
public class TieuChiController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchi=Integer.parseInt(req.getParameter("id_tieuchi"));
		TieuChiDao tieuChiDao=new TieuChiDaoImpl();
		TieuChi tieuchi=tieuChiDao.getTieuChiById(id_tieuchi);
		req.setAttribute("tieuchi", tieuchi);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/chitietTieuChi.jsp");
		dispatcher.forward(req, resp);
	}
}
