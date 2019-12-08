package login_system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Mail_Bag.MailCollection;

@SuppressWarnings("serial")
public class driverGUI extends JFrame implements ActionListener {

	private JPanel driverPanel;
	private JPanel boolPanel;
	
	private JLabel boolLabel = new JLabel("Is Customer there?");
	
	private JTextPane textPanel = new JTextPane();
	
	private JButton yesBtn = new JButton("Yes");
	private JButton noBtn = new JButton("No");
	
	MailCollection bag = new MailCollection(500);
	MailCollection bag2 = new MailCollection(500);
	
	private Font font = new Font("Times new Roman", Font.BOLD, 40);
	
	
	/**
	 * description: creates constructor 
	 * parameters: String title
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public driverGUI (String title) {
		super(title);
		setSize(1005,415); //set the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default exit method
		
		buildPanel();
		buildButtonPanel();
		
		add(driverPanel, BorderLayout.CENTER);
		add(boolPanel, BorderLayout.SOUTH);
		
		setActionCommand(); //call action command method
		setVisible(true); //set frame to be visible
	}
	
	
	/**
	 * description: adds listener for button
	 * parameters: none
	 * precondition: is called 
	 * postcondition: adds listener 
	 * throws: none
	 */
	private void setActionCommand() {
		yesBtn.addActionListener(this);
		yesBtn.setActionCommand("Yes");
		
		noBtn.addActionListener(this);
		noBtn.setActionCommand("No");
	}

	/**
	 * description: creates actions 
	 * parameters: none
	 * precondition: button is present 
	 * postcondition: performs action
	 * throws: none
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		//if the user chooses yes, removes item from bag
		if (action.equals("Yes")) {
			bag.pop();
		}
		//If the user chooses no, push item to bag2 and removes from bag
		else if (action.equals("No")) {
			String temp = bag.pop();
			bag2.push(temp);
		}
		
	}
	
	/**
	 * description: adds text to panel 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: displays bag
	 * throws: none
	 */
	public void centeringText() {
		SimpleAttributeSet attrs = new SimpleAttributeSet();
        	StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
       		StyledDocument doc = (StyledDocument) textPanel.getDocument();
        	try {
			doc.insertString(0,bag.toString(),attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
       	doc.setParagraphAttributes(0,doc.getLength()-1,attrs,false);
	}
	
	/**
	 * description: creates display panel 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: displays panel 
	 * throws: none
	 */
	public void buildPanel() {
		textPanel.setFont(font); // set font
		textPanel.setEditable(false); //set the pane uneditable
		centeringText();
	
		driverPanel.add(textPanel); //add pane to panel
	}
	
	/**
	 * description: creates panel 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates panel 
	 * throws: none
	 */
	public void buildButtonPanel() {
		boolPanel.setLayout(new FlowLayout()); //use flowLayout 
		boolPanel.add(boolLabel);
		
		//add components to panel
		boolPanel.add(yesBtn);
		boolPanel.add(noBtn);
	}

}