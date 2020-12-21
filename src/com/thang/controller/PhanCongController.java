package com.thang.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.PhanCongDaoImpl;
import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.DaoImpl.TieuChuanDaoImpl;
import com.thang.dao.PhanCongDao;
import com.thang.dao.PhuLucDao;
import com.thang.dao.TaiKhoanDao;
import com.thang.dao.TieuChuanDao;
import com.thang.library.Pagination;
import com.thang.model.PhanCong;
import com.thang.model.PhuLuc;
import com.thang.model.TaiKhoan;
import com.thang.model.TieuChuan;

@WebServlet(urlPatterns = "/kiemdinh/phancong")
public class PhanCongController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		PhanCongDao phancongDao = new PhanCongDaoImpl();

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

		int total = phancongDao.totalPhanCong();
		int totalPage = pagination.totalPage(total, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<PhanCong> phancongList = phancongDao.getAll(limit, offset);
		req.setAttribute("phancong", phancongList);

		TaiKhoanDao taikhoanDao = new TaiKhoanDaoImpl();
		List<TaiKhoan> taikhoan = taikhoanDao.getAll();
		req.setAttribute("taikhoan", taikhoan);

		List<PhanCong> phancongListAll = phancongDao.getAll();
		TieuChuanDao tieuchuanDao = new TieuChuanDaoImpl();
		List<TieuChuan> tieuChuanList = tieuchuanDao.getAll();
		List<TieuChuan> tieuchuan = new ArrayList<TieuChuan>();
		for (int i = 0; i < tieuChuanList.size(); i++) {
			TieuChuan tieuChuan = tieuChuanList.get(i);
			for (int j = 0; j < phancongListAll.size(); j++) {
				PhanCong phancong = phancongListAll.get(j);
				if (phancong.getTieuchuan().getId_tieuchuan() == tieuChuan.getId_tieuchuan()) {
					tieuChuanList.remove(i);

				}
			}

		}
		for (TieuChuan tieuChuan2 : tieuChuanList) {
			tieuchuan.add(tieuChuan2);
		}
		req.setAttribute("tieuChuanList", tieuchuan);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/phancong.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_taikhoan = Integer.parseInt(req.getParameter("taikhoan"));
		int id_tieuchuan = Integer.parseInt(req.getParameter("tieuchuan"));

		PhanCong phancong = new PhanCong();

		TaiKhoanDao taikhoanDao = new TaiKhoanDaoImpl();
		TaiKhoan taikhoan = taikhoanDao.getIdTK(id_taikhoan);
		phancong.setTaikhoan(taikhoan);

		TieuChuanDao tieuchuanDao = new TieuChuanDaoImpl();
		TieuChuan tieuchuan = tieuchuanDao.getTieuChuanById(id_tieuchuan);
		phancong.setTieuchuan(tieuchuan);
		PhanCongDao phancongDao = new PhanCongDaoImpl();

		if (phancongDao.getTieuChuan(id_tieuchuan) == null) {
			phancongDao.addPhanCong(phancong);
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/phancong?mess=success");
		} else {
			resp.sendRedirect(req.getContextPath() + "/kiemdinh/phancong?mess=erorr");
		}

	}
}
