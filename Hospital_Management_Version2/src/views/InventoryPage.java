package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import common.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class InventoryPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtItem;
	private JFormattedTextField txtQuan;
	private JButton btnDel;
	private JButton btnAdd;
	private JLabel lblItemName;
	private JLabel lblQuantity;
	private JLabel lblInventoryList;
	private JButton btnView;

	private Inventory inv;
	private JLabel lblMessage;
	private JTextArea txtInv;

	public InventoryPage(Inventory inv) {
		this.inv = inv;
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 865, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblInventoryList = new JLabel("Inventory list: ");
		lblInventoryList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInventoryList.setBounds(55, 28, 170, 32);
		contentPane.add(lblInventoryList);

		btnView = new JButton("View Inventory");

		btnView.setBounds(654, 33, 145, 25);
		contentPane.add(btnView);

		btnAdd = new JButton("Add item");

		btnAdd.setBounds(55, 505, 97, 25);
		contentPane.add(btnAdd);

		txtItem = new JTextField();
		txtItem.setBounds(55, 444, 116, 22);
		contentPane.add(txtItem);
		txtItem.setColumns(10);

		lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(183, 447, 186, 16);
		contentPane.add(lblItemName);


		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		// If you want the value to be committed on each keystroke instead of focus lost
		formatter.setCommitsOnValidEdit(true);

		txtQuan = new JFormattedTextField(formatter);
		txtQuan.setBounds(55, 470, 116, 22);
		contentPane.add(txtQuan);
		txtQuan.setColumns(10);



		lblQuantity = new JLabel("quantity");
		lblQuantity.setBounds(183, 473, 56, 16);
		contentPane.add(lblQuantity);

		btnDel = new JButton("delete item");

		btnDel.setBounds(164, 505, 97, 25);
		contentPane.add(btnDel);

		lblMessage = new JLabel("");
		lblMessage.setBounds(55, 543, 591, 16);
		contentPane.add(lblMessage);
		
		txtInv = new JTextArea();
		txtInv.setBounds(34, 75, 788, 343);
		contentPane.add(txtInv);
	}

	private void createEvents()
	{
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemName = txtItem.getText();
				int quan = Integer.parseInt(txtQuan.getText());

				if(itemName.length() > 0 && quan > 0)
				{
					if(inv.inventory.containsKey(itemName))
					{

						lblMessage.setText("Item already exists");
						lblMessage.setForeground(Color.RED);
					}
					else 
					{
						inv.addInventoryRecords(itemName, quan);
						lblMessage.setForeground(Color.GREEN);
						lblMessage.setText("Item added succesfully");
						txtInv.setText(inv.toString());
						txtInv.setEditable(false);
					}
				}

			}
		});

		//delete item from inventory
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemName = txtItem.getText();
				int quan = Integer.parseInt(txtQuan.getText());
				if(itemName.length() > 0 && quan > 0)
				{
					if(inv.inventory.containsKey(itemName))
					{
						inv.deleteInventoryRecords(itemName, quan);
						lblMessage.setText("Item deleted succesfully");
						lblMessage.setForeground(Color.GREEN);
						txtInv.setText(inv.toString());
						txtInv.setEditable(false);
					}
					else
					{
						lblMessage.setText("Item not found");
						lblMessage.setForeground(Color.RED);
					}
				}

			}
		});

		//view inventory button
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtInv.setText(inv.toString());
				txtInv.setEditable(false);
			}
		});
	}
}
