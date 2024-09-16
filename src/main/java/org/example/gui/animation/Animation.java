package org.example.gui.animation;

import org.example.gui.panel.GamePanel;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.MouseEvent;

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
 * Absztrakt animáció osztály
 */
public abstract class Animation extends JPanel {

    /**
     * Az időzítő
     */
    protected Timer stopper;

    /**
     * A játék panel
     */
    protected GamePanel gamePanel;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Animation(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        this.addMouseListener(new Animation_this_mouseAdapter(this));
    }

    //----------------------------------------------------------------------

    /**
     * Elindítja az animációt
     */
    public void start() {
        stopper.start();
    }

    //----------------------------------------------------------------------

    /**
     * Meállítja az animációt
     */
    public void stop() {
        stopper.stop();
    }

    //----------------------------------------------------------------------

    /**
     * Előhívja a helyi menüt
     */
    public void showPopupMenu(MouseEvent e) {
        gamePanel.getGamePanelPopupMenu().show(e.getComponent(), e.getX(), e.getY());
    }

    //----------------------------------------------------------------------

    void this_mousePressed(MouseEvent e) {
        if (e.getModifiers() == e.BUTTON3_MASK) { // jobb egérkattintás
            showPopupMenu(e);
        }
    }
}

class Animation_this_mouseAdapter extends java.awt.event.MouseAdapter {
    Animation adaptee;

    Animation_this_mouseAdapter(Animation adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.this_mousePressed(e);
    }
}











