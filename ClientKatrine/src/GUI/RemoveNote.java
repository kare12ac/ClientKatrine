package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveNote extends JFrame{

	JPanel  panel = new JPanel(); 
	
	JTextField nidtx = new JTextField(30);
	JTextField poptx = new JTextField(30);
	
	JLabel nid = new JLabel ("Note ID");
	JLabel pop = new JLabel ("Public or Private");
	
	JButton DeleteN = new JButton("Delete Note");
	JButton Cancel = new JButton("Cancel");
	
	public RemoveNote(){
		super("Delete Note");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
		
		
		nidtx.setBounds(100, 50, 100, 50);
		poptx.setBounds(50, 100, 50, 100);
		
		nid.setBounds(100,60,100,60);
		pop.setBounds(50, 100, 50, 100);
		
		DeleteN.setBounds(100, 50, 100, 50);
		Cancel.setBounds(50, 100, 50, 100);
		
	panel.add(nidtx);
	panel.add(poptx);
	panel.add(nid);
	panel.add(pop);
	panel.add(DeleteN);
	panel.add(Cancel);
	
	getContentPane().add(panel);
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
