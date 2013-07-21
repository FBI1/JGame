package JGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class JGImageObject extends JGObject {

    private Image image;
    private boolean clickable;

    public JGImageObject(int drawPriority, double x, double y, double bx, double by, boolean collideable) {
        super(drawPriority, x, y, bx, by, collideable);

        URL url = getClass().getResource("ressources/Object.jpg");
        image = Toolkit.getDefaultToolkit().getImage(url);
    }
    
    public boolean clicked() {
        if(getClickable() == true && JGManager.xClicked >= getX() && JGManager.xClicked <= getX()+getImage().getWidth(null) && JGManager.yClicked >= getY() && JGManager.yClicked <= getY()+getImage().getHeight(null)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setClickable(boolean clickable){
        this.clickable = clickable;
    }
    
    public boolean getClickable(){
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
