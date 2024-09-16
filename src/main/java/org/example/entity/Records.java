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
 * Az elrendezésekhez tartozó legjobb tíz rekordot összefog0ó osztály
 */
public class Records extends Vector implements Constants, Serializable {

    /**
     * Konstruktor, mely elkészíti az összes top tizes rekordot alapértelmezett
     * értékekkel szabályrendszer és elrendezés alapján.
     */
    public Records() {
        for (int i = 0; i < LAYOUT_NAMES.length; i++) {
            add(new TopTen(RULE_HORIZONTAL, LAYOUT_NAMES[i]));
            add(new TopTen(RULE_VERTICAL, LAYOUT_NAMES[i]));
            add(new TopTen(RULE_SIMPE, LAYOUT_NAMES[i]));
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a kapott szabályrendszerhez és elrendezésnévhez tartozó
     * tíz legjobb rekordot
     */
    public TopTen getTopTen(int rule, String layoutName) {
        for (int i = 0; i < size(); i++) {
            TopTen topTen = (TopTen) get(i);
            if (topTen.getRule() == rule &&
                    topTen.getLayoutName().equals(layoutName))
                return topTen;
        }
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Törli a kapott szabályrenszerhez és elrendezésnévhez tartozó
     * legjobb tizes listát
     */
    public void resetTopTen(int rule, String layoutName) {
        TopTen topTen = getTopTen(rule, layoutName);
        topTen = new TopTen(topTen.getRule(), topTen.getLayoutName()); // jó ez így ???????????
    }
}







