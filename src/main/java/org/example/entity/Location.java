package org.example.entity;

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
 * Komponensek elhelyezéséhez használt konstansokat definiáló interfész
 */
public interface Location {

    /**
     * Bal felső sarok
     */
    public static final int NORTH_WEST = 0;

    /**
     * Fent
     */
    public static final int NORTH = 1;

    /**
     * Jobb felső sarok
     */
    public static final int NORTH_EAST = 2;

    /**
     * Bal oldalon
     */
    public static final int WEST = 3;

    /**
     * Középen
     */
    public static final int CENTER = 4;

    /**
     * Jobb oldalon
     */
    public static final int EAST = 5;

    /**
     * Bal alsó sarokban
     */
    public static final int SOUTH_WEST = 6;

    /**
     * Lent
     */
    public static final int SOUTH = 7;

    /**
     * Jobb alsó sarokban
     */
    public static final int SOUTH_EAST = 8;
}





