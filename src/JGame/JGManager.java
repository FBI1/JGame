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
    private static JGDebugObject debugObject;
    private static JGBackground background;
    public static boolean lost;
    public static boolean stop = true;
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

        debugObject = new JGDebugObject(101, 0, 0, 0, 0, false);
        addObject(debugObject);

        background = new JGBackground(-100, 0, 0, 0, 0, false);
        addObject(background);

        StartButton = new JGButton(50, JGWindow.getWidth() / 2 - 50, JGWindow.getHeight() / 2 - 25, 0, 0, 100, 50, "Start");
        addObject(StartButton);
    }

    public static void computeGame() {
        move(player, 2, 2);
        if (StartButton.clicked() == true && JGMouseAdapter.mouseButton == 1) {
            removeObject(StartButton);
            stop = false;
        }
        if (stop == false) {
            Dimension windowDim = JGame.getWindow().getSize();
            int maxX = windowDim.width;
            int maxY = windowDim.height;

            Iterator<JGObject> iter = objects.iterator();
            while (iter.hasNext()) {
                JGObject obj = iter.next();
                obj.computeObject();
                if (obj.getCollideable() == true && collided(obj) == true) {
                    removeObject(obj);
                    removeObject(player);
                    lost = true;
                }
                limitObjectPosition(obj, maxX, maxY);
            }
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
        System.out.println("xClicked: " + xClicked + " yClicked: " + yClicked + " mouseButton: " + JGMouseAdapter.mouseButton);
    }

    public static void keyPressed(KeyEvent e) {
        pressedKeyCode = e.getKeyCode();
        System.out.println("pressedKeyCode: " + pressedKeyCode);
        switch (pressedKeyCode) {
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
        }
    }

    public static void move(JGImageObject obj, double speedX, double speedY) {
        double X, Y, targetX, targetY;

        if (JGMouseAdapter.mouseButton == 3) {
            X = obj.getX();
            Y = obj.getY();

            targetX = xClicked;
            targetY = yClicked;

            distanceX = targetX - X;
            distanceY = targetY - Y;
            if (distanceX < 0 && distanceY < 0) {
                if (distanceX < distanceY) {
                    speedX *= 1;
                    speedY *= distanceY / distanceX;
                } else if (distanceY < distanceX) {
                    speedY *= 1;
                    speedX *= distanceX / distanceY;
                }
            } else if (distanceX > 0 && distanceY > 0) {
                if (distanceX > distanceY) {
                    speedX *= 1;
                    speedY *= distanceY / distanceX;
                } else if (distanceY > distanceX) {
                    speedY *= 1;
                    speedX *= distanceX / distanceY;
                }
            } else if (distanceX < 0 && distanceY > 0) {
                distanceX *= -1;
                if (distanceX > distanceY) {
                    speedX *= -1;
                    speedY *= distanceY / distanceX * -1;
                } else if (distanceY > distanceX) {
                    speedY *= 1;
                    speedX *= distanceX / distanceY * -1;
                }
            } else if (distanceX > 0 && distanceY < 0) {
                distanceY *= -1;
                if (distanceX > distanceY) {
                    speedX *= 1;
                    speedY *= distanceY / distanceX * -1;
                } else if (distanceY > distanceX) {
                    speedY *= -1;
                    speedX *= distanceX / distanceY * -1;
                }
            }

            if (distanceX > 3) {
                obj.setBx(speedX);
            } else if (distanceX < -3) {
                obj.setBx(speedX * -1);
            } else {
                obj.setBx(0);
            }
            if (distanceY > 3) {
                obj.setBy(speedY);
            } else if (distanceY < -3) {
                obj.setBy(speedY * -1);
            } else {
                obj.setBy(0);
            }
        }
    }

    public static void moving() {
    }

    public static void start() {
        stop = false;
    }

    public static void stop() {
        stop = false;
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