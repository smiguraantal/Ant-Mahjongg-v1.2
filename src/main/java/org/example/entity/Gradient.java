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
 * Egy kitöltési effektushoz használt szinátmenetet pontjait, illetve a
 * hozzá tartozó színsémát tartalmazó osztály. A pontokból és a színsémából
 * egy GradientPaint objektum lesz felépítve.
 */
public class Gradient implements Serializable {

    /**
     * Az kitöltési effektus első pontjának x koordinátája
     */
    private float x1;

    /**
     * Az kitöltési effektus első pontjának y koordinátája
     */
    private float y1;

    /**
     * Az kitöltési effektus második pontjának x koordinátája
     */
    private float x2;

    /**
     * Az kitöltési effektus második pontjának y koordinátája
     */
    private float y2;

    /**
     * A kitöltési effektushoz tartozó színséma
     */
    private ColorTheme colorTheme;

    //----------------------------------------------------------------------

    /**
     * Konstruktor színsémával
     */
    public Gradient(float x1,
                    float y1,
                    float x2,
                    float y2,
                    ColorTheme colorTheme) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.colorTheme = colorTheme;
    }

    //----------------------------------------------------------------------

    /**
     * Konstruktor színséma nélkül
     */
    public Gradient(float x1,
                    float y1,
                    float x2,
                    float y2) {
        this(x1, y1, x2, y2, null);
    }

    //----------------------------------------------------------------------

    /**
     * Két kitöltési effektus már akkor is ugyanannak tekinttendő, ha
     * a pontok koordinátái rendre megegyeznek.
     */
    public boolean equals(Object object) {
        Gradient gradient = (Gradient) object;
        return
                x1 == gradient.getX1() &&
                        y1 == gradient.getY1() &&
                        x2 == gradient.getX2() &&
                        y2 == gradient.getY2();
    }

    //----------------------------------------------------------------------

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public float getX1() {
        return x1;
    }

    public float getX2() {
        return x2;
    }

    public float getY1() {
        return y1;
    }

    public float getY2() {
        return y2;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }
}


















