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
 * Egy kő táblán való elhelyezkedésének adatait tartalmazó osztály
 */
public class Place implements Constants, Serializable {

    /**
     * A hely x pozíciója
     */
    private double x;

    /**
     * A hely y pozíciója
     */
    private double y;

    /**
     * Rétegszám
     */
    public int layer;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Place(double x, double y, int layer) {
        this.x = x;
        this.y = y;
        this.layer = layer;
    }

    //----------------------------------------------------------------------

    /**
     * Két hely akkor azonos, ha az x-, y koordinátájuk és a rétegszámuk
     * megegyezik
     */
    public boolean equals(Object object) {
        Place place = (Place) object;
        return x == place.getX() &&
                y == place.getY() &&
                layer == place.getLayer();
    }

    //----------------------------------------------------------------------

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}







