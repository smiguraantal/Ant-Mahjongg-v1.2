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

/** Egy képfájl nevét és elérési útját tartalmazó osztály */
public class Background implements Serializable {

    /** A fájl elérési útja a munkakönyvtárból kiindulva*/
    private String path;

    /** A háttérkép vagy textúra neve */
    private String name;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Background(String path,
                      String name) {
        this.path = path;
        this.name = name;
    }

    //----------------------------------------------------------------------

    /** Két Background objektum akkor egyezik meg, ha az elérési út és a
     * név is megegyezik. */
    public boolean equals(Object object) {
        Background background = (Background) object;
        return getPath().equals(background.getPath()) && getName().equals(background.getName());
    }

    //----------------------------------------------------------------------

    /** A toString a kép vagy textúra nevét adja vissza. */
    public String toString() {
        return name;
    }

    //----------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
}














