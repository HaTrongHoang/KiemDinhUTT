package com.thang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.DaoImpl.DanhGiaDaoImpl;
import com.thang.DaoImpl.MinhChungDaoImpl;
import com.thang.DaoImpl.TieuChiDaoImpl;
import com.thang.dao.DanhGiaDao;
import com.thang.dao.MinhChungDao;
import com.thang.dao.TieuChiDao;
import com.thang.model.DanhGia;
import com.thang.model.MinhChung;
import com.thang.model.TaiKhoan;
import com.thang.model.TieuChi;
@WebServlet(urlPatterns = "/utt/danhgia")
public class GetDanhGiaController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchi=Integer.parseInt(req.getParameter("id_tieuchi"));
		HttpSession session=req.getSession();
		TaiKhoan user=(TaiKhoan) session.getAttribute("loginClient");
		
		TieuChiDao tieuchiDao=new TieuChiDaoImpl();
		TieuChi tieuchi=tieuchiDao.getTieuChiById(id_tieuchi);
		req.setAttribute("tieuchi", tieuchi);
		DanhGiaDao danhGiaDao=new DanhGiaDaoImpl();
		DanhGia danhgia=danhGiaDao.getDanhGia(id_tieuchi, user.getId_tk());
		req.setAttribute("danhgia", danhgia);
		
		MinhChungDao minhchungDao=new MinhChungDaoImpl();
		List<MinhChung> mcList=minhchungDao.getList(id_tieuchi, user.getId_tk());
		req.setAttribute("mcList", mcList);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/danhgia.jsp");
		dispatcher.forward(req, resp);
	}
}
