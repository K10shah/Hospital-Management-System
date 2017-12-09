package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Patient;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierPage extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrPatientAccount;
	private JButton btnSubmit;
	private JTextField txtUsername;
	private JLabel lblMessage;

	public CashierPage() {
		
		initComponents();
		createEvents();
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterPatientUsername = new JLabel("Enter Patient Username");
		lblEnterPatientUsername.setBounds(25, 31, 154, 16);
		contentPane.add(lblEnterPatientUsername);

		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(249, 28, 142, 22);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		btnSubmit = new JButton("Submit");

		btnSubmit.setBounds(149, 74, 97, 25);
		contentPane.add(btnSubmit);

		txtrPatientAccount = new JTextArea();
		txtrPatientAccount.setText("Patient Account");
		txtrPatientAccount.setBounds(64, 142, 315, 75);
		contentPane.add(txtrPatientAccount);

		lblMessage = new JLabel("Message");
		lblMessage.setBounds(25, 230, 381, 16);
		contentPane.add(lblMessage);
	}

	private void createEvents(){
		Patient pat = new Patient();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=txtUsername.getText();
				if(pat.getUserName()==username)
				{
					pat.getAccountBalance();
				}
				else
				{
					lblMessage.setText("Patient not found");
					lblMessage.setForeground(Color.RED);
				}
			}
		});
		
		

}

}

