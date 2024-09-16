package org.example.entity;

import java.awt.Color;
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
 * Egy színkombináció színeit tartalmazó osztály
 */
public class ColorTheme implements Serializable {

    /**
     * Név
     */
    private String name;

    /**
     * Elsődleges szín
     */
    private Color color_1;

    /**
     * Másodlagos szín
     */
    private Color color_2;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public ColorTheme(String name,
                      Color color_1,
                      Color color_2) {
        this.name = name;
        this.color_1 = color_1;
        this.color_2 = color_2;
    }

    //----------------------------------------------------------------------

    /**
     * Akkor azonos ha mind a két szín egyezik
     */
    public boolean equals(Object object) {
        ColorTheme colorTheme = (ColorTheme) object;
        return
                getName().equals(colorTheme.getName()) &&
                        getColor_1().equals(colorTheme.getColor_1()) &&
                        getColor_2().equals(colorTheme.getColor_2());
    }

    //----------------------------------------------------------------------

    /**
     * Az objektum szöveges formában a színséma neve.
     */
    public String toString() {
        return name;
    }

    //----------------------------------------------------------------------

    public Color getColor_1() {
        return color_1;
    }

    public Color getColor_2() {
        return color_2;
    }

    public void setColor_1(Color color_1) {
        this.color_1 = color_1;
    }

    public void setColor_2(Color color_2) {
        this.color_2 = color_2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}











