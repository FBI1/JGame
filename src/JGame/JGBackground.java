package JGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.net.URL;


public class JGBackground extends JGObject{
    
    
    public JGBackground(int drawPriority, double x, double y, double bx, double by,boolean collideAble) {
        
        super(drawPriority, x, y, bx ,by,collideAble);

    }
    
    public void drawObject(Graphics g, int width, int height) {
        g.setColor(new Color(0x9a, 0xcd, 0x32));
        g.fillRect(0, 0, width, height);
    }    
}
