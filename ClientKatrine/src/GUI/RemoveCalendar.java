
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

public class RemoveCalendar extends JFrame {

	JPanel panel = new JPanel();
	
	JLabel caln = new JLabel("Calender Name");
	JLabel un = new JLabel("User Name");
	
	JTextField calntf = new JTextField(30);
	JTextField untf = new JTextField(30);
	
	JButton Delete = new JButton("Delete");
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
	
	Delete.setBounds(104, 347, 100, 29);
	Cancel.setBounds(236, 350, 100, 23);
	
	panel.add(caln);
	panel.add(un);
	panel.add(calntf);
	panel.add(untf);
	panel.add(Delete);
	panel.add(Cancel);
	
	getContentPane().add(panel);
	lblDeleteCalendar.setForeground(Color.ORANGE);
	lblDeleteCalendar.setFont(new Font("Lucida Grande", Font.BOLD, 22));
	lblDeleteCalendar.setBounds(193, 40, 180, 29);
	
	panel.add(lblDeleteCalendar);
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
