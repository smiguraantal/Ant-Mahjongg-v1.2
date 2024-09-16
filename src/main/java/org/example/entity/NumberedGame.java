package org.example.entity;

import java.io.Serializable;
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
 * Egy sorszámozott játékhoz szükséges értékeket tartalmazó osztály
 */
public class NumberedGame implements Serializable {

    /**
     * Szabály
     */
    private int rule;

    /**
     * Az elrendezés
     */
    private String layoutName;

    /**
     * A játék száma
     */
    private int number;

    /**
     * A helyek leszedési sorrendben
     */
    private Vector places;

    /**
     * A kövek értékei
     */
    private int valuesIndex;


    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public NumberedGame(int rule,
                        String layoutName,
                        int number,
                        Vector places,
                        int valuesIndex) {
        this.rule = rule;
        this.layoutName = layoutName;
        this.number = number;
        this.places = places;
        this.valuesIndex = valuesIndex;
    }

    //----------------------------------------------------------------------

    /**
     * Két számozott játék akkor egyezik, ha a számuk és az elrendezésük
     * egyezik
     */
    public boolean equals(Object object) {
        return rule == ((NumberedGame) object).getRule() &&
                layoutName.equals(((NumberedGame) object).getLayoutName()) &&
                number == ((NumberedGame) object).getNumber();
    }

    //----------------------------------------------------------------------

    public int getNumber() {
        return number;
    }

    public int getValuesIndex() {
        return valuesIndex;
    }

    public Vector getPlaces() {
        return places;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public int getRule() {
        return rule;
    }

}








