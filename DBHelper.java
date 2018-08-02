package com.deloitte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.serializer.utils.AttList;

public class DBHelper {
public ArrayList getAllPassengers(String destination)
{ArrayList al=new ArrayList();
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			

	
	
	
	
	PreparedStatement ps=con.prepareStatement("SELECT * FROM PASSENGERS WHERE DESTINATION=?");
ps.setString(1, destination);
ResultSet rs=ps.executeQuery();
	//collections framework is used  here
//convert this resultset into arraylist of object
	




while (rs.next())
	{
	String fname=rs.getString(1);
	String lname=rs.getString(2);
	String source=rs.getString(3);
	String destination1=rs.getString(4);
	String gender=rs.getString(5);
	
	
	
	
	
	
	passengerVO pvo=new passengerVO();
	pvo.setFname(fname);
	pvo.setLname(lname);
	pvo.setSource(source);
	pvo.setDestination(destination1);
	pvo.setGender(gender);
	al.add(pvo);}
	
	rs.close();
	ps.close();
	con.close();
	
	
	}
catch (ClassNotFoundException cnf) {System.out.println(cnf.getMessage());}
catch (SQLException se) {System.out.println(se.getMessage());}
return al;

}
}
