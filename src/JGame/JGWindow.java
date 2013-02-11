package JGame;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JGWindow {

    private JFrame Frame;
    private static JGCanvas canvas;

    public JGWindow(String Name) {

        Frame = new JFrame(Name);

        
        canvas = new JGCanvas();

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Frame.getContentPane().add(canvas);
        Frame.setSize(960, 540);
        Frame.setVisible(true);

        Frame.addKeyListener(new JGActionListener());
        Frame.addMouseListener(new JGMouseAdapter());

    }

    public void repaint() {
        Frame.repaint();

    }

    public Dimension getSize() {
        return canvas.getSize();
    }

    public static int getHeight() {
        return canvas.getHeight();
    }

    public static int getWidth() {
        return canvas.getWidth();
    }
}