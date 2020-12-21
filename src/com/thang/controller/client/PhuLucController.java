package com.thang.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.DaoImpl.PhuLucDaoImpl;
import com.thang.dao.PhuLucDao;
import com.thang.model.PhuLuc;
@WebServlet(urlPatterns = "/utt/phuluc")
public class PhuLucController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_phuluc = Integer.parseInt(req.getParameter("id_phuluc"));
		PhuLucDao phulucDao = new PhuLucDaoImpl();
		PhuLuc phuluc = phulucDao.getIdPhuLuc(id_phuluc);
		req.setAttribute("phuluc", phuluc);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/phuluc.jsp");
		dispatcher.forward(req, resp);
	}
}
