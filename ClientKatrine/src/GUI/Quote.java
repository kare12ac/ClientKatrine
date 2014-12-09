package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import JsonClasses.testing;
import Logic.ServerConnection;

import javax.swing.JTextArea;

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
		headline.setForeground(Color.ORANGE);
		headline.setFont(new Font("Arial", Font.BOLD, 22));
		headline.setBounds(190, 32, 168, 33);
		
		panel.add(author);
		panel.add(topic);
		panel.add(quote);
		panel.add(btnexit);
		panel.add(headline);
		getContentPane().add(panel);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(26, 158, 53, 16);
		panel.add(lblAuthor);
		
		JLabel lblTopic = new JLabel("Topic:");
		lblTopic.setBounds(26, 186, 44, 16);
		panel.add(lblTopic);
		lblQuote.setBounds(26, 214, 44, 16);
		
		panel.add(lblQuote);
		
//		setDefaultCloseOperation(closeOperation());
		
		
//		showQuote();
//		btnexit.addActionListener(new Actionbtnexit());
//		
//		
		
		getContentPane().add(panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(119, 129, 232, 116);
		panel.add(textArea);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	
	
		public int CloseOperation(){
			setVisible(false);
			return 1;
		}
		
		public void actionQuote(){
			String getQuote = "getQuote";
			testing quoting = new testing();
			Gson gson = new Gson();
			ServerConnection connection = new ServerConnection();
			try {
			quoting = gson.fromJson(connection.connectToServerAndSendReturnObject(getQuote), testing.class);
			} catch (JsonSyntaxException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
			
			}
			public class ActionThankYou implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
				
			}
			
		}
	}

