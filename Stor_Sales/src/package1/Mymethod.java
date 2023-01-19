package package1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import java.sql.ResultSetMetaData;



public class Mymethod {
	static Connection con;
	static Statement stmt;
	static PreparedStatement pst;
	static ResultSet rs;

	
	
	                                                            //uses
	//this method for search by id from database
	public static void searchById(String id) {
		
		try {
			 con=DB.getConnection();
				pst=con.prepareStatement("select name,spare_no,price,quantity,wared from table1 where id= ?");
				pst.setString(1, id);
				
				rs=pst.executeQuery();
				 
				
				if(rs.next()==true) {
					String name= rs.getString(1);
					String num= rs.getString(2);
					String price= rs.getString(3);
					String quant= rs.getString(4);
					String made= rs.getString(5);
					
 					  guis1.txtname.setText(name);
					   guis1.txtno.setText(num);
					   guis1.txtprice.setText(price);
					   guis1.txtquantity.setText(quant);
					   guis1.txtmade.setText(made);
					
					 //LibrarianDao.save(name, num, price, made);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"this id not exsiting,please try again..");
					 guis1.setTextFieldsNull(); // i crate this method for make textfield null
				}
				
				
				con.close();
			} catch (SQLException z ) {
				 
				z.printStackTrace();
			}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	                                                                        //uses
  // this method for update database 
	public static int update(String bname,String num,String pric,String qu,String mad,String bid) {
		int j=0;
		try {
			  con=DB.getConnection();
				
			  pst=con.prepareStatement("update table1 set name= ?,spare_no= ?,price= ?,quantity=?,wared= ? where id= ?");
				pst.setString(1,bname);
				pst.setString(2,num);
				pst.setString(3,pric);
				pst.setString(4,qu);
				pst.setString(5,mad);
				pst.setString(6,bid);
			j=pst.executeUpdate();
			 con.close();
		} catch (SQLException e1) {
			 e1.printStackTrace();
		}
		return j;

		
		
	}
	
	// this method for search by name 
	public static void searchByName(String sn) {
		try {
		con=DB.getConnection();
		pst=con.prepareStatement("select * from table1 where name like ?");
		pst.setString(1, sn);
		rs=pst.executeQuery();
//			 String ss="select * from table1 where name like '%"+ sn +"%'" ;
//			 Connection con =DB.getConnection();
//			Statement stmt=con.createStatement();
//				ResultSet rs=stmt.executeQuery(ss);
		
				//searchForm.table2.setModel(DbUtils.resultSetToTableModel(rs));
		
		}
		catch(SQLException e3) {
			e3.printStackTrace();
			
		}
		
		
	}
	
	
	
}
