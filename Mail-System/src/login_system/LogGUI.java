package login_system;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Employee_System.Employee;
import Employee_System.EmployeeList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LogGUI extends JFrame implements ActionListener{
	
	// TEXTFIELDs
	private JTextField usernameInput = new JTextField();
	
	
	// PANELs
	private JPanel panel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel mainLoginPanel = new JPanel();
	
	// LABELs
	private JLabel usernameLabel = new JLabel("Username", SwingConstants.CENTER);
	private JLabel passwordLabel = new JLabel("Password", SwingConstants.CENTER);
	
	// BUTTONs
	private JButton createAccountBtn = new JButton("Create Account");
	private JButton loginBtn = new JButton("Log In");
	private JButton cancelBtn = new JButton("Cancel");
	
	private JTextPane loginTitle = new JTextPane();
	
	// FONT
	private Font font = new Font("Calibri", Font.BOLD, 40);

	// PASSWORD FIELD
	private JPasswordField passwordInput = new JPasswordField();
	
	
	/**
	 * CREATE LOGIN FRAME
	 * @param title : title of the frame
	 * Set bounds, size, close operation, etc.
	 * Call panel building methods to create panels
	 * Add panels to frame
	 */
	public LogGUI (String title) {
		super(title);
		setSize(400,200); //set the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default exit method
		
		buildPanel();
		buildMainLoginPanel();
		buildButtonPanel();

		add(panel, BorderLayout.NORTH);
		add(mainLoginPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		//add(employeeLoginPanel);
		//add(employeeCreationPanel);
		//add(rejectionPanel);
		
		setActionCommand(); //call action command method
		setVisible(true); //set frame to be visible
	}
	
	public void buildPanel() {
		loginTitle.setFont(font);
		loginTitle.setEditable(false);
		centeringText();
		panel.add(loginTitle);
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
	private void centeringText() {
		SimpleAttributeSet attrs = new SimpleAttributeSet();
	    StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
	    StyledDocument doc = (StyledDocument) loginTitle.getDocument();
	    try {
			doc.insertString(0,"MNS Employee",attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	        doc.setParagraphAttributes(0,doc.getLength()-1,attrs,false);
	}

	/**
	 * Method name: buildMainLoginPanel
	 * Heading: public void buildMainLoginPanel
	 * Description: build main Login panel allowing both employee and customer to operate
	 * Parameters: none
	 * Precondition: none
	 * Postcondition: components added to panel
	 * Throws list: none
	 */
	public void buildMainLoginPanel() {
		mainLoginPanel.setLayout(new GridLayout(2,2));
		mainLoginPanel.add(usernameLabel);
		mainLoginPanel.add(usernameInput);
		mainLoginPanel.add(passwordLabel);
		mainLoginPanel.add(passwordInput);
	}

	public void buildButtonPanel() {
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(createAccountBtn);
		buttonPanel.add(loginBtn);
		buttonPanel.add(cancelBtn);
	}
	
	/**
	 * Method name: setActionCommand
	 * Heading: public void setActionCommand
	 * Description: set command for buttons
	 * Parameters: none
	 * Precondition: none
	 * Postcondition: commands set to buttons
	 * Throws list: none
	 */
	public void setActionCommand() {
		createAccountBtn.addActionListener(this);
		createAccountBtn.setActionCommand("Create Account");
		
		loginBtn.addActionListener(this);
		loginBtn.setActionCommand("Log In");
		
		cancelBtn.addActionListener(this);
		cancelBtn.setActionCommand("Cancel");
	}
	
	/**
	 * Method name: actionPerformed
	 * Heading: public void actionPerformed
	 * Description: set specific performance to each button under command
	 * Parameters: e - command clicked to for operation
	 * Precondition: none
	 * Postcondition: action performed
	 * Throws list: none
	 */
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if (action.equals("Create Account")) {
			new CreateAccountGUI("New Employee");
		}
		else if (action.equals("Log In")) {	
			String passwordEntered = new String (passwordInput.getPassword());
			Token login = new Token(usernameInput.getText(), passwordEntered);
			EmployeeList employeeList = readCSV("Mail-System/src/Employee_System/EmployeeSystem.csv");
			Authenticator check = new Authenticator(login, employeeList);
			if (check.authenticate()) {
				new driverGUI("Driver Page");
				dispose();
			} 
			else {
				JOptionPane.showMessageDialog(mainLoginPanel, "Invalid Username or Password!",
						"Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if (action.equals("Cancel")) {
			dispose();
		}
	}
	
	/**
	 * Method name: creat()
	 * Heading: public void creatFile 
	 * Description: fileIn is a writer
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: creates fileIn
	 * Throws list: IOException e
	 */
	@SuppressWarnings("resource")
	public void creatFile() {
		try {
			new BufferedWriter(new FileWriter("Mail-System/src/Employee_System/EmployeeSystem.csv", true));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method name: readCSV()
	 * Heading: private static EmployeeList readCSV(String fileName) 
	 * Description: to reads CSV
	 * Parameters: String fileName
	 * Precondition: is called
	 * Postcondition: returns EmployeeList list
	 * Throws list: IOException e
	 */
	private static EmployeeList readCSV(String fileName){
		
		System.out.print(fileName);
		EmployeeList list = new EmployeeList();
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine(); //read every line
			while(line != null) {
				String[] attributes = line.split(","); //remove delimiter
				Employee employee = createEmployee(attributes); //create a Product object
				list.add(employee); //add item to linked list
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	/**
	 * Method name: createEmployee()
	 * Heading: createEmployee(String[] data)
	 * Description: to sets and returns Employee
	 * Parameters: String[] data
	 * Precondition: is called
	 * Postcondition: returns new Employee(firstName, lastName, email, username, password)
	 * Throws list: N/A
	 */
	private static Employee createEmployee(String[] data) {
		String firstName = data[0];
		String lastName = data[1];
		String email = data[2];
		String username = data[3];
		String password = data[4];
		return new Employee(firstName, lastName, email, username, password);
	}
}
