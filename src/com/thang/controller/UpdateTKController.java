package com.thang.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.TaiKhoanDao;
import com.thang.model.TaiKhoan;

@WebServlet(urlPatterns = "/kiemdinh/taikhoan/update")
public class UpdateTKController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tk = Integer.parseInt(req.getParameter("id_tk"));
		TaiKhoanDao tkDao = new TaiKhoanDaoImpl();
		TaiKhoan tk = tkDao.getIdTK(id_tk);
		req.setAttribute("tkUpdate", tk);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateTK.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaiKhoan tk = new TaiKhoan();
		TaiKhoanDao tkDao = new TaiKhoanDaoImpl();
		HttpSession sesson = req.getSession();
		int id_tk = Integer.parseInt(req.getParameter("id_tk"));
		tk.setId_tk(id_tk);
		// tao doi tuong luu file
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//// set dia chi luu file
		factory.setRepository(new File("E:\\Java\\KiemDinhUTT\\WebContent\\upload\\user"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		// doc request tu client gui len trong form upload
		try {
			List<FileItem> itemList = servletFileUpload.parseRequest(req);
			Iterator<FileItem> iteml = itemList.iterator();

			while (iteml.hasNext()) {
				FileItem item = iteml.next();
				if (item.getFieldName().equals("hoten")) {
					String hoten = item.getString("UTF-8");
					System.out.println(hoten);
					tk.setHoten(hoten);
				}
//				if (item.getFieldName().equals("taikhoan")) {
//					int id_lop = Integer.parseInt(item.getString("UTF-8"));
//					LopDao lopDao = new LopDaoImpl();
//					Lop lop = lopDao.getLopId(id_lop);
//					sv.setLop(lop);
//				}
				if (item.getFieldName().equals("gioitinh")) {
					String gioitinh = item.getString("UTF-8");
					tk.setGioitinh(gioitinh);
				}
				if (item.getFieldName().equals("diachi")) {
					String diachi = item.getString("UTF-8");
					tk.setDiachi(diachi);
				}
				if (item.getFieldName().equals("sdt")) {
					String sdt = item.getString();
					tk.setSdt(sdt);
				}
				if (item.getFieldName().equals("role")) {
					int role = Integer.parseInt(item.getString("UTF-8"));
					tk.setRole(role);
				}
				if (item.getFieldName().equals("ngaysinh")) {
					String ngaysinh = item.getString();
					tk.setNgaysinh(ngaysinh);
				}
				if (item.getFieldName().equals("img")) {
					if (item.getSize() > 0) {
						final String UPLOAD = "E:\\Java\\KiemDinhUTT\\WebContent\\upload\\user";
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String name = item.getName();
						File UPLOAD_IMG = new File(UPLOAD + File.separator + name);
						if (!UPLOAD_IMG.exists()) {
							item.write(UPLOAD_IMG);
							tk.setImg(name);
						} else {
							tk.setImg(name);
						}
					} else {
						TaiKhoan img = tkDao.getIdTK(id_tk);
						tk.setImg(img.getImg());
					}
				}
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tkDao.updateTK(tk);
		resp.sendRedirect(req.getContextPath() + "/kiemdinh/taikhoan?mess=update");

	}
}
