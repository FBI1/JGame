package JGame;

import java.util.TimerTask;

public class JTimer extends TimerTask {

    @Override
    public void run() {
        JManager.computeGame();
        JGame.drawGame();        
    }
}
