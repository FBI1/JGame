package JGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JGMouseAdapter extends MouseAdapter{
    static int mouseButton;
        public void mousePressed(MouseEvent e) {
            JGManager.mousePressed(e);
            mouseButton = e.getButton();
        }
}
