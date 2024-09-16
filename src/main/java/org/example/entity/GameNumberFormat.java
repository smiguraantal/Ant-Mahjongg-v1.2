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
 * A játék számát megformázó osztály
 */
public class GameNumberFormat {

    /**
     * Konstruktor letiltva
     */
    private GameNumberFormat() {
    }

    //----------------------------------------------------------------------

    /**
     * Megformázza az játék számát
     */
    public static String format(int number) {
        return number < 10 ? "#0" + number : "#" + number;
    }
}













