
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.IIOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import JsonClasses.CreateCalender;
import JsonClasses.DeleteCalender;
import Logic.ServerConnection;
import Logic.TCPClient;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.awt.Font;
import java.awt.Color;
import java.io.IOException;

public class RemoveCalendar extends JFrame {

	JPanel panel = new JPanel();
	
	JLabel caln = new JLabel("Calender Name");
	JLabel un = new JLabel("User Name");
	
	JTextField calntf = new JTextField(30);
	JTextField untf = new JTextField(30);
	
	JButton btnDelete = new JButton("Delete");
	JButton Cancel = new JButton("Cancel");
	private final JLabel lblDeleteCalendar = new JLabel("Delete Calendar");
	
	public RemoveCalendar(){
		super("Delete Calender");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
		
	caln.setBounds(6, 134, 100, 29);	
	un.setBounds(6, 164, 100, 29);
	
	calntf.setBounds(168,134,100,29);
	untf.setBounds(168, 164, 100, 29);
	
	btnDelete.setBounds(104, 347, 100, 29);
	Cancel.setBounds(236, 350, 100, 23);
	
	panel.add(caln);
	panel.add(un);
	panel.add(calntf);
	panel.add(untf);
	panel.add(btnDelete);
	panel.add(Cancel);
	
	getContentPane().add(panel);
	lblDeleteCalendar.setForeground(Color.ORANGE);
	lblDeleteCalendar.setFont(new Font("Lucida Grande", Font.BOLD, 22));
	lblDeleteCalendar.setBounds(193, 40, 180, 29);
	
	panel.add(lblDeleteCalendar);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	actionDE();
	
	
	}
	 public void actionDE(){
		 
		 btnDelete.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent event){
			 TCPClient tc = new TCPClient();
			 String nowdeletingcal= null;
			 String  namecal = calntf.getText();
			 String  nameuser = untf.getText();
			 
			 DeleteCalender del = new DeleteCalender();
			 del.setCalenderName(namecal);
			 del.setUserName(nameuser);
			 Gson gson = new Gson();
			 String jsonString = gson.toJson(nowdeletingcal);
			 ServerConnection connection = new ServerConnection();
			
			 try{
				 try {
					nowdeletingcal = connection.connectToServerAndSendReturnObject(jsonString);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }catch(JsonSyntaxException e1){
				 e1.printStackTrace();
			
			
				
			}
			 
			 JOptionPane.showMessageDialog(null, nowdeletingcal);
			calntf.setText("");
			 untf.requestFocus();
				 
		 }	 
		
		 
	}

);



}
}
