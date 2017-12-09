package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Room;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NursePage extends JFrame {

	private JPanel contentPane;
	private JLabel lblRoomName;
	private JTextField txtEnterRoom;
	private JButton btnBookRoom;
	private JButton btnReleaseRoom;
	private JLabel lblMessage;
	private Room r;

	public NursePage(Room r) {
		this.r=r;
		initComponents();
		createEvents();	
	}
	
	
	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRoomName = new JLabel("Room Name:");
		lblRoomName.setBounds(49, 43, 91, 16);
		contentPane.add(lblRoomName);
		
		txtEnterRoom = new JTextField();
		txtEnterRoom.setText("Enter Room");
		txtEnterRoom.setBounds(152, 40, 116, 22);
		contentPane.add(txtEnterRoom);
		txtEnterRoom.setColumns(10);
		
		btnBookRoom = new JButton("Book Room");
		
		btnBookRoom.setBounds(76, 101, 97, 25);
		contentPane.add(btnBookRoom);
		
		btnReleaseRoom = new JButton("Make Available");
		
		btnReleaseRoom.setBounds(236, 101, 133, 25);
		contentPane.add(btnReleaseRoom);
		
		lblMessage = new JLabel("Message");
		lblMessage.setBounds(49, 188, 320, 16);
		contentPane.add(lblMessage);
	}
	
	private void createEvents()
	{
		btnBookRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room r= new Room();
				String roomname=txtEnterRoom.getText();
				if(r.room.contains(roomname))
				{
					r.bookRoom(roomname);
					lblMessage.setText("Room booked");
					lblMessage.setForeground(Color.GREEN);
				}
				else
				{
					lblMessage.setText("Room not found");
					lblMessage.setForeground(Color.RED);
					
				}
			}
		});
		
		btnReleaseRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomname=txtEnterRoom.getText();
				if(r.room.contains(roomname))
				{
					r.makeRoomAvailable(roomname);
					lblMessage.setText("Room available now!");
					lblMessage.setForeground(Color.GREEN);
				}
				else
				{
					lblMessage.setText("Room not found");
					lblMessage.setForeground(Color.RED);
					
				}			
				
			}
		});
	}
	

}
