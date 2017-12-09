package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import common.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceptionistPage extends JFrame {

	private JPanel contentPane;
	private Login loginInfo;
	private String recepName = "";
	private JPanel pnlAppoint;
	private JPanel pnlRecCtrl;
	private JTextField txtUsrNme;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblPwd;
	private JTextField txtPwd;
	private JButton btnAdd;
	private JLabel lblAddRes;
	private JButton btnAddAppointment;
	private JButton btnLogOut;
	
	/**
	 * Create the frame.
	 */
	public ReceptionistPage(Login lg, String username) {
		loginInfo = lg;
		recepName = loginInfo.getRecep().get(username).getName();
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlRecCtrl = new JPanel();
		pnlRecCtrl.setBounds(10, 11, 133, 305);
		contentPane.add(pnlRecCtrl);
		pnlRecCtrl.setLayout(null);
		
		btnAddAppointment = new JButton("Add \r\nPatient");
		btnAddAppointment.setBounds(10, 26, 113, 44);
		pnlRecCtrl.add(btnAddAppointment);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(453, 293, 89, 23);
		contentPane.add(btnLogOut);
		
		pnlAppoint = new JPanel();
		pnlAppoint.setVisible(false);
		pnlAppoint.setBounds(153, 11, 389, 278);
		contentPane.add(pnlAppoint);
		pnlAppoint.setLayout(null);
		
		JLabel lblUsrName = new JLabel("Enter username");
		lblUsrName.setBounds(10, 11, 90, 14);
		pnlAppoint.add(lblUsrName);
		
		txtUsrNme = new JTextField();
		txtUsrNme.setBounds(10, 26, 264, 20);
		pnlAppoint.add(txtUsrNme);
		txtUsrNme.setColumns(10);
		
		lblName = new JLabel("Enter Name");
		lblName.setBounds(10, 74, 112, 14);
		pnlAppoint.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(10, 89, 264, 20);
		pnlAppoint.add(txtName);
		txtName.setColumns(10);
		
		lblPwd = new JLabel("Enter Password");
		lblPwd.setBounds(10, 141, 145, 14);
		pnlAppoint.add(lblPwd);
		
		txtPwd = new JTextField();
		txtPwd.setBounds(10, 158, 264, 20);
		pnlAppoint.add(txtPwd);
		txtPwd.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(11, 215, 89, 23);
		pnlAppoint.add(btnAdd);
		
		lblAddRes = new JLabel("");
		lblAddRes.setBounds(10, 189, 264, 14);
		pnlAppoint.add(lblAddRes);
	}
	
	private void createEvents()
	{
		btnAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAppoint.setVisible(true);
			}
		});
		
		
		//event handler for adding patient to the system.
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsrNme.getText();
				String name = txtName.getText();
				String pwd = txtPwd.getText();
				String role = "";
				if(loginInfo.verifyUserName(username) && loginInfo.verifyName(name) && loginInfo.verifyPassword(pwd))
				{
					loginInfo.addNewUser(username, name, pwd, "patient");
					lblAddRes.setVisible(true);
					lblAddRes.setText("User added succesfully");
					lblAddRes.setForeground(Color.GREEN);
				}
				else
				{
					lblAddRes.setText("Username exists or invalid data. Kindly type again");
					lblAddRes.setForeground(Color.RED);
				}
			}
		});
		

		//Log out button
		btnLogOut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				LoginPage loginframe = new LoginPage(loginInfo);
				loginframe.setVisible(true);
				dispose();
			}
		});
		
	}
}