package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import JsonClasses.AuthUser;
import JsonClasses.createEvent;
import Logic.ServerConnection;
import Logic.TCPClient;

import com.google.gson.Gson;

import java.awt.Font;
import java.awt.Color;

public class AddEvent extends JFrame{
	JPanel panel = new JPanel();
	JLabel ty = new JLabel("Type");
	JLabel loc = new JLabel("Location");
	JLabel cre = new JLabel("Created by");
	JLabel start = new JLabel ("Start Time");
	JLabel end = new JLabel ("End time");
	JLabel nm = new JLabel("Name");
	JLabel txt = new JLabel ("Text");
	JLabel custev = new JLabel ("Custom event");
	JLabel calID = new JLabel ("Calender ID");
	

	JTextField tytxt = new JTextField(30);
	JTextField loctxt = new JTextField(30);
	JTextField cretxt = new JTextField(30);
	JTextField starttxt = new JTextField(30);
	JTextField endtxt = new JTextField(30);
	JTextField nmtxt = new JTextField(30);
	JTextField txttxt = new JTextField(30);
	JTextField custevtxt = new JTextField(30);
	JTextField calIDtxt = new JTextField(30);
	
	JButton btnAdd = new JButton("Add Event");
	JButton Cancel = new JButton("Cancel");
	
	public AddEvent(){
		super("Create Event");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
	

	ty.setBounds(6,178,100,28);
	loc.setBounds(6,218,100,22);
	cre.setBounds(6,252,100,28);
	start.setBounds(6,292,100,28);
	end.setBounds(277,138,100,28);
	nm.setBounds(277,181,100,22);
	txt.setBounds(277,215,100,28);
	custev.setBounds(277,252,100,28);
	calID.setBounds(277,292,100,28);

	tytxt.setBounds(100,178,100,28);
	loctxt.setBounds(100,215,100,28);
	cretxt.setBounds(100,252,100,28);
	starttxt.setBounds(100,295,100,22);
	endtxt.setBounds(389,138,100,28);
	nmtxt.setBounds(389,181,100,22);
	txttxt.setBounds(389,218,100,22);
	custevtxt.setBounds(389,255,100,22);
	calIDtxt.setBounds(389,295,100,22);
	btnAdd.setBounds(100,395,100,28);
	Cancel.setBounds(277,395,100,28);
	
	

	panel.add(ty);
	panel.add(loc);
	panel.add(cre);
	panel.add(start);
	panel.add(end);
	panel.add(nm);
	panel.add(txt);
	panel.add(custev);
	panel.add(calID);
	

	panel.add(tytxt);
	panel.add(loctxt);
	panel.add(cretxt);
	panel.add(starttxt);
	panel.add(endtxt);
	panel.add(nmtxt);
	panel.add(txttxt);
	panel.add(custevtxt);
	panel.add(calIDtxt);
	
	panel.add(btnAdd);
	panel.add(Cancel);
	
	getContentPane().add(panel);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	
	JLabel lblNewEvent = new JLabel("New Event");
	lblNewEvent.setForeground(Color.ORANGE);
	lblNewEvent.setFont(new Font("Lucida Grande", Font.BOLD, 22));
	lblNewEvent.setBounds(206, 42, 193, 30);
	panel.add(lblNewEvent);
	actionAE();
	}
	
	public void actionAE(){
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				TCPClient tc = new TCPClient();
				String Eventinprogress = null;
				String ty= tytxt.getText();
				String loc = loctxt.getText();
				String cre = cretxt.getText();
				String start= starttxt.getText();
				String end = endtxt.getText();
				String nm = nmtxt.getText();
				String txt = txttxt.getText();
				String custev = custevtxt.getText();
				String calID = calIDtxt.getText();
				
				
				createEvent eventcreated = new createEvent();
				
				eventcreated.settype(ty);
				eventcreated.setlocation(loc);
				eventcreated.setcreatedby(cre);
				eventcreated.setstartTime(start);
				eventcreated.setendTime(end);
				eventcreated.setname(nm);
				eventcreated.settext(txt);
				eventcreated.setcustomevent(custev);
				eventcreated.setCalenderID(calID);
				
				
				
				
				
				Gson gson = new Gson();
				String jsonString = gson.toJson(eventcreated);
				ServerConnection connection = new ServerConnection();
				TCPClient client = new TCPClient();
				
//				LoginAU = connection.connectToServerAndSendReturnObject(jsonString);
			
					try {
						Eventinprogress = tc.sendMessage(jsonString);
						System.out.println(jsonString);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
				if(Eventinprogress.equals("1")){
System.out.println("naaede her til");

					AddCalendar notew = new AddCalendar();
					notew.setVisible(true);
					dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "Event was not added!");
					tytxt.setText("");
					loctxt.setText("");
					cretxt.setText("");
					starttxt.setText("");
					endtxt.setText("");
					nmtxt.setText("");
					txttxt.setText("");
					custevtxt.setText("");
					calIDtxt.setText("");
					tytxt.requestFocus();
					
			
			
		}
		
	}
}
	);
	}
}