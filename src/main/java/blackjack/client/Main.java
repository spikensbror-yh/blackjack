package blackjack.client;

import blackjack.client.view.*;
import blackjack.game.*;
import blackjack.network.Client;
import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    private final static ArrayList<Renderable> renderQueue = new ArrayList<>();
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: client.jar <host> <port>");
            return;
        }
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Client client;
        
        try {
            String host = args[0];
            int port = Integer.parseInt(args[1]);
            client = new Client(new Socket(host, port));
            System.out.println("Connected to '" + host + "' on port " + port + ".");
        } catch(NumberFormatException | IOException e) {
            System.out.println("Exception caught on connect: " + e.getMessage());
            e.printStackTrace();
            return;
        }
         
        try {
            Result result;
            while ((result = (Result)client.getInput().readObject()) != null) {
                update(result);
                render();
                
                Action action = null;
                while (action == null) {
                    System.out.print("> ");
                    action = getActionFromInput(stdin);
                }

                if (action.getType() == Action.Type.Exit) {
                    client.getSocket().close();
                    break;
                }
                
                client.getOutput().writeObject(action);
                client.getOutput().reset();
            }
        } catch(Exception e) {
            System.out.println("Exception caught on handle: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static Action getActionFromInput(BufferedReader input) throws IOException {
        Action action = new Action(Action.Type.Unknown);
        switch (input.readLine().toLowerCase()) {
            case "hit": {
                action = new Action(Action.Type.Hit);
            } break;

            case "stand": {
                action = new Action(Action.Type.Stand);
            } break;

            case "restart": {
                action = new Action(Action.Type.Restart);
            } break;

            case "exit": {
                action = new Action(Action.Type.Exit);
            } break;
                
            case "help": {
                System.out.println("Commands: hit, stand, restart, exit, help");
            } break;
        }
        
        return action;
    }
    
    public static void update(Result result) {
        renderQueue.add(new TurnView(result));
        
        if (result.isEnded()) {
            renderQueue.add(new ResultView(result));
        }
    }
    
    public static void render() {
        for (Renderable renderable : renderQueue) {
            renderable.render(System.out);
        }
        
        renderQueue.clear();
    }
}
