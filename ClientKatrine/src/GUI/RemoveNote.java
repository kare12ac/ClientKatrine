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

public class RemoveNote extends JFrame{

	JPanel  panel = new JPanel(); 
	
	JTextField nidtx = new JTextField(30);
	JTextField poptx = new JTextField(30);
	
	JLabel nid = new JLabel ("Note ID");
	JLabel pop = new JLabel ("Public or Private");
	
	JButton DeleteN = new JButton("Delete Note");
	JButton Cancel = new JButton("Cancel");
	private final JLabel lblDeleteNote = new JLabel("Delete Note");
	
	public RemoveNote(){
		super("Delete Note");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
		
		
		nidtx.setBounds(146, 125, 95, 28);
		poptx.setBounds(146, 92, 95, 29);
		
		nid.setBounds(6,128,100,22);
		pop.setBounds(6, 92, 115, 28);
		
		DeleteN.setBounds(84, 211, 100, 29);
		Cancel.setBounds(230, 211, 95, 29);
		
	panel.add(nidtx);
	panel.add(poptx);
	panel.add(nid);
	panel.add(pop);
	panel.add(DeleteN);
	panel.add(Cancel);
	
	getContentPane().add(panel);
	lblDeleteNote.setForeground(Color.ORANGE);
	lblDeleteNote.setFont(new Font("Lucida Grande", Font.BOLD, 22));
	lblDeleteNote.setBounds(208, 35, 182, 28);
	
	panel.add(lblDeleteNote);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	public int CloseOperation(){
		setVisible(false);
		return 1 ;
	}
	public class ActionRemoveNote implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
