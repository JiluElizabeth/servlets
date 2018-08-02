package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesDemo
 */
@WebServlet("/CookiesDemo")
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie allCookie[]=request.getCookies();
		PrintWriter pw=response.getWriter();
		if (allCookie==null)
		{
			Cookie c=new Cookie ("location","Bengaluru");
			c.setMaxAge(24*60*60);// cookie will be there for one day
			response.addCookie(c);
			pw.println("Cookie has been added");
			pw.println("Welcome to the store for the first time");
			pw.println("Some offers are awaiting for the first time users. Enjoy your shopping");//cookies are stored until the browsing session ends
		}
		else {
			//read all cookies
			//iterate all cookies one by one
			for(int i=0;i<allCookie.length;i++)
			{
				Cookie cc=allCookie[i];
				System.out.println(cc.getName()+"and"+cc.getValue());
				String name=cc.getName();
				String val=cc.getValue();
				if(name.equals("location")&& val.equals("Bengaluru")) {
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
