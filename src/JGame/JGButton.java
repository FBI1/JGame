package JGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.text.AttributedCharacterIterator;

public class JGButton extends JGImageObject {

    private int width;
    private int height;
    private int x;
    private int y;
    private String text;

    public JGButton(int drawPriority, double x, double y, double bx, double by, int width, int height, String text) {
        super(drawPriority, x, y, bx, by, false);

        this.x = (int) x;
        this.y = (int) y;
        this.text = text;
        this.width = width;
        this.height = height;

        URL url = getClass().getResource("ressources/Button.jpg");
        setImage(Toolkit.getDefaultToolkit().getImage(url).getScaledInstance(width, height, 0));
        setClickable(true);
    }

    public void setText() {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void drawObject(Graphics g, int width, int height) {
        g.drawImage(getImage(), (int) getX(), (int) getY(), null);
        g.setColor(Color.black);
        g.drawString(text, x + this.width/2 - text.length()*4, y + this.height / 2 + 8);
    }
}
