package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PASSENGERSYSTEM
 */
@WebServlet("/PASSENGERSYSTEM")
public class PASSENGERSYSTEM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PASSENGERSYSTEM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw= response.getWriter();
		String destination=request.getParameter("destination");
		//dont write jdbc code here. call jdbc code here
		DBHelper db=new DBHelper();
		ArrayList passengersList=db.getAllPassengers(destination);
		
		
		 
			String str1="<table border=1>"+
			"<tr>"+
					"<th>First Name</th>"+
					"<th>Last Name</th>"+
					"<th>Source</th>"+
					"<th>Destination</th>"+
					"<th>gender</th>"+
					"</tr>";
			
			pw.println(str1);
			
			
			
			
			
			
			for (int i=0;i<passengersList.size();i++) {
				
				passengerVO pvo=(passengerVO)passengersList.get(i);
						
				String str2="<tr>"+
								"<td>"+pvo.getFname()+"</td>"+
								"<td>"+pvo.getLname()+"</td>"+
								"<td>"+pvo.getSource()+"</td>"+
								"<td>"+pvo.getDestination()+"</td>"+
								"<td>"+pvo.getGender()+"</td>"+
								"</tr>";
				
			
			pw.println(str2);
			
			
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
