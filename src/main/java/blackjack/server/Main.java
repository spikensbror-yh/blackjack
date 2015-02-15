package blackjack.server;

import blackjack.network.Server;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: server.jar <port>");
        }
        
        int port;
        Server server;
        
        try {
            port = Integer.parseInt(args[0]);
            server = new Server(port);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Exception caught on start: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        
        try {
            System.out.println("Listening on port " + port + "...");
            server.listen();
        } catch (Exception e) {
            System.out.println("Exception caught on listen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
