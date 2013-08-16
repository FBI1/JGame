package JGame;

public class JGMovement {

    public void move(JGObject obj, double speed, double xClicked, double yClicked, boolean moveable) {

        if (moveable == true && xClicked != 0 && yClicked != 0) {
            double distance = obj.getDistance(xClicked, yClicked);
            int steps = (int) distance / (int) speed;
            double distanceX, distanceY, speedX, speedY;

            distanceX = obj.getX() - xClicked;
            if (distanceX < 0) {
                distanceX = -distanceX;
            }

            distanceY = obj.getY() - yClicked;
            if (distanceY < 0) {
                distanceY = -distanceY;
            }

            if (distanceX > 0 && distanceY > 0) {
                if (obj.getX() < xClicked) {
                    speedX = distanceX / steps;
                } else {
                    speedX = -distanceX / steps;
                }
                if (obj.getY() < yClicked) {
                    speedY = distanceY / steps;
                } else {
                    speedY = -distanceY / steps;
                }
                obj.setBx(speedX);
                obj.setBy(speedY);
            } else {
                obj.setBx(0);
                obj.setBy(0);
            }
        } else {
            obj.setBx(0);
            obj.setBy(0);
        }
    }
}
