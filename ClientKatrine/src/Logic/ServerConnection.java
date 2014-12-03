package Logic;



import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import Logic.encryption;

public class ServerConnection {
}
//	private Socket connectionClient;
//	private String jsonIn;
//	private byte[] byteArrayIn = new byte[500000];
//	private byte[] byteArrayOut = new byte[500000];
//	
//	private encryption encryptionObject = new encryption(); 
//	
//	public String connectToServerAndSendReturnObject(String jsonOut) throws IOException{
//		System.out.println("Attempting connection...");
//		connectionClient = new Socket(InetAddress.getByName("localhost"), 8349);
//		System.out.println("Connected to "+connectionClient.getInetAddress().getHostAddress());
//		byteArrayOut = encryptionObject.encrypted(jsonOut);
//		connectionClient.getOutputStream().write(byteArrayOut);
//		//efter ovenforst��ende venter klienten p�� svar, og det skulle gerne
//		//komme i form af et bytearray fra serveren, som h��ndteres nedenfor:
//		connectionClient.getInputStream().read(byteArrayIn);
//		//i ovenforst��ende linje l��ser getInputStrem().read det indkommende
//		//bytearray og gemmer det i variablen connectionClient. Sidenhen bliver
//		//variablen brugt til at sende til decrypt metoden i Encryption klassen
//		//som dekrypterer den og gemmer den i en String i form af json.
//		jsonIn = encryptionObject.decrypt(byteArrayIn);
//		//metoden returnerer til sidst en String i form af json.
//		return jsonIn;
//	}
//
//}