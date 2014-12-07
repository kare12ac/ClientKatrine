package GUI;
import JsonClasses.CreateCalender;
import GUI.Calendar;

import java.util.ArrayList;

import com.google.gson.*;

import javax.swing.*;

import Logic.ServerConnection;
import JsonClasses.CreateCalender;
import JsonClasses.AuthUser;

import java.awt.Color;
import java.awt.Font;
import java.awt.color.*;
import java.awt.font.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Logic.TCPClient2;
public class AddCalendar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -507260835291603930L;
	String msg = "";
	JPanel panel = new JPanel();
	JButton btnCreate = new JButton("Create Calendar");
	JButton btnCancel = new JButton("Cancel");
	JTextField txtUserName = new JTextField(30);
	JTextField txtCalName = new JTextField(30);
	JTextField txtpubPriv= new JTextField(30);
	JLabel AC = new JLabel("Add Calendar");
	JLabel N = new JLabel ("Calendar Name:");
	JLabel prpu= new JLabel("Is it Private or public");
	JLabel UN= new JLabel("Username");
	
	public AddCalendar(){
	super("Create Calendar");
	setSize(550,550);
	setLocation(500,280);
	panel.setLayout(null);
	
	txtUserName.setBounds(187,144,150,20);
	txtCalName.setBounds(187,80,150,20);
	txtpubPriv.setBounds(187,112,150,20);
	btnCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	btnCreate.setBounds(261,406,140,29);
	btnCancel.setBounds(160, 406, 67, 29);
	AC.setFont(new Font("Arial", Font.BOLD, 22));
	AC.setForeground(Color.ORANGE);
	AC.setBounds(187, 6, 198, 74);
	N.setBounds(35, 75, 115, 30);
	prpu.setBounds(35, 117, 150, 15);
	UN.setBounds(34, 138, 116, 33);
	
	panel.add(txtUserName);
	panel.add(txtCalName);
	panel.add(txtpubPriv);
	panel.add(btnCreate);
	panel.add(btnCancel);
	panel.add(AC);
	panel.add(N);
	panel.add(prpu);
	panel.add(UN);
	
	getContentPane().add(panel);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	}
	public int closeOperation(){
		setVisible(false);
		return 1;
	}
	
}
//	public class ActionAddCalendar implements ActionListener{
//	
//	public void actionPerformed(ActionEvent e){
//		String calName = txtUserName.getText();
//		int pubPriv = Integer.parseInt(txtpubPriv.getText());
//		CreateCalender createcalendar = new CreateCalender();
//		createcalendar.setCalenderName(calName);
//		createcalendar.setPublicOrPrivate(pubPriv);
//		Gson gson = new Gson();
//		String jsonString = gson.toJson(createcalendar);
//		ServerConnection connection = new ServerConnection();
//		String CAL = "";
//		try{
//			CAL =connection.connectToServerAndSendReturnObject(jsonString);
//		}catch(JsonSyntaxException e1){
//			e1.printStackTrace();
//		}catch (IOException e1){
//			e1.printStackTrace();
//		}
//		if(CAL.equals("0")){
//			Calendar calendar = new Calendar();
//				calendar.setVisible(true);
//				dispose();
//
//			try{
//			msg = connection.;(jsonString);
//		}catch(JsonSyntaxException e1){
//			e1.printStackTrace();
//		}catch(IOException e1){
//			e1.printStackTrace();
//		}
//		
//		public void actionlogin(){
//			btnlogin.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent event){
//					String uname = txtUserName.getText();
//					String pword = password.getText();
//					AuthUser login = new AuthUser();
//					login.setAuthUserEmail(uname);
//					login.setAuthUserPassword(pword);
//					login.setAuthUserIsAdmin(false);
//					Gson gson = new Gson();
//					String jsonString = gson.toJson(login);
//					ServerConnection connection = new ServerConnection();
//					String LoginAU =("");
//					try{
//						LoginAU =connection.connectToServerAndSendReturnObject(jsonString);
//					}catch(JsonSyntaxException e1){
//						e1.printStackTrace();
//					}catch (IOException e1){
//						e1.printStackTrace();
//					}
//					if(LoginAU.equals("0")){
//						Calendar calendar = new Calendar();
//							calendar.setVisible(true);
//							dispose();
//		
		
		
		
		
		
		
		
		
		
//		
//		JOptionPane.showMessageDialog(null,msg);
////		pubPriv.setText("");
////		pubPriv.requestFocus();
//	}
//	}
//		
//		public class ActionCancel implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//				dispose();
//			}
//		}
//		
//}	


