package JGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.net.URL;

public class JDebugObject extends JObject {

    public JDebugObject(int drawPriority, double x, double y, double bx, double by,boolean collideAble) {
        super(drawPriority, x, y, bx, by,collideAble);

    }

    public void drawObject(Graphics g, int width, int height) {
        g.setColor(Color.black);
        g.drawString("Player bx: " + JManager.getPlayer().getBx(), width - 200, height - 90);
        g.drawString("Player by: " + JManager.getPlayer().getBy(), width - 200, height - 70);
        g.drawString("lost  : " + JManager.lost, width - 200, height - 50);
        g.drawString("Pause     : " + JManager.stop, width - 200, height - 30);
        g.drawString("Started   : " + JManager.started, width - 200, height - 10);
    }
}
