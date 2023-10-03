package ServerTesting;

import java.io.*;
import java.net.*;

public class TCPServer {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(12345); // Portnummer hier anpassen
      System.out.println("Server IP: " + getPublicIPv6() + " Port: " + serverSocket.getLocalPort() + "\n" + "Warte auf Verbindung...");

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

  public static String getPublicIPv6() throws IOException {
    URL url = new URL("https://ipv6.icanhazip.com/");
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

    try {
      // Lesen Sie die Antwort von der Website
      BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
      String line;
      StringBuilder response = new StringBuilder();

      while ((line = reader.readLine()) != null) {
        response.append(line);
      }

      // Die Antwort von ipv6.icanhazip.com enthält die IPv6-Adresse
      return response.toString().trim();
    } finally {
      httpURLConnection.disconnect();
    }
  }
}