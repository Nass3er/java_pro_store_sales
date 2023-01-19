package package1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSetMetaData;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableCell;

import net.proteanit.sql.DbUtils;

import java.sql.ResultSetMetaData;

import package1.DB;
public class LibrarianDao {
private	int id;
private	String name;
private String password;
private String email;
private String address;
private String city;
private String contact;

 Connection con;
 Statement stmt;
 PreparedStatement pst;
 ResultSet rs;
                                                                       //uses

public static int save(String name, String num,String price,String qu,String made){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into table1(name,spare_no,price,quantity,wared) values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,num);
		    ps. setString(3,price);
		    ps. setString(4,qu);
			ps.setString(5,made);
//			ps.setString(5,city);
//			ps.setString(6,contact);
			status=ps.executeUpdate();
			con.close();
		}catch(SQLException e){ 
			e.printStackTrace();
		}
		return status;
	}
	public static int delete(int id){
 		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String student_no){
		boolean status=false ;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from valid where name=? and student_no=?");
			ps.setString(1,name);
			ps.setString(2,student_no);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	//this method i created it for show all data in the database table 
	
//	public static TableCell getTabledata(String st) {
//		try {
//		Connection con=DB.getConnection();
//		PreparedStatement ps=con.prepareStatement(st);
//		ResultSet rs=ps.executeQuery(st);
//		 ResultSetMetaData rsmd=rs.getMetaData();
//		 int c=rsmd.getColumnCount();
//		 JTable t=new JTable();
//		 
//		
//		} catch(SQLException ex) {
//			 ex.getMessage();
//		}
//		
//	}
	
	
	
	
	// this method succecfully
	//this method for fill the table from database   first way
	/*
	 * 
	 * public static void filltable(String tablenorelect) {
		 
		try {
			ResultSet rs;
			String q="select * from " + tablenorelect;
			Connection con=DB.getConnection();
			Statement stat=con.createStatement();
			rs=stat.executeQuery(q);
			ResultSetMetaData rsmd=rs.getMetaData();
			int c=rsmd.getColumnCount();
			DefaultTableModel model=(DefaultTableModel) guis1.table.getModel();
			
			Vector row=new Vector();
			model.setRowCount(0);
			while(rs.next()) {
				row=new Vector(c);
				for(int i=1;i<=c;i++) {
					row.add(rs.getString(i));
				}
          model.addRow(row);
          
			}
			 
			if(guis1.table.getColumnCount()!=c) {
				System.out.println("column greater....");
			}
			
			con.close();
			
		} catch (Exception e) {
			 e.getMessage();
		}
		
	}
	
	*/
	 // end first way to fill table
	
	
	                                                       //uses
//	second way to fill table by using jar file rm2xml 
	//the jar file is (DbUtils)
	public static void full_table() {
		
		 try { 
			 String s="select * from table1";
			 Connection con =DB.getConnection();
			Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(s);
			guis1.table.setModel(DbUtils.resultSetToTableModel(rs));
				 
			 }
		        
			 catch(SQLException x) {
				 x.printStackTrace();
			 }
			 
			
		}
	
	
	
	
	
	
	
	
	//delete from jtable 
    public 	static void deleted() {
    	DefaultTableModel model1=(DefaultTableModel) guis1.table.getModel();
    	int currentrow=guis1.table.getSelectedRow();
    	model1.removeRow(currentrow);
    	 
    	
    }
     
//    search by id 
    public static void searchById(int  id) {
    	 
    	 
    		
			
		 
    }
    
    //search by name sparts
    public static void searchByname(String namesp) {
    	//String strselect2="select * from table1 where name like '%" + namesp + "%'";
    	boolean status=false;
    	try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from table1 where name like '%" + namesp + "%'");
		//	ps.setString(1,namesp);
			//ps.setString(2,student_no);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
    	} catch(SQLException e) {
    	  e.getMessage();
    	}
    	
    }
    
    

	public static void save(String[] strings) {
		// TODO Auto-generated method stub
		
	}

}
