package JGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JPlayer extends JImageObject {

    public JPlayer(int drawPriority, double x, double y, double bx, double by) {
        super(drawPriority, x, y, bx, by, false);

        URL url = getClass().getResource("ressources/Player.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url));
    }
    public void computeObject() {
        super.computeObject();
    }
}
