package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEvent extends JFrame{
	JPanel panel = new JPanel();
	JLabel eID = new JLabel("Event ID");
	JLabel ty = new JLabel("Type");
	JLabel loc = new JLabel("Location");
	JLabel cre = new JLabel("Created by");
	JLabel start = new JLabel ("Start Time");
	JLabel end = new JLabel ("End time");
	JLabel nm = new JLabel("Name");
	JLabel txt = new JLabel ("Text");
	JLabel custev = new JLabel ("Customer event");
	JLabel calID = new JLabel ("Calender ID");
	
	JTextField eIDtxt = new JTextField(30);
	JTextField tytxt = new JTextField(30);
	JTextField loctxt = new JTextField(30);
	JTextField cretxt = new JTextField(30);
	JTextField starttxt = new JTextField(30);
	JTextField endtxt = new JTextField(30);
	JTextField nmtxt = new JTextField(30);
	JTextField txttxt = new JTextField(30);
	JTextField custevtxt = new JTextField(30);
	JTextField calIDtxt = new JTextField(30);
	
	JButton Add = new JButton("Add Event");
	JButton Cancel = new JButton("Cancel");
	
	public AddEvent(){
		super("Create Event");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
	
	
	
	eID.setBounds(100,50,100,50);
	ty.setBounds(100,50,100,50);
	loc.setBounds(100,50,100,50);
	cre.setBounds(100,50,100,50);
	start.setBounds(100,50,100,50);
	end.setBounds(100,50,100,50);
	nm.setBounds(100,50,100,50);
	txt.setBounds(100,50,100,50);
	custev.setBounds(100,50,100,50);
	calID.setBounds(100,50,100,50);
	
	eIDtxt.setBounds(100,50,100,50);
	tytxt.setBounds(100,50,100,50);
	loctxt.setBounds(100,50,100,50);
	cretxt.setBounds(100,50,100,50);
	starttxt.setBounds(100,50,100,50);
	endtxt.setBounds(100,50,100,50);
	nmtxt.setBounds(100,50,100,50);
	txttxt.setBounds(100,50,100,50);
	custevtxt.setBounds(100,50,100,50);
	calIDtxt.setBounds(100,50,100,50);
	Add.setBounds(100,50,100,50);
	Cancel.setBounds(100,50,100,50);
	
	
	panel.add(eID);
	panel.add(ty);
	panel.add(loc);
	panel.add(cre);
	panel.add(start);
	panel.add(end);
	panel.add(nm);
	panel.add(txt);
	panel.add(custev);
	panel.add(calID);
	
	panel.add(eIDtxt);
	panel.add(tytxt);
	panel.add(loctxt);
	panel.add(cretxt);
	panel.add(starttxt);
	panel.add(endtxt);
	panel.add(nmtxt);
	panel.add(txttxt);
	panel.add(custevtxt);
	panel.add(calIDtxt);
	
	panel.add(Add);
	panel.add(Cancel);
	
	getContentPane().add(panel);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	public int closeOperation(){
		setVisible(false);
		return 1;
	}
	
	public class ActionAddEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
}