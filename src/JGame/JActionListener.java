package JGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JActionListener extends KeyAdapter {

    public void keyReleased(KeyEvent e) {
        JManager.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        JManager.keyPressed(e);
    }
}

