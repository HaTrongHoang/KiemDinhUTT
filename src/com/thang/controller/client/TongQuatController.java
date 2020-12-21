package com.thang.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.TongQuatDaoImpl;
import com.thang.dao.TongQuatDao;
import com.thang.model.TongQuat;
@WebServlet(urlPatterns = "/utt/tongquat")
public class TongQuatController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tongquat = Integer.parseInt(req.getParameter("id_tongquat"));
		TongQuatDao tongquatDao = new TongQuatDaoImpl();
		TongQuat tongquat = tongquatDao.getIdTongQuat(id_tongquat);
		req.setAttribute("tongquat", tongquat);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/tongquat.jsp");
		requestDispatcher.forward(req, resp);
	}
}
