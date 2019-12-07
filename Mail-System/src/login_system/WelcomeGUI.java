package login_system;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class WelcomeGUI extends JFrame implements ActionListener {
	//Panels
	private JPanel welcomePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
		
	//Buttons
	private JButton continueBtn = new JButton("Continue");
	private JButton cancelBtn = new JButton("Cancel");
		
	//Titled Border
	private TitledBorder consoleBorder = new TitledBorder("");
		
	//Font
	private Font font = new Font("Times new Roman", Font.BOLD, 54);
		
	//TextPane
	private JTextPane textPane = new JTextPane();
		
	
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
		setSize(550,400); //set size of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			buildPanel();
			buildButtonPanel();
			add(welcomePanel, BorderLayout.CENTER);
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
	        StyledDocument doc=(StyledDocument) textPane.getDocument();
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
		textPane.setEditable(false); //set the pane uneditable
		textPane.setBorder(consoleBorder); //set border for pane
		centeringText(); //call centering method
		welcomePanel.add(textPane); //add pane to panel
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
		buttonPanel.add(continueBtn);
		buttonPanel.add(cancelBtn);
	}
		
	//method to set action command for buttons
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
		continueBtn.addActionListener(this);
		continueBtn.setActionCommand("Continue");
		
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
		//if the user chooses continue, open the BMI analyzer frame or AnalyzeGUI frame
		if (action.equals("Continue")) {
			@SuppressWarnings("unused")
			LogGUI newFrame = new LogGUI("Login Page");
			dispose(); //remove the current frame
		}
		//If the user chooses cancel, exit program
		else if (action.equals("Cancel")) {
			System.exit(0);
		}
		}
		
	//Main method
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		WelcomeGUI frame = new WelcomeGUI("MNS MAIL SERVICE");
	}
}
