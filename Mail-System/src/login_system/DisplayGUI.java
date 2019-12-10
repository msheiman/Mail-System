package login_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Mail_Bag.Mail;

@SuppressWarnings("serial")
public class DisplayGUI extends JFrame implements ActionListener {
	
	private static ArrayList<Mail> mailList = new ArrayList<>();
	
	// TEXT AREA
	private JTextArea area = new JTextArea(80,25);
	
	// SCROLL PANE
	private JScrollPane pane = new JScrollPane(area);
	
	// BUTTON
	private JButton closeBtn = new JButton("Close");
	
	// PANEL
	private JPanel buttonPanel = new JPanel();
	
	// FONT
	private Font font = new Font("Calibri", Font.BOLD, 20);
	
	//TITLED BORDER
	private TitledBorder border = new TitledBorder(null, "MAIL LIST", TitledBorder.CENTER , TitledBorder.ABOVE_TOP, font, Color.red);
	
	public DisplayGUI(String title) {
		super(title);
		setSize(1000,400); //set the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default exit method
		
		area.setFont(new Font("monospaced", Font.PLAIN, 12)); //set font for text area
		area.setEditable(false); //set text area to not editable
		pane.setBorder(border); //set border for scroll pane
		
		buttonPanel.setLayout(new FlowLayout()); //set layout of button panel to flow layout
		buttonPanel.add(closeBtn); // add button to button panel
		
		add(pane, BorderLayout.CENTER); //add scroll pane to frame in the center 
		add(buttonPanel, BorderLayout.SOUTH); //add button panel to frame in the south
		
		display(mailList); //call method to function
		
		setActionCommand();//set action command for button
		setVisible(true); //set frame to be visible
	}

	/**
	 * Method name: setActionCommand
	 * Heading: private void setActionCommand() 
	 * Description: set action command for button
	 * Parameters: none
	 * Precondition: none
	 * Postcondition: set action command 
	 * Throws list: none
	 */
	private void setActionCommand() {
		closeBtn.addActionListener(this);
		closeBtn.setActionCommand("Close");
	}

	/**
	 * Method name: display
	 * Heading: public void display(ArrayList <Mail> list) 
	 * Description: display content in sorted mail list to the text area in scroll pane
	 * Parameters: list - sorted mail list 
	 * Precondition: none
	 * Postcondition: list appended in the text area with format
	 * Throws list: none
	 */
	public void display(ArrayList <Mail> list) {
		
		//Format the categories
		String categories = String.format("%-20s%-25s%-25s%-6s%-10s%-12s%-18s%-15s%n%n",
				"Customer Name", "Address", "City", "State", "Zipcode","Weight(lbs)",
				"Tracking Number", "Status");

		mailList = EmployeeGUI.sortedList; //get the sorted mail from EmployeeGUI
		area.append(categories); //append to textarea
		
		//Append each element in the list to textarea
		for (Mail i : mailList) {
			area.append(i.toString());
			area.append("\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		//if user clicks close, dispose the current frame
		if (action.equals("Close")) {
			dispose();
		}
		
	}
	
}
