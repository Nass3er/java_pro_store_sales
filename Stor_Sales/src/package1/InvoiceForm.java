package package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.tools.Tool;

import org.w3c.dom.events.MouseEvent;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.border.EtchedBorder;

public class InvoiceForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtinvno;
	private JTextField txtdate;
	private JTextField txtcustomer;
	public static JTextField txttotal;
	public static int total=0;
	public static String vid;
	public static String vquant;
	public static String vname;
	public static JTable table3;
	
	
	Connection con;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	
	int i;
	private JTextField txtitem;
	private JTextField txtprice2;
	private JTextField txtquant;
	private JTable table;
	
	public static void alterTabl1Db(String vna,String vq) {
		
		
	}
	
	
	private void addAndEmpty() {
		    
		int  pric=Integer.parseInt(txtprice2.getText());
				total+=pric;
			
				txttotal.setText(String.valueOf(total));
				
			// txtitem.setText("");
			// txtprice2.setText("");	
			// txtquant.setText("");	
		
	}
	
	//this method for fill the textfields directly from  the row selected of jtable
		private void fillTextDirect() {
					}
		
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceForm frame = new InvoiceForm();
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
	
	
	public InvoiceForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199, 21, 133));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(10, 34, 393, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("invioce_number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(10, 19, 99, 22);
		panel.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		lblDate.setBounds(10, 57, 88, 22);
		panel.add(lblDate);
		
		JLabel lblCustomername = new JLabel("customer_name:");
		lblCustomername.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		lblCustomername.setBounds(10, 105, 99, 22);
		panel.add(lblCustomername);
		
		txtinvno = new JTextField();
		txtinvno.setBounds(112, 21, 234, 30);
		panel.add(txtinvno);
		txtinvno.setColumns(10);
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(112, 56, 234, 30);
		panel.add(txtdate);
		
		txtcustomer = new JTextField();
		txtcustomer.setColumns(10);
		txtcustomer.setBounds(112, 97, 234, 30);
		panel.add(txtcustomer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 0));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Enter name of item", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(10, 189, 393, 144);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("item:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		lblNewLabel_1.setBounds(10, 11, 46, 21);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("price:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		lblNewLabel_1_1.setBounds(10, 56, 46, 21);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("quantity:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		lblNewLabel_1_2.setBounds(173, 56, 55, 21);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel(" TOTAL:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		lblNewLabel_1_3.setBounds(315, 15, 55, 21);
		panel_1.add(lblNewLabel_1_3);
		
		txttotal = new JTextField();
		txttotal.setColumns(10);
		txttotal.setBounds(308, 53, 75, 28);
		panel_1.add(txttotal);
		
		JButton btnprint = new JButton("PRINT");
		btnprint.setBackground(new Color(0, 0, 255));
		btnprint.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
			}
		});
		btnprint.setBounds(20, 98, 89, 35);
		panel_1.add(btnprint);
		
		            
		JButton btnadd = new JButton("ADD");
		btnadd.setBackground(new Color(0, 0, 255));
		btnadd.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	/*in this line below programming i will save item and price into DB(dbtables2 )
	 * and show this value on the tableSales that in frame(Sales)
	 */			
				String Item=txtitem.getText();
				 int Price=Integer.parseInt(txtprice2.getText());
				 int txtq=Integer.parseInt(txtquant.getText());
				 
				 
				 int qdb=Integer.parseInt(vquant)-txtq;
				 int v=0;
				  v=Methodinvoice.alterQuant(vid,qdb);
				 if(v>0) {
					 JOptionPane.showMessageDialog(null, "alterd table1 successfully..");
					 
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "table1 not alterd..");
				 }
				/*
				 * this method take the value from txtitem and txtprice into tableSales by method allSales(-,-)
				 */
				int k=Methodinvoice.insertSales(Item,Price,qdb);// for insert into dbtable2 and alterd the value of quantity
				if(k>0) {
					JOptionPane.showMessageDialog(null,"added into your sales");
					
					//Methodinvoice. full_tableSales();// for full tableSales
					
					Window frame = null;
					frame.dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null,"not added into DB");
				}
				
			/*
			 *  this below method set all textfields empty eccept total set in it the sum price
			 */
				addAndEmpty();  
				
			}
		});
		btnadd.setBounds(281, 98, 89, 35);
		panel_1.add(btnadd);
		
		txtitem = new JTextField();
		txtitem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String ss=txtitem.getText();
				try {
					String strselect2="select * from table1 where name like '%" + ss + "%'";
					
					con=DB.getConnection();
					stmt=con.createStatement();
	    			rs=stmt.executeQuery(strselect2);	
	    			 table3.setModel(DbUtils.resultSetToTableModel(rs));
	    			
				}catch(SQLException en) {
					en.printStackTrace();
				}
				
				
				
			}
		});
		txtitem.setBounds(52, 12, 253, 33);
		panel_1.add(txtitem);
		txtitem.setColumns(10);
		
		txtprice2 = new JTextField();
		txtprice2.setBounds(52, 53, 111, 28);
		panel_1.add(txtprice2);
		txtprice2.setColumns(10);
		
		txtquant = new JTextField();
		txtquant.setBounds(223, 53, 66, 28);
		panel_1.add(txtquant);
		txtquant.setColumns(10);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	txtitem.setText("");
				//txtprice2.setText("");
				//txtquant.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		btnClear.setBackground(Color.BLUE);
		btnClear.setBounds(151, 98, 89, 35);
		panel_1.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setName("");
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, ١٢));
		scrollPane.setBackground(new Color(255, 192, 203));
		scrollPane.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
				
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				
			}
		});
		scrollPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
			}
		});
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				try {
					int quantity=1;
					txtitem.setText("");
					i=table3.getSelectedRow();
					
					 vname=table3.getValueAt(i, 1).toString();
					String vprice= table3.getValueAt(i, 3).toString();
					
					/*
					 * this below value important
					 */
					  vid= table3.getValueAt(i, 0).toString();// for less the quantity
					  vquant= table3.getValueAt(i, 4).toString();//for less the quantity
					
					 
					
					txtitem.setText(vname);
					txtprice2.setText(vprice);
					txtquant.setText(String.valueOf(quantity));
					 
				}catch(Exception ev) {
					ev.printStackTrace();
					//ev.getMessage();
				}
				 
				
			}
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(413, 34, 347, 299);
		contentPane.add(scrollPane);
		
		table3 = new JTable();
		scrollPane.setViewportView(table3);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"price", " quantity", "item"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(88, 335, 645, 88);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guis1.main(new String[] {});
			}
		});
		btnNewButton.setBounds(10, 400, 68, 23);
		contentPane.add(btnNewButton);
		 
 	     
			
		
	}
}
