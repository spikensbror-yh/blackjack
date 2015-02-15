package blackjack.network;

import blackjack.game.*;

public class ClientThread extends Thread {
    private final Client client;
    private final Game game = new Game();
    
    public ClientThread(Client client) {
        this.client = client;
    }
    
    public Client getClient() {
        return this.client;
    }
    
    public Game getGame() {
        return this.game;
    }
    
    @Override
    public void run() {
        System.out.println("Client connected!");
        
        try {
            getGame().handle(new Action(Action.Type.Restart));
            getClient().getOutput().writeObject(getGame().getResult());
            getClient().getOutput().reset();
            
            Action input;
            while ((input = (Action)getClient().getInput().readObject()) != null) {
                getGame().handle(input);
                getClient().getOutput().writeObject(getGame().getResult());
                getClient().getOutput().reset();
            }
        } catch (Exception e) {
            if (getClient().getSocket().isConnected()) {
                try {
                    getClient().getSocket().close();
                } catch (Exception inner) {
                    inner.printStackTrace();
                }
            }
            
            System.out.println("Client disconnected!");
        }
    }
}
