package blackjack.game;

import java.io.Serializable;

public class Action implements Serializable {
    public enum Type {
        Hit,
        Stand,
        Restart,
        Unknown,
        Exit
    }
    
    private final Type type;
    
    public Action(Type type) {
        this.type = type;
    }
    
    public Type getType() {
        return this.type;
    }
}
