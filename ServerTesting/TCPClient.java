package ServerTesting;
import java.io.*;
import java.net.*;


public class TCPClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("10.50.122.72", 12345); // Server-IP und Port hier anpassen

      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      out.println("Hallo, Ich bims!");
      String response = in.readLine();
      System.out.println("Antwort vom Server: " + response);

      in.close();
      out.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}