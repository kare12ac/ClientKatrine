package Logic;
import Logic.encryptionAES;


import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import com.google.gson.Gson;

import JsonClasses.AuthUser;
import Logic.encryption;

public class ServerConnection {

	private Socket connectionClient;
	private String jsonIn;
	private TCPClient tc;
	private byte[] byteArrayIn = new byte[500000];
	private byte[] byteArrayOut = new byte[500000];
	
//	private encryption encryptionObject = new encryption(); 
//	
//	public String connectToServerAndSendReturnObject(String jsonOut) throws IOException{
//		System.out.println("Attempting connection...");
//		connectionClient = new Socket(InetAddress.getByName("localhost"), 8888);
//		System.out.println("Connected to "+connectionClient.getInetAddress().getHostAddress());
//		//byteArrayOut = encryptionObject.encrypted(jsonOut);
//		connectionClient.getOutputStream().write(byteArrayOut);
//		
//		connectionClient.getInputStream().read(byteArrayIn);
//	
//		jsonIn = encryptionObject.decrypt(byteArrayIn);
//	
//		return jsonIn;
		
		
		public String connectToServerAndSendReturnObject(String jsonOut) throws IOException{
			
			System.out.println("Attempting connection...");
			connectionClient = new Socket(InetAddress.getByName("localhost"), 8888);
			System.out.println("Connected to "+connectionClient.getInetAddress().getHostAddress());
			
			Gson g = new Gson();
			
			String ut = g.toJson(jsonOut);
			System.out.println("Slik at det bli slik: " + jsonOut);
		
			System.out.println("Siden det må sendes i bytes så gjøres det om til bytes ");
			//byteArrayOut = jsonOut.getBytes();
			TCPClient tc = new TCPClient();
			//tc.sendMessage(gsonString);
			
			
			
			
			System.out.println("Så sendes det til server");
			connectionClient.getOutputStream().write(byteArrayOut);
			System.out.println(byteArrayOut.toString());
			System.out.println("Sendt");
			
			return "hello";
		
			
//			public String connectToServerAndSendReturnObject(String jsonOut) throws IOException{
//				
//				System.out.println("Attempting connection...");
//				connectionClient = new Socket(InetAddress.getByName("localhost"), 8888);
//				System.out.println("Connected to "+connectionClient.getInetAddress().getHostAddress());
//				
//				Gson g = new Gson();
//				
//				String ut = g.toJson(jsonOut);
//				System.out.println("Slik at det bli slik: " + jsonOut);
//			
//				System.out.println("Siden det må sendes i bytes så gjøres det om til bytes ");
//				byteArrayOut = jsonOut.getBytes();
//			
//				System.out.println("Så sendes det til server");
//				connectionClient.getOutputStream().write(byteArrayOut);
//				System.out.println("Sendt");
//				
//				return "hello";
//			}
			
			
	}
}
