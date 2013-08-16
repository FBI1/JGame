package JGame;

import java.util.TimerTask;

public class JGTimer extends TimerTask {

    @Override
    public void run() {
        JGManager.computeGame();
        JGame.drawGame();
    }
}
