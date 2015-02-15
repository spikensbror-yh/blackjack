package blackjack.game;

public class Player {
    private final Hand hand = new Hand();
    
    public Hand getHand() {
        return hand;
    }
    
    public void reset() {
        getHand().clear();
    }
}
