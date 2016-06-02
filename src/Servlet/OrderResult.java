package Servlet;

import dao.HistoryDao;
import java.io.*;
//import static java.lang.System.out;
//import java.sql.*;
//import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class OrderResult extends HttpServlet {
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        HttpSession session = request.getSession();
	        String userId = (String) session.getAttribute("userId");
	        System.out.println("userId" + userId);

	        HistoryDao historyDao = new HistoryDao();
	        int sum = (int) session.getAttribute("sum");
	        System.out.println("sum" + sum);
	        
	        historyDao.create(userId, sum);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/orderDone.jsp");
	        dispatcher.forward(request, response);
	    }
	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }
	  @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>
}
