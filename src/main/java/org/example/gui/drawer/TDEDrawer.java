package org.example.gui.drawer;

import org.example.entity.Constants;
import org.example.entity.DataModule;

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
 * A térhatást megrajzoló osztály
 */
public class TDEDrawer implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A kő grafikus objektuma
     */
    private Graphics g;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TDEDrawer(Graphics g) {
        this.g = g;
    }

    //----------------------------------------------------------------------

    /**
     * Meghívja a térhatásrajzoló metódusok egyikét
     */
    public void drawTDE() {
        if (dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_WEST))
            drawThreeDimensiolanEffectNW();
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_EAST))
            drawThreeDimensiolanEffectNE();
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_WEST))
            drawThreeDimensiolanEffectSW();
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_EAST))
            drawThreeDimensiolanEffectSE();
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a 3 dimenziós hatást NW = NorthWest
     */
    private void drawThreeDimensiolanEffectNW() {
        g.setColor(dataModule.getColorTheme().getColor_2());
        // jobb oldali világos kitöltés
        g.drawLine(36, 1, 36, 44);
        g.drawLine(37, 2, 37, 45);
        g.drawLine(38, 3, 38, 46);
        // alsó világos kitöltés
        g.drawLine(1, 45, 36, 45);
        g.drawLine(2, 46, 37, 46);
        g.drawLine(3, 47, 38, 47);

        g.setColor(dataModule.getColorTheme().getColor_1());
        // jobb oldali sötét kitöltés
        g.drawLine(39, 4, 39, 47);
        g.drawLine(40, 5, 40, 48);
        g.drawLine(41, 6, 41, 49);
        // alsó sötét kitöltés
        g.drawLine(4, 48, 39, 48);
        g.drawLine(5, 49, 40, 49);
        g.drawLine(6, 50, 41, 50);

        // jobb alsó vonal
        g.drawLine(36, 45, 41, 50);
        // bal alsó vonal
        g.drawLine(1, 45, 6, 50);
        // felső vonal
        g.drawLine(36, 1, 41, 6);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a 3 dimenziós hatást (NE = NorthEast)
     */
    private void drawThreeDimensiolanEffectNE() {
        g.setColor(dataModule.getColorTheme().getColor_2());
        // bal oldali világos kitöltés
        g.drawLine(5, 1, 5, 44);
        g.drawLine(4, 2, 4, 45);
        g.drawLine(3, 3, 3, 46);
        // alsó világos kitöltés
        g.drawLine(5, 45, 40, 45);
        g.drawLine(4, 46, 39, 46);
        g.drawLine(3, 47, 38, 47);

        g.setColor(dataModule.getColorTheme().getColor_1());
        // bal oldali sötét kitöltés
        g.drawLine(2, 4, 2, 47);
        g.drawLine(1, 5, 1, 48);
        g.drawLine(0, 6, 0, 49);
        // alsó sötét kitöltés
        g.drawLine(2, 48, 37, 48);
        g.drawLine(1, 49, 36, 49);
        g.drawLine(0, 50, 35, 50);

        // bal alsó vonal
        g.drawLine(5, 45, 0, 50);
        // felső vonal
        g.drawLine(5, 1, 0, 6);
        // jobb alsó vonal
        g.drawLine(40, 45, 35, 50);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a 3 dimenziós hatást (SW = SouthWest)
     */
    private void drawThreeDimensiolanEffectSW() {
        g.setColor(dataModule.getColorTheme().getColor_2());
        // jobb oldali világos kitöltés
        g.drawLine(36, 6, 36, 49);
        g.drawLine(37, 5, 37, 48);
        g.drawLine(38, 4, 38, 47);
        // felső világos kitöltés
        g.drawLine(3, 3, 38, 3);
        g.drawLine(2, 4, 37, 4);
        g.drawLine(1, 5, 36, 5);

        g.setColor(dataModule.getColorTheme().getColor_1());
        // jobb oldali sötét kitöltés
        g.drawLine(39, 3, 39, 46);
        g.drawLine(40, 2, 40, 45);
        g.drawLine(41, 1, 41, 44);
        // felső sötét kitöltés
        g.drawLine(6, 0, 41, 0);
        g.drawLine(5, 1, 40, 1);
        g.drawLine(4, 2, 39, 2);

        // bal felső vonal
        g.drawLine(1, 5, 6, 0);
        // jobb felső vonal
        g.drawLine(36, 5, 41, 0);
        // jobb alsó vonal
        g.drawLine(36, 49, 41, 44);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a 3 dimenziós hatást (SE = SouthEast)
     */
    private void drawThreeDimensiolanEffectSE() {
        g.setColor(dataModule.getColorTheme().getColor_2());
        // bal oldali világos kitöltés
        g.drawLine(3, 4, 3, 47);
        g.drawLine(4, 5, 4, 48);
        g.drawLine(5, 6, 5, 49);
        // felső világos kitöltés
        g.drawLine(3, 3, 38, 3);
        g.drawLine(4, 4, 39, 4);
        g.drawLine(5, 5, 40, 5);

        g.setColor(dataModule.getColorTheme().getColor_1());
        // bal oldali sötét kitöltés
        g.drawLine(0, 1, 0, 44);
        g.drawLine(1, 2, 1, 45);
        g.drawLine(2, 3, 2, 46);
        // felső sötét kitöltés
        g.drawLine(0, 0, 35, 0);
        g.drawLine(1, 1, 36, 1);
        g.drawLine(2, 2, 37, 2);

        // bal felső vonal
        g.drawLine(5, 5, 0, 0);
        // jobb felső vonal
        g.drawLine(40, 5, 35, 0);
        // bal alsó vonal
        g.drawLine(5, 49, 0, 44);
    }

}







