package com.thang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.DaoImpl.TieuChiDaoImpl;
import com.thang.DaoImpl.TieuChuanDaoImpl;
import com.thang.DaoImpl.TongQuatDaoImpl;
import com.thang.dao.PhuLucDao;
import com.thang.dao.TieuChiDao;
import com.thang.dao.TieuChuanDao;
import com.thang.dao.TongQuatDao;
import com.thang.model.PhuLuc;
import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;
import com.thang.model.TongQuat;

@WebServlet(urlPatterns = "/utt/home")
public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TieuChuanDao tieuChuanDao = new TieuChuanDaoImpl();
		List<TieuChuan> tieuChuan = tieuChuanDao.getAll();
		req.setAttribute("tieuChuan", tieuChuan);
		TieuChiDao tieuChiDao = new TieuChiDaoImpl();
		List<TieuChi> tieuchi = tieuChiDao.getAll();
		req.setAttribute("tieuChi", tieuchi);
		
		
		PhuLucDao phulucDao =new PhuLucDaoImpl();
		List<PhuLuc> phulucList=phulucDao.getAll();
		req.setAttribute("phulucList", phulucList);
		
		TongQuatDao tongquatDao = new TongQuatDaoImpl();
		List<TongQuat> tongquatList = tongquatDao.getAll();
		req.setAttribute("tongquatList", tongquatList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/home.jsp");
		dispatcher.forward(req, resp);
	}
}
