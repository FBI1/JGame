package JGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JGActionListener extends KeyAdapter {

    public void keyReleased(KeyEvent e) {
        JGManager.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        JGManager.keyPressed(e);
    }
}

