package org.example.gui.animation;

import org.example.gui.panel.GamePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Vector;

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
 * Az ég, melyen a csillagok vannak
 */
public class SkyPanel extends Animation {

    /**
     * A csillagok
     */
    Vector stars = new Vector();

    /**
     * A játék panel
     */
    GamePanel gamePanel;

    BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /**
     * Konsturktor
     */
    public SkyPanel(GamePanel gamePanel) {
        super(gamePanel);
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        setPreferredSize(new Dimension(800, 600));
        setBounds(0, 0, 800, 600);
        this.addMouseMotionListener(new SkyPanel_this_mouseMotionAdapter(this));
        setLayout(null);
        setBackground(Color.black);

        for (int x = 0; x < 800; x++) {
            for (int y = 0; y < 600; y++) {
                if (rnd(500) == 0) {
                    Star star = null;
                    add(star = new Star());
                    stars.add(star);
                    star.setLocation(x, y);
                }
            }
        }

        stopper = new javax.swing.Timer(300, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Star star = (Star) (stars.get(rnd(stars.size())));
                if (!star.isBright()) // ha nem fényes
                    star.flash();
            }
        });
    }

    //----------------------------------------------------------------------

    /**
     * Véletlenszám 0 és max között
     */
    private int rnd(int max) {
        return (int) (Math.random() * max);
    }

    //----------------------------------------------------------------------

    void this_mouseMoved(MouseEvent e) {

    }
}

class SkyPanel_this_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
    SkyPanel adaptee;

    SkyPanel_this_mouseMotionAdapter(SkyPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseMoved(MouseEvent e) {
        adaptee.this_mouseMoved(e);
    }
}
