package org.example.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.GregorianCalendar;
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
 * Tíz rekordot tároló osztály
 */
public class TopTen extends Vector implements Serializable, Constants {

    /**
     * Szabály
     */
    private int rule;

    /**
     * Annak az elrendezésnek a neve, amelyikhez a rekordok tartoznak
     */
    private String layoutName;

    //----------------------------------------------------------------------

    /**
     * konstruktor
     */
    public TopTen(int rule,
                  String layoutName) {
        this.rule = rule;
        this.layoutName = layoutName;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja  a legrosszabb időeredményt
     */
    public Record getWorstRecord() {
        Collections.sort(this);
        return size() < 10 ? new Record("" + Character.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                new GregorianCalendar()) :
                ((Record) lastElement());
    }

    //----------------------------------------------------------------------

    /**
     * Hozzáadja a kapott rekordot a rekordokhoz, majd rendezi a vektort.
     * Ezután csak a tíz legjobb rekord marad érvényben
     */
    public void addRecord(Record newRecord) {
        add(newRecord);
        Collections.sort(this);
        if (size() > 10)
            setSize(10);
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja az index-edik rekordot
     */
    public Record getRecord(int index) {
        return (Record) get(index);
    }

    //----------------------------------------------------------------------

    public String getLayoutName() {
        return layoutName;
    }

    public int getRule() {
        return rule;
    }


}






