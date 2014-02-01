package com.oracle.staffmanagement.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	 public static Connection getConnection() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/commuterdb",
	                    "root", "addicted"  /*"jdbc:mysql://:3306/commuterdb", "root", "vkKrxMWCzY"*/);
	            return con;
	        } catch (Exception ex) {
	            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
	            return null;
	        }
	    }
	 
	    public static void close(Connection con) {
	        try {
	            con.close();
	        } catch (Exception ex) {
	        }
	    }

}
