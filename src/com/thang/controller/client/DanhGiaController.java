package com.thang.controller.client;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

@WebServlet(urlPatterns = "/utt/danhgia/update")
public class DanhGiaController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchi = Integer.parseInt(req.getParameter("id_tieuchi"));
		TieuChiDao tieuChiDao = new TieuChiDaoImpl();
		TieuChi tieuchi = tieuChiDao.getTieuChiById(id_tieuchi);
		req.setAttribute("tieuchi", tieuchi);

		HttpSession session = req.getSession();
		TaiKhoan user = (TaiKhoan) session.getAttribute("loginClient");

		DanhGiaDao danhGiaDao = new DanhGiaDaoImpl();
		DanhGia danhgia = danhGiaDao.getDanhGia(id_tieuchi, user.getId_tk());
		req.setAttribute("danhgia", danhgia);

		MinhChungDao minhchungDao = new MinhChungDaoImpl();
		List<MinhChung> mcList = minhchungDao.getList(id_tieuchi, user.getId_tk());
		req.setAttribute("mcList", mcList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/updateDanhGia.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tieuchi = Integer.parseInt(req.getParameter("id_tieuchi"));
		MinhChungDao minhchungDao = new MinhChungDaoImpl();
		DanhGia danhGia = new DanhGia();
		// lay ng dung
		HttpSession session = req.getSession();
		TaiKhoan user = (TaiKhoan) session.getAttribute("loginClient");

		// lay thoi gian hien tai
		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String thoigian = dateformat.format(date);

		// lay tieu chi
		TieuChiDao tieuChiDao = new TieuChiDaoImpl();
		TieuChi tieuchi = tieuChiDao.getTieuChiById(id_tieuchi);

		danhGia.setTieuchi(tieuchi);
		danhGia.setUser(user);
		danhGia.setThoigian(thoigian);
		// tao doi tuong luu file
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//// set dia chi luu file
		factory.setRepository(new File("E:\\Java\\KiemDinhUTT\\WebContent\\upload\\file"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		// doc request tu client gui len trong form upload

		try {
			List<FileItem> itemList = servletFileUpload.parseRequest(req);
			Iterator<FileItem> iteml = itemList.iterator();

			while (iteml.hasNext()) {
				FileItem item = iteml.next();
				if (item.getFieldName().equals("mota")) {
					String mota = item.getString("UTF-8");
					danhGia.setMota(mota);
				}
				if (item.getFieldName().equals("diemmanh")) {
					String diemmanh = item.getString("UTF-8");
					danhGia.setDiemmanh(diemmanh);

				}
				if (item.getFieldName().equals("diemtontai")) {
					String diemtontai = item.getString("UTF-8");
					danhGia.setDiemtontai(diemtontai);
				}
				if (item.getFieldName().equals("kehoach")) {
					String kehoach = item.getString("UTF-8");
					danhGia.setKehoach(kehoach);
				}
				if (item.getFieldName().equals("tudanhgia")) {
					String tudanhgia = item.getString("UTF-8");
					danhGia.setTudanhgia(tudanhgia);
				}
				if (item.getFieldName().equals("file[]")) {

					if (item.getSize() > 0) {
						final String UPLOAD = "E:\\Java\\KiemDinhUTT\\WebContent\\upload\\file";
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String file_name = item.getName().toString();
						MinhChung minhchung = new MinhChung();
						minhchung.setTenfile(file_name);
						minhchung.setTieuchi(tieuchi);
						minhchung.setUser(user);
						minhchungDao.addMinhChung(minhchung);
						File UPLOAD_FILE = new File(UPLOAD + File.separator + file_name);
						if (!UPLOAD_FILE.exists()) {
							item.write(UPLOAD_FILE);
						}
					}
				}
			}

			DanhGiaDao danhGiaDao = new DanhGiaDaoImpl();
			if (danhGiaDao.getDanhGia(id_tieuchi, user.getId_tk()) == null) {
				danhGiaDao.addDanhGia(danhGia);
			} else {
				DanhGia getIdDanhGia = danhGiaDao.getDanhGia(id_tieuchi, user.getId_tk());
				danhGia.setId_danhgia(getIdDanhGia.getId_danhgia());
				danhGiaDao.updateDanhGia(danhGia);
			}
			resp.sendRedirect(req.getContextPath() + "/utt/home");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
