package JGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JGAbility extends JGImageObject {

    private int damage;
    private int cooldown;
    public long startTime = 0;

    public JGAbility(int drawPriority, double x, double y, double bx, double by, double hp, double speed, int damage, int cooldown) {
        super(drawPriority, x, y, bx, by, hp, speed, false);
        URL url = getClass().getResource("ressources/Ability.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url));

        this.cooldown = cooldown * 1000;
        this.damage = damage;
        setMoveable(true);
    }

    public void activateCooldown() {
        startTime = new Date().getTime();
        setMoveable(false);
        setX(JGame.getWindow().getSize().getWidth());
        setY(0);
        JGManager.xClickedLeft = 0;
        JGManager.yClickedLeft = 0;
    }

    public void cooldown() {
        if (startTime != 0 && new Date().getTime() - startTime > cooldown) {
            startTime = 0;
            setMoveable(true);
        }

    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return cooldown;
    }
}
