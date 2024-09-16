package org.example.gui;

import org.example.entity.DataModule;
import org.example.gui.tile.Tile;

import java.awt.event.MouseAdapter;
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
 * Egéresemény-figyelő osztály
 */
public class SelectingListener extends MouseAdapter {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A figyelt kő
     */
    private Tile tile;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public SelectingListener(Tile tile) {
        this.tile = tile;
    }

    //----------------------------------------------------------------------

    /**
     * Egérgomb lenyomása
     */
    public void mousePressed(MouseEvent e) {
        tile.mousePressed(e);
    }

}
