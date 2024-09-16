package org.example.gui.drawer;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.TilePosition;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

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
 * A kapott kőre a képet felrajzoló osztály
 */

public class ImageDrawer implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A kő
     */
    private JPanel tile;

    /**
     * A kép, melyet fel kell rajzolni a kőre
     */
    private Image image;

    /**
     * A kő grafikus objektuma
     */
    private Graphics g;

    /**
     * A kő értéke
     */
    private int value;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public ImageDrawer(JPanel tile,
                       Image image,
                       Graphics g,
                       int value) {
        this.tile = tile;
        this.image = image;
        this.g = g;
        this.value = value;
    }

    //----------------------------------------------------------------------

    /**
     * A térhatástól függően hívja meg a képrajzoló metódusok egyikét
     */
    public void drawImage() {
        if (dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_WEST))
            drawImageNW();
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_EAST))
            drawImageNE();
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_WEST))
            drawImageSW();
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_EAST))
            drawImageSE();
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a képet a bal felső sarokba
     */
    public void drawImageNW() {
        if (image != null) { // csak ha megvan a kép
            g.drawImage(image,
                    0,
                    0,
                    TILE_WIDTH * UNIT,
                    TILE_HEIGHT * UNIT,
                    TilePosition.getCalculatedX(value),
                    TilePosition.getCalculatedY(value),
                    TilePosition.getCalculatedX(value) + TILE_WIDTH * UNIT,
                    TilePosition.getCalculatedY(value) + TILE_HEIGHT * UNIT,
                    tile);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a képet a jobb felső sarokba
     */
    private void drawImageNE() {
        if (image != null) { // csak ha megvan a kép
            g.drawImage(image,
                    TILE_TRANSLATE,
                    0,
                    TILE_WIDTH * UNIT + TILE_TRANSLATE,
                    TILE_HEIGHT * UNIT,
                    TilePosition.getCalculatedX(value),
                    TilePosition.getCalculatedY(value),
                    TilePosition.getCalculatedX(value) + TILE_WIDTH * UNIT,
                    TilePosition.getCalculatedY(value) + TILE_HEIGHT * UNIT,
                    tile);
        }
    }


    //----------------------------------------------------------------------

    /**
     * Megrajzolja a képet a bal alsó sarokba
     */
    private void drawImageSW() {
        if (image != null) { // csak ha megvan a kép
            g.drawImage(image,
                    0,
                    TILE_TRANSLATE,
                    TILE_WIDTH * UNIT,
                    TILE_HEIGHT * UNIT + TILE_TRANSLATE,
                    TilePosition.getCalculatedX(value),
                    TilePosition.getCalculatedY(value),
                    TilePosition.getCalculatedX(value) + TILE_WIDTH * UNIT,
                    TilePosition.getCalculatedY(value) + TILE_HEIGHT * UNIT,
                    tile);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a képet a jobb alsó sarokba
     */
    private void drawImageSE() {
        if (image != null) { // csak ha megvan a kép
            g.drawImage(image,
                    TILE_TRANSLATE,
                    TILE_TRANSLATE,
                    TILE_WIDTH * UNIT + TILE_TRANSLATE,
                    TILE_HEIGHT * UNIT + TILE_TRANSLATE,
                    TilePosition.getCalculatedX(value),
                    TilePosition.getCalculatedY(value),
                    TilePosition.getCalculatedX(value) + TILE_WIDTH * UNIT,
                    TilePosition.getCalculatedY(value) + TILE_HEIGHT * UNIT,
                    tile);
        }
    }

}











