package JGame;

import java.util.Timer;
import java.util.TimerTask;

public class JGame {

    private static Timer timer;
    private static JGWindow window;

    public static void main(String[] args) {
        window = new JGWindow("JGame");
        JGManager.stop = true;

        timer = new Timer();
        TimerTask task = new JGTimer();
        timer.scheduleAtFixedRate(task, 0, 1000 / 35);
    }

    public static void drawGame() {
        window.repaint();
    }

    public static void shutdown() {
        System.exit(0);
    }

    public static JGWindow getWindow() {
        return window;
    }
}
