package com.thang.controller.client;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.MinhChungDaoImpl;
import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.MinhChungDao;
import com.thang.dao.TaiKhoanDao;
import com.thang.model.MinhChung;

@WebServlet(urlPatterns = "/utt/danhgia/delete")
public class DeleteMinhChungController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_minhchung = Integer.parseInt(req.getParameter("id_minhchung"));
		String url = "E:\\Java\\KiemDinhUTT\\WebContent\\upload\\file";
		MinhChungDao mcDao = new MinhChungDaoImpl();
		MinhChung name = mcDao.getMinhChungId(id_minhchung);
		String namefile = name.getTenfile();
		int id_tieuchi = name.getTieuchi().getId_tieuchi();
		File file = new File(url + File.separator + namefile);
		file.delete();

		mcDao.deleteMinhChung(id_minhchung);
		resp.sendRedirect("/KiemDinhUTT/utt/danhgia/update?id_tieuchi=" + id_tieuchi);
	}
}
