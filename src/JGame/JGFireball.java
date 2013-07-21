package JGame;

import java.awt.Toolkit;
import java.net.URL;

public class JGFireball extends JGAbility{
        public JGFireball(int drawPriority, double x, double y, double bx, double by) {
        super(drawPriority, x, y, bx, by);

        URL url = getClass().getResource("ressources/Fireball.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url));
        setDamage(100);
        setSpeed(25);
        setCooldown(10);
    }
}
