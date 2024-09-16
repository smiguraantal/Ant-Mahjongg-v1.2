package org.example.gui;

import org.example.entity.Constants;
import org.example.gui.tile.Tile;

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
 * Segítség kérésekor a kapott köveket villogtató osztály
 */
public class Flash implements Constants, Runnable {

    /**
     * Nem villogtatható állapot
     */
    public static final int BASE = 0;

    /**
     * Villogtatható állapot, de nem kijelölt
     */
    public static final int NON_SELECTED = 1;

    /**
     * Villogtatható állapot és kijelölt
     */
    public static final int SELECTED = 2;

    /**
     * A villogtatni kívánt kövek
     */
    private SameTiles sameTiles;

    /**
     * A szál, amelyben fut az idő
     */
    private Thread thread;

    //----------------------------------------------------------------------

    /**
     * konstruktor
     */
    public Flash(SameTiles tiles) {
        this.sameTiles = tiles;
    }

    //----------------------------------------------------------------------

    /**
     * Fél másodpercenként megvillantja a köveket
     */
    public void run() {
        while (true) {
            try {
                flashTiles();
                thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza a kö villogási állapotát, majd újrarajzolja
     */
    private void flashTiles() {
        for (int i = 0; i < sameTiles.size(); i++) {
            Tile tile = (Tile) sameTiles.get(i);
            if (tile.getFlashState() == BASE || tile.getFlashState() == NON_SELECTED)
                tile.setFlashState(SELECTED);
            else
                tile.setFlashState(NON_SELECTED);
            tile.repaint();
        }
    }

    //----------------------------------------------------------------------

    /**
     * elindítja a szálat
     */
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    //----------------------------------------------------------------------

    /**
     * megállítja a szálat
     */
    public void stop() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }
    }
}





