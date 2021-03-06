package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import JsonClasses.CreateNote;
import Logic.ServerConnection;
import Logic.TCPClient;

import java.awt.Font;
import java.awt.Color;
import java.io.IOException;

public class AddNote extends JFrame {
	String msg = "";
	JPanel panel = new JPanel();
	
	
	JLabel nT = new JLabel("Note Text");
	JLabel ncb = new JLabel("Note Created By");
	JLabel na = new JLabel ("Note Activity");
	JLabel neID = new JLabel("Note Event ID");
	JLabel active = new JLabel("Active user");
	
	JTextField nTtxt = new JTextField(30);
	JTextField ncbtxt = new JTextField(30);
	JTextField natxt = new JTextField(30);
	JTextField neIDtxt = new JTextField(30);
	JTextField activetxt = new JTextField(30);
	
	JButton AddN = new JButton("Add Note");
	JButton Cancel = new JButton("Cancel");
	private final JLabel lblNewNote = new JLabel("New Note");
	
	public AddNote(){
		super("Add Note");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
	
	
	nT.setBounds(6,133,100,22);
	ncb.setBounds(248,133,100,28);
	na.setBounds(248,173,100,22);
	neID.setBounds(6,207,100,28);
	active.setBounds(6,173,100,22);
	
	nTtxt.setBounds(118,133,100,28);
	ncbtxt.setBounds(393,133,100,28);
	natxt.setBounds(393,170,100,28);
	neIDtxt.setBounds(118,207,100,28);
	activetxt.setBounds(118,170,100,28);

	AddN.setBounds(97,324,100,28);
	Cancel.setBounds(284,324,100,28);
	
	
	panel.add(nT);
	panel.add(ncb);
	panel.add(na);
	panel.add(neID);
	panel.add(active);
	
	panel.add(nTtxt);
	panel.add(ncbtxt);
	panel.add(natxt);
	panel.add(neIDtxt);
	panel.add(activetxt);
	
	panel.add(AddN);
	panel.add(Cancel);
	
	getContentPane().add(panel);
	lblNewNote.setForeground(Color.ORANGE);
	lblNewNote.setFont(new Font("Lucida Grande", Font.BOLD, 22));
	lblNewNote.setBounds(204, 39, 177, 34);
	
	panel.add(lblNewNote);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	actionAN();
	}
	
	
	
	public void actionAN (){
		AddN.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			
				
					TCPClient tc = new TCPClient();
					String notemaking = null;
					String nT = nTtxt.getText();
					String nc= ncbtxt.getText();
					String neID = neIDtxt.getText();
					String active = activetxt.getText();
					
					CreateNote notecreated = new CreateNote();
					notecreated.setNoteText(nT);
					notecreated.setNoteCreatedBy(nc);
					notecreated.seteventid(neID);
					notecreated.setNoteActive(active);
					
					Gson gson = new Gson();
					String jsonString = gson.toJson(notecreated);
					
					System.out.println(jsonString);
					ServerConnection connection = new ServerConnection();
					TCPClient client = new TCPClient();
					
					
					// HER LIGGER DET EN FEIL!!!
					try{
						notemaking= tc.sendMessage(jsonString);
						System.out.println(jsonString);

					}catch (Exception e){
						e.printStackTrace();
					
				}
					System.out.println("før if statement");
				if(notemaking.equals("1")){
						System.out.println("så langt kom vi denne gang!");
						
						Login login = new Login();
						login.setVisible(true);
						dispose();
						
						System.out.println("kommer gjennom if statement");
				}else{
							JOptionPane.showMessageDialog(null,"Note was not added");
							
							nTtxt.setText("");
							ncbtxt.setText("");
							neIDtxt.setText("");
							neIDtxt.requestFocus();
				}				
		}		
		}
		);
		}
}		
	
				




	

	
	
		
	

