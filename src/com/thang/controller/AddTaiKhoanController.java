package com.thang.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.thang.DaoImpl.TaiKhoanDaoImpl;
import com.thang.dao.TaiKhoanDao;
import com.thang.library.MD5Encoder;
import com.thang.model.TaiKhoan;

@WebServlet(urlPatterns = "/kiemdinh/taikhoan/add")
public class AddTaiKhoanController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/addTaiKhoan.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaiKhoan tk = new TaiKhoan();
		TaiKhoanDao userDao = new TaiKhoanDaoImpl();
		HttpSession sesson = req.getSession();

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
				if (item.getFieldName().equals("taikhoan")) {
					String taikhoan = item.getString();
					TaiKhoan tkList = userDao.getSearchTK(taikhoan);
					if (tkList == null) {
						tk.setTaikhoan(taikhoan);
					} else {

					}

				}
				if (item.getFieldName().equals("matkhau")) {
					String matkhau = item.getString();
					req.setAttribute("matkhau", matkhau);
				}
				if (item.getFieldName().equals("confirmpassword")) {
					String confirmpassword = item.getString();
					String pass = (String) req.getAttribute("matkhau");
					if (confirmpassword.equals(pass)) {
						MD5Encoder md5 = new MD5Encoder();
						try {
							tk.setMatkhau(md5.md5Encoder(pass));
							req.removeAttribute("matkhau");
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
					}
				}
				if (item.getFieldName().equals("role")) {
					int role = Integer.parseInt(item.getString("UTF-8"));
					tk.setRole(role);
				}
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
					}
				}
			}
			
			if (tk.getMatkhau() == null) {
				resp.sendRedirect(req.getContextPath() + "/kiemdinh/taikhoan/add?mess=password");
				System.out.println("mk k giong");
			}
			if (tk.getTaikhoan() == null) {
				resp.sendRedirect(req.getContextPath() + "/kiemdinh/taikhoan/add?mess=username");
				System.out.println("username ton tai");
			} else {
				userDao.addTaiKhoan(tk);
				resp.sendRedirect(req.getContextPath() + "/kiemdinh/taikhoan?mess=success");
				System.out.println("them thanh cong" + tk.getTaikhoan());
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
