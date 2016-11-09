package Communication;

import java.io.Serializable;

/**
 * Created by mike on 10/22/16.
 */
public class GameEvent implements Serializable {
    public int buttonPressed;

    public GameEvent(int buttonId) {
        this.buttonPressed=buttonId;
    }
}
