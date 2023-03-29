import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.InetAddress;

public class TCPClient {
  public static void main(String[] args) throws IOException {
    // Socket declaration and assignment of port 10000
    Socket clientSocket = new Socket("localhost", 10000);

    // to handle the data flowing from the client to the server
    DataOutputStream clientDataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

    // will be use to take the input from the client console
    BufferedReader clientBufferedReader = new BufferedReader(new InputStreamReader(System.in));

    try {
      while (true) {

        // Read message from the client console
        String clientMessage = clientBufferedReader.readLine();

        // send message to server
        clientDataOutputStream.writeUTF(clientMessage);

        // breaking the infinite loop
        if (clientMessage.equalsIgnoreCase("exit"))
          break;
      }

    } finally {
      // Closing the socket.
      clientSocket.close();
    }
  }
}
