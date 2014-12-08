package GUI;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import JsonClasses.createEvent;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;

import JsonClasses.createEvent;
import Logic.ServerConnection;
import Logic.TCPClient;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImportEvents extends JFrame {


	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JButton btnImport = new JButton("Import Events");
	JButton btnCancel = new JButton("Cancel");
	JLabel lblImport = new JLabel("Imported Events");
	private JTable impev;


	public ImportEvents(){
		super("Import Events");
		setSize(550,550);
		lblImport.setBounds(192,6,253,73);
		lblImport.setForeground(Color.ORANGE);
		lblImport.setFont(new Font("Lucida Grande", Font.BOLD,22));
		panel.setLayout(null);

		btnImport.setBounds(384, 33, 145, 29);

		panel.add(btnImport);
		btnCancel.setBounds(429, 67, 100, 24);
		panel.add(btnCancel);
		panel.add(lblImport);

		getContentPane().add(panel);
		String[] test = {""};
		Object[][] data=
			{
				{"events"},{"data"}
			};

		JTable dataTable = new JTable(data, test);
		dataTable.setBounds(63, 91, 444, 52);
		panel.add(dataTable);

		JTextArea calendarTextArea = new JTextArea();
		calendarTextArea.setBounds(63, 167, 444, 166);
		panel.add(calendarTextArea);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionEvents();

		btnImport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try{
					calendarTextArea.setText(getCalendar());
				}catch(Exception e){

				}
			}
		});
	}

	public String getCalendar() throws Exception{
		String calendar = readUrl("http://calendar.cbs.dk/events.php/anha13ao/c69e9c9423e1154d9eea09b9a02a6a91.json");
		return calendar;
	}

	public String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public  void  actionEvents(){

		btnImport.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				ServerConnection connection = new ServerConnection();

				TCPClient tc = new TCPClient();
				String eventstoclient = null;


				try {
					ServerSocket welcomeSocket = new ServerSocket(8889);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				URL objectGet = null;
				try {
					objectGet = new URL("http://calendar.cbs.dk/events.php/anha13ao/c69e9c9423e1154d9eea09b9a02a6a91.json");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				URLConnection yc = null;
				try {
					yc = objectGet.openConnection();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader in = null;
				try {
					in = new BufferedReader(
							new InputStreamReader(
									yc.getInputStream()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Gson gson = new Gson();

				try {
					for (int i=0; i<300; i++)
					{
						System.out.println(in.readLine());
					}
					createEvent data = new Gson().fromJson(in.readLine(), createEvent.class);

					//			            System.out.println(data.getname());
				}catch (Exception e) {
					e.printStackTrace();
				}
			}      





		}
				);
	}
}		       

















