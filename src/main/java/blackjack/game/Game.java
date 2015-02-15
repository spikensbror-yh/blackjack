package blackjack.game;

import java.util.*;

public class Game {
    private final Random random = new Random();
    private final Dealer dealer = new Dealer();
    private final Player player = new Player();
    private final Result result = new Result();
    
    public Game() {
        result.setDealerHand(dealer.getHand());
        result.setPlayerHand(player.getHand());
    }
    
    public Random getRandom() {
        return this.random;
    }
    
    public Dealer getDealer() {
        return this.dealer;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Result getResult() {
        return this.result;
    }
    
    public void initialize() {
        getResult().reset();
        getDealer().reset();
        if (getRandom().nextBoolean()) {
            getDealer().useAdditionalDeck();
            getResult().setAdditionalDeck(true);
        }
        getPlayer().reset();
        
        getDealer().hit(player);
        getDealer().hit(player);
        getDealer().hit(dealer);
    }
    
    public void handle(Action action) {
        if (getResult().isEnded() && action.getType() != Action.Type.Restart) {
            getResult().setShouldRestart(true);
            return;
        }
        
        switch (action.getType()) {
            case Hit: {
                getDealer().hit(getPlayer());
            } break;
                
            case Stand: {
                getResult().setEnded(true);
            } break;
            
            case Restart: {
                initialize();
            } break;
        }
        
        if (getPlayer().getHand().getScore() > 21) {
            getResult().setBust(true);
            getResult().setEnded(true);
        }
        
        if (getResult().isEnded() && !getResult().isBust()) {
            getDealer().hit(dealer);
            while (getDealer().getHand().getScore() < 17) {
                getDealer().hit(dealer);
            }
            
            int dealerScore = getDealer().getHand().getScore();
            int playerScore = getPlayer().getHand().getScore();
            getResult().setWin(dealerScore < playerScore || dealerScore > 21);
        }
    }
}
