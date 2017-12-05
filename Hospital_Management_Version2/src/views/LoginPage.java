package views;

import common.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JLabel lblUsrName;
	private JLabel lblPwd;
	private Login loginInfo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public LoginPage(Login lg) {
		loginInfo = lg;
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Calibri", Font.BOLD, 13));
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUserName = new JTextField();
		txtUserName.setBounds(143, 59, 228, 26);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(143, 108, 228, 26);
		contentPane.add(txtPassword);

		lblUsrName = new JLabel("Enter the username");
		lblUsrName.setForeground(Color.WHITE);
		lblUsrName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUsrName.setBounds(10, 65, 123, 20);
		contentPane.add(lblUsrName);

		lblPwd = new JLabel("Enter password");
		lblPwd.setForeground(Color.WHITE);
		lblPwd.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPwd.setBounds(20, 114, 93, 14);
		contentPane.add(lblPwd);

		btnLogin = new JButton("Login");

		btnLogin.setInheritsPopupMenu(true);
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 13));
		btnLogin.setBackground(new Color(64, 64, 64));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(143, 170, 93, 34);
		contentPane.add(btnLogin);
	}

	private void createEvents()
	{
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String username = txtUserName.getText();
				String password = txtPassword.getText();

				if(loginInfo.loginVerify(username, password))
				{
					//moving on to the admin page.
					ShowAdminPage();
				}
			}
		});
	}

	private void ShowAdminPage()
	{
		AdminPage admin = new AdminPage(loginInfo);
		admin.setVisible(true);
		dispose();
	}
}
