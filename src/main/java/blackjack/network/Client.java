package blackjack.network;

import java.io.*;
import java.net.*;

public class Client {
    private final Socket socket;
    private final ObjectOutputStream output;
    private final ObjectInputStream input;
    
    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
    }
    
    public Socket getSocket() {
        return this.socket;
    }
    
    public ObjectOutputStream getOutput() {
        return this.output;
    }
    
    public ObjectInputStream getInput() {
        return this.input;
    }
}
