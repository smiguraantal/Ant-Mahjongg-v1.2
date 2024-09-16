package org.example.entity;

import org.example.gui.layout.Layout;

import java.io.Serializable;
import java.util.Stack;
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
 * Egy elmentésre szánt illetve beolvasni kívánt mentett játék állapotának
 * az újraépítéshez szükséges adatait tároló osztály
 */
public class GameState implements Constants, Serializable, Comparable {

    /**
     * Az játék állapot neve, amit a használó megadott
     */
    private String name;

    /**
     * Elrendezés
     */
    private Layout layout;

    /**
     * A játék indításakor létrehozott helyek, melyek a leszedés
     * sorrendjében vannak
     */
    private Vector allPlaces;

    /**
     * A játék elmentésekor a maradék kövek helyei
     */
    private Vector actualPlaces;

    /**
     * A játék indításakor kreált összes érték (az újraindításhoz kell)
     */
    private Vector allValues;

    /**
     * A játék elmentésekor a maradék kövek értékei
     */
    private Vector actualValues;

    /**
     * Idő
     */
    private int time;

    /**
     * Büntetés
     */
    private int penalty;

    /**
     * Játék száma
     */
    private int gameNumber;

    /**
     * Levett kőpárok verme
     */
    private Stack undo;

    /**
     * Visszatett kőpárok verme
     */
    private Stack redo;

    /**
     * Szabály
     */
    private int rule;

    /**
     * A meglévő kövek száma
     */
    private int tiles;

    /**
     * A levehető párok száma
     */
    private int opens;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public GameState(String name,
                     Layout layout,
                     Vector allPlaces,
                     Vector actualPlaces,
                     Vector allValues,
                     Vector actualValues,
                     int time,
                     int penalty,
                     int gameNumber,
                     Stack undo,
                     Stack redo,
                     int rule,
                     int tiles,
                     int opens) {
        this.name = name;
        this.layout = layout;
        this.allPlaces = allPlaces;
        this.actualPlaces = actualPlaces;
        this.allValues = allValues;
        this.actualValues = actualValues;
        this.time = time;
        this.penalty = penalty;
        this.gameNumber = gameNumber;
        this.undo = undo;
        this.redo = redo;
        this.rule = rule;
        this.tiles = tiles;
        this.opens = opens;
    }

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public GameState(String name) {
        this.name = name;
    }

    //----------------------------------------------------------------------

    /**
     * Két játék állapot akkor egyezik, ha egyezik a név.
     */
    public boolean equals(Object object) {
        GameState gameState = (GameState) object;
        return name.equals(gameState.getName());
    }

    //----------------------------------------------------------------------

    /**
     * elrendezés szerint, azon belül pedig név szerint rendez
     */
    public int compareTo(Object object) {
        GameState gameState = (GameState) object;
        if (layout.getName().compareTo(gameState.getLayout().getName()) > 0)
            return 1;
        else if (layout.getName().compareTo(gameState.getLayout().getName()) < 0)
            return -1;
        return name.compareTo(gameState.getName());
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a mentett játékot szöveges formában
     */
    public String toString() {
        return
                name +
                        " (" +
                        layout.getName() +
                        ")";
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja az eltelt egész másodperceket
     */
    public int getSeconds() {
        return time / 100;
    }

    //----------------------------------------------------------------------

    public Vector getActualPlaces() {
        return actualPlaces;
    }

    public Vector getActualValues() {
        return actualValues;
    }

    public Vector getAllValues() {
        return allValues;
    }

    public Layout getLayout() {
        return layout;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public int getPenalty() {
        return penalty;
    }

    public Stack getRedo() {
        return redo;
    }

    public Stack getUndo() {
        return undo;
    }

    public int getOpens() {
        return opens;
    }

    public int getRule() {
        return rule;
    }

    public int getTiles() {
        return tiles;
    }

    public Vector getAllPlaces() {
        return allPlaces;
    }

}
