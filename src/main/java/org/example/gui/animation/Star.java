package org.example.gui.animation;

import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Title: Ant-Mahjongg</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004-2005</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.2
 */

/**
 * A csillag az égen, mely időközönként megvillan
 */
public class Star extends JComponent {

    /**
     * Fényes-e
     */
    private boolean bright;

    /**
     * A villanás időzítője
     */
    private Timer stopper;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Star() {
        setSize(10, 10);
        bright = rnd(3) == 0 ? true : false;
    }

    //----------------------------------------------------------------------

    /**
     * Véletlenszám egy és max között
     */
    private int rnd(int max) {
        return (int) (Math.random() * max);
    }

    //----------------------------------------------------------------------

    /**
     * Megvillantja a csillagot
     */
    public void flash() {
        bright = true;
        repaint();
        stopper = new Timer(300, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bright = false;
                repaint();
                stopper = null;
            }
        });
        stopper.setRepeats(false);
        stopper.start();
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a csillagot
     */
    public void paintComponent(Graphics g) {
        super.paintChildren(g);
        g.setColor(Color.white);
        if (bright)
            g.drawString("*", 0, 10);
        else {
            g.drawString(".", 1, 3);
        }
    }

    //----------------------------------------------------------------------

    public boolean isBright() {
        return bright;
    }

    public void setBright(boolean bright) {
        this.bright = bright;
    }
}