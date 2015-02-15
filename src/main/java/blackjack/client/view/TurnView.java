package blackjack.client.view;

import blackjack.game.*;
import java.io.PrintStream;

public class TurnView extends View {
    public TurnView(Result result) {
        super(result);
    }
    
    @Override
    public void render(PrintStream output) {
        if (getResult().hasAdditionalDeck()) {
            output.println("[Playing with two decks.]");
        } else {
            output.println("[Playing with single deck.]");
        }
        
        printHand(output, "Dealer's hand", getResult().getDealerHand());
        printHand(output, "Your hand", getResult().getPlayerHand());
    }
}
