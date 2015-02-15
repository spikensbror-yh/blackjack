package blackjack.client.view;

import blackjack.game.Result;
import java.io.PrintStream;

public class ResultView extends View {
    public ResultView(Result result) {
        super(result);
    }

    @Override
    public void render(PrintStream output) {
        printSeparator(output);
        if (getResult().getShouldRestart()) {
            output.println("Restart to begin a new game!");
        } else if (getResult().isBust()) {
            output.println("Bust!");
        } else {
            output.println(getResult().isWin() ? "You win!" : "You loose!");
        }
        printSeparator(output);
    }
    
}
