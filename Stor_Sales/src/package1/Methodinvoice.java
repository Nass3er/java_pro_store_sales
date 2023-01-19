package package1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

public class Methodinvoice {
	static Connection con;
	static Statement stmt;
	static java.sql.PreparedStatement pst;
	static ResultSet rs;
	InvoiceForm invoice=new InvoiceForm();
	
	
	// for full tableSales
	public static void full_tableSales() {
		
		 try { 
			 String s1="select * from dbtable2";
			 Connection con =DB.getConnection();
			Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(s1);
				Sales.tableSales.setModel(DbUtils.resultSetToTableModel(rs));
				 
			 }
		        
			 catch(SQLException x) {
				 x.printStackTrace();
			 }
			 
			
		}
	
	
	
	

	public static int insertSales(String item,int price,int qu) {
		int f=0;
		try {
		// String date="sysdate" ;
		con=DB.getConnection();
		pst=con.prepareStatement("insert into dbtable2(item,price,quantity) values(?,?,?)");
		pst.setString(1, item);
		pst.setInt(2, price);
		pst.setInt(3, qu);
		// pst.setString(3, date);
		 f=pst.executeUpdate();
		
		 	con.close();	
		}
		catch(SQLException en) {
			en.printStackTrace();
		}
		return f;
	}
	
    public static int alterQuant(String vid,int vqu) {
    	 
    	int id=Integer.parseInt(vid);
    	 
    	 int k=0;
    	try {
    			 con=DB.getConnection();
    			 pst=con.prepareStatement("update table1 set quantity=? where id=?");
    			 pst.setInt(1,vqu);
    			 pst.setInt(2,id);
    		   k=pst.executeUpdate();
    			  
 		
 		 	con.close();	
 		}
 		catch(SQLException en) {
 			en.printStackTrace();
 		}
 		 return k;
 	}
    			 
    			 
    
	
}	

