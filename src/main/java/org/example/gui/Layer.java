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
 * Azonos rétegszámú köveket összefogó osztály
 */
public class Layer extends Vector implements Comparable {

    /**
     * A réteg száma
     */
    private int number;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Layer(int number, Tile tile) {
        this.number = number;
        add(tile);
    }

    //----------------------------------------------------------------------

    /**
     * Akkor ugyanaz, ha a rétegszám ugyanannyi
     */
    public boolean equals(Object object) {
        return number == (((Layer) object).getNumber());
    }

    //----------------------------------------------------------------------

    /**
     * Akkor nagyobb, ha a rétegszám nagyobb
     */
    public int compareTo(Object object) {
        return number - (((Layer) object).getNumber());
    }

    //----------------------------------------------------------------------

    public int getNumber() {
        return number;
    }

}







