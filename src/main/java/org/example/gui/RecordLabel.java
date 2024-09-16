package org.example.gui;

import org.example.entity.Constants;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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
 * Egy rekord adatai megjelenítő címke
 */
public class RecordLabel extends JLabel implements Constants {

    /**
     * Kell-e aláhúzás
     */
    boolean underline;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public RecordLabel(String text,
                       int horizontalAlignment,
                       int width,
                       boolean underline,
                       boolean colored) {
        super(text);
        this.underline = underline;
        setHorizontalAlignment(horizontalAlignment);
        setPreferredSize(new Dimension(width, getPreferredSize().height));
        if (colored)
            this.setForeground(BLUE_LABEL);
        //this.setForeground(UIManager.getColor("List.selectionBackground"));
        setOpaque(true);
    }

    //----------------------------------------------------------------------

    /**
     * Ha kell aláhúzza a címkét
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (underline) {
            g.setColor(Color.black);
            g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
        }
    }
}







