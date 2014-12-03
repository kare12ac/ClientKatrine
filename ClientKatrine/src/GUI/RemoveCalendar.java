
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveCalendar extends JFrame {

	JPanel panel = new JPanel();
	
	JLabel caln = new JLabel("Calender Name");
	JLabel un = new JLabel("User Name");
	
	JTextField calntf = new JTextField(30);
	JTextField untf = new JTextField(30);
	
	JButton Delete = new JButton("Delete");
	JButton Cancel = new JButton("Cancel");
	
	public RemoveCalendar(){
		super("Delete Calender");
		setSize(550,550);
		setLocation(500,290);
		panel.setLayout(null);
		
	caln.setBounds(48, 50, 100, 50);	
	un.setBounds(48, 112, 100, 50);
	
	calntf.setBounds(225,50,100,50);
	untf.setBounds(225, 112, 100, 50);
	
	Delete.setBounds(61, 271, 100, 50);
	Cancel.setBounds(238, 271, 100, 50);
	
	panel.add(caln);
	panel.add(un);
	panel.add(calntf);
	panel.add(untf);
	panel.add(Delete);
	panel.add(Cancel);
	
	getContentPane().add(panel);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	public int closeOperation(){
		setVisible(false);
		return 1;
	}
	 public class ActionEditCalender implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		 
	}

}
