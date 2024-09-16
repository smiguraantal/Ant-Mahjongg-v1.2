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
 * Az időt megformázó osztály
 */
public class TimeFormat {

    /**
     * Konstruktor letiltva
     */
    private TimeFormat() {
    }

    //----------------------------------------------------------------------

    /**
     * Megformázza az időt
     */
    public static String format(int time) {
        time /= 100; // századmásodpercekről másodpercekre való osztás
        int minutes = time / 60;
        int seconds = time - minutes * 60;

        return time == 3600 ? "1:00:00" :
                twoNumbers(minutes) + ":" + twoNumbers(seconds);
    }

    //----------------------------------------------------------------------

    /**
     * Az egyjegyű számokat két karakteren ábrázolja (Pl: 04)
     */
    private static String twoNumbers(int number) {
        return number < 10 ? "0" + number : "" + number;
    }
}








