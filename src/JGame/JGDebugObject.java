package JGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.net.URL;

public class JGDebugObject extends JGObject {

    public JGDebugObject(int drawPriority, double x, double y, double bx, double by,boolean collideAble) {
        super(drawPriority, x, y, bx, by,collideAble);

    }

    public void drawObject(Graphics g, int width, int height) {
        g.setColor(Color.black);
        g.drawString("Player bx: " + JGManager.getPlayer().getBx(), width - 200, height - 90);
        g.drawString("Player by: " + JGManager.getPlayer().getBy(), width - 200, height - 70);
        g.drawString("lost  : " + JGManager.lost, width - 200, height - 50);
        g.drawString("Pause     : " + JGManager.stop, width - 200, height - 30);
        g.drawString("Started   : " + JGManager.started, width - 200, height - 10);
    }
}
