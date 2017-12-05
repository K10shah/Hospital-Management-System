package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import common.*;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JButton btnLogout;
	private Login loginInfo;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminPage(Login lg) {
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
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(389, 332, 89, 23);
		contentPane.add(btnLogout);
	}
	
	private void createEvents()
	{
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginPage login = new LoginPage(loginInfo);
				login.setVisible(true);
				dispose();
			}
			
		});
	}

}
