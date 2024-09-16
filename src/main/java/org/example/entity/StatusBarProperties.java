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
 * Az állapotsor beállításait összefogó osztály. Adatai megadják, hogy
 * az állapotsor mely mezői látszódjanak.
 */
public class StatusBarProperties implements Serializable {

    /**
     * Játék száma
     */
    private boolean gameNumber;

    /**
     * Idő
     */
    private boolean time;

    /**
     * Büntetés
     */
    private boolean penalty;

    /**
     * Kövek száma
     */
    private boolean tiles;

    /**
     * Párok
     */
    private boolean opens;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public StatusBarProperties(boolean gameNumber,
                               boolean time,
                               boolean penalty,
                               boolean tiles,
                               boolean opens) {
        this.gameNumber = gameNumber;
        this.time = time;
        this.penalty = penalty;
        this.tiles = tiles;
        this.opens = opens;
    }

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public StatusBarProperties() {
        this(true, true, true, true, true);
    }

    //----------------------------------------------------------------------

    public boolean isGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(boolean gameNumber) {
        this.gameNumber = gameNumber;
    }

    public boolean isTime() {
        return time;
    }

    public void setTime(boolean time) {
        this.time = time;
    }

    public boolean isPenalty() {
        return penalty;
    }

    public void setPenalty(boolean penalty) {
        this.penalty = penalty;
    }

    public boolean isTiles() {
        return tiles;
    }

    public void setTiles(boolean tiles) {
        this.tiles = tiles;
    }

    public boolean isOpens() {
        return opens;
    }

    public void setOpens(boolean opens) {
        this.opens = opens;
    }

}









