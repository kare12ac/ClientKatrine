package GUI;
import javax.swing.*;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import JsonClasses.AuthUser;
//import shared.LogInObject;
//import shared.LogInReturnObject;


import JsonClasses.getCalendar;
import Logic.ServerConnection;
import Logic.TCPClient;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

//import logic.ServerConnection;



public class Login  extends JFrame{

	public static void main(String[]args){
		Login frameTabel = new Login();

	}
	JButton btnlogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txtUser = new JTextField(15);
	JPasswordField password = new JPasswordField(15);
	JLabel UN = new JLabel("Username");
	JLabel PW = new JLabel ("Password");

	public Login(){
		super("Login Autentification");
		setSize(1000,1000);
		setLocation(500,280);
		panel.setLayout(null);


		txtUser.setBounds(440,108,150,20);
		password.setBounds(440,140,150,20);
		btnlogin.setBounds(473,195,80,20);
		UN.setBounds(255, 111, 90, 15);
		PW.setBounds(255, 135, 115, 30);


		panel.add(btnlogin);
		panel.add(txtUser);
		panel.add(password);
		panel.add(UN);
		panel.add(PW);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();

	}

	public void actionlogin(){
		btnlogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				TCPClient tc = new TCPClient();
				String LoginAU = null;
				String uname = txtUser.getText();
				String pword = password.getText();
				AuthUser login = new AuthUser();
				login.setAuthUserEmail(uname);
				login.setAuthUserPassword(pword);
				login.setAuthUserIsAdmin(false);
				Gson gson = new Gson();
				String jsonString = gson.toJson(login);
				ServerConnection connection = new ServerConnection();
				TCPClient client = new TCPClient();
				
				try {
					LoginAU = connection.connectToServerAndSendReturnObject(jsonString);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
					try {
						LoginAU = tc.sendMessage(jsonString);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
				if(LoginAU.equals("0")){
System.out.println("naaede her til");

					ImportEvents calget = new ImportEvents();
					calget.setVisible(true);
					dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "Wrong password, username or user is unactive");
					txtUser.setText("");
					password.setText("");
					txtUser.requestFocus();
				}
			}
		}
				);



		//	try {
		//		loginreturn = gson.fromJson(connection.connectToServerAndSendReturnObject(jsonString), LogInReturnObject.class);
		//	} catch (JsonSyntaxException e1) {
		//		e1.printStackTrace();
		//	} catch (IOException e1) {
		//		e1.printStackTrace();
		//	}
		//	
		//	if(loginreturn.isLogOn()){
		//		Calendar calendar= new Calendar();
		//		calendar.setVisible(true);
		//		dispose();
		//	}else{
		//		
		//		JOptionPane.showMessageDialog(null, loginreturn.getExplanation());
		//		txtUser.setText("");
		//		password.setText("");
		//		txtUser.requestFocus();

	}
}

