package Servlet;

import java.io.*;
import static java.lang.System.out;
import java.sql.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Items;
public class Order extends HttpServlet {
	  */
	    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=UTF-8");
	        HttpSession session = request.getSession();
	        List<Items> Items = (ArrayList) session.getAttribute("Items");
	        int sum = 0;
	        for (int count = 0; count < Items.size(); count++) {//num?:変数名
	            String numbers = (String) request.getParameter("num" + count);//numbers:個数
	            //System.out.println("★☆numbers渡す値:"+numbers);
	            String numbers2 = convertFullwidthDigitToHalfWidthDigit(numbers);//半角に変換後の数値
	            //System.out.println("★☆numbers2:" + numbers2);

	            session.setAttribute("num" + count, numbers2);
	            if (!numbers.equals("")) {
	                int price = Items.get(count).getPrice();
	                System.out.println(price);
	                System.out.println("numbers:" + numbers);
	                sum += Integer.parseInt(numbers2) * price;
	            }
	        }
	        session.setAttribute("sum", sum);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/order.jsp");
	        dispatcher.forward(request, response);
	    }
	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        System.out.println("◆◆GET!◆◆");
	        //processRequest(request, response);
	    }
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        System.out.println("◆◆POST!◆◆");
	        processRequest(request, response);
	    }
	  @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>
	  private String convertFullwidthDigitToHalfWidthDigit(String str) {//全角数字を半角に直す
	        if (str == null) {
	            throw new IllegalArgumentException("Method argument 'string is null.");
	        }

	        StringBuffer stringBuffer = new StringBuffer(str);
	        for (int i = 0; i < stringBuffer.length(); i++) {
	            char character = stringBuffer.charAt(i);
	            if (character >= '０' && character <= '９') {
	                stringBuffer.setCharAt(i, (char) (character - '０' + '0'));
	            }
	        }
	        return stringBuffer.toString();
	    }
}
