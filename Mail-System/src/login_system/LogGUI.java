package login_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogGUI {

	private JFrame frame;
	
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
	private JLabel rejectionLabel = new JLabel("Incorrect username or password.  Please try again");
	
	// BUTTONs
	private JButton loginButton = new JButton("Employee Login");
	private JButton searchButton = new JButton("Search");
	private JButton employeeSubmitButton = new JButton("Submit");
	private JButton employeeLoginButton = new JButton("Login");
	private JButton employeeCreationButton = new JButton("New Employee");
	private JButton rejectionConfirmationButton = new JButton("Ok");
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogGUI window = new LogGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 879, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JPanel mainLoginPanel = new JPanel();
		mainLoginPanel.setBounds(0, 0, 863, 516);
		frame.getContentPane().add(mainLoginPanel);
		mainLoginPanel.setLayout(null);
		mainLoginPanel.setVisible(true);
		
		//JLabel trackingNumberLabel = new JLabel("Tracking Number");
		trackingNumberLabel.setBounds(10, 25, 126, 14);
		mainLoginPanel.add(trackingNumberLabel);
		
		//trackingNumberTextField = new JTextField();
		trackingNumberTextField.setBounds(10, 50, 281, 20);
		mainLoginPanel.add(trackingNumberTextField);
		trackingNumberTextField.setColumns(10);
		
		//JButton loginButton = new JButton("Employee Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//employeeLoginPanel.setVisible(true);
			}
		});
		
		//JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String trackingNumber = trackingNumberTextField.getText();
			}
		});
		searchButton.setBounds(301, 49, 89, 23);
		mainLoginPanel.add(searchButton);
		loginButton.setBounds(727, 482, 126, 23);
		mainLoginPanel.add(loginButton);
		
		//JPanel employeeCreationPanel = new JPanel();
		employeeCreationPanel.setBounds(0, 0, 863, 516);
		frame.getContentPane().add(employeeCreationPanel);
		employeeCreationPanel.setLayout(null);
		employeeCreationPanel.setVisible(false);
		
		//JLabel employeeFirstNameLabel = new JLabel("First Name");
		employeeFirstNameLabel.setBounds(10, 11, 86, 14);
		employeeCreationPanel.add(employeeFirstNameLabel);
		
		//employeeFirstNameTextField = new JTextField();
		//employeeFirstNameTextField.setBounds(10, 36, 120, 20);
		employeeCreationPanel.add(employeeFirstNameTextField);
		employeeFirstNameTextField.setColumns(10);
		
		//JLabel employeeLastNameLabel = new JLabel("Last Name");
		employeeLastNameLabel.setBounds(10, 67, 86, 14);
		employeeCreationPanel.add(employeeLastNameLabel);
		
		//employeeLastNameTextField = new JTextField();
		employeeLastNameTextField.setBounds(10, 92, 120, 20);
		employeeCreationPanel.add(employeeLastNameTextField);
		employeeLastNameTextField.setColumns(10);
		
		//JLabel employeeUsernameLabel = new JLabel("Username");
		employeeUsernameLabel.setBounds(10, 123, 86, 14);
		employeeCreationPanel.add(employeeUsernameLabel);
		
		//employeeUsernameTextField = new JTextField();
		employeeUsernameTextField.setBounds(10, 148, 120, 20);
		employeeCreationPanel.add(employeeUsernameTextField);
		employeeUsernameTextField.setColumns(10);
		
		//JLabel employeePasswordLabel = new JLabel("Password");
		employeePasswordLabel.setBounds(10, 179, 86, 14);
		employeeCreationPanel.add(employeePasswordLabel);
		
		//employeePasswordTextField = new JTextField();
		employeePasswordTextField.setBounds(10, 204, 120, 20);
		employeeCreationPanel.add(employeePasswordTextField);
		employeePasswordTextField.setColumns(10);
		
		//JLabel employeeEmailLabel = new JLabel("Email");
		employeeEmailLabel.setBounds(10, 235, 86, 14);
		employeeCreationPanel.add(employeeEmailLabel);
		
		//employeeEmailTextField = new JTextField();
		employeeEmailTextField.setBounds(10, 260, 120, 20);
		employeeCreationPanel.add(employeeEmailTextField);
		employeeEmailTextField.setColumns(10);
		
		//JButton employeeSubmitButton = new JButton("Submit");
		employeeSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee employee = new Employee(employeeFirstNameTextField.getText(), employeeLastNameTextField.getText(),
						employeeEmailTextField.getText(), employeeUsernameTextField.getText(),
						employeePasswordTextField.getText());
				Driver.list.addTail(employee);
				employeeCreationPanel.setVisible(false);
			}
		});
		employeeSubmitButton.setBounds(10, 291, 89, 23);
		employeeCreationPanel.add(employeeSubmitButton);
		
		//JPanel employeeLoginPanel = new JPanel();
		employeeLoginPanel.setBounds(0, 0, 863, 516);
		frame.getContentPane().add(employeeLoginPanel);
		employeeLoginPanel.setLayout(null);
		employeeLoginPanel.setVisible(false);
		
		//JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(20, 45, 100, 14);
		employeeLoginPanel.add(usernameLabel);
		
		//textField_1 = new JTextField();
		textField_1.setBounds(20, 70, 200, 20);
		employeeLoginPanel.add(textField_1);
		textField_1.setColumns(10);
		
		//JLabel passwordLabel = new JLabel("password");
		passwordLabel.setBounds(20, 115, 100, 14);
		employeeLoginPanel.add(passwordLabel);
		
		//textField_2 = new JTextField();
		textField_2.setBounds(20, 140, 200, 20);
		employeeLoginPanel.add(textField_2);
		textField_2.setColumns(10);
		
		//JButton employeeLoginButton = new JButton("Login");
		employeeLoginButton.setBounds(131, 171, 89, 23);
		employeeLoginPanel.add(employeeLoginButton);
		
		//JButton employeeCreationButton = new JButton("New Employee");
		employeeCreationButton.setBounds(713, 482, 140, 23);
		employeeLoginPanel.add(employeeCreationButton);
		
		//JPanel rejectionPanel = new JPanel();
		rejectionPanel.setBounds(0, 0, 863, 516);
		frame.getContentPane().add(rejectionPanel);
		rejectionPanel.setLayout(null);
		rejectionPanel.setVisible(false);
		
		//JLabel rejectionLabel = new JLabel("Incorrect username or password. Please try again");
		rejectionLabel.setBounds(310, 11, 243, 14);
		rejectionPanel.add(rejectionLabel);
		
		//JButton rejectionConfirmationButton = new JButton("Ok");
		rejectionConfirmationButton.setBounds(374, 34, 89, 23);
		rejectionPanel.add(rejectionConfirmationButton);
	}
}
