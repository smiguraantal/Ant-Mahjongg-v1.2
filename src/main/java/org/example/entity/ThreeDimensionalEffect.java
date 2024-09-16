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
 * A térhatásthoz szükséges eltolásokat adatait tartalmazó osztály
 */
public class ThreeDimensionalEffect implements Constants,
        Serializable, Location {

    /**
     * Kivételosztály a rossz paraméterezés esetére
     */
    class TreeDimensionalEffectException extends RuntimeException {
        public TreeDimensionalEffectException() {
            super("Not supported TreeDimensionalEffect parameter");
        }

        public TreeDimensionalEffectException(String errorMessage) {
            super(errorMessage);
        }
    }

    /**
     * Vízszintes irányú eltolás
     */
    private int horizontalTranslate;

    /**
     * Függőleges irányú eltolás
     */
    private int verticalTranslate;

    //----------------------------------------------------------------------

    /**
     * Konstruktor, mely a kapott paramter szerint állítja be az eltolásokat
     */
    public ThreeDimensionalEffect(int corner) {
        if (corner == NORTH_EAST)
            setTranslates(TILE_TRANSLATE, -TILE_TRANSLATE);
        else if (corner == SOUTH_EAST)
            setTranslates(TILE_TRANSLATE, TILE_TRANSLATE);
        else if (corner == NORTH_WEST)
            setTranslates(-TILE_TRANSLATE, -TILE_TRANSLATE);
        else if (corner == SOUTH_WEST)
            setTranslates(-TILE_TRANSLATE, TILE_TRANSLATE);
        else
            throw new TreeDimensionalEffectException();
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja az eltolásokat
     */
    private void setTranslates(int horizontalTranslate, int verticalTranslate) {
        this.horizontalTranslate = horizontalTranslate;
        this.verticalTranslate = verticalTranslate;
    }

    //----------------------------------------------------------------------

    /**
     * Két térhatás akkor egyezik meg, ha a vízszintes- és a függőleges
     * eltolásaik rendre megegyeznek.
     */
    public boolean equals(Object object) {
        ThreeDimensionalEffect other = (ThreeDimensionalEffect) object;
        return horizontalTranslate == other.getHorizontalTranslate() &&
                verticalTranslate == other.getVerticalTranslate();
    }

    //----------------------------------------------------------------------

    public String toString() {
        return
                "Horizontal translate: " + horizontalTranslate +
                        "\n" +
                        "Vertical translate: " + verticalTranslate;
    }

    //----------------------------------------------------------------------

    public int getHorizontalTranslate() {
        return horizontalTranslate;
    }

    public int getVerticalTranslate() {
        return verticalTranslate;
    }

}








