package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import common.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;

public class AdminPage extends JFrame 
{

	private JPanel contentPane;
	private Login loginInfo;
	private JButton btnLogOut;
	private JButton btnAddUser;
	private JPanel pnlAddUser;
	private JButton btnDltUser;
	private JPanel pnlDltUsr;
	private JLabel lblUsername;
	private JLabel lblName;
	private JLabel lblPwd;
	private JTextField txtUsr;
	private JTextField txtName;
	private JTextField txtPwd;
	private JRadioButton rdbtnRecep;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnDoctor;
	private JLabel lblWarningDisp;
	private JButton btnVerifyAndAdd;
	private JTextField txtSearch;
	private JLabel lblSearch;
	private JButton btnSearch;
	private JLabel lblFound;
	private JButton btnDelete;

	public AdminPage(Login lg) 
	{
		loginInfo = lg;
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlDltUsr = new JPanel();
		pnlDltUsr.setVisible(false);
		pnlDltUsr.setBounds(160, 11, 318, 310);
		contentPane.add(pnlDltUsr);
		pnlDltUsr.setLayout(null);

		txtSearch = new JTextField();
		txtSearch.setText("");
		txtSearch.setBounds(10, 11, 201, 20);
		pnlDltUsr.add(txtSearch);
		txtSearch.setColumns(10);

		lblSearch = new JLabel("Enter username to delete");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearch.setBounds(10, 42, 201, 20);
		pnlDltUsr.add(lblSearch);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(221, 10, 89, 23);
		pnlDltUsr.add(btnSearch);

		lblFound = new JLabel("");
		lblFound.setBounds(10, 75, 269, 38);
		pnlDltUsr.add(lblFound);

		btnDelete = new JButton("Delete");
		btnDelete.setVisible(false);
		btnDelete.setBounds(10, 140, 89, 23);
		pnlDltUsr.add(btnDelete);

		btnLogOut = new JButton("Log Out");

		btnLogOut.setBounds(389, 332, 89, 23);
		contentPane.add(btnLogOut);

		JPanel pnlAdminCtrl = new JPanel();
		pnlAdminCtrl.setBounds(10, 11, 140, 344);
		contentPane.add(pnlAdminCtrl);
		pnlAdminCtrl.setLayout(null);

		btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(10, 97, 120, 38);
		pnlAdminCtrl.add(btnAddUser);

		btnDltUser = new JButton("Delete user");
		btnDltUser.setBounds(10, 191, 120, 38);
		pnlAdminCtrl.add(btnDltUser);

		pnlAddUser = new JPanel();
		pnlAddUser.setVisible(false);
		pnlAddUser.setBounds(160, 11, 318, 310);
		contentPane.add(pnlAddUser);
		pnlAddUser.setLayout(null);

		lblUsername = new JLabel("User name");
		lblUsername.setBounds(20, 11, 89, 30);
		pnlAddUser.add(lblUsername);

		lblName = new JLabel("Name");
		lblName.setBounds(20, 79, 89, 30);
		pnlAddUser.add(lblName);

		lblPwd = new JLabel("Password");
		lblPwd.setBounds(20, 146, 89, 30);
		pnlAddUser.add(lblPwd);

		txtUsr = new JTextField();
		txtUsr.setBounds(20, 34, 240, 20);
		pnlAddUser.add(txtUsr);
		txtUsr.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(20, 102, 240, 20);
		pnlAddUser.add(txtName);
		txtName.setColumns(10);

		txtPwd = new JTextField();
		txtPwd.setBounds(20, 169, 240, 20);
		pnlAddUser.add(txtPwd);
		txtPwd.setColumns(10);

		rdbtnDoctor = new JRadioButton("doctor");
		rdbtnDoctor.setBounds(20, 209, 71, 23);
		pnlAddUser.add(rdbtnDoctor);

		rdbtnAdmin = new JRadioButton("admin");
		rdbtnAdmin.setBounds(119, 209, 78, 23);
		pnlAddUser.add(rdbtnAdmin);

		rdbtnRecep = new JRadioButton("receptionist");
		rdbtnRecep.setBounds(199, 209, 109, 23);
		pnlAddUser.add(rdbtnRecep);

		lblWarningDisp = new JLabel("");
		lblWarningDisp.setBounds(20, 239, 288, 14);
		pnlAddUser.add(lblWarningDisp);

		btnVerifyAndAdd = new JButton("Add");
		btnVerifyAndAdd.setBounds(229, 276, 89, 23);
		pnlAddUser.add(btnVerifyAndAdd);
	}

	private void createEvents()
	{
		//When Login is pressed
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage loginframe = new LoginPage(loginInfo);
				loginframe.setVisible(true);
				dispose();
			}
		});

		//When Add user button is pressed
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAddUser.setVisible(true);	
				pnlDltUsr.setVisible(false);
			}
		});

		//When someone clicks the Add button to finally add the user
		btnVerifyAndAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = txtUsr.getText();
				String name = txtName.getText();
				String pwd = txtPwd.getText();
				String role = "";
				if(loginInfo.verifyUserName(username) && loginInfo.verifyName(name) && loginInfo.verifyPassword(pwd))
				{
					if(rdbtnDoctor.isSelected())
					{
						role = "doctor";
					}
					else if(rdbtnAdmin.isSelected())
					{
						role = "admin";
					}
					else if(rdbtnRecep.isSelected())
					{
						role = "recep";
					}

					if(!role.isEmpty())
					{
						loginInfo.addNewUser(username, name, pwd, role);
						lblWarningDisp.setVisible(true);
						lblWarningDisp.setText("User added succesfully");
						lblWarningDisp.setForeground(Color.GREEN);
					}
				}
				else
				{
					lblWarningDisp.setText("Invalid data or username present");
					lblWarningDisp.setVisible(true);
					lblWarningDisp.setForeground(Color.RED);

				}
			}
		});


		//When the delete button is clicked
		btnDltUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAddUser.setVisible(false);
				pnlDltUsr.setVisible(true);
				String username = txtSearch.getText();
				loginInfo.deleteUser(username);
			}
		});

		//When search button is clicked
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtSearch.getText();
				if(username.equals("admin"))
				{
					lblFound.setText("Cannot delete default admin");
					lblFound.setForeground(Color.BLACK);
				}
				else 
				{
					if(loginInfo.getLoginData().containsKey(username))
					{
						String role = loginInfo.getLoginData().get(username);
						String found = "User " + username+ " found " + "\nUser type: " + role;
						lblFound.setText(found);
						btnDelete.setVisible(true);
						lblFound.setForeground(Color.GREEN);
					}
					else
					{
						lblFound.setText("User name not found \nPlease type another username");
						lblFound.setForeground(Color.RED);
					}
				}
			}
		});
	}
}
