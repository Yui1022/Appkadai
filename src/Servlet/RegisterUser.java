package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.RegisterUserLogic;
import model.User;


public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet RegisterUser</title>");            
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Servlet RegisterUser at " + request.getContextPath() + "</h1>");
	            out.println("</body>");
	            out.println("</html>");
	        }
	    }
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
	        dispatcher.forward(request, response);
	        //processRequest(request, response);
	    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("userId");
    String pass = request.getParameter("pass");
    

    User registerUser = new User(id, pass);
    HttpSession session = request.getSession();
    session.setAttribute("registerUser", registerUser);

    RegisterUserLogic rg = new RegisterUserLogic();
    rg.execute(registerUser);

    RequestDispatcher dispatcher
            = request.getRequestDispatcher("/WEB-INF/jsp/registerDone.jsp");
    dispatcher.forward(request, response);
}
@Override
public String getServletInfo() {
    return "Short description";
}// </editor-fold>
}

