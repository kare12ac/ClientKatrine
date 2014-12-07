package Logic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
 
import JsonClasses.*;
 
public class TCPClient {
       
        public String sendMessage(String gsonString) throws Exception {
                encryption cryp = new encryption();
                String stringToBeReturned = null;
                String modifiedSentence;
                Socket clientSocket = new Socket("localhost", 8888);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
               
                byte[] encrypted = cryp.decrypt(gsonString.getBytes());
                outToServer.write(encrypted);
                System.out.println("FROM CLIENT:"+encrypted);
                outToServer.flush();
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                modifiedSentence = inFromServer.readLine();
                System.out.println("SE HER FRA SERVER: "+modifiedSentence);
                String TestingString = new String(modifiedSentence).trim();
               
                byte[] decrypted = cryp.decrypt(TestingString.getBytes());
               
                String decrypted2 = new String(decrypted).trim();
                System.out.println("FROM SERVER: " + decrypted2);
                clientSocket.close();
                stringToBeReturned = decrypted2;
               
                return stringToBeReturned;
        }
}