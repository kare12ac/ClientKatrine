package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Quote extends JFrame{

	JPanel panel = new JPanel();
	JLabel author = new JLabel();
	JLabel topic = new JLabel();
	JLabel quote = new JLabel();
	JLabel headline = new JLabel("Daily Qoute");
	JButton btnexit = new JButton("Exit");
	private final JLabel lblQuote = new JLabel("Quote:");
	
	public Quote(){
		super("Quote");
		setSize(550,550);
		setLocation(500,280);
		panel.setLayout(null);
	
		author.setBounds(340, 44, 168, 33);
		topic.setBounds(568, 44, 178, 33);
		quote.setHorizontalAlignment(SwingConstants.CENTER);
		quote.setBounds(6, 125, 988, 25);
		btnexit.setBounds(201, 282, 104, 33);
		headline.setForeground(new Color(0, 0, 128));
		headline.setFont(new Font("Arial", Font.BOLD, 20));
		headline.setBounds(190, -1, 168, 33);
		
		panel.add(author);
		panel.add(topic);
		panel.add(quote);
		panel.add(btnexit);
		panel.add(headline);
		getContentPane().add(panel);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(17, 44, 53, 16);
		panel.add(lblAuthor);
		
		JLabel lblTopic = new JLabel("Topic:");
		lblTopic.setBounds(17, 97, 44, 16);
		panel.add(lblTopic);
		lblQuote.setBounds(16, 148, 44, 16);
		
		panel.add(lblQuote);
		
//		setDefaultCloseOperation(closeOperation());
		
		
//		showQuote();
//		btnexit.addActionListener(new Actionbtnexit());
//		
//		
		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	
	
		public int CloseOperation(){
			setVisible(false);
			return 1;
		}
		
		public class ActionQuote implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}
	}

