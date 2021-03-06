package JGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JGPlayer extends JGImageObject {

    public JGPlayer(int drawPriority, double x, double y, double bx, double by) {
        super(drawPriority, x, y, bx, by, 100, 3, false);

        URL url = getClass().getResource("ressources/Player.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url));
        
        setMoveable(true);
    }

    public void computeObject() {
        super.computeObject();
    }
}
