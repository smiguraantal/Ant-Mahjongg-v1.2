package org.example.gui;

import org.example.entity.Location;

import java.awt.Component;

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
 * Egy komponenset az őse területén elhelyező osztály
 */
public class ComponentLocation implements Location {

    //----------------------------------------------------------------------

    /**
     * Kivételosztály a rossz paraméterezés esetére
     */
    class ComponentLocationException extends RuntimeException {
        public ComponentLocationException() {
            super("Not supported ComponentLocation parameter");
        }

        public ComponentLocationException(String errorMessage) {
            super(errorMessage);
        }
    }

    //----------------------------------------------------------------------

    /**
     * A szülő objektum
     */
    private Component parent;

    /**
     * Az elhelyezni kívánt komponens
     */
    private Component component;

    /**
     * Az tartamazó objektum szélétől való távolság
     */
    private int gap;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public ComponentLocation(Component component,
                             Component parent,
                             int location,
                             int gap) {
        this.component = component;
        this.parent = parent;
        this.gap = gap;

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
            throw new ComponentLocationException();
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés középre
     */
    private void center() {
        component.setLocation((parent.getPreferredSize().width - component.getWidth()) / 2,
                (parent.getPreferredSize().height - component.getHeight()) / 2);
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés a bal oldalra
     */
    private void west() {
        component.setLocation(gap,
                (parent.getPreferredSize().height - component.getHeight()) / 2);
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés jobb oldalra
     */
    private void east() {
        component.setLocation(parent.getPreferredSize().width - component.getWidth() - gap,
                (parent.getPreferredSize().height - component.getHeight()) / 2);
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés fentre
     */
    private void north() {
        component.setLocation((parent.getPreferredSize().width - component.getWidth()) / 2,
                gap);
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés lenre
     */
    private void south() {
        component.setLocation((parent.getPreferredSize().width - component.getWidth()) / 2,
                parent.getPreferredSize().height - component.getHeight() - gap);
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés a bal felső sarokba
     */
    private void northWest() {
        component.setLocation(gap,
                gap);
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés a bal alsó sarokba
     */
    private void southWest() {
        component.setLocation(gap,
                parent.getPreferredSize().height - component.getHeight() - gap);
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés a jobb felső sarokba
     */
    private void northEast() {
        component.setLocation(parent.getPreferredSize().width - component.getWidth() - gap,
                gap);
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezés a jobb alsó sarokba
     */
    private void southEast() {
        component.setLocation(parent.getPreferredSize().width - component.getWidth() - gap,
                parent.getPreferredSize().height - component.getHeight() - gap);
    }
}






