package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.Items;
import model.User;
import model.getItemListLogic;


public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet Main</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Servlet Main at " + request.getContextPath() + "</h1>");
	            out.println("</body>");
	            out.println("</html>");
	        }
	    }
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        User loginUser = (User) session.getAttribute("loginUser");
	        System.out.println("loginUser" + loginUser);


	        getItemListLogic getItemListLogic = new getItemListLogic();
	        List<Items> Items = getItemListLogic.execute();

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
	                int num=rs.getInt("num");
	                int num=rs.getInt("num");
	                System.out.println("*num:"+num);
	                session.setAttribute("Items", Items);
	            }
	            //session.setAttribute("userId", userId);
	            System.out.println("*userId:"+session.getAttribute("userId"));
	            rs.close();
	            stmt.close();
	        }catch(Exception e){
	            out.println(e);
	        }
	        RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
	        dispatcher.forward(request, response);
	        //processRequest(request, response);
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
