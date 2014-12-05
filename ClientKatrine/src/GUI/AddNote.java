package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class AddNote extends JFrame {

	JPanel panel = new JPanel();
	
	JLabel nID = new JLabel("Note ID");
	JLabel nT = new JLabel("Note Text");
	JLabel ncb = new JLabel("Note Created By");
	JLabel na = new JLabel ("Note Activity");
	JLabel neID = new JLabel("Note Event ID");
	
	JTextField nIDtxt = new JTextField(30);
	JTextField nTtxt = new JTextField(30);
	JTextField ncbtxt = new JTextField(30);
	JTextField natxt = new JTextField(30);
	JTextField neIDtxt = new JTextField(30);
	
	JButton AddN = new JButton("Add Note");
	JButton Cancel = new JButton("Cancel");
	private final JLabel lblNewNote = new JLabel("New Note");
	
	public AddNote(){
		super("Add Note");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
	
	nID.setBounds(6,139,100,22);
	nT.setBounds(6,173,100,22);
	ncb.setBounds(248,133,100,28);
	na.setBounds(248,173,100,22);
	neID.setBounds(6,207,100,28);
	
	nIDtxt.setBounds(118,133,100,28);
	nTtxt.setBounds(118,170,100,28);
	ncbtxt.setBounds(393,133,100,28);
	natxt.setBounds(393,170,100,28);
	neIDtxt.setBounds(118,207,100,28);
	
	AddN.setBounds(97,324,100,28);
	Cancel.setBounds(284,324,100,28);
	
	panel.add(nID);
	panel.add(nT);
	panel.add(ncb);
	panel.add(na);
	panel.add(neID);
	
	panel.add(nIDtxt);
	panel.add(nTtxt);
	panel.add(ncbtxt);
	panel.add(natxt);
	panel.add(neIDtxt);
	
	panel.add(AddN);
	panel.add(Cancel);
	
	getContentPane().add(panel);
	lblNewNote.setForeground(Color.ORANGE);
	lblNewNote.setFont(new Font("Lucida Grande", Font.BOLD, 22));
	lblNewNote.setBounds(204, 39, 177, 34);
	
	panel.add(lblNewNote);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	public int closeOperation(){
		setVisible(false);
		return 1;
	}
	
	public class ActionAddNote implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	
	
	
	
	
	
}
}