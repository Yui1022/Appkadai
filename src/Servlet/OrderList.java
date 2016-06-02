package Servlet;

import java.io.*;
import static java.lang.System.out;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.getItemListLogic;
import model.Items;

public class OrderList extends HttpServlet {
	 private static final long serialVirsionUID = 1L;
	 
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        //request.setCharacterEncoding("UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet OrderList</title>");            
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Servlet OrderList at " + request.getContextPath() + "</h1>");
	            out.println("</body>");
	            out.println("</html>");
	        }
	    }
	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        HttpSession session = request.getSession();
	        getItemListLogic getItemListLogic=new getItemListLogic();
	        List<Items> Items=getItemListLogic.execute();
	        //request.setAttribute("Items", Items);
	        //System.out.println("getget");

	        Connection conn=null;
	        String url="jdbc:derby://localhost:1527/db0818";
	        try{
	            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
	            conn=DriverManager.getConnection(url,"db","db");
	            
	            Statement stmt=conn.createStatement();
	            String sql="SELECT * FROM ITEM";
	            ResultSet rs=stmt.executeQuery(sql);
	            
	            while(rs.next()){
	                String itemId=rs.getString("itemId");
	                String itemName=rs.getString("itemName");
	                int price=rs.getInt("price");
	                
	                session.setAttribute("Items", Items);
	            }
	            //session.setAttribute("userId", "a0001");
	            System.out.println("userId:"+session.getAttribute("userId"));
	            rs.close();
	            stmt.close();
	        }catch(Exception e){
	            out.println(e);
	        }
	        
	        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/orderList.jsp");
	        dispatcher.forward(request,response);
	        //processRequest(request, response);
	    }
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");

	    }
	  @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>

}
