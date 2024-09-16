package org.example.gui.manager;

import javax.swing.ImageIcon;

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
 * A képeket előállító osztály
 */
public class ImageIconManager {

    /**
     * A képek könyvtára
     */
    public static final String RESOURCE_PATH = "/resources/";

    //----------------------------------------------------------------------

    /**
     * Létrehoz egy ikont az útvonal alapján
     */
    public ImageIcon createImageIcon(String path) {
//        return new ImageIcon(getClass().getResource(RESOURCE_PATH + path));
        return new ImageIcon(getClass().getResource("/" + path));
    }
}








