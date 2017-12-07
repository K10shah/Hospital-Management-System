package views;

import java.awt.BorderLayout;
import common.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class DoctorPage extends JFrame 
{
	private JPanel contentPane;
	private Login loginInfo;
	private String docName = "";
	private JPanel pnlViewRec;
	private JButton btnLogout;
	private JButton btnViewPatient;
	private JButton btnTreatPatient;
	private JPanel pnlUpdateRec;
	private JTextField txtViewSearch;
	private JButton btnViewSearch;
	private JLabel lblEnterThePatients;
	private JTextArea txtPatientRec;
	private JTextField txtUpSearch;
	private JTextField txtAmount;
	private JLabel lblDiag;
	private JButton btnAmount;
	private JLabel lblFound;
	private JButton btnUpSearch;
	private JLabel lblUpdateStat;
	private JTextArea txtDiag;
	private JTextArea txtPres;
	/**
	 * Create the frame.
	 */
	public DoctorPage(Login lg, String username) 
	{
		loginInfo = lg;
		docName = loginInfo.getDoctors().get(username).getName();
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlViewRec = new JPanel();
		pnlViewRec.setVisible(false);

		pnlUpdateRec = new JPanel();
		pnlUpdateRec.setVisible(false);
		pnlUpdateRec.setBounds(166, 11, 381, 287);
		contentPane.add(pnlUpdateRec);
		pnlUpdateRec.setLayout(null);

		txtUpSearch = new JTextField();
		txtUpSearch.setBounds(24, 31, 141, 20);
		txtUpSearch.setColumns(10);
		pnlUpdateRec.add(txtUpSearch);

		JLabel lblInput = new JLabel("Enter the patient's username");
		lblInput.setBounds(26, 9, 139, 14);
		pnlUpdateRec.add(lblInput);

		btnUpSearch = new JButton("Search");
		btnUpSearch.setBounds(175, 30, 84, 20);
		pnlUpdateRec.add(btnUpSearch);

		lblFound = new JLabel("");
		lblFound.setBounds(24, 67, 46, 14);
		pnlUpdateRec.add(lblFound);

		lblDiag = new JLabel("Enter the diagnosis");
		lblDiag.setBounds(24, 74, 126, 20);
		pnlUpdateRec.add(lblDiag);

		txtDiag = new JTextArea();
		txtDiag.setBounds(24, 93, 347, 54);
		pnlUpdateRec.add(txtDiag);

		JLabel lblPres = new JLabel("Enter the prescription");
		lblPres.setBounds(24, 172, 126, 20);
		pnlUpdateRec.add(lblPres);

		txtPres = new JTextArea();
		txtPres.setBounds(24, 190, 347, 54);
		pnlUpdateRec.add(txtPres);

		lblUpdateStat = new JLabel("");
		lblUpdateStat.setVisible(false);
		lblUpdateStat.setBounds(24, 62, 347, 14);
		pnlUpdateRec.add(lblUpdateStat);

		txtAmount = new JTextField();
		txtAmount.setVisible(false);
		txtAmount.setBounds(24, 74, 86, 20);
		pnlUpdateRec.add(txtAmount);
		txtAmount.setColumns(10);

		btnAmount = new JButton("Charge fee");
		btnAmount.setVisible(false);
		btnAmount.setBounds(124, 73, 118, 23);
		pnlUpdateRec.add(btnAmount);
		pnlViewRec.setBounds(166, 11, 381, 278);
		contentPane.add(pnlViewRec);
		pnlViewRec.setLayout(null);

		txtViewSearch = new JTextField();
		txtViewSearch.setBounds(10, 32, 158, 20);
		pnlViewRec.add(txtViewSearch);
		txtViewSearch.setColumns(10);

		btnViewSearch = new JButton("Search");

		btnViewSearch.setBounds(178, 31, 79, 20);
		pnlViewRec.add(btnViewSearch);

		lblEnterThePatients = new JLabel("Enter the patient's username");
		lblEnterThePatients.setBounds(10, 11, 307, 23);
		pnlViewRec.add(lblEnterThePatients);

		txtPatientRec = new JTextArea();
		txtPatientRec.setWrapStyleWord(true);
		txtPatientRec.setVisible(false);
		txtPatientRec.setEditable(false);
		txtPatientRec.setBounds(10, 82, 361, 185);
		pnlViewRec.add(txtPatientRec);

		JPanel pnlDocCtrl = new JPanel();
		pnlDocCtrl.setBounds(10, 11, 146, 303);
		contentPane.add(pnlDocCtrl);
		pnlDocCtrl.setLayout(null);

		btnViewPatient = new JButton("View patient \r\nrecord\r\n");
		btnViewPatient.setBounds(0, 11, 143, 37);
		pnlDocCtrl.add(btnViewPatient);

		btnTreatPatient = new JButton("Treat Patient");
		btnTreatPatient.setBounds(0, 71, 143, 37);
		pnlDocCtrl.add(btnTreatPatient);

		btnLogout = new JButton("Log Out");

		btnLogout.setBounds(458, 300, 89, 23);
		contentPane.add(btnLogout);
	}

	private void createEvents()
	{
		//Handler for log out button
		btnLogout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LoginPage loginframe = new LoginPage(loginInfo);
				loginframe.setVisible(true);
				dispose();
			}
		});

		//Handler for viewPatient button
		btnViewPatient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlUpdateRec.setVisible(false);
				pnlViewRec.setVisible(true);
				txtPatientRec.setVisible(false);
			}
		});

		//Handle when someone presses search on view patient record panel
		btnViewSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String username = txtViewSearch.getText();

				if(username.length() > 0)
				{
					if(loginInfo.getPatients().containsKey(username))
					{
						Patient p = loginInfo.getPatients().get(username);
						txtPatientRec.setText(p.getPatientRecord().toString());
					}
					else
					{
						txtPatientRec.setText("User not found");
					}
					txtPatientRec.setVisible(true);
				}
			}
		});

		//Handler for update record requst
		btnTreatPatient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pnlUpdateRec.setVisible(true);
				pnlViewRec.setVisible(false);
			}
		});

		//handler for updating the record button
		btnUpSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtViewSearch.getText();
				lblUpdateStat.setVisible(false);
				txtAmount.setVisible(false);
				btnAmount.setVisible(false);

				if(username.length() > 0)
				{
					if(loginInfo.getPatients().containsKey(username))
					{
						Patient p = loginInfo.getPatients().get(username);
						String diag = txtDiag.getText();
						String pres = txtPres.getText();

						if(diag.length()>0 && pres.length()>0)
						{
							PatientRecord pr = new PatientRecord(LocalTime.now(), diag, pres, docName);
							p.AddRecord(pr);
							txtAmount.setVisible(true);
							btnAmount.setVisible(true);
							
						}


					}
					else
					{
						lblUpdateStat.setText("User not found");
						lblUpdateStat.setVisible(true);
					}

				}
			}
		});
	}
}
