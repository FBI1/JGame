package JGame;

import java.awt.Toolkit;
import java.net.URL;

public class JGEnemy extends JGImageObject {

    public JGEnemy(int drawPriority, double x, double y, double bx, double by, boolean collideAble) {
        super(drawPriority, x, y, bx, by, 100, 3, collideAble);

        URL url = getClass().getResource("ressources/Enemy.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url));
        
        setMoveable(true);
    }

    public void computeObject() {
        super.computeObject();
    }
}
