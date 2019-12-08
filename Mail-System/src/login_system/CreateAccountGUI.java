package login_system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Employee_System.Employee;

@SuppressWarnings("serial")
public class CreateAccountGUI extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel employeeCreationPanel = new JPanel();
	
	private JTextField firstNameTxt = new JTextField();
	private JTextField lastNameTxt = new JTextField();
	private JTextField emailTxt = new JTextField();
	private JTextField usernameTxt = new JTextField();
	private JTextField passwordTxt = new JTextField();
	
	private JLabel firstNameLbl = new JLabel("First Name", SwingConstants.CENTER);
	private JLabel lastNameLbl = new JLabel("Last Name", SwingConstants.CENTER);
	private JLabel usernameLbl = new JLabel("Username", SwingConstants.CENTER);
	private JLabel passwordLbl = new JLabel("Password", SwingConstants.CENTER);
	private JLabel emailLbl = new JLabel("Email", SwingConstants.CENTER);
	
	private JButton submitBtn = new JButton ("Submit");
	private JButton cancelBtn = new JButton("Cancel");
	
	private JTextPane loginTitle = new JTextPane();
	
	private Font font = new Font("Calibri", Font.BOLD, 40);
	
	public CreateAccountGUI (String title) {
		super(title);
		setSize(450,350); //set the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default exit method
		
		buildPanel();
		buildEmployeeCreationPanel();
		buildButtonPanel();
		
		add(panel, BorderLayout.NORTH);
		add(employeeCreationPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	
		setActionCommand(); //call action command method
		setVisible(true); //set frame to be visible
	}

	public void buildPanel() {
		loginTitle.setFont(font);
		loginTitle.setEditable(false);
		centeringText();
		panel.add(loginTitle);
	}
	
	public void buildEmployeeCreationPanel() {
		employeeCreationPanel.setLayout(new GridLayout(5,2));
		
		employeeCreationPanel.add(firstNameLbl);
		employeeCreationPanel.add(firstNameTxt);
		employeeCreationPanel.add(lastNameLbl);
		employeeCreationPanel.add(lastNameTxt);
		employeeCreationPanel.add(emailLbl);
		employeeCreationPanel.add(emailTxt);
		employeeCreationPanel.add(usernameLbl);
		employeeCreationPanel.add(usernameTxt);
		employeeCreationPanel.add(passwordLbl);
		employeeCreationPanel.add(passwordTxt);
	}
	
	public void buildButtonPanel() {
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(submitBtn);
		buttonPanel.add(cancelBtn);
	}
	
	private void centeringText() {
		SimpleAttributeSet attrs = new SimpleAttributeSet();
	    StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
	    StyledDocument doc = (StyledDocument) loginTitle.getDocument();
	    try {
			doc.insertString(0,"New Employee",attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	        doc.setParagraphAttributes(0,doc.getLength()-1,attrs,false);
	}
	
	private void setActionCommand() {
		submitBtn.addActionListener(this);
		submitBtn.setActionCommand("Submit");
		
		cancelBtn.addActionListener(this);
		cancelBtn.setActionCommand("Cancel");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
	
		if (action.equals("Submit")) {
			Employee employee = new Employee(firstNameTxt.getText(), lastNameTxt.getText(),
					emailTxt.getText(), usernameTxt.getText(),passwordTxt.getText());
			writeToFile(employee); // Add the employee information to CVS File
		}
		else if(action.equals("Cancel")) {
			dispose();
		}
	}
	
	/**
	 * Method name: writeToFile(Employee employee)
	 * Heading: public void writeToFile(Employee employee) 
	 * Description: to write items in arrayList in file
	 * Parameters: Employee employee
	 * Precondition: the tail is not null
	 * Postcondition: appends items to file
	 * Throws list: IOException e
	 		Exception e
	 */
	public void writeToFile(Employee employee) {
		FileWriter fileIn = null; //declare a file
		try {
			fileIn = new FileWriter("Mail-System/src/Employee_System/EmployeeSystem.csv", true); //create new file
			
			//Write each item in arrayList into file
			//Append item to file and separate them by comma delimiter
			fileIn.append(String.valueOf(employee.getFirstName()));
			fileIn.append(",");
			fileIn.append(String.valueOf(employee.getLastName()));
			fileIn.append(",");
			fileIn.append(employee.getEmail());
			fileIn.append(",");
			fileIn.append(employee.getUser());
			fileIn.append(",");
			fileIn.append(employee.getPassword());
			fileIn.append("\n");
			
			fileIn.close(); //Close file
		} catch (IOException e) {
			e.printStackTrace();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
