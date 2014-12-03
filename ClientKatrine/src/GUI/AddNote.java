package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	
	public AddNote(){
		super("Add Note");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
	
	nID.setBounds(6,6,100,50);
	nT.setBounds(6,50,100,50);
	ncb.setBounds(248,6,100,50);
	na.setBounds(258,50,100,50);
	neID.setBounds(0,112,100,50);
	
	nIDtxt.setBounds(120,17,100,28);
	nTtxt.setBounds(120,61,100,28);
	ncbtxt.setBounds(393,17,100,28);
	natxt.setBounds(393,61,100,28);
	neIDtxt.setBounds(120,123,100,28);
	
	AddN.setBounds(21,257,121,40);
	Cancel.setBounds(154,257,111,40);
	
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