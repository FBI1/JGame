package JGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JGCanvas extends JPanel {

    public JGCanvas() {
        setOpaque(true);
        setVisible(true);
        addMouseListener(new JGMouseAdapter());

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.PLAIN, 20));

        JGDrawer.drawGame(this.getWidth(), this.getHeight(), g);        
    }
}
