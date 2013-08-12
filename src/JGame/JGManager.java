package JGame;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class JGManager {

    private static ArrayList<JGObject> objects;
    private static JGPlayer player;
    private static JGEnemy enemy;
    private static JGFireball fireball;
    private static JGDebugObject debugObject;
    private static JGBackground background;
    public static boolean lost;
    public static boolean stop = true;
    public static boolean won;
    public static boolean started;
    private static double distanceX = 0;
    private static double distanceY = 0;
    public static int xClicked, yClicked;
    private static int pressedKeyCode, releasedKeyCode;
    private static JGButton StartButton;

    static {
        objects = new ArrayList<JGObject>();

        player = new JGPlayer(100, 200, 200, 0, 0);
        addObject(player);

        enemy = new JGEnemy(99, 100, 100, 0, 0, true);
        addObject(enemy);

        fireball = new JGFireball(101, 300, 300, 0, 0);
        addObject(fireball);

        debugObject = new JGDebugObject(101, 0, 0, 0, 0, false);
        addObject(debugObject);

        background = new JGBackground(-100, 0, 0, 0, 0, false);
        addObject(background);

        StartButton = new JGButton(50, JGWindow.getWidth() / 2 - 50, JGWindow.getHeight() / 2 - 25, 0, 0, 100, 50, "Start");
        addObject(StartButton);
    }

    public static void computeGame() {
        move(player, 3, 3);
        move(fireball, 15, 1);

        if (StartButton.clicked() == true && JGMouseAdapter.mouseButton == 1) {
            removeObject(StartButton);
            stop = false;
            started = true;
        }
        if (stop == false) {
            Dimension windowDim = JGame.getWindow().getSize();
            int maxX = windowDim.width;
            int maxY = windowDim.height;

            Iterator<JGObject> iter = objects.iterator();
            while (iter.hasNext() && stop == false) {
                JGObject obj = iter.next();
                obj.computeObject();
                limitObjectPosition(obj, maxX, maxY);
                if (obj.getCollideable() == true && collided(obj, player) == true) {
                    removeObject(obj);
                    removeObject(player);
                    lost = true;
                    stop = true;
                } else if (obj.getCollideable() == true && collided(obj, fireball) == true) {
                    removeObject(obj);
                    won = true;
                    stop = true;
                }
            }
        }
    }

    private static boolean collided(JGObject obj1, JGObject obj2) {
        Rectangle r1 = new Rectangle((int) obj1.getX(), (int) obj1.getY(), obj1.getWidth(), obj1.getHeight());
        Rectangle r2 = new Rectangle((int) obj2.getX(), (int) obj2.getY(), obj2.getWidth(), obj2.getHeight());
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
        System.out.println("xClicked: " + xClicked + " yClicked: " + yClicked + " mouseButton: " + JGMouseAdapter.mouseButton);
    }

    public static void keyPressed(KeyEvent e) {
        pressedKeyCode = e.getKeyCode();
        System.out.println("pressedKeyCode: " + pressedKeyCode);
        switch (pressedKeyCode) {
            case 80: //P
                if (stop == false && lost == false && won == false) {
                    stop();
                } else if (started == true && lost == false && won == false) {
                    resume();
                }
                break;
            case 82: //R
                restart();
                break;
        }
    }

    public static void keyReleased(KeyEvent e) {
        releasedKeyCode = e.getKeyCode();
        System.out.println("releasedKeyCode: " + releasedKeyCode);
        switch (releasedKeyCode) {
        }
    }

    public static void move(JGImageObject obj, double speed, int mouseButton) {

        double distance = obj.getDistance(xClicked, yClicked);
        double time = distance / speed;
        double distanceX, distanceY, speedX, speedY;

        distanceX = obj.getX() - xClicked;
        if (distanceX < 0) {
            distanceX = -distanceX;
        }

        distanceY = obj.getY() - yClicked;
        if (distanceY < 0) {
            distanceY = -distanceY;
        }

        if (JGMouseAdapter.mouseButton == mouseButton && obj.getDistance(xClicked, yClicked) > 8) {

            if (obj.getX() < xClicked) {
                speedX = distanceX / time;
            } else {
                speedX = -distanceX / time;
            }
            if (obj.getY() < yClicked) {
                speedY = distanceY / time;
            } else {
                speedY = -distanceY / time;
            }

            obj.setBx(speedX);
            obj.setBy(speedY);
        } else {
            obj.setBx(0);
            obj.setBy(0);
        }
    }

    public static void start() {
        stop = false;
        won = false;
        lost = false;
        started = true;
    }

    public static void restart() {
        objects = new ArrayList<JGObject>();

        player = new JGPlayer(100, 200, 200, 0, 0);
        addObject(player);

        enemy = new JGEnemy(99, 100, 100, 0, 0, true);
        addObject(enemy);

        fireball = new JGFireball(101, 300, 300, 0, 0);
        addObject(fireball);

        debugObject = new JGDebugObject(101, 0, 0, 0, 0, false);
        addObject(debugObject);

        background = new JGBackground(-100, 0, 0, 0, 0, false);
        addObject(background);

        StartButton = new JGButton(50, JGWindow.getWidth() / 2 - 50, JGWindow.getHeight() / 2 - 25, 0, 0, 100, 50, "Start");
        addObject(StartButton);
    }

    public static void resume() {
        stop = false;
    }

    public static void stop() {
        stop = true;
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