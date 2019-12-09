package login_system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Mail_Bag.Customer;
import Mail_Bag.Mail;
import Mail_Bag.SortByHouseNumber;
import Mail_Bag.SortByZipcode;


public class EmployeeGUI extends JFrame implements ActionListener {
	
	private TitledBorder addBorder = new TitledBorder("Add New Mail");
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
	
	private JButton addBtn = new JButton("Add");
	private JButton routeBtn = new JButton("Generate List");
	private JButton resetBtn = new JButton("Reset");
	private JButton cancelBtn = new JButton("Cancel");
	
	static ArrayList<Mail> sortedList = new ArrayList<>();
	
	/**
	 * Method name: EmployeeGUI()
	 * Heading: public EmployeeGUI(String title)
	 * Description: to create the frame of the GUI
	 * Parameters: String title
	 * Precondition: the frame is called
	 * Postcondition: creates the frame
	 * Throws list: N/A
	 */
	public EmployeeGUI(String title) {
		super(title);
		setSize(600,400); //set the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default exit method
		
		buildInfoPanel();
		buildButtonPanel();
		
		add(infoPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setActionCommand(); //call action command method
		setVisible(true); //set frame to be visible
	}

	/**
	 * Method name: buildInfoPanel()
	 * Heading: public void buildInfoPanel()
	 * Description: to create the info panel of the GUI
	 * Parameters: none
	 * Precondition: the info panel is called
	 * Postcondition: creates the panel
	 * Throws list: N/A
	 */
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
	
	/**
	 * Method name: buildInfoPanel()
	 * Heading: public void buildInfoPanel()
	 * Description: to create the info panel of the GUI
	 * Parameters: none
	 * Precondition: the info panel is called
	 * Postcondition: creates the panel
	 * Throws list: N/A
	 */
	public void buildButtonPanel() {
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(addBtn);
		buttonPanel.add(resetBtn);
		buttonPanel.add(routeBtn);
		buttonPanel.add(cancelBtn);
	}
	
	/**
	 * Method name: setActionCommand()
	 * Heading: private void setActionCommand()
	 * Description: to set action command for buttons
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: creates action commands
	 * Throws list: none
	 */
	private void setActionCommand() {
		addBtn.addActionListener(this);
		addBtn.setActionCommand("Add");
		
		routeBtn.addActionListener(this);
		routeBtn.setActionCommand("Generate List");
		
		resetBtn.addActionListener(this);
		resetBtn.setActionCommand("Reset");
		
		cancelBtn.addActionListener(this);
		cancelBtn.setActionCommand("Cancel");
	}
	
	/**
	 * Method name: actionPerformed()
	 * Heading: public void actionPerformed(ActionEvent e)
	 * Description: to perform action selected
	 * Parameters: ActionEvent e
	 * Precondition: if action is continue
	 * Postcondition: calls newFrame
	 * Throws list: none
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if(action.equals("Add")) {
			Customer customer1 = new Customer(firstNameTxt.getText().trim(), lastNameTxt.getText().trim(), 
					Integer.valueOf(houseNumberTxt.getText().trim()), streetTxt.getText().trim(), 
					cityTxt.getText().trim(),stateTxt.getText().toUpperCase().trim(), 
					Integer.valueOf(zipTxt.getText().trim()));
			Mail mail1 = new Mail(Double.valueOf(weightTxt.getText()), String.valueOf(statusBox.getSelectedItem()), customer1);
			writeCSV(mail1);
			
			firstNameTxt.setText("");
			lastNameTxt.setText("");
			houseNumberTxt.setText("");
			streetTxt.setText("");
			cityTxt.setText("");
			stateTxt.setText("");
			zipTxt.setText("");
			weightTxt.setText(""); 
		}
		else if (action.equals("Generate List")) {
			ArrayList<Mail> list = readCSV("Mail-System/src/Mail_Bag/MailList.csv");
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(infoPanel, "List is Empty!","Warning", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Collections.sort(list, new SortByZipcode());
				Collections.sort(list, new SortByHouseNumber());
				sortedList = list;
				new DisplayGUI("Display to Console");
			}
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

	//Method reads every line in file to arraylist
	/**
	 * Method name: readCSV()
	 * Heading: public static ArrayList<Mail> readCSV(String fileName)
	 * Description: to create an arrayList of the mail
	 * Parameters: none
	 * Precondition: read the filee
	 * Postcondition: returns mails
	 * Throws list: IOException e
	 */
	private static ArrayList<Mail> readCSV(String fileName){
		ArrayList<Mail> mails = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine(); //read every line
			while(line != null) {
				String[] attributes = line.split(","); //remove delimiter
				Mail mail = createMail(attributes); //create a Product object
				mails.add(mail); //add item to arraylist
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mails;	
	}
		
	/**
	 * Method name: createMail()
	 * Heading: private static Mail createMail
	 * Description: to creates Product object by taking every item
	 * Parameters: String[] data
	 * Precondition: is called
	 * Postcondition: returns new Mail(weight, trackingNumber, status, customer)
	 * Throws list: N/A
	 */
	private static Mail createMail(String[] data) {
		double weight = Double.parseDouble(data[0]);
		String trackingNumber = data[1];
		String status = data[2];
		String first = data [3];
		String last = data[4];
		int houseNum = Integer.parseInt(data[5]);
		String street = data[6];
		String city = data[7];
		String state = data[8];
		int zip = Integer.parseInt(data[9]);
		Customer customer = new Customer (first, last, houseNum, street, city, state, zip);
			
		return new Mail (weight, trackingNumber, status, customer);
	}
		
	/**
	 * Method name: writeCSV()
	 * Heading: public void writeCSV(Mail m)
	 * Description: to writes sorted arrayList to a file
	 * Parameters: Mail
	 * Precondition: attempts to read file
	 * Postcondition: appends items to file
	 * Throws list: Exception e
	 		IOException e
	 */
	public void writeCSV(Mail m) {
		BufferedWriter fileIn = null; //declare a file
		try {
			fileIn = new BufferedWriter( new FileWriter("Mail-System/src/Mail_Bag/MailList.csv", true)); //create new file
				//Write each item in arrayList into file
				
			fileIn.append(String.valueOf(m.getWeight()));
			fileIn.append(",");
			fileIn.append(m.getTrackingNumber());
			fileIn.append(",");
			fileIn.append(m.getStatus());
			fileIn.append(",");
			fileIn.append(m.getCustomer().getFirstName());
			fileIn.append(",");
			fileIn.append(m.getCustomer().getLastName());
			fileIn.append(",");
			fileIn.append(String.valueOf(m.getCustomer().getHouseNum()));
			fileIn.append(",");
			fileIn.append(m.getCustomer().getStreet());
			fileIn.append(",");
			fileIn.append(m.getCustomer().getCity());
			fileIn.append(",");
			fileIn.append(m.getCustomer().getState());
			fileIn.append(",");
			fileIn.append(String.valueOf(m.getCustomer().getZipcode()));
			fileIn.append("\n");
			
			fileIn.close(); //Close file
		} catch (IOException e) {
			e.printStackTrace();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
