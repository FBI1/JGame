package JGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JGMouseAdapter extends MouseAdapter {

    static int mouseButton;

    public void mousePressed(MouseEvent e) {
        mouseButton = e.getButton();
        JGManager.mousePressed(e);

    }
    
    public void mouseReleased(MouseEvent e){
        JGManager.mouseReleased(e);
    }
}
