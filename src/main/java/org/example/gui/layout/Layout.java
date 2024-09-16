package org.example.gui.layout;

import java.io.Serializable;
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
 * Absztrakt elrendezés osztály
 */
public abstract class Layout implements Serializable {

    /**
     * A kövek helyei
     */
    protected Vector places = new Vector();

    /**
     * Az elrendezés köveinek vízszintes száma
     */
    protected double layoutWidth;

    /**
     * Az elrendezés köveinek függőleges száma
     */
    protected double layoutHeight;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Layout() {
        init();
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza a kövek helyeit, a szélességet és a magasságot
     */
    public abstract void init();

    //----------------------------------------------------------------------

    /**
     * Visszaadja az elrendezés nevét
     */
    public abstract String getName();

    //----------------------------------------------------------------------

    /**
     * Két elrendezés akkor egyezik, ha a nevük ugyanaz.
     */
    public boolean equals(Object object) {
        return getName().equals(((Layout) object).getName());
    }

    public Vector getPlaces() {
        return places;
    }

    public double getLayoutWidth() {
        return layoutWidth;
    }

    public double getLayoutHeight() {
        return layoutHeight;
    }

    public void setPlaces(Vector places) {
        this.places = places;
    }


}








