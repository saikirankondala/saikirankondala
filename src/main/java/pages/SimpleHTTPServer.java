package pages;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class SimpleHTTPServer {

    public static void main(String[] args) throws IOException {
        // Specify the port on which the server should listen
        int port = 8000;

        // Create an HTTP server on the specified port
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Set up the context to handle requests
        server.createContext("/", new MyHandler());

        // Start the server
        server.start();

        System.out.println("Server is running on http://localhost:" + port);
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Get the requested URI
            String uri = exchange.getRequestURI().toString();

            // Load the requested file
            String filePath = "C:\\Users\\Saikiran Kondala\\Music\\selenium\\target\\test-output\\Reports\\Clucloud_Test_Automation_Report.html" + uri;

            File file = new File(filePath);

            // Check if the file exists
            if (file.exists()) {
                byte[] fileBytes = Files.readAllBytes(file.toPath());

                // Set the content type based on the file extension
                String contentType = getContentType(file.getName());

                // Set the response headers
                exchange.getResponseHeaders().set("Content-Type", contentType);
                exchange.sendResponseHeaders(200, fileBytes.length);

                // Write the file content to the response body
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(fileBytes);
                }
            } else {
                // If the file is not found, send a 404 response
                String response = "File not found";
                exchange.sendResponseHeaders(404, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
        }

        private String getContentType(String fileName) {
            if (fileName.endsWith(".html")) {
                return "text/html";
            } else if (fileName.endsWith(".css")) {
                return "text/css";
            } else {
                return "application/octet-stream";
            }
        }
    }
}
