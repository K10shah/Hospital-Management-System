package views;

import common.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Login;

public class PatientPage extends JFrame {

	private JPanel contentPane;
	private Login loginInfo;
	private String patName = "";
	
	/**
	 * Create the frame.
	 */
	public PatientPage(Login lg, String username) {
		loginInfo = lg;
		patName = loginInfo.getPatients().get(username).getName();
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private void createEvents()
	{
		
	}
}