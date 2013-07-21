package JGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JGAbility extends JGImageObject {

    private int damage;
    private int speed;
    private int cooldown;

    public JGAbility(int drawPriority, double x, double y, double bx, double by) {
        super(drawPriority, x, y, bx, by, false);

        URL url = getClass().getResource("ressources/Ability.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url));
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return cooldown;
    }
}
