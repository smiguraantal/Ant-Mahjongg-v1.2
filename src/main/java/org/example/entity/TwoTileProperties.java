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
 * Két kő tulajdonságait összefogó osztály. (undo-redo-hoz)
 */
public class TwoTileProperties implements Serializable, Cloneable {

    /**
     * Az egyik kő tulajdonságai
     */
    TileProperties tileProperties_1;

    /**
     * A másik kő tulajdonságai
     */
    TileProperties tileProperties_2;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TwoTileProperties(TileProperties tileProperties_1,
                             TileProperties tileProperties_2) {
        this.tileProperties_1 = tileProperties_1;
        this.tileProperties_2 = tileProperties_2;
    }

    //----------------------------------------------------------------------

    /**
     * Klózonható
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //----------------------------------------------------------------------

    public TileProperties getTileProperties_1() {
        return tileProperties_1;
    }

    public TileProperties getTileProperties_2() {
        return tileProperties_2;
    }

}







