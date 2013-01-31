package JGame;

import java.awt.Graphics;
import java.util.Iterator;

public class JDrawer {
    
    public static void drawGame(int width,int height,Graphics g){      
        Iterator<JObject> iter = JManager.getObjects().iterator();
        while (iter.hasNext()) {
            JObject obj = iter.next();
            obj.drawObject(g, width, height);
        }
    }
}
