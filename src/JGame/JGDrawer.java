package JGame;

import java.awt.Graphics;
import java.util.Iterator;

public class JGDrawer {
    
    public static void drawGame(int width,int height,Graphics g){      
        Iterator<JGObject> iter = JGManager.getObjects().iterator();
        while (iter.hasNext()) {
            JGObject obj = iter.next();
            obj.drawObject(g, width, height);
        }
    }
}
