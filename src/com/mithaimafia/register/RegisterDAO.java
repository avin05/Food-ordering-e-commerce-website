package com.mithaimafia.register;

import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class RegisterDAO {
	
public static int addRegister(RegisterModel r){
	int result = 0; 
	
	try
	{
		System.out.println("222");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("333");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mithai_mafia","root","avin05");
		System.out.println("444");
		PreparedStatement pst = con.prepareStatement("insert into mithai_mafia.customer(name,email,phone,password,cpassword) values (?,?,?,?,?)");
		System.out.println("555");
		pst.setString(1,r.getName());
		pst.setString(2,r.getEmail());
		pst.setString(3,r.getPhone());
		pst.setString(4,r.getPassword());
		pst.setString(5,r.getCpassword());
		System.out.println("666");
		result = pst.executeUpdate();
		System.out.println("777");
		
	}
	catch(Exception e){
		System.out.println("111");
		e.printStackTrace();
	}
	
	return result;
}

public static int verifyemail(RegisterModel r){
	
	
	try
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mithai_mafia","root","avin05");
		
		PreparedStatement pst = con.prepareStatement("select custid from mithai_mafia.customer where email = ?");
		
		pst.setString(1,r.getEmail());
		
		
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
            return 1;
        }       
		
		
	
	}
	catch(Exception e){
		e.printStackTrace();
	
	}
	
	return 0;
}
	
}

