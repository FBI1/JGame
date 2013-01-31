package JGame;

import java.awt.Toolkit;
import java.net.URL;

public class JEnemy extends JImageObject {

    public JEnemy(int drawPriority, double x, double y, double bx, double by, boolean collideAble) {
        super(drawPriority, x, y, bx, by, collideAble);

        URL url = getClass().getResource("ressources/Enemy.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url));
    }
    public void computeObject() {
        super.computeObject();
    }
}
