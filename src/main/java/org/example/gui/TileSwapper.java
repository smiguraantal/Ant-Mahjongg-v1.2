package org.example.gui;

import org.example.entity.DataModule;
import org.example.gui.tile.Tile;

import java.util.Comparator;
import java.util.TreeSet;
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
 * A kijelölt kő alatti köveket megkereső, illetve a kijelölt követ
 * alúlra tevő osztály
 */
public class TileSwapper {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Az összes kő
     */
    private Vector tiles;

    /**
     * A kijelölt kő és az az alatti kövek
     */
    private Vector swappingTiles = new Vector();

    /**
     * A kijelölt kő
     */
    private Tile selectedTile;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TileSwapper(Vector tiles, Tile selectedTile) {
        this.tiles = tiles;
        this.selectedTile = selectedTile;
        chooseSwappingTiles(selectedTile);
    }

    //----------------------------------------------------------------------

    /**
     * Alulra teszi a kijelölt követ
     */
    public void swapTiles() {
        changeValues();
        selectedTile.setSelected(false);
        dataModule.setNumberOfSelectedTiles(0);
    }

    //----------------------------------------------------------------------

    /**
     * Rekurzívan megkeresi azokat a köveket, melyek pontosan a kapott kő alatt
     * helyezkednek el
     */
    private void chooseSwappingTiles(Tile tile) {
        swappingTiles.add(tile);
        for (int i = 0; i < tile.getUnderTiles().size(); i++) {
            Tile underTile = (Tile) tile.getUnderTiles().get(i);
            if (underTile.getPlace().getX() == tile.getPlace().getX() &&
                    underTile.getPlace().getY() == tile.getPlace().getY() &&
                    underTile.getPlace().getLayer() == tile.getPlace().getLayer() - 1)
                chooseSwappingTiles(underTile);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Rétegszám szerint rendezi a kapott köveket
     */
    private void shortSwappingTiles() {
        TreeSet treeSet = new TreeSet(new Comparator() {
            public int compare(Object object_1, Object object_2) {
                Tile tile_1 = (Tile) object_1;
                Tile tile_2 = (Tile) object_2;
                return tile_1.getPlace().getLayer() - tile_2.getPlace().getLayer();
            }
        });
        treeSet.addAll(swappingTiles);
        swappingTiles = new Vector(treeSet);
    }

    //----------------------------------------------------------------------

    /**
     * Felcseréli a kövek értékeit
     */
    private void changeValues() {
        Vector values = new Vector();
        // értékek kigyűjtése
        for (int i = 0; i < swappingTiles.size(); i++) {
            Tile swappingTile = (Tile) swappingTiles.get(i);
            values.add(new Integer(swappingTile.getValue()));
        }
        // első kivevése és az utolsó helyre tevése
        values.add(values.remove(0));
        // más értékeket kapnak a cserepek
        for (int i = 0; i < swappingTiles.size(); i++) {
            Tile swappingTile = (Tile) swappingTiles.get(i);
            swappingTile.setValue(((Integer) values.get(i)).intValue());
            swappingTile.repaint();
        }
    }

    //----------------------------------------------------------------------

    public Vector getSwappingTiles() {
        return swappingTiles;
    }

}







