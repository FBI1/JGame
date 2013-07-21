package JGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public abstract class JGObject implements Comparable {

    private boolean collideable;
    private double x;
    private double y;
    private double bx; // "pixel pro tick"
    private double by;
    private int drawPriority;

    public JGObject(int drawPriority, double x, double y, double bx, double by, boolean collideable) {
        this.drawPriority = drawPriority;
        this.x = x;
        this.y = y;
        this.bx = bx;
        this.by = by;
        this.collideable = collideable;
    }

    public int getHeight() {
        return 0;
    }

    public int getWidth() {
        return 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getBx() {
        return bx;
    }

    public void setBx(double bx) {
        this.bx = bx;
    }

    public double getBy() {
        return by;
    }
    
    public void setBy(double by) {
        this.by = by;
    }
       
    public void setCollideable(boolean collideable){
        this.collideable = collideable;
    }
    public boolean getCollideable(){
        return this.collideable;
    }

    public void addBy(double by) {
        this.by += by;
    }

    public void computeObject() {

        x += getBx();
        y += getBy();
    }

    public int getDrawPriority() {
        return drawPriority;
    }

    public void setDrawPriority(int drawPriority) {
        this.drawPriority = drawPriority;
    }

    @Override
    public int compareTo(java.lang.Object o) {
        if (o instanceof JGObject) {
            JGObject obj = (JGObject) o;
            return drawPriority - obj.getDrawPriority();
        } else {
            return 0;
        }

    }

    public void drawObject(Graphics g, int width, int height) {
    }
}
