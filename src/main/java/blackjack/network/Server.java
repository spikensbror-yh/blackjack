package blackjack.network;

import java.io.*;
import java.net.*;

public class Server {
    private final int port;
    private final ServerSocket socket;
    
    public Server(int port) throws IOException {
        this.port = port;
        this.socket = new ServerSocket(port);
    }
    
    public int getPort() {
        return this.port;
    }
    
    public ServerSocket getSocket() {
        return this.socket;
    }
    
    public void listen() throws IOException {
        while (true) {
            (new ClientThread(new Client(getSocket().accept()))).start();
        }
    }
}
