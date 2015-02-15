package blackjack.game;

import java.io.Serializable;

public class Card implements Serializable {
    public enum Suit {
        HEARTS,
        DIAMONDS,
        CLUBS,
        SPADES
    }
    
    public enum Value {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        KNIGHT,
        QUEEN,
        KING
    }
    
    private final Suit suit;
    private final Value value;
    
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    public Suit getSuit() {
        return this.suit;
    }
    
    public Value getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        String result = "";
        switch (getValue()) {
            case ACE: result += "Ace of "; break;
            case TWO: result += "Two of "; break;
            case THREE: result += "Three of "; break;
            case FOUR: result += "Four of "; break;
            case FIVE: result += "Five of "; break;
            case SIX: result += "Six of "; break;
            case SEVEN: result += "Seven of "; break;
            case EIGHT: result += "Eight of "; break;
            case NINE: result += "Nine of "; break;
            case TEN: result += "Ten of "; break;
            case KNIGHT: result += "Knight of "; break;
            case QUEEN: result += "Queen of "; break;
            case KING: result += "King of "; break;
        }
        
        switch (getSuit()) {
            case HEARTS: result += "Hearts"; break;
            case DIAMONDS: result += "Diamonds"; break;
            case CLUBS: result += "Clubs"; break;
            case SPADES: result += "Spades"; break;
        }
        
        return result;
    }
}
