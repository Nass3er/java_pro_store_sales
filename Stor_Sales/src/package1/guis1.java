package package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.tools.Tool;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class guis1 extends JFrame {

	public static JScrollPane scrollPane;
	
	Connection con;
	Statement stmt;
	java.sql.PreparedStatement pst;
	ResultSet rs;

	
	private JPanel contentPane;
	private JTextField txtid;
	public static JTable table;
	 public static JTextField txtname;
	 public static JTextField txtno;
	 public static JTextField txtmade;
	 public static JTextField txtprice;
	 private JPanel panel_1;
	 public static JTextField txtquantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guis1 frame = new guis1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//this simple method for make textfield null;
public static void setTextFieldsNull() {
	 txtname.setText("");
		txtno.setText("");
		txtprice.setText("");
		txtmade.setText("");
		txtquantity.setText("");
	
}
	
	
	public guis1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("spare parts");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, ٢٤));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(198, 0, 250, 52);
		contentPane.add(lblNewLabel);
		
		JButton btn2 = new JButton("delete from this table");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		      LibrarianDao.deleted(); // this delete from jtable but not from database
		  
				
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btn2.setBackground(new Color(211, 211, 211));
		btn2.setForeground(Color.RED);
		btn2.setBounds(640, 423, 184, 34);
		contentPane.add(btn2);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this for add the data into database
				//
			String name,made;
			name=getTxtname().getText();
			String  num= txtno.getText();
			String price=txtprice.getText();
			String  quant= txtquantity.getText();
			made=txtmade.getText();
			 
			
			int i=LibrarianDao.save(name,num,price,quant,made);
			
			if(i>0){
				JOptionPane.showMessageDialog(null,"تم إضافة القطعة بنجاح");
				                //(the frame we want show this message in it,message)
				LibrarianDao.full_table();
				 setTextFieldsNull();// i create this method
 
				getTxtname().requestFocus(); // for the cursor stand in the txtname 
			 	//guis1.main(new String[]{});
				Window frame = null;
				frame.dispose();
				
			}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(21, 354, 97, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("seachByName");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, ١٣));
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchForm.main(new String[] {});
				dispose();
			}
		});
		btnNewButton_1.setBounds(687, 494, 137, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("show all");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {     //show all row to the table
//			 this first way	
//				String sq="table1";
//				LibrarianDao.filltable(sq);
			
//				  this second way
				LibrarianDao.full_table();
				
				 
					 
					
				 

			}	
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setBounds(249, 353, 95, 35);
		contentPane.add(btnNewButton_2);
		
		  scrollPane = new JScrollPane();
		  scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "all data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		  scrollPane.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		  scrollPane.setForeground(new Color(255, 0, 0));
		  scrollPane.setBackground(new Color(0, 0, 205));
		scrollPane.setBounds(354, 86, 470, 301);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), null, new Color(0, 255, 255), new Color(255, 0, 255)), "search", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(21, 402, 323, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtid = new JTextField();
		txtid.setBounds(34, 29, 179, 33);
		panel.add(txtid);
		txtid.setColumns(10);
		
		JButton btnNewButton_3 = new JButton(" بحث");
		btnNewButton_3.setBounds(216, 29, 75, 34);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("id:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 33, 34, 24);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_3_1 = new JButton("delete");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btnNewButton_3_1.setForeground(Color.RED);
		btnNewButton_3_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    // this for deleting
				int i=0;
				String did=txtid.getText();
				try {
				  con=DB.getConnection();
					
				  pst=con.prepareStatement("delete from table1 where id=?");
					pst.setString(1,did);
					
					i=pst.executeUpdate();
					  if(i>0) {
					  JOptionPane.showMessageDialog(null,"record deleted.. ");
						LibrarianDao.full_table();// for show the update in the table
					  }
					  else {
						  JOptionPane.showMessageDialog(null," sorry,this id not existing try again.. ");
						  
					  }
				}
				catch(SQLException e2) {
					e2.printStackTrace();
					
				}
				
				
				
				
			}
		});
		btnNewButton_3_1.setBounds(358, 424, 75, 34);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("update");
		btnNewButton_3_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btnNewButton_3_2.setForeground(Color.BLUE);
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this update by id 
				String bname,num,pric,mad,bid,bquant;
				
				bname=txtname.getText();
				num=txtno.getText();
				pric=txtprice.getText();
				mad=txtmade.getText();
				bquant=txtquantity.getText();
				
				bid=txtid.getText(); // for search by it
				int i=0;
			    i= Mymethod.update(bname, num, pric,bquant,mad, bid); //this method working good
			     
				  if(i>0) {
				  JOptionPane.showMessageDialog(null,"record alterd.. ");
					LibrarianDao.full_table();// for show the update in the table
					
					 setTextFieldsNull();  // i create this method
 
					}
				  else {
					  JOptionPane.showMessageDialog(null,"sorry,this record not exiting please try again.. ");
				  }
			
			}
		});
		
		               
		
		btnNewButton_3_2.setBounds(482, 424, 86, 34);
		contentPane.add(btnNewButton_3_2);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 255, 255), null), "Register", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(21, 86, 323, 257);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("made in:");
		lblNewLabel_1_2.setBounds(10, 210, 41, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("price:");
		lblNewLabel_1_1_1.setBounds(10, 118, 41, 23);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("parts_no:");
		lblNewLabel_1_1.setBounds(10, 73, 52, 23);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("name:");
		lblNewLabel_1.setBounds(10, 32, 52, 23);
		panel_1.add(lblNewLabel_1);
		
		txtmade = new JTextField();
		txtmade.setBounds(61, 217, 240, 30);
		panel_1.add(txtmade);
		txtmade.setColumns(10);
		
		setTxtname(new JTextField());
		getTxtname().setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("quantity:");
		lblNewLabel_3.setBounds(10, 172, 52, 14);
		panel_1.add(lblNewLabel_3);
		
		txtprice = new JTextField();
		txtprice.setBounds(61, 118, 240, 30);
		panel_1.add(txtprice);
		txtprice.setColumns(10);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(61, 164, 240, 30);
		panel_1.add(txtquantity);
		
		txtno = new JTextField();
		txtno.setBounds(61, 69, 240, 30);
		panel_1.add(txtno);
		txtno.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 255), new Color(255, 0, 255), new Color(255, 99, 71), new Color(255, 99, 71)));
		panel_2.setBounds(144, 0, 374, 60);
		contentPane.add(panel_2);
		
		JButton btnNewInvoice = new JButton(" new invoice");
		btnNewInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceForm.main(new String[] {});
				dispose();
			}
		});
		btnNewInvoice.setForeground(new Color(220, 20, 60));
		btnNewInvoice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, ١٣));
		btnNewInvoice.setBackground(new Color(245, 245, 245));
		btnNewInvoice.setBounds(21, 492, 150, 34);
		contentPane.add(btnNewInvoice);
		
		JButton btnNewButton_3_2_1 = new JButton("mySales");
		btnNewButton_3_2_1.setForeground(new Color(255, 105, 180));
		btnNewButton_3_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, ١٣));
		btnNewButton_3_2_1.setBackground(new Color(0, 255, 255));
		btnNewButton_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales.main(new String[] {});
				dispose();
			}
		});
		btnNewButton_3_2_1.setBounds(373, 493, 97, 34);
		contentPane.add(btnNewButton_3_2_1);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextFieldsNull();
				
			}
		});
		btnClear.setForeground(Color.DARK_GRAY);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btnClear.setBackground(UIManager.getColor("info"));
		btnClear.setBounds(142, 354, 86, 34);
		contentPane.add(btnClear);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {          // for search by id 
				 String id= txtid.getText();
				 
				 
				Mymethod.searchById(id);
		
			}
		});
	}

	public JTextField getTxtname() {
		return txtname;
	}

	public void setTxtname(JTextField txtname) {
		this.txtname = txtname;
		txtname.setBounds(61, 28, 240, 30);
		panel_1.add(txtname);
	}
	}
