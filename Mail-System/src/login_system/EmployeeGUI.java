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


@SuppressWarnings("serial")
public class EmployeeGUI extends JFrame implements ActionListener {
	
	//TITLED BORDER
	private TitledBorder addBorder = new TitledBorder("Add New Mail");
	
	//LABELS
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
	
	//TEXT FIELDS
	private JTextField firstNameTxt = new JTextField();
	private JTextField lastNameTxt = new JTextField();
	private JTextField houseNumberTxt = new JTextField();
	private JTextField streetTxt = new JTextField();
	private JTextField cityTxt = new JTextField();
	private JTextField stateTxt = new JTextField();
	private JTextField zipTxt = new JTextField();
	private JTextField weightTxt = new JTextField();
	
	//COMBO BOX
	String[] statusList = {"Posted", "Processing", "In Transit", "Out for Delivery", "Delivered"};
	private JComboBox <String> statusBox = new JComboBox<>(statusList);
	
	//PANELS
	private JPanel infoPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	//BUTTONS
	private JButton addBtn = new JButton("Add");
	private JButton routeBtn = new JButton("Generate List");
	private JButton resetBtn = new JButton("Reset");
	private JButton cancelBtn = new JButton("Cancel");
	
	//ARRAYLIST
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
		
		//build panel
		buildInfoPanel();
		buildButtonPanel();
		
		//add panel to frame at specific positions
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
		//set layout of panel to grid layout to grid layout with 8 rows and 4 columns
		infoPanel.setLayout(new GridLayout(8,4));
		
		//set titled border to panel
		infoPanel.setBorder(addBorder);
		
		//Add components to panel
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
		//set layout of panel to flow layout
		buttonPanel.setLayout(new FlowLayout());
		
		//add components to panel
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
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		//if user clicks add, create Customer instance, Mail object
		//write mail to a CSV file name MailList
		if(action.equals("Add")) {
			if (firstNameTxt.getText().trim() == "" || lastNameTxt.getText().trim() == "" || 
					houseNumberTxt.getText().trim() == ""|| streetTxt.getText().trim() == ""|| 
					cityTxt.getText().trim() == "" || stateTxt.getText().toUpperCase().trim() == ""|| 
					zipTxt.getText().trim() == ""){
				JOptionPane.showMessageDialog(infoPanel, "Information is missing!","Warning",
						JOptionPane.WARNING_MESSAGE);
			}
			else if (zipTxt.getText().trim().length()!= 5) {
				JOptionPane.showMessageDialog(infoPanel, "Zipcode is invalid!","Warning",
						JOptionPane.WARNING_MESSAGE);
			}
			Customer customer1 = new Customer(firstNameTxt.getText().trim(), lastNameTxt.getText().trim(), 
					Integer.valueOf(houseNumberTxt.getText().trim()), streetTxt.getText().trim(), 
					cityTxt.getText().trim(),stateTxt.getText().toUpperCase().trim(), 
					Integer.valueOf(zipTxt.getText().trim()));
			Mail mail1 = new Mail(Double.valueOf(weightTxt.getText()), String.valueOf(statusBox.getSelectedItem()), customer1);
			writeCSV(mail1);
			
			//Set all the text to blank
			firstNameTxt.setText("");
			lastNameTxt.setText("");
			houseNumberTxt.setText("");
			streetTxt.setText("");
			cityTxt.setText("");
			stateTxt.setText("");
			zipTxt.setText("");
			weightTxt.setText(""); 
		}
		
		// if user clicks Generate list, read the MailList.csv
		// if list is empty, show message box
		// otherwise, sort list by zipcode then by house number
		//create new GUI to display the list
		else if (action.equals("Generate List")) {
			ArrayList<Mail> list = readCSV("Mail-System/src/Mail_Bag/MailList.csv");
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(infoPanel, "List is Empty!","Warning", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Collections.sort(list, new SortByZipcode());
				new DisplayGUI("Display to Console");
			}
		}
		//if user clicks reset, set all the texts to blank
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
		//exit program if user clicks cancel
		else if (action.equals("Cancel")) {
			System.exit(0);
		}
	}
	
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
			@SuppressWarnings("resource")
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
	 * Postcondition: return created Mail object
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
