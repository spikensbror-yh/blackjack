package blackjack.game;

import java.io.Serializable;

public class Result implements Serializable {
    private Hand playerHand;
    private Hand dealerHand;
    private boolean ended = false;
    private boolean additionalDeck = false;
    private boolean win = false;
    private boolean bust = false;
    private boolean shouldRestart = false;
    
    public Hand getPlayerHand() {
        return this.playerHand;
    }
    
    public void setPlayerHand(Hand hand) {
        this.playerHand = hand;
    }
    
    public Hand getDealerHand() {
        return this.dealerHand;
    }
    
    public void setDealerHand(Hand hand) {
        this.dealerHand = hand;
    }
    
    public boolean isEnded() {
        return this.ended;
    }
    
    public void setEnded(boolean ended) {
        this.ended = ended;
    }
    
    public boolean hasAdditionalDeck() {
        return this.additionalDeck;
    }
    
    public void setAdditionalDeck(boolean additionalDeck) {
        this.additionalDeck = additionalDeck;
    }
    
    public boolean isWin() {
        return this.win;
    }
    
    public void setWin(boolean win) {
        this.win = win;
    }
    
    public boolean isBust() {
        return this.bust;
    }
    
    public void setBust(boolean bust) {
        this.bust = bust;
    }
    
    public boolean getShouldRestart() {
        return this.shouldRestart;
    }
    
    public void setShouldRestart(boolean shouldRestart) {
        this.shouldRestart = shouldRestart;
    }
    
    public void reset() {
        setEnded(false);
        setAdditionalDeck(false);
        setWin(false);
        setBust(false);
        setShouldRestart(false);
    }
}
