package projava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
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

                    // Prepare HTTP response
                    String currentTime = LocalDateTime.now().toString();
                    String responseBody = STR."<html><head><title>Improved Web Server</title></head><body><h1>Welcome to the improved Web Server!</h1><p>The current time is \{currentTime}</p><p>This is an example of a simple HTTP response.</p></body></html>";
                    w.println("HTTP/1.1 200 OK");
                    w.println("Content-Type: text/html");
                    w.println("Content-Length: " + responseBody.getBytes(
                            StandardCharsets.UTF_8));
                    w.println();
                    w.println();
                    w.println(responseBody);
                    w.println("Connection: close");

                } catch (SocketTimeoutException e) {
                    logger.log(Level.WARNING,
                               "Connection timed out: " + e.getMessage(), e);
                } catch (IOException e) {
                    // Print I/O errors
                    logger.log(Level.SEVERE, "I/O error: " + e.getMessage(), e);
                } catch (Exception e) {
                    logger.log(
                            Level.SEVERE,
                            "Unexpected error: " + e.getMessage(),
                            e);
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