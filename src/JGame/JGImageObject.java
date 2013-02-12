package JGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class JGImageObject extends JGObject {

    private Image image;

    public JGImageObject(int drawPriority, double x, double y, double bx, double by, boolean collideAble) {
        super(drawPriority, x, y, bx, by, collideAble);

        URL url = getClass().getResource("ressources/Object.jpg");
        image = Toolkit.getDefaultToolkit().getImage(url);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void drawObject(Graphics g, int width, int height) {
        g.drawImage(image, (int) getX(), (int) getY(), null);
    }
}
