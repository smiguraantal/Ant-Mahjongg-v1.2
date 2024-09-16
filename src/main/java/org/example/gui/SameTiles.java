package org.example.gui;

import org.example.gui.tile.Tile;

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
 * Ugyanolyan értékű levehető köveket összefogó osztály.
 * Ugyanolyannak számít két kő, ha értékben egyeznek, viszont a
 * virágok és az évszakok családjához tartozók itt ugyanolyannak
 * minősülnek, értékültől függetlenül is.
 */
public class SameTiles extends Vector {

    /**
     * A kövek értéke. 0-33-ig a kő értéke, viszont az évszakok 34-est,
     * a virágok 35-os sorszámot kapnak itt
     */
    int number;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public SameTiles(int number, Tile tile) {
        this.number = number;
        add(tile);
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja hogy hány pár alkotható .
     */
    public int pairs() {
        if (size() == 2 || size() == 3) // két vagy három kő = 1 pár
            return 1;
        if (size() == 4) // négy kő == 2 pár
            return 2;
        return 0; // egy vagy annál kevesebb kő == 0 pár
    }

    //----------------------------------------------------------------------

    /**
     * A sorszámuk szerint egyeznek
     */
    public boolean equals(Object object) {
        return number == (((SameTiles) object).getNumber());
    }

    //----------------------------------------------------------------------

    public int getNumber() {
        return number;
    }

}











