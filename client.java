import java.io.*;
import java.net.*;

public class client
{
     public static void main(String[] args) throws Exception
     {
	String sentence;
	String modifiedSentence;

	System.out.println("Enter text: ");

	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

	Socket clientSocket = new Socket("192.168.253.130", 6789);

	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

	sentence = inFromUser.readLine();

	outToServer.writeBytes(sentence + '\n');
	modifiedSentence = inFromServer.readLine();
	System.out.println("FROM SERVER: " + modifiedSentence);

	clientSocket.close();
	}
}        
