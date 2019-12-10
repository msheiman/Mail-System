package login_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Mail_Bag.Customer;
import Mail_Bag.Mail;

@SuppressWarnings("serial")
public class WelcomeGUI extends JFrame implements ActionListener {
	//Panels
	private JPanel welcomePanel = new JPanel();
	private JPanel trackingPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
		
	//Buttons
	private JButton trackBtn = new JButton("Track");
	private JButton loginBtn = new JButton("Log In");
	private JButton cancelBtn = new JButton("Cancel");
		
	//Font
	private Font font = new Font("Times new Roman", Font.BOLD, 54);
		
	//TextPane
	private JTextPane textPane = new JTextPane();
	
	//TextField
	private JTextField trackingNumber = new JTextField(15);
	
	/**
	 * Method name: Welcome()
	 * Heading: public WelcomeGUI(String title)
	 * Description: to create the frame of the GUI
	 * Parameters: String title
	 * Precondition: the frame is called
	 * Postcondition: creates the frame
	 * Throws list: N/A
	 */
	public WelcomeGUI(String title) {
		super(title);
		setSize(550,430); //set size of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildPanel();
		buildTrackPanel();
		buildButtonPanel();
		
		add(welcomePanel, BorderLayout.NORTH);
		add(trackingPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setActionCommand();
		setVisible(true);
	}

	/**
	 * Method name: centeringText()
	 * Heading: public void centeringText()
	 * Description: to set the text at the center of the pane
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: centers the text
	 * Throws list: BadLocationexception e
	 */
	public void centeringText() {
		SimpleAttributeSet attrs = new SimpleAttributeSet();
	    StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
	    StyledDocument doc = (StyledDocument) textPane.getDocument();
	    try {
			doc.insertString(0,"\nWELCOME\nto\nMNS Mail Service\n",attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	        doc.setParagraphAttributes(0,doc.getLength()-1,attrs,false);
	}
		
	/**
	 * Method name: buildPanel()
	 * Heading: public void buildPanel()
	 * Description: to build panel consisting of JTextPane
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: builds the panel
	 * Throws list: none
	 */
	public void buildPanel() {
		textPane.setFont(font); // set font
		textPane.setForeground(Color.red);
		textPane.setBackground(Color.white);
		textPane.setEditable(false); //set the pane uneditable
		centeringText(); //call centering method
		welcomePanel.add(textPane); //add pane to panel
		welcomePanel.setBackground(Color.white);
	}
	
	/**
	 * Method name: buildTrackPanel
	 * Heading: public void buildTrackPanel()
	 * Description: build the panel consisting of field for user 
	 * 				to enter the tracking number to track their mails
	 * Parameters: none
	 * Precondition: when it's called
	 * Postcondition: panel is built
	 * Throws list: none
	 */
	public void buildTrackPanel() {
		trackingPanel.setLayout(new FlowLayout());	
		trackingPanel.add(trackingNumber);
		trackingPanel.add(trackBtn);
	}
	
	/**
	 * Method name: buildButtonPanel()
	 * Heading: public void buildButtonPanel()
	 * Description: to build the panel consisting of buttons
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: builds button panel
	 * Throws list: none
	 */
	public void buildButtonPanel() {
		buttonPanel.setLayout(new FlowLayout()); //use flowLayout 
		//add components to panel
		buttonPanel.add(loginBtn);
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
		trackBtn.addActionListener(this);
		trackBtn.setActionCommand("Track");
		
		loginBtn.addActionListener(this);
		loginBtn.setActionCommand("Log In");
		
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
		
		// If user chooses "Track", checj if entered tracking number is 10 digits
		// and first 2 characters are "MS"
		// display error message if it not correctly entered
		if (action.equals("Track")) {
			char char1 = String.valueOf(trackingNumber.getText().trim()).charAt(0);
			char char2 = String.valueOf(trackingNumber.getText().trim()).charAt(0);
			if (String.valueOf(trackingNumber.getText().trim()) == null){
				JOptionPane.showMessageDialog(trackingPanel, "Please Enter Tracking Number\nto Track Your Mail", 
						"Error Message Box", JOptionPane.ERROR_MESSAGE );
			}
			else if (String.valueOf(trackingNumber.getText().trim()).length() != 10) {
				JOptionPane.showMessageDialog(trackingPanel, "Invalid Tracking Number\nPlease Enter Again", 
						"Error Message Box", JOptionPane.ERROR_MESSAGE );
				trackingNumber.setText("");
			}
			else if(char1!='M' || char2!='S') {
				JOptionPane.showMessageDialog(trackingPanel, "Invalid Tracking Number\nPlease Enter Again", 
						"Error Message Box", JOptionPane.ERROR_MESSAGE );
				trackingNumber.setText("");
			}
			
			// if it correct, read the mail and go through all tracking number
			// if it is found, display status of that mail
			// otherwise, display error message
			else {
				String track = trackingNumber.getText().trim();
				ArrayList<Mail> list = readCSV("Mail-System/src/Mail_Bag/MailList.csv");
				for (Mail i : list) {
					if (track.equals(i.getTrackingNumber())) {
						JOptionPane.showMessageDialog(trackingPanel, "Your mail is:" + i.getStatus());
					}
					else {
						JOptionPane.showMessageDialog(trackingPanel, "Couldn't find mail based on\nentered tracking number", 
								"Error Message Box", JOptionPane.ERROR_MESSAGE );
						trackingNumber.setText("");
					}
				}
			}
		}
		//if user choose log in, open logGUI and dispose current frame
		else if (action.equals("Log In")) {
			@SuppressWarnings("unused")
			LogGUI newFrame = new LogGUI("Employee Login Page");
			dispose(); //remove the current frame
		}
		//If the user chooses cancel, exit program
		else if (action.equals("Cancel")) {
			System.exit(0);
		}
	}
	
	
	//Method reads every line in file to arraylist
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
		
		//Method creates Product object by taking every item 
		//in arraylist to assign to intance variables
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
		

	
	//Main method
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		WelcomeGUI frame = new WelcomeGUI("MNS MAIL SERVICE");
	}
}
