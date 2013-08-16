package JGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Date;

public class JGFireball extends JGAbility {

    private int cooldown;

    public JGFireball(int drawPriority, double x, double y, double bx, double by, double hp, double speed, int damage, int cooldown) {
        super(drawPriority, x, y, bx, by, hp, speed, damage, cooldown);

        URL url = getClass().getResource("ressources/Fireball.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url));

        this.cooldown = cooldown * 1000;
    }

    public void drawObject(Graphics g, int width, int height) {
        super.drawObject(g, width, height);
        if (new Date().getTime() - startTime > 0 && new Date().getTime() - startTime < cooldown) {
            g.setColor(Color.black);
            g.drawString("" + (-(new Date().getTime() - startTime - cooldown - 1000) / 1000), (int) (getX() + getWidth() / 2.5), (int) (getY() + getHeight() / 1.5));
        }
    }
}
