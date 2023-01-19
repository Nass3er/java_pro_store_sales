package package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class guis2 extends JFrame {

	Connection con;
	Statement stat;
	ResultSet rs;
	PreparedStatement pst;
	
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guis2 frame = new guis2();
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
	public guis2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u0625\u0636\u0627\u0641\u0629");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {     //for insert
				con=DB.getConnection();
				String sname=txt1.getText();
				int snum=Integer.parseInt(txt2.getText());
				String s=txt3.getText();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				
//			 int i=LibrarianDao.save(sname, snum, s);
//				 
//				if(i>0){
//					JOptionPane.showMessageDialog(guis2.this,"تم إضافة القطعة بنجاح");
//					                            //(the frame we want show this message in it,message)
//				 	//guis1.main(new String[]{});
//					Window frame = null;
//					frame.dispose();
//					
//				}
				
				
				
				}
		});
		btnNewButton.setBackground(new Color(124, 252, 0));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, ١٤));
		btnNewButton.setBounds(56, 213, 251, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u0625\u0633\u0645  \u0627\u0644\u0642\u0637\u0639\u0629");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(320, 41, 81, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0631\u0642\u0645 \u0627\u0644\u0642\u0637\u0639\u0629");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		lblNewLabel_1.setBounds(320, 93, 81, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0648\u0627\u0631\u062F");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, ١٣));
		lblNewLabel_1_1.setBounds(320, 150, 81, 41);
		contentPane.add(lblNewLabel_1_1);
		
		txt1 = new JTextField();
		txt1.setBounds(56, 45, 251, 37);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(56, 96, 251, 37);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(56, 153, 251, 37);
		contentPane.add(txt3);
	}
}
