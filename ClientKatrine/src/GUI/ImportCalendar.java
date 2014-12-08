package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import JsonClasses.CalendarInfo;
import JsonClasses.getCalendar;
import Logic.ServerConnection;
import Logic.TCPClient;

import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

public class ImportCalendar extends JFrame{

	JPanel panel = new JPanel();
	JTable tblimCal = new JTable();
	JButton btnImport = new JButton("Import Calendar");
	JButton btnCancel = new JButton("Cancel");
	JLabel lblImport = new JLabel("Imported Calendar");
	private JTable table;
	
	public ImportCalendar(){
		super("Import Calendar");
		setSize(550,550);
		lblImport.setBounds(192, 6, 253, 73);
		lblImport.setForeground(Color.ORANGE);
		lblImport.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		panel.setLayout(null);
		btnImport.setBounds(78, 398, 145, 29);
		
		panel.add(btnImport);
		btnCancel.setBounds(264, 400, 100, 24);
		panel.add(btnCancel);
		panel.add(lblImport);
		tblimCal.setBounds(53, 361, 424, -282);
		panel.add(tblimCal);
		
		
		getContentPane().add(panel);
		String [] test ={""};
		Object [][] data=
			{
				{"events"},{"data2"}
			};
		
		JTable dataTable = new JTable(data,test);
		dataTable.setBounds(63, 91, 444, 184);
		panel.add(dataTable);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		calendarImp();
	}
	
	public void calendarImp(){
		btnImport.addActionListener(new ActionListener(){
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent event){
				TCPClient tc = new TCPClient();
				String importCBS = null;
				

				getCalendar getget = new getCalendar();
				getget.setUserName("1");
				Gson gson = new Gson();
				String jsonString = gson.toJson(getget);
				
				System.err.println(getget.getUserName());
				ServerConnection connection = new ServerConnection();
				TCPClient client = new TCPClient();
				CalendarInfo returncalendarinfo = null;
				try{
					
				importCBS = tc.sendMessage(jsonString);
				
				
				JsonParser parser = new JsonParser();
				System.err.println("Parsed from: " + jsonString);
				JsonArray ja = parser.parse(importCBS).getAsJsonArray();
				
				
				ArrayList<CalendarInfo> cal = new ArrayList<CalendarInfo>();
				
				
				System.err.println("SIZE: " + ja.size());
				for(JsonElement obj : ja )
			    {
					System.err.println(obj);
			        CalendarInfo finalcal = gson.fromJson( obj , CalendarInfo.class);
			        cal.add(finalcal);
			    }
				
				//returncalendarinfo = (CalendarInfo)gson.fromJson(importCBS, CalendarInfo.class);
				
//				System.out.println(cal.get(1));
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error123");
					e.printStackTrace();
				}
				
				System.out.println(returncalendarinfo.getCalenderName());
				System.out.println("returnert!");
				
				
			//	String replyfromserver = gson.fromJson(importCBS, CalendarInfo.class);
				
			
				
				
//			if(importCBS.equals("1")){
				if(true){
System.out.println("naaede her til");

				AddEvent event123 = new AddEvent();
				event123.setVisible(true);
				dispose();
				
			}else{
				JOptionPane.showMessageDialog(null, "Wrong password, username or user is unactive");
			
			
			
			
			}
		}
				
		
		
	}
	
	
		);
	}
}
