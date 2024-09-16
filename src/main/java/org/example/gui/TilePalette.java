package org.example.gui;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Orientation;
import org.example.gui.panel.GamePanel;
import org.example.gui.popupmenu.TilePalettePopupMenu;
import org.example.gui.tile.InfoTile;
import org.example.gui.tile.Tile;

import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

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
 * A kőpaletta
 */
public class TilePalette extends JPanel implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Tábla
     */
    private GamePanel gamePanel;

    /**
     * A kövek közötti és a panel szélévől való távolság
     */
    private final int GAP = 5;

    /**
     * Helyi menü
     */
    private TilePalettePopupMenu popupMenu;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TilePalette(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        this.setLayout(null);
        this.setOpaque(false);
        setPaletteBounds();
        localeTilePalette();
        popupMenu = new TilePalettePopupMenu(this);
        setVisible(dataModule.getTilePaletteProperty().isVisible());
        this.addMouseListener(new TilePalette_this_mouseAdapter(this));
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a paletta elhelyezkedését
     */
    public void setPaletteBounds() {
        int TDE = dataModule.getTilePaletteProperty().isTde() ?
                TILE_TRANSLATE : 0;
        if (dataModule.getTilePaletteProperty().getOrientation() == Orientation.VERTICAL)
            setBounds(0,
                    0,
                    TILE_WIDTH * UNIT + TDE + GAP * 2,
                    (int) ((TILE_HEIGHT * UNIT + TDE) * MAX_PACK_SIZE + GAP * (MAX_PACK_SIZE + 1)));
        else
            setBounds(0,
                    0,
                    (int) ((TILE_WIDTH * UNIT + TDE) * MAX_PACK_SIZE + GAP * (MAX_PACK_SIZE + 1)),
                    TILE_HEIGHT * UNIT + TDE + GAP * 2);
    }

    //----------------------------------------------------------------------

    /**
     * Megvizsgálja, hogy a kapott kövek értékei rendre megegyeznek-e
     * a kőpalettán elhelyezett infokövek értékeivel. Ha megegyeznek, akkor
     * nem kell újra elhelyezni az infoköveket.
     */
    private boolean differentTiles(Vector tiles) {
        if (getComponentCount() != tiles.size()) // eltérő számú kő
            return true;
        for (int i = 0; i < getComponentCount(); i++) { // ugyanannyi kő
            InfoTile infoTile = (InfoTile) getComponent(i);
            Tile tile = (Tile) tiles.get(i);
            if (infoTile.getValue() != tile.getValue()) // más érték
                return true;
        }
        return false;
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezi az információs köveket a palettán
     */
    public void buildPalette(Vector tiles) {
        if (differentTiles(tiles)) { // csak akkor épít ha más köveket kap
            removeAll();
            if (!dataModule.getTilePaletteProperty().isShowUnderTiles() && !tiles.isEmpty())
                tiles.setSize(1); // ne mutassa az alatta lévőket
            if (dataModule.getTilePaletteProperty().getOrientation() == Orientation.VERTICAL)
                putTilesHorizontally(tiles);
            else
                putTilesVertically(tiles);
            repaint();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Törli az összes követ a palettáról
     */
    public void clearPalette() {
        buildPalette(new Vector());
    }

    //----------------------------------------------------------------------

    /**
     * Vízszintesen helyezi el az információs köveket, melyek értéke a
     * kapott kövekéből lesz meghatározva
     */
    private void putTilesHorizontally(Vector tiles) {
        int TDE = dataModule.getTilePaletteProperty().isTde() ?
                TILE_TRANSLATE : 0;
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            add(new InfoTile(this,
                    GAP,
                    (i + 1) * GAP + i * (TILE_HEIGHT * UNIT + TDE),
                    tile.getValue()));
        }
    }

    //----------------------------------------------------------------------

    /**
     * Függőlegesen helyezi el az információs köveket, melyek értéke a
     * kapott kövekéből lesz meghatározva
     */
    private void putTilesVertically(Vector tiles) {
        int TDE = dataModule.getTilePaletteProperty().isTde() ?
                TILE_TRANSLATE : 0;
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            add(new InfoTile(this,
                    (i + 1) * GAP + i * (TILE_WIDTH * UNIT + TDE),
                    GAP,
                    tile.getValue()));
        }
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja az infokövek elhelyezkedését vízszintesen
     */
    private void setInfoTilesHorizontally() {
        int TDE = dataModule.getTilePaletteProperty().isTde() ?
                TILE_TRANSLATE : 0;
        for (int i = 0; i < getComponentCount(); i++) {
            InfoTile infoTile = (InfoTile) getComponent(i);
            infoTile.setBounds(GAP,
                    (i + 1) * GAP + i * (TILE_HEIGHT * UNIT + TDE),
                    TILE_WIDTH * UNIT + TDE,
                    TILE_HEIGHT * UNIT + TDE);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja az infokövek elhelyezkedését függőlegesen
     */
    private void setInfoTilesVertically() {
        int TDE = dataModule.getTilePaletteProperty().isTde() ?
                TILE_TRANSLATE : 0;
        for (int i = 0; i < getComponentCount(); i++) {
            InfoTile infoTile = (InfoTile) getComponent(i);
            infoTile.setBounds((i + 1) * GAP + i * (TILE_WIDTH * UNIT + TDE),
                    GAP,
                    TILE_WIDTH * UNIT + TDE,
                    TILE_HEIGHT * UNIT + TDE);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a palettát
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor((Color) UIManager.get("Panel.background"));

        if (dataModule.getTilePaletteProperty().isNonSkid())
            drawNonSkid(g);

        g.draw3DRect(0, 0, getWidth() - 1, getHeight() - 1, true); // 3D-s keret
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a csúszásgátlót
     */
    private void drawNonSkid(Graphics g) {
        for (int y = 3; y < getHeight(); y += 3) {
            for (int x = 3; x < getWidth(); x += 3) {
                g.fillOval(x, y, 2, 2);
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Újrarajzolja a köveket
     */
    public void refreshTiles() {
        for (int i = 0; i < getComponentCount(); i++) {
            InfoTile infoTile = (InfoTile) getComponent(i);
            infoTile.loadImage();
            infoTile.repaint();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Elhelyezi a tartalamzó panelon a palettát
     */
    public void localeTilePalette() {
        new ComponentLocation(this,
                gamePanel,
                dataModule.getTilePaletteProperty().getLocation(),
                dataModule.getTilePaletteProperty().getGap());
    }

    //----------------------------------------------------------------------

    /**
     * Megváltoztatja a paletta méretét, elhelyezését és a rajta lévő
     * köveket
     */
    public void changeTDE() {
        setPaletteBounds();
        localeTilePalette();

        if (dataModule.getTilePaletteProperty().getOrientation() == Orientation.VERTICAL)
            setInfoTilesHorizontally();
        else
            setInfoTilesVertically();

        repaint();
    }

    //----------------------------------------------------------------------

    /**
     * Pozíció változtatása
     */
    public void newLocation(int location) {
        dataModule.getTilePaletteProperty().setLocation(location);
        dataModule.saveSettings();
        localeTilePalette();
    }

    //----------------------------------------------------------------------

    /**
     * Fekvés változtatása
     */
    public void newOrientation(int orientation) {
        dataModule.getTilePaletteProperty().setOrientation(orientation);
        dataModule.saveSettings();
        setPaletteBounds();
        localeTilePalette();
    }

    //----------------------------------------------------------------------

    /**
     * Távolság változtatása
     */
    public void newGap(int gap) {
        dataModule.getTilePaletteProperty().setGap(gap);
        dataModule.saveSettings();
        localeTilePalette();
    }

    //----------------------------------------------------------------------

    /**
     * Infotípus változtatása
     */
    public void newInfoType(int infoType) {
        dataModule.getTilePaletteProperty().setInfoType(infoType);
        dataModule.saveSettings();
    }

    //----------------------------------------------------------------------

    void this_mousePressed(MouseEvent e) {
        if (e.getModifiers() == e.BUTTON3_MASK)  // jobb egérkattintás
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    //----------------------------------------------------------------------

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    //----------------------------------------------------------------------

    void this_mouseEntered(MouseEvent e) {
        removeAll();
        repaint();
    }


}

class TilePalette_this_mouseAdapter extends java.awt.event.MouseAdapter {
    TilePalette adaptee;

    TilePalette_this_mouseAdapter(TilePalette adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.this_mousePressed(e);
    }

    public void mouseEntered(MouseEvent e) {
        adaptee.this_mouseEntered(e);
    }
}




