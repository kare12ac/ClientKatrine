package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Calendar extends JFrame{
	
	
		JLabel welcome = new JLabel("Welcome to CBS Calendar");
		JPanel panel = new JPanel();
		JButton editCalendar = new JButton("Edit Calendar");
		JButton editEvent = new JButton("Edit Event");
		JButton share = new JButton("Share");
		JButton btnRandomQuote = new JButton("Random Quote");
		JButton btnForecast = new JButton("Weather");
		JButton logOut = new JButton("Log out");
		
		public Calendar(){
			super("CBS Calendar");
			setSize(1000,1000);
			setLocation(500,280);
			getContentPane().setLayout(null);
			panel.setBounds(0, 0, 1000, 978);
			panel.setLayout(null);
			welcome.setForeground(SystemColor.textHighlight);
			welcome.setFont(new Font("Apple Braille", Font.PLAIN, 28));
			
			welcome.setBounds(310,-3,392,160);
			panel.add(welcome);
			
			editCalendar.setBounds(25, 140, 105, 39);
			panel.add(editCalendar);
			
			editEvent.setBounds(25, 191, 105, 39);
			panel.add(editEvent);
			
			share.setBounds(25, 242, 105, 39);
			panel.add(share);
			
			btnRandomQuote.setBounds(25, 293, 105, 39);
			panel.add(btnRandomQuote);
			
			btnForecast.setBounds(25, 344, 105, 39);
			panel.add(btnForecast);
			
			logOut.setBounds(895, 6, 105, 39);
			panel.add(logOut);
			
			getContentPane().add(panel);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			editCalendar.addActionListener(new ActionEditCalendar());
			editEvent.addActionListener(new ActionEditEvent());
			logOut.addActionListener(new ActionLogOut());
			
		}
		public class ActionEditCalendar implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
					EditCalendar editcalendar = new EditCalendar();
		//			editcalendar.setVisible(true);
					}
			}
		
		public class ActionEditEvent implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
					EditEvent editevent = new EditEvent();
		//			editevent.setVisible(true);
					}
			}

		public class ActionLogOut implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
					Login login = new Login();
					login.setVisible(true);
					dispose();
					}
			}
}