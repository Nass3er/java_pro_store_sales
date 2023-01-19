package package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchForm extends JFrame {

	
	public static JScrollPane scrollPane;
	
	java.sql.Connection con;
	Statement stmt;
	java.sql.PreparedStatement pst;
	ResultSet rs;
	
	
	private JPanel contentPane;
	private JTextField txtsearchName;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchForm frame = new searchForm();
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
	public searchForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, ١٣));
		lblNewLabel.setBounds(183, 55, 53, 28);
		contentPane.add(lblNewLabel);
		
		txtsearchName = new JTextField();
		txtsearchName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {  //search by name
				
			String name=txtsearchName.getText();
//			Mymethod.searchByName(name);
			 if(name !=" ") {
			try {
				String ss="select * from table1 where name like '%"+ name +"%'" ;

			 con=DB.getConnection();
			 
			 Statement stmt=con.createStatement();
			 ResultSet rs=stmt.executeQuery(ss);
		 table2.setModel(DbUtils.resultSetToTableModel(rs)); // for insert the result int table
				
			}
			catch(SQLException e3) {
				e3.printStackTrace();
				
			}

			 }
			 else { 
				 table2.setModel(null); // this need to alterd 	 
			 }
				
				
			}
		});
		txtsearchName.setBounds(246, 52, 252, 37);
		contentPane.add(txtsearchName);
		txtsearchName.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), new Color(0, 0, 255), null, null), "search by name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(169, 24, 421, 84);
		contentPane.add(panel);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 134, 421, 214);
		contentPane.add(scrollPane);
		
		
		
		
		
		table2 = new JTable();
		scrollPane.setViewportView(table2);
		
		JButton btnNewButton = new JButton(" Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guis1.main(new String[] {});
				dispose();
				
			}
		});
		btnNewButton.setBounds(10, 340, 89, 28);
		contentPane.add(btnNewButton);
	}
}
