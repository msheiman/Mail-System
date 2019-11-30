package login_system;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LogGUI extends JFrame implements ActionListener{
	
	// TEXTFIELDs
	private JTextField trackingNumberTextField = new JTextField();
	private JTextField textField_1 = new JTextField();;
	private JTextField textField_2 = new JTextField();;
	private JTextField employeeFirstNameTextField = new JTextField();;
	private JTextField employeeLastNameTextField = new JTextField();;
	private JTextField employeeUsernameTextField = new JTextField();;
	private JTextField employeePasswordTextField = new JTextField();;
	private JTextField employeeEmailTextField = new JTextField();;
	
	// PANELs
	private JPanel mainLoginPanel = new JPanel();
	private JPanel employeeCreationPanel = new JPanel();
	private JPanel employeeLoginPanel = new JPanel();
	private JPanel rejectionPanel = new JPanel();
	
	// LABELs
	private JLabel trackingNumberLabel = new JLabel("Tracking Number");
	private JLabel employeeFirstNameLabel = new JLabel("First Name");
	private JLabel employeeLastNameLabel = new JLabel("Last Name");
	private JLabel employeeUsernameLabel = new JLabel("Username");
	private JLabel employeePasswordLabel = new JLabel("Password");
	private JLabel employeeEmailLabel = new JLabel("Email");
	private JLabel usernameLabel = new JLabel("Username");
	private JLabel passwordLabel = new JLabel("Password");
	private JLabel rejectionLabel = new JLabel("Incorrect username or password. Please try again");
	
	// BUTTONs
	private JButton loginButton = new JButton("Employee Login");
	private JButton searchButton = new JButton("Search");
	private JButton employeeSubmitButton = new JButton("Submit");
	private JButton employeeLoginButton = new JButton("Login");
	private JButton employeeCreationButton = new JButton("New Employee");
	private JButton rejectionConfirmationButton = new JButton("OK");
	
	// INSTANCE VARIABLEs
	
	/**
	 * CREATE LOGIN FRAME
	 * @param title : title of the frame
	 * Set bounds, size, close operation, etc.
	 * Call panel building methods to create panels
	 * Add panels to frame
	 */
	public LogGUI (String title) {
		super(title);
		//setBounds(100, 100, 879, 555);
		setSize(1005,415); //set the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default exit method
		
		buildMainLoginPanel();
		buildEmployeeLoginPanel();
		buildEmployeeCreationPanel();
		buildRejectionPanel();

		add(mainLoginPanel);
		add(employeeLoginPanel);
		add(employeeCreationPanel);
		add(rejectionPanel);
		
		setActionCommand(); //call action command method
		setVisible(true); //set frame to be visible
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

		mainLoginPanel.setBounds(0, 0, 863, 516);
		mainLoginPanel.setLayout(null);
		mainLoginPanel.setVisible(true);

		trackingNumberLabel.setBounds(10, 25, 126, 14);
		mainLoginPanel.add(trackingNumberLabel);

		trackingNumberTextField.setBounds(10, 50, 281, 20);
		mainLoginPanel.add(trackingNumberTextField);
		trackingNumberTextField.setColumns(10);
		
		
		searchButton.setBounds(301, 49, 89, 23);
		mainLoginPanel.add(searchButton);
		loginButton.setBounds(727, 482, 126, 23);
		mainLoginPanel.add(loginButton);
	
	}

	/**
	 * Method name: buildEmployeeLoginPanel
	 * Heading: public void buildEmployeeLoginPanel
	 * Description: build employee login panel
	 * Parameters: none
	 * Precondition: none
	 * Postcondition: components added to panel
	 * Throws list: none
	 */
	public void buildEmployeeLoginPanel() {
	
		employeeLoginPanel.setBounds(0, 0, 863, 516);
		employeeLoginPanel.setLayout(null);
		employeeLoginPanel.setVisible(false);
		
		usernameLabel.setBounds(20, 45, 100, 14);
		employeeLoginPanel.add(usernameLabel);

		textField_1.setBounds(20, 70, 200, 20);
		employeeLoginPanel.add(textField_1);
		textField_1.setColumns(10);	

		passwordLabel.setBounds(20, 115, 100, 14);
		employeeLoginPanel.add(passwordLabel);

		textField_2.setBounds(20, 140, 200, 20);
		employeeLoginPanel.add(textField_2);
		textField_2.setColumns(10);
		
		employeeLoginButton.setBounds(131, 171, 89, 23);
		employeeLoginPanel.add(employeeLoginButton);
		
		employeeCreationButton.setBounds(713, 482, 140, 23);
		employeeLoginPanel.add(employeeCreationButton);
	}
	
	/**
	 * Method name: buildEmployeeCreationPanel
	 * Heading: public void buildEmployeeCreationPanel
	 * Description: build Employee Creation panel where new employee can create new account
	 * Parameters: none
	 * Precondition: none
	 * Postcondition: panel with components added
	 * Throws list:none
	 */
	public void buildEmployeeCreationPanel() {
		
		employeeCreationPanel.setBounds(0, 0, 863, 516);
		employeeCreationPanel.setLayout(null);
		employeeCreationPanel.setVisible(false);
		
		
		employeeFirstNameLabel.setBounds(10, 11, 86, 14);
		employeeCreationPanel.add(employeeFirstNameLabel);
		
		
		employeeFirstNameTextField.setBounds(10, 36, 120, 20);
		employeeCreationPanel.add(employeeFirstNameTextField);
		employeeFirstNameTextField.setColumns(10);
	
		employeeLastNameLabel.setBounds(10, 67, 86, 14);
		employeeCreationPanel.add(employeeLastNameLabel);

		employeeLastNameTextField.setBounds(10, 92, 120, 20);
		employeeCreationPanel.add(employeeLastNameTextField);
		employeeLastNameTextField.setColumns(10);
		
		employeeUsernameLabel.setBounds(10, 123, 86, 14);
		employeeCreationPanel.add(employeeUsernameLabel);

		employeeUsernameTextField.setBounds(10, 148, 120, 20);
		employeeCreationPanel.add(employeeUsernameTextField);
		employeeUsernameTextField.setColumns(10);

		employeePasswordLabel.setBounds(10, 179, 86, 14);
		employeeCreationPanel.add(employeePasswordLabel);

		employeePasswordTextField.setBounds(10, 204, 120, 20);
		employeeCreationPanel.add(employeePasswordTextField);
		employeePasswordTextField.setColumns(10);

		employeeEmailLabel.setBounds(10, 235, 86, 14);
		employeeCreationPanel.add(employeeEmailLabel);

		employeeEmailTextField.setBounds(10, 260, 120, 20);
		employeeCreationPanel.add(employeeEmailTextField);
		employeeEmailTextField.setColumns(10);

		employeeSubmitButton.setBounds(10, 291, 89, 23);
		employeeCreationPanel.add(employeeSubmitButton);
	}
	
	/**
	 * Method name: buildRejectionPanel
	 * Heading: public void buildRejectionPanel
	 * Description: build rejection panel where it displays the error message to user
	 * 				when they entered wrong credentials of account
	 * Parameters: none
	 * Precondition: none
	 * Postcondition: panel with components added
	 * Throws list: none
	 */
	public void buildRejectionPanel() {
		
		rejectionPanel.setBounds(0, 0, 863, 516);
		rejectionPanel.setLayout(null);
		rejectionPanel.setVisible(false);

		rejectionLabel.setBounds(310, 11, 243, 14);
		rejectionPanel.add(rejectionLabel);

		rejectionConfirmationButton.setBounds(374, 34, 89, 23);
		rejectionPanel.add(rejectionConfirmationButton);
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
		
		loginButton.addActionListener(this);
		loginButton.setActionCommand("Employee Login");
		
		searchButton.addActionListener(this);
		searchButton.setActionCommand("Search");

		employeeSubmitButton.addActionListener(this);
		employeeSubmitButton.setActionCommand("Submit");
		
		employeeLoginButton.addActionListener(this);
		employeeLoginButton.setActionCommand("Login");
		
		employeeCreationButton.addActionListener(this);
		employeeCreationButton.setActionCommand("New Employee");
		
		rejectionConfirmationButton.addActionListener(this);
		rejectionConfirmationButton.setActionCommand("OK");
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
		if (action.equals("Search")){
			@SuppressWarnings("unused")
			String trackingNumber = trackingNumberTextField.getText();
		}
		else if (action.equals("New Employee")) {
			
		}
		else if (action.equals("Submit")) {
			Employee employee = new Employee(employeeFirstNameTextField.getText(), employeeLastNameTextField.getText(),
					employeeEmailTextField.getText(), employeeUsernameTextField.getText(),
					employeePasswordTextField.getText());
			//Driver.list.addTail(employee);
			employeeCreationPanel.setVisible(false);
		}
		else if (action.equals("Employee Login")) {
			employeeLoginPanel.setVisible(true);
		}
		else if (action.equals("OK")) {
			
		}
		else if (action.equals("Login")) {
			
		}
	}
}
