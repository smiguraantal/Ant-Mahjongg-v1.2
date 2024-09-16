package org.example.entity;

import java.io.Serializable;


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
 * Egy kő két tulajdonságát tároló osztály. Ezek a tulajdonságok az undo-
 * redo funkciókhoz kellenek.
 */
public class TileProperties implements Serializable, Cloneable {

    /**
     * A kő helye
     */
    private Place place;

    /**
     * A kő értéke
     */
    private int value;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TileProperties(Place place, int value) {
        this.place = place;
        this.value = value;
    }

    //----------------------------------------------------------------------

    /**
     * Klózonható
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    public Place getPlace() {
        return place;
    }

    public int getValue() {
        return value;
    }

}








