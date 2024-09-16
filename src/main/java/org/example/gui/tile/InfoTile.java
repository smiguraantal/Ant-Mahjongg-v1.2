package org.example.gui.tile;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Location;
import org.example.entity.Style;
import org.example.gui.TilePalette;
import org.example.gui.drawer.ImageDrawer;
import org.example.gui.drawer.TDEDrawer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

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
 * A kőpalettán megjelenített objektum, amely olyan mint egy kő, csak
 * sokkal kevesebb adattal rendelkezik és sokkal kevesebbet tud.
 */
public class InfoTile extends JPanel implements Constants, Location {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A kép, melyen a kövek kollekciója található
     */
    private Image image;

    /**
     * A panel melyen elhelyezkedik
     */
    private TilePalette tilePalette;

    /**
     * A kő értéke
     */
    private int value;

    /**
     * X koordináta
     */
    private int x;

    /**
     * Y koordináta
     */
    private int y;

    BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public InfoTile(TilePalette tilePalette, int x, int y, int value) {
        this.tilePalette = tilePalette;
        this.x = x;
        this.y = y;
        this.value = value;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        int TDE = dataModule.getTilePaletteProperty().isTde() ?
                TILE_TRANSLATE : 0;
        setBounds(x, y, TILE_WIDTH * UNIT + TDE, TILE_HEIGHT * UNIT + TDE);

        this.setLayout(borderLayout1);
        this.addMouseListener(new InfoTile_this_mouseAdapter(this));
        this.setOpaque(false);
        loadImage();
    }

    //----------------------------------------------------------------------

    /**
     * Betölti a képeket egy fáljból
     */
    public void loadImage() {
        MediaTracker tr = new MediaTracker(this);
        Style style = dataModule.getStyle();
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(
                RESOURCE_PATH + style.getImagePath_1()));
        tr.addImage(image, 0);
        try {
            tr.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja az aktuális képet
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (dataModule.getTilePaletteProperty().isTde())
            new ImageDrawer(this, image, g, value).drawImage();
        else
            new ImageDrawer(this, image, g, value).drawImageNW(); // ha nincs térhatás, akkor a bal felső saroktól rajzolja a követ

        if (dataModule.getTilePaletteProperty().isTde())
            new TDEDrawer(g).drawTDE();
    }

    //----------------------------------------------------------------------

    /**
     * Fontos, hogy ha beér a területére a kurzor akkor tűnjön el az összes
     * kőinfó, mert különben nem hívható a helyi menü!
     */
    void this_mouseEntered(MouseEvent e) {
        tilePalette.removeAll();
        tilePalette.repaint();
    }

    //----------------------------------------------------------------------

    void this_mousePressed(MouseEvent e) {
    }

    public int getValue() {
        return value;
    }

}

class InfoTile_this_mouseAdapter extends java.awt.event.MouseAdapter {
    InfoTile adaptee;

    InfoTile_this_mouseAdapter(InfoTile adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.this_mousePressed(e);
    }

    public void mouseEntered(MouseEvent e) {
        adaptee.this_mouseEntered(e);
    }
}








