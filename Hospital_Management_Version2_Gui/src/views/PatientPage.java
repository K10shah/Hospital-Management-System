package views;

import common.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Login;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PatientPage extends JFrame {

	private JPanel contentPane;
	private Login loginInfo;
	private String patName = "";
	private String username = "";
	private JButton btnLogOut;
	private JTextField txtRecord;
	private JLabel lblRoom;
	private JLabel lblAccount;
	private JLabel lblWelcome;

	/**
	 * Create the frame.
	 */
	public PatientPage(Login lg, String username) {
		loginInfo = lg;
		patName = loginInfo.getPatients().get(username).getName();
		this.username = username;
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(459, 285, 89, 23);
		contentPane.add(btnLogOut);
		
		txtRecord = new JTextField();
		txtRecord.setBounds(47, 85, 501, 189);
		contentPane.add(txtRecord);
		txtRecord.setColumns(10);
		
		lblWelcome = new JLabel("");
		lblWelcome.setBounds(47, 11, 418, 14);
		contentPane.add(lblWelcome);
		
		lblAccount = new JLabel("");
		lblAccount.setBounds(47, 36, 340, 14);
		contentPane.add(lblAccount);
		
		lblRoom = new JLabel("");
		lblRoom.setBounds(47, 60, 46, 14);
		contentPane.add(lblRoom);
		
		
		lblWelcome.setText("Welcome "+ loginInfo.getPatients().get(username).getName());
		lblAccount.setText("Account balance is " + loginInfo.getPatients().get(username).getAccountBalance());
		txtRecord.setText(loginInfo.getPatients().get(username).ViewRecords());
	}

	private void createEvents()
	{
		//log out button
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				LoginPage loginframe = new LoginPage(loginInfo);
				loginframe.setVisible(true);
				dispose();
			}
		});
	}
}