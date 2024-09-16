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
 * Egy kőkészlet stílusának neve, és a készlet valamint az inverz készlet
 * elérési útja
 */
public class Style implements Serializable {

    /**
     * A stílus neve
     */
    String name;

    /**
     * A készlet elérési útja
     */
    String imagePath_1;

    /**
     * Az inverz készlet elérési útja
     */
    String imagePath_2;


    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Style(String name,
                 String imagePath_1,
                 String imagePath_2) {
        this.name = name;
        this.imagePath_1 = imagePath_1;
        this.imagePath_2 = imagePath_2;
    }

    //----------------------------------------------------------------------

    /**
     * Két stílus akkor egyezik, ha a két kép elérési útja ugyanaz
     */
    public boolean equals(Object object) {
        Style otherStyle = (Style) object;
        return imagePath_1.equals(otherStyle.getImagePath_1()) &&
                imagePath_2.equals(otherStyle.getImagePath_2());
    }

    //----------------------------------------------------------------------

    public String getImagePath_1() {
        return imagePath_1;
    }

    public String getImagePath_2() {
        return imagePath_2;
    }

    public String getName() {
        return name;
    }

}
