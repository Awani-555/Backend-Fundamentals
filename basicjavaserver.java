import java.io.*;
import java.net.*;

public class RawTCPServer {
    public static void main(String[] args) throws IOException {
        // Create a socket that listens on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");
        
        while (true) {
            // Accept incoming connection (blocking call)
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            
            // Get input/output streams
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Read what the client sent (line by line)
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
                if (line.isEmpty()) break; // HTTP headers end with empty line
            }
            
            // Send HTTP response
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain");
            out.println();
            out.println("Hello from raw socket server!");
            
            clientSocket.close();
        }
    }
}