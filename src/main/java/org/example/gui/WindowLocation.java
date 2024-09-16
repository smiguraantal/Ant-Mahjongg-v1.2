package org.example.gui;

import org.example.entity.Location;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

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
 * A kapott ablakot a képernyőn elhelyező osztály.
 */
public class WindowLocation implements Location {

    //----------------------------------------------------------------------

    /**
     * Kivételosztály a rossz paraméterezés esetére
     */
    class WindowLocationException extends RuntimeException {
        public WindowLocationException() {
            super("Not supported WindowLocation parameter");
        }

        public WindowLocationException(String errorMessage) {
            super(errorMessage);
        }
    }

    //----------------------------------------------------------------------

    /**
     * A képernyő mérete.
     */
    private static Dimension screenSize;

    /**
     * Az elhelyezni kívánt ablak
     */
    private Window window;

    //----------------------------------------------------------------------

    /**
     *
     */
    public WindowLocation(Window window, int location) {
        this.window = window;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        if (location == NORTH_WEST)
            northWest();
        else if (location == NORTH)
            north();
        else if (location == NORTH_EAST)
            northEast();
        else if (location == WEST)
            west();
        else if (location == CENTER)
            center();
        else if (location == EAST)
            east();
        else if (location == SOUTH_WEST)
            southWest();
        else if (location == SOUTH)
            south();
        else if (location == SOUTH_EAST)
            southEast();
        else
            throw new WindowLocationException();
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő közepére helyezi.
     */
    private void center() {
        window.setLocation((screenSize.width - window.getWidth()) / 2,
                (screenSize.height - window.getHeight()) / 2);
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő bal szélére helyezi.
     */
    private void west() {
        window.setLocation(0, (screenSize.height - window.getHeight()) / 2);
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő jobb szélére helyezi.
     */
    private void east() {
        window.setLocation(screenSize.width - window.getWidth(),
                (screenSize.height - window.getHeight()) / 2);
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő felső részére helyezi.
     */
    private void north() {
        window.setLocation((screenSize.width - window.getWidth()) / 2, 0);
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő alsó részére helyezi.
     */
    private void south() {
        window.setLocation((screenSize.width - window.getWidth()) / 2,
                (screenSize.height - window.getHeight()));
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő bal felső sarkába helyezi.
     */
    private void northWest() {
        window.setLocation(0, 0);
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő bal alsó sarkába helyezi.
     */
    private void southWest() {
        window.setLocation(0, screenSize.height - window.getHeight());
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő jobb felső sarkába helyezi.
     */
    private void northEast() {
        window.setLocation(screenSize.width - window.getWidth(), 0);
    }

    //----------------------------------------------------------------------

    /**
     * A paraméterben kapott ablakot a képernyő jobb alsó sarkába helyezi.
     */
    private void southEast() {
        window.setLocation(screenSize.width - window.getWidth(),
                screenSize.height - window.getHeight());
    }
}





