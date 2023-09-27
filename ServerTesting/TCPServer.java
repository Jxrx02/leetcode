package ServerTesting;

import java.io.*;
import java.net.*;

public class TCPServer {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(12345); // Portnummer hier anpassen
      System.out.println("Server wartet auf Verbindung... ");

      Socket clientSocket = serverSocket.accept();
      System.out.println("Verbindung hergestellt mit: " + clientSocket.getInetAddress().getHostAddress());

      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      String message;
      while ((message = in.readLine()) != null) {
        System.out.println("Nachricht vom Client: " + message);
        out.println("Nachricht empfangen: " + message);
      }

      in.close();
      out.close();
      clientSocket.close();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}