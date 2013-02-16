package JGame;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class JGManager {

    private static ArrayList<JGObject> objects;
    private static JGPlayer player;
    private static JGEnemy enemy;
    private static JGDebugObject debugObject;
    private static JGBackground background;
    public static boolean lost;
    public static boolean stop;
    public static boolean started;
    private static double playerBx;
    private static double playerBy;
    public static int xClicked, yClicked;
    private static int pressedKeyCode, releasedKeyCode;
    
    private static JGButton StartButton;

    static {
        objects = new ArrayList<JGObject>();

        player = new JGPlayer(100, 200, 200, 0, 0);
        addObject(player);

        enemy = new JGEnemy(99, 100, 100, 0, 0,true);
        addObject(enemy);

        debugObject = new JGDebugObject(101, 0, 0, 0, 0,false);
        addObject(debugObject);

        background = new JGBackground(-100, 0, 0, 0, 0,false);
        addObject(background);       
        
        StartButton = new JGButton(50,200,100,0,0,100,50,"Start");
        addObject(StartButton);
    }

    public static void computeGame() {
        Dimension windowDim = JGame.getWindow().getSize();
        int maxX = windowDim.width;
        int maxY = windowDim.height;
        
        player.setBx(playerBx);
        player.setBy(playerBy);

        if(StartButton.clicked()== true){
            removeObject(StartButton);
        }
        Iterator<JGObject> iter = objects.iterator();
        while (iter.hasNext()) {
            JGObject obj = iter.next();
            obj.computeObject();
            if(obj.getCollideAble() == true && collided(obj) && obj.getHeight()>0 && obj.getWidth()>0){
                removeObject(obj);
                removeObject(player);
            }
            limitObjectPosition(obj, maxX, maxY);
        }
    }

    private static boolean collided(JGObject obj) {
        Rectangle r1 = new Rectangle((int) player.getX(), (int) player.getY(), player.getWidth(), player.getHeight());
        Rectangle r2 = new Rectangle((int) obj.getX(), (int) obj.getY(), obj.getWidth(), obj.getHeight());
        return r1.intersects(r2);
    }

    private static void limitObjectPosition(JGObject obj, double maxX, double maxY) {
        if (obj.getX() < 0) {
            obj.setX(0);
            obj.setBx(0 - obj.getBx());
            obj.setBy(0 - obj.getBy());
        } else if (obj.getX() > maxX - 5) {
            obj.setX(maxX - 5);
            obj.setBx(0 - obj.getBx());
            obj.setBy(0 - obj.getBy());
        }

        if (obj.getY() < 0) {
            obj.setY(0);
            obj.setBx(0 - obj.getBx());
            obj.setBy(0 - obj.getBy());
        } else if (obj.getY() > maxY - 5) {
            obj.setY(maxY - 5);
            obj.setBx(0 - obj.getBx());
            obj.setBy(0 - obj.getBy());
        }
    }

    public static void mousePressed(MouseEvent e) {
        xClicked = e.getX();
        yClicked = e.getY();
        System.out.println("xClicked: " + xClicked + " yClicked: " + yClicked);
    }

    public static void keyPressed(KeyEvent e) {
        pressedKeyCode = e.getKeyCode();
        System.out.println("pressedKeyCode: " + pressedKeyCode);
        switch (pressedKeyCode) {
            case 87: //W
                if(playerBy > -2)
                playerBy -= 2;
                break;
            case 83: //A
                if(playerBy < 2)
                playerBy += 2;
                break;
            case 68: //D
                if(playerBx < 2)
                playerBx += 2;
                break;
            case 65: //A
                if(playerBx > -2)
                playerBx -= 2;
                break;
            case 80: //P
                if (stop == false && lost == false) {
                    stop();
                } else if (started == true && lost == false) {
                    start();
                }
                break;
        }
    }

    public static void keyReleased(KeyEvent e) {
        releasedKeyCode = e.getKeyCode();
        System.out.println("releasedKeyCode: " + releasedKeyCode);  
        switch (releasedKeyCode) {
            case 87: //W
                playerBy = 0;
                break;
            case 83: //A
                playerBy = 0;
                break;
            case 68: //D
                playerBx = 0;
                break;
            case 65: //A
                playerBx = 0;
                break;
        }
    }

    public static void start() {
    }

    public static void stop() {
    }

    public static ArrayList<JGObject> getObjects() {
        return objects;
    }

    public static JGPlayer getPlayer() {
        return player;
    }

    public static void addObject(JGObject obj) {
        objects.add(obj);
        Collections.sort(objects);
    }

    public static void removeObject(JGObject obj) {
        objects.remove(obj);
    }
}