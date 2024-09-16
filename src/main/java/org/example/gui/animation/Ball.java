package org.example.gui.animation;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * <p>Title: Ant-Mahjongg</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004-2005</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.2
 */

public class Ball extends JPanel {

    private SkyPanel skyPanel;

    public Ball(SkyPanel skyPanel) {
        this.skyPanel = skyPanel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(550, 550));
        setBounds(0, 0, 550, 550);
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(25, 25);
        for (int i = 0, color = 0, r = 250, tav = 250; i <= 250; i += 2, color += 2, --tav, r -= 2) {
            Polygon poly = new Polygon();
            g.setColor(new Color(color, color, color));
            for (int j = 0; j < 360; j++) {
                int x = (int) (r * Math.cos(Math.toRadians(j)) + tav);
                int y = (int) (r * Math.sin(Math.toRadians(j)) + tav);
                poly.addPoint(x, y);
            }
            g.fillPolygon(poly);
        }
    }
}
