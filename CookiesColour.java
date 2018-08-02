package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;

/**
 * Servlet implementation class CookiesColour
 */
@WebServlet("/CookiesColour")
public class CookiesColour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesColour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie1[]=request.getCookies();
		PrintWriter pw=response.getWriter();
		if (cookie1==null) {
			Cookie c=new Cookie("location","Bengaluru");
			c.setMaxAge(48*60*60);
			response.addCookie(c);
			pw.print("<body bgcolor=yellow>");
			pw.println("Cookie has been added");
			pw.println("Welcome to the store for the first time");
			pw.println("Some offers are awaiting for the first time users. Enjoy your shopping");
		}
		else {
			for(int i=0;i<cookie1.length;i++)
			{
				Cookie cc=new Cookie("location", "Bengaluru");
				System.out.println(cc.getName()+"and"+cc.getValue());
				String name=cc.getName();
				String val=cc.getValue();
				if(name.equals("location")&& val.equals("Bengaluru")) {
					pw.println("<body bgcolor=pink>");
					pw.println("Welcome back to my store <br>");
					pw.println("since you liked my store <br>");
					pw.println("For regular customers like you have 20% discount on some items <br>");
					}
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
