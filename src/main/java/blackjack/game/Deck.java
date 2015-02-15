package blackjack.game;

import java.util.*;

public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();
    
    public List<Card> getCards() {
        return this.cards;
    }
    
    public void addFullDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                this.cards.add(new Card(suit, value));
            }
        }
    }
    
    public Card getTopCard() {
        return getCards().get(0);
    }
    
    public void removeTopCard() {
        getCards().remove(0);
    }
    
    public void shuffle() {
        Collections.shuffle(this.cards);
    }
    
    public final void reset() {
        this.cards.clear();
        initialize();
    }
    
    public final void initialize() {
        this.addFullDeck();
        this.shuffle();
    }
}
