package JGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JMouseAdapter extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            JManager.mousePressed(e);
        }
}
