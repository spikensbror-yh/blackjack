package blackjack.client.view;

import blackjack.game.Card;
import blackjack.game.Hand;
import blackjack.game.Result;
import java.io.PrintStream;

public abstract class View implements Renderable {
    private final Result result;
    
    public View(Result result) {
        this.result = result;
    }
    
    public Result getResult() {
        return this.result;
    }
    
    protected void printHand(PrintStream output, String label, Hand hand) {
        output.print(label + ": ");
        if (hand.hasAce() && hand.getHighScore() == hand.getScore()) {
            output.println(hand.getLowScore() + " or " + hand.getHighScore());
        } else {
            output.println(hand.getScore());
        }
        
        for (Card card : hand.getCards()) {
            output.println(" * " + card.toString());
        };
    }
    
    protected void printSeparator(PrintStream output) {
        output.println("----------------------------------------------");
    }
}
