package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.google.gson.Gson;

import JsonClasses.getEvents;
import Logic.ServerConnection;
import Logic.TCPClient;
import Logic.EncryptUserID;
public class ImportEvents extends JFrame {

/**
	 * 
	 */
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
	btnImport.setBounds(78, 398, 145, 29);
	
	EncryptUserID e = new EncryptUserID();
	String userID = "anha13ao";
	
	panel.add(btnImport);
	btnCancel.setBounds(264, 400, 100, 24);
	panel.add(btnCancel);
	panel.add(lblImport);

	getContentPane().add(panel);
	String[] test = {""};
	Object[][] data=
		{
			{"events"},{"data"}
		};
	
	JTable dataTable = new JTable(data, test);
	dataTable.setBounds(63, 91, 444, 184);
	panel.add(dataTable);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	impEvents();
	
}

public  void impEvents(){
	btnImport.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			getEvents getevents = new getEvents();
		//	getevents.setCalenderID(CalenderID.getText());
			
			TCPClient tc = new TCPClient();
			String ImportCBSev = null;
			
			getEvents ge = new getEvents();			
			ge.seteventid("1");
			Gson gson = new Gson();
			//String jsonString = gson.toJson(ge);
			
			System.err.println(ge.geteventid());
			ServerConnection connection = new ServerConnection();
			TCPClient client = new TCPClient();
			
			
			
		EncryptUserID e = new EncryptUserID();
		String userID = "anha13ao";
		
		
		userID ="anha13ao";
        String json = null;
		try {
			json = readUrl("http://calendar.cbs.dk/events.php/"+userID+"/"+e.getKey(userID)+".json");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] print= {""};
		{
		} 
		
        System.out.println("hei på deg " +json);
		}
		String[] test = {""};
		Object[][] data=
		String jsonString = gson.toJson(ge);
			
			{
				{jsonString}
			};
       
		
		
		
		private  String readUrl(String urlString) throws Exception {
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
		
	});
	
	
}
	
	
}
