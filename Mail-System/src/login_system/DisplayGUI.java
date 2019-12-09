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
	private JTextArea area = new JTextArea(80,25);
	private JScrollPane pane = new JScrollPane(area);
	private JButton closeBtn = new JButton("Close");
	private JPanel topPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private Font font = new Font("Calibri", Font.BOLD, 20);
	private TitledBorder border = new TitledBorder(null, "MAIL LIST", TitledBorder.CENTER , TitledBorder.ABOVE_TOP, font, Color.red);
	
	public DisplayGUI(String title) {
		super(title);
		setSize(1000,400); //set the size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default exit method
		
		area.setFont(new Font("monospaced", Font.PLAIN, 12));
		area.setEditable(false);
		pane.setBorder(border);
		topPanel.add(pane);
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(closeBtn);
		add(pane, BorderLayout.CENTER);
		add(closeBtn, BorderLayout.SOUTH);
		display(mailList);
		setActionCommand();
		setVisible(true); 
	}

	private void setActionCommand() {
		closeBtn.addActionListener(this);
		closeBtn.setActionCommand("Close");
	}

	public void display(ArrayList <Mail> list) {
		
		String categories = String.format("%-20s%-25s%-25s%-6s%-10s%-12s%-18s%-15s%n%n",
				"Customer Name", "Address", "City", "State", "Zipcode","Weight(lbs)",
				"Tracking Number", "Status");
		
		mailList = EmployeeGUI.sortedList;
		area.append(categories);
		for (Mail i : mailList) {
			area.append(i.toString());
			area.append("\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Close")) {
			dispose();
		}
		
	}
	
}
