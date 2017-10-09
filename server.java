import java.io.*;
import java.net.*;

public class server
{
  public static void main(String args[]) throws Exception
  {
      String clientSentence;
      String capitalizedSentence;
      ServerSocket welcomeSocket = new ServerSocket(6789);

      while(true) {
	Socket connectionSocket = welcomeSocket.accept();

	System.out.println("Launching server & starting connection.");


        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

	DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

	clientSentence = inFromClient.readLine();

	System.out.println("Text from client: " + clientSentence);


	capitalizedSentence = clientSentence.toUpperCase() + '\n';

	outToClient.writeBytes(capitalizedSentence);

	}
     }
}
