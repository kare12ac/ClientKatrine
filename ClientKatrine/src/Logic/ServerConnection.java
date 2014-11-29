package Logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



public class ServerConnection {
	public static void main(String[] args) throws Exception {
	
	//SwitchMethods sw = new SwitchMethods();
	//QOTDModel QOTDKlasse = new QOTDModel();
	//String reply = QOTDKlasse.getQuote();
	
		//metoden som skal brukes er getDataFromCalendar 
		//i klassen GetCalendarData i pakken, model.calendar
	}
		public static String getText(String url) throws Exception {
	        URL website = new URL(url);
	        URLConnection connection = website.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                    connection.getInputStream()));

	        StringBuilder response = new StringBuilder();
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) 
	            response.append(inputLine);

	        in.close();

	        return response.toString();
	}
}
