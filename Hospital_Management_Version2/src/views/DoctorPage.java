package views;

import java.awt.BorderLayout;
import common.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DoctorPage extends JFrame {

	private JPanel contentPane;
	private Login loginInfo;
	/**
	 * Create the frame.
	 */
	public DoctorPage(Login lg) {
		loginInfo = lg;
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
