package blackjack.game;

import java.io.Serializable;
import java.util.*;

public class Hand implements Serializable {
    private final ArrayList<Card> cards = new ArrayList<>();
    
    public List<Card> getCards() {
        return this.cards;
    }
    
    public boolean hasCardOfValue(Card.Value value) {
        boolean found = false;
        for (Card card : getCards()) {
            if (card.getValue() == value) {
                found = true;
                break;
            }
        }
        
        return found;
    }
    
    public boolean hasAce() {
        return hasCardOfValue(Card.Value.ACE);
    }
    
    public int getScore() {
        return (getHighScore() > 21)
            ? getLowScore()
            : getHighScore();
    }
    
    public int getHighScore() {
        int score = getLowScore();
        if (hasAce()) {
            score += 10;
        }
        
        return score;
    }
    
    public int getLowScore() {
        int score = 0;
        for (Card card : getCards()) {
            int value = card.getValue().ordinal() + 1;
            value = (value > 10) ? 10 : value;
            
            score += value;
        }
        
        return score;
    }
    
    public void add(Card card) {
        getCards().add(card);
    }
    
    public void clear() {
        getCards().clear();
    }
}
