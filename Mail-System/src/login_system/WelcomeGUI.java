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
		
	//Create a frame
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

		//Method to set the text at the center of the pane
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
		
		//Build panel consisting of JTextPane
		public void buildPanel() {
			textPane.setFont(font); // set font
			textPane.setEditable(false); //set the pane uneditable
			textPane.setBorder(consoleBorder); //set border for pane
			centeringText(); //call centering method
			welcomePanel.add(textPane); //add pane to panel
		}
		
		//Build the panel consisting of buttons
		public void buildButtonPanel() {
			buttonPanel.setLayout(new FlowLayout()); //use flowLayout 
			
			//add components to panel
			buttonPanel.add(continueBtn);
			buttonPanel.add(cancelBtn);
		}
		
		//method to set action command for buttons
		private void setActionCommand() {
			continueBtn.addActionListener(this);
			continueBtn.setActionCommand("Continue");
			
			cancelBtn.addActionListener(this);
			cancelBtn.setActionCommand("Cancel");
		}
		
		// Perform action selected
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
			WelcomeGUI frame = new WelcomeGUI("KIM NGUYEN CLINIC");
		}
	}
