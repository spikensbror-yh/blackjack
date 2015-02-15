package blackjack.game;

public class Dealer extends Player {
    private final Deck deck = new Deck();
    
    public Deck getDeck() {
        return this.deck;
    }
    
    public void useAdditionalDeck() {
        getDeck().addFullDeck();
        getDeck().shuffle();
    }
    
    public void hit(Player player) {
        Card card = getDeck().getTopCard();
        getDeck().removeTopCard();
        
        player.getHand().add(card);
    }
    
    @Override
    public void reset() {
        super.reset();
        deck.reset();
    }
}
