package JGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class JGImageObject extends JGObject {

    private Image image;
    private boolean clickable;

    public JGImageObject(int drawPriority, double x, double y, double bx, double by, double hp, double speed, boolean collideable) {
        super(drawPriority, x, y, bx, by, hp, speed, collideable);
        
        URL url = getClass().getResource("ressources/Object.jpg");
        image = Toolkit.getDefaultToolkit().getImage(url);
    }

    public JGImageObject(int drawPriority, double x, double y, double bx, double by, boolean collideable) {
        super(drawPriority, x, y, bx, by, collideable);

        URL url = getClass().getResource("ressources/Object.jpg");
        image = Toolkit.getDefaultToolkit().getImage(url);
    }

    public boolean clickedLeft() {
        if (getClickable() == true && JGManager.xClickedLeft >= getX() && JGManager.xClickedLeft <= getX() + getImage().getWidth(null) && JGManager.yClickedLeft >= getY() && JGManager.yClickedLeft <= getY() + getImage().getHeight(null)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean clickedRight() {
        if (getClickable() == true && JGManager.xClickedRight >= getX() && JGManager.xClickedRight <= getX() + getImage().getWidth(null) && JGManager.yClickedRight >= getY() && JGManager.yClickedRight <= getY() + getImage().getHeight(null)) {
            return true;
        } else {
            return false;
        }
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean getClickable() {
        return clickable;
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
