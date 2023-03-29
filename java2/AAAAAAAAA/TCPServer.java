import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;

public class TCPServer {
      
  public static void main(String[] args) throws IOException, InterruptedException {
	  // creates of a server socket and binds it to the port number 10000:
    ServerSocket serverSocket = new ServerSocket(10000);
		    
    //Once a ServerSocket instance is created, call accept() to start listening for incoming client requests:
    Socket clientSocket = serverSocket.accept();

    // Initial message of our Server 
	  System.out.println("Client Connected");

    // Use to read the data send from the client
    DataInputStream serverDataInputStream = new DataInputStream(clientSocket.getInputStream());
   
    try{
       
      while (true){
       //Read message from the client socket 
        String clientMessage = serverDataInputStream.readUTF();
        System.out.println("client says: " + clientMessage);

        // breaking the infinite loop
        if(clientMessage.equalsIgnoreCase("exit"))
          break;
      }

    } catch (IOException e) {
        // Exceptions to be handle
	      System.out.println(e);
    }finally{
      // Closing the socket. 
	    serverSocket.close();
    }    
  }
}
