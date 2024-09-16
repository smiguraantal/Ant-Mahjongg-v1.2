package org.example.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
 * Rekord osztály
 */
public class Record implements Serializable, Comparable, Constants {

    /**
     * a csúcstartó neve
     */
    private String player;

    /**
     * ennyi idő alatt fejezte be a játékot
     */
    private int time;

    /**
     * bűntetőpontok
     */
    private int penalty;

    /**
     * a rekord születésének időpontja
     */
    private GregorianCalendar date;

    //----------------------------------------------------------------------

    /**
     * konstruktor
     */
    public Record(String player,
                  int time,
                  int penalty,
                  GregorianCalendar date) {
        this.player = player;
        this.time = time;
        this.penalty = penalty;
        this.date = date;
    }

    //----------------------------------------------------------------------

    /**
     * konstruktor
     */
    public Record() {
        this(System.getProperty("user.name"),
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                new GregorianCalendar());
    }

    //----------------------------------------------------------------------

    /**
     * Időeredményre, azon belül bűntetőpontra, azon belül dárumra,
     * azon belül pedig névre rendez.
     */
    public int compareTo(Object object) {
        Record record = (Record) object;
        if (time / 100 > record.getTime() / 100) // a rekordok összevetésénél már nem számítanak a századmásodpercek!
            return 1;
        else if (time / 100 < record.getTime() / 100) // a rekordok összevetésénél már nem számítanak a századmásodpercek!
            return -1;
        else if (penalty > record.getPenalty())
            return 1;
        else if (penalty < record.getPenalty())
            return -1;
        else if (date.getTimeInMillis() > record.getDate().getTimeInMillis())
            return 1;
        else if (date.getTimeInMillis() < record.getDate().getTimeInMillis())
            return -1;
        return player.compareTo(record.getPlayer());
    }

    //----------------------------------------------------------------------

    /**
     * Formázottan adja vissza a dátumot
     */
    public String getDateToString() {
        if (date == null)
            return "";
        return date.get(Calendar.YEAR) +
                "." +
                format((date.get(Calendar.MONTH) + 1)) +
                "." +
                format(date.get(Calendar.DAY_OF_MONTH)) +
                "." +
                "   " +
                format(date.get(Calendar.HOUR_OF_DAY)) +
                ":" +
                format(date.get(Calendar.MINUTE)) +
                ":" +
                format(date.get(Calendar.SECOND));
    }

    //----------------------------------------------------------------------

    /**
     *
     */
    private String format(int number) {
        return number < 10 ? "0" + number : "" + number;
    }

    //----------------------------------------------------------------------

    public String toString() {
        return "time: " + time;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPenalty() {
        return penalty;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}






