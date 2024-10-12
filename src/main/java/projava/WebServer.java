package projava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServer {
    private static final Logger logger = Logger.getLogger(WebServer.class.getName());

    public static void main(String[] args) {
        // Start the server on port 8880
        try (ServerSocket server = new ServerSocket(8880)) {
            while (true) {
                // Wait for a client connection
                try (Socket soc = server.accept();
                        var isr = new InputStreamReader(soc.getInputStream());
                        var bur = new BufferedReader(isr);
                        var w = new PrintWriter(soc.getOutputStream(), true)
                ) {
                    String clientAddress = soc.getInetAddress().toString();
                    logger.info("Connected from " + clientAddress);

                    // Read and print request lines
                    bur.lines()
                       .takeWhile(line -> ! line.isEmpty())
                       .forEach(line -> logger.info("Request: " + line));

                    // Send an HTTP response
                    w.println("HTTP/1.1 200 OK");
                    w.println("Content-Type: text/html");
                    w.println();
                    w.println("<html><head><title>Hello</title></head>");
                    w.println("<body><h1>Hello</h1>It works!</body></html>");
                } catch (IOException e) {
                    // Print I/O errors
                    logger.log(Level.SEVERE, "I/O error: " + e.getMessage(), e);
                }
            }
        } catch (IOException e) {
            // Print errors if the server cannot start
            logger.log(
                    Level.SEVERE,
                    "Server could not start: " + e.getMessage());
        }
    }
}