package org.example.entity;

import org.example.gui.MainFrame;

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
 * A játék alatt eltelt időt megvalósító osztály osztály
 */
public class Time implements Serializable, Runnable {

    /**
     * A időt egy óráig számolja a program.
     */
    private final int MAX_TIME = 3600 * 100;

    /**
     * A főablak
     */
    private MainFrame mainFrame;

    /**
     * Az eltelt idő századmásodpercekben
     */
    private int time;

    /**
     * A szál, amelyben fut az idő
     */
    private Thread thread;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Time() {
    }

    //----------------------------------------------------------------------

    /**
     * Időzítés századmásodpercenként
     */
    public void run() {
        while (true) {
            try {
                thread.sleep(10);

                increaseTime();
                if (time % 100 == 0) // minden egész másodpercben
                    mainFrame.setTimeLabel();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Elindítja az időt
     */
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    //----------------------------------------------------------------------

    /**
     * Megállítja az időt
     */
    public void stop() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }
    }

    //----------------------------------------------------------------------

    /**
     * Ha még lehet, akkor növeli az időt
     */
    public void increaseTime() {
        if (time < MAX_TIME)
            ++time;
    }

    //----------------------------------------------------------------------

    /**
     * Hozzáadja a kapott másodperceket az időzöz. Ha viszont túllépné a maximális
     * időt, akkor lekerekítjük
     */
    public void addSeconds(int seconds) {
        if (time < MAX_TIME) // hozzáadás
            time += seconds * 100;
        if (time > MAX_TIME) // ha túllépte a maximumot
            time = MAX_TIME;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja az eltelt egész másodperceket
     */
    public int getSeconds() {
        return time / 100;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy fut-e a szál
     */
    public boolean isRunning() {
        return thread.isAlive();
    }

    //----------------------------------------------------------------------

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

}





