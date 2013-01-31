package JGame;

import java.util.Timer;
import java.util.TimerTask;

public class JGame {

    private static Timer timer;
    private static JWindow window;

    public static void main(String[] args) {
        window = new JWindow("JGame");
        JManager.stop = true;

        timer = new Timer();
        TimerTask task = new JTimer();
        timer.scheduleAtFixedRate(task, 0, 1000 / 35);
    }

    public static void drawGame() {
        window.repaint();
    }

    public static void shutdown() {
        System.exit(0);
    }

    public static JWindow getWindow() {
        return window;
    }
}
