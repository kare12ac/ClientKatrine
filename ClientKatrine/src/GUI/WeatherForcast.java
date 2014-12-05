package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class WeatherForcast extends JFrame{

	
	JPanel panel = new JPanel();
	JLabel Date = new JLabel("Date");
	JLabel Celcius = new JLabel("Celcius");
	JLabel Desc = new JLabel("Desc");
	
	JLabel header = new JLabel("Weather Forcast");
	JButton btnexit =  new JButton("Exit");
	
	public WeatherForcast(){
		super("Weather");
		setSize(550,550);
		setLocation(500,280);
		panel.setLayout(null);
		
		Date.setBounds(6,91,100,50);
		Celcius.setBounds(6,228,100,50);
		Desc.setBounds(6,153,100,50);
		header.setForeground(Color.ORANGE);
		header.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		header.setBounds(164, 19, 219, 50);
		btnexit.setBounds(203, 312, 105, 29);
		
		panel.add(Date);
		panel.add(Celcius);
		panel.add(Desc);
		panel.add(header);
		panel.add(btnexit);
		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
		public class ActionWeatherForcast implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
			}
		
		
		
	}
	
}
