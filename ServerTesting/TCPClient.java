package ServerTesting;
import java.io.*;
import java.net.*;


public class TCPClient {
  public static void main(String[] args) {
    try {

      Socket socket = new Socket("2001:16b8:31ff:8800:a1f0:1f7d:8590:d6e1", 12345); // Temporäre IP-Adresse
      System.out.println("Connecting to server's ip: " + "2001:16b8:31ff:8800:135:6972:975b:754d");

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