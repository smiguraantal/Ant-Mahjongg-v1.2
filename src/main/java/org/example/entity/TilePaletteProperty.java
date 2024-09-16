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
 * A kőpaletta elhelyezkedésével kapcsolatos adatokat összefogó osztály
 */
public class TilePaletteProperty implements Orientation,
        Location, Serializable {

    /**
     * Csak a kijelölhető köveket mutassa
     */
    public static final int SELECTABLE = 0;

    /**
     * Csak a levehető, párban lévő köveket mutassa
     */
    public static final int PAIR = 1;

    /**
     * Minden felső követ mutasson
     */
    public static final int ALL_TOP = 2;

    /**
     * Az összes követ mutassa
     */
    public static final int ALL = 3;

    /**
     * Függőleges vagy vízszintes elhelyezés
     */
    private int orientation;

    /**
     * Elhelyezkedés a szülő komponensen
     */
    private int location;

    /**
     * A tartalmazó paneltól való távolsága
     */
    private int gap;

    /**
     * Látható-e
     */
    private boolean visible;

    /**
     * Melyik kövekre legyen érzékeny az egérmozgatás
     */
    private int infoType;

    /**
     * Mutassa az alatta lévőket
     */
    private boolean showUnderTiles;

    /**
     * 3D-s kövek
     */
    private boolean tde;

    /**
     * Csúszágátló
     */
    private boolean nonSkid;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TilePaletteProperty(int orientation,
                               int location,
                               int gap,
                               int infoType,
                               boolean visible,
                               boolean showUnderTiles,
                               boolean tde,
                               boolean nonSkid) {
        this.orientation = orientation;
        this.location = location;
        this.gap = gap;
        this.infoType = infoType;
        this.visible = visible;
        this.showUnderTiles = showUnderTiles;
        this.tde = tde;
        this.nonSkid = nonSkid;
    }

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TilePaletteProperty() {
        this(VERTICAL, // fekvés
                WEST, // pozíció
                10, // távolság
                ALL, // info típus
                true, // látható-e
                true, // mutassa az alatta lévőket
                true, // 3D-s kövek
                false); // csúszásgátló
    }

    //----------------------------------------------------------------------

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setInfoType(int infoType) {
        this.infoType = infoType;
    }

    public int getInfoType() {
        return infoType;
    }

    public boolean isShowUnderTiles() {
        return showUnderTiles;
    }

    public void setShowUnderTiles(boolean showUnderTiles) {
        this.showUnderTiles = showUnderTiles;
    }

    public boolean isTde() {
        return tde;
    }

    public void setTde(boolean tde) {
        this.tde = tde;
    }

    public boolean isNonSkid() {
        return nonSkid;
    }

    public void setNonSkid(boolean nonSkid) {
        this.nonSkid = nonSkid;
    }

}












