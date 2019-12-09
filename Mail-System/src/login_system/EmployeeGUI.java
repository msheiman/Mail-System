package login_system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Customer_List.Customer;
import Mail_Bag.Mail;
import Mail_Bag.MailCollection;

public class EmployeeGUI extends JFrame implements ActionListener {
	
	private TitledBorder addBorder = new TitledBorder("Add New Mail");
	private TitledBorder editBorder = new TitledBorder("Edit Mail");
	
	private JLabel customerInfoLbl = new JLabel("Customer Information", SwingConstants.LEFT);
	private JLabel firstNameLbl = new JLabel("First Name", SwingConstants.CENTER);
	private JLabel lastNameLbl = new JLabel("Last Name", SwingConstants.CENTER);
	private JLabel houseNumberLbl = new JLabel("House Number", SwingConstants.CENTER);
	private JLabel streetLbl = new JLabel("Street", SwingConstants.CENTER);
	private JLabel cityLbl = new JLabel("City", SwingConstants.CENTER);
	private JLabel stateLbl = new JLabel("State", SwingConstants.CENTER);
	private JLabel zipLbl = new JLabel("Zipcode",SwingConstants.CENTER);
	private JLabel mailInfoLbl = new JLabel("Mail Info", SwingConstants.LEFT);
	private JLabel weightLbl = new JLabel("Weight",SwingConstants.CENTER);
	private JLabel poundsLbl = new JLabel("pounds", SwingConstants.LEFT);
	private JLabel statusLbl = new JLabel("Status", SwingConstants.CENTER);
	
	private JTextField firstNameTxt = new JTextField();
	private JTextField lastNameTxt = new JTextField();
	private JTextField houseNumberTxt = new JTextField();
	private JTextField streetTxt = new JTextField();
	private JTextField cityTxt = new JTextField();
	private JTextField stateTxt = new JTextField();
	private JTextField zipTxt = new JTextField();
	private JTextField weightTxt = new JTextField();
	
	String[] statusList = {"Posted", "Processing", "In Transit", "Out for Delivery", "Delivered"};
	private JComboBox <String> statusBox = new JComboBox<>(statusList);
	
	private JPanel infoPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	private JButton addBtn = new JButton("Add New");
	private JButton addAnotherBtn = new JButton("Add Another");
	private JButton resetBtn = new JButton("Reset");
	private JButton cancelBtn = new JButton("Cancel");
	
	public EmployeeGUI(String title) {
		super(title);
		setSize(400,200); //set the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default exit method
		
		buildInfoPanel();
		buildButtonPanel();
		
		add(infoPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setActionCommand(); //call action command method
		setVisible(true); //set frame to be visible
	}

	public void buildInfoPanel() {
		infoPanel.setLayout(new GridLayout(8,4));
		infoPanel.setBorder(addBorder);
		infoPanel.add(customerInfoLbl);
		infoPanel.add(new JLabel());
		infoPanel.add(new JLabel());
		infoPanel.add(new JLabel());
		
		infoPanel.add(firstNameLbl);
		infoPanel.add(firstNameTxt);
		infoPanel.add(lastNameLbl);
		infoPanel.add(lastNameTxt);
		
		infoPanel.add(houseNumberLbl);
		infoPanel.add(houseNumberTxt);
		infoPanel.add(streetLbl);
		infoPanel.add(streetTxt);
		
		infoPanel.add(cityLbl);
		infoPanel.add(cityTxt);
		infoPanel.add(stateLbl);
		infoPanel.add(stateTxt);
		
		infoPanel.add(zipLbl);
		infoPanel.add(zipTxt);
		infoPanel.add(new JLabel());
		infoPanel.add(new JLabel());
		
		infoPanel.add(mailInfoLbl);
		infoPanel.add(new JLabel());
		infoPanel.add(new JLabel());
		infoPanel.add(new JLabel());
		
		infoPanel.add(weightLbl);
		infoPanel.add(weightTxt);
		infoPanel.add(poundsLbl);
		infoPanel.add(new JLabel());
		
		infoPanel.add(statusLbl);
		infoPanel.add(statusBox);
		infoPanel.add(new JLabel());
		infoPanel.add(new JLabel());
	}
	
	public void buildButtonPanel() {
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(addBtn);
		buttonPanel.add(addAnotherBtn);
		buttonPanel.add(resetBtn);
		buttonPanel.add(cancelBtn);
	}
	
	private void setActionCommand() {
		addBtn.addActionListener(this);
		addBtn.setActionCommand("Add New");
		
		addAnotherBtn.addActionListener(this);
		addAnotherBtn.setActionCommand("Add Another");
		
		resetBtn.addActionListener(this);
		resetBtn.setActionCommand("Reset");
		
		cancelBtn.addActionListener(this);
		cancelBtn.setActionCommand("Cancel");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if(action.equals("Add New")) {
			Mail mail1 = new Mail(Double.valueOf(weightTxt.getText()), String.valueOf(statusBox.getSelectedItem()));
			MailCollection mailBox = new MailCollection(20);
			Customer customer1 = new Customer(firstNameTxt.getText().trim(), lastNameTxt.getText().trim(), 
					Integer.valueOf(houseNumberTxt.getText().trim()), streetTxt.getText().trim(), 
					cityTxt.getText().trim(),stateTxt.getText().toUpperCase().trim(), 
					Integer.valueOf(zipTxt.getText().trim()), mailBox);
			mailBox.push(mail1);
		}
		else if (action.equals("Add Another")) {
			weightTxt.setText("");
		}
		else if (action.equals("Reset")) {
			firstNameTxt.setText("");
			lastNameTxt.setText("");
			houseNumberTxt.setText("");
			streetTxt.setText("");
			cityTxt.setText("");
			stateTxt.setText("");
			zipTxt.setText("");
			weightTxt.setText(""); 
		}
		else if (action.equals("Cancel")) {
			dispose();
		}
		
	}
}
