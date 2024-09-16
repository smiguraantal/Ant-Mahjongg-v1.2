package org.example.gui;

import org.example.entity.DataModule;
import org.example.gui.tile.Tile;

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
 * Érték szerint összeválogatja a köveket
 */
public class OpenTileSelector extends Vector {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A még meglévő kövek
     */
    private Vector tiles = new Vector();

    /**
     * A levehető kövek
     */
    private Vector selectableTiles = new Vector();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public OpenTileSelector(Vector tiles) {
        this.tiles = tiles;
        chooseSelectableTiles();
        selectByValue();
    }

    //----------------------------------------------------------------------

    /**
     * levehető kövek kiválasztása
     */
    private void chooseSelectableTiles() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            if (tile.selectable())
                selectableTiles.add(tile);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Szétválogatja az értékben egymáshoz passzoló köveket
     */
    private void selectByValue() {
        for (int i = 0; i < selectableTiles.size(); i++) {
            Tile tile = (Tile) selectableTiles.get(i);
            if (getSameTiles(convert(tile.getValue())) != null) { // ha már van ilyen értékű kő, akkor csak hozzá kell adni
                getSameTiles(convert(tile.getValue())).add(tile);
            } else { // ha még nincs, akkor egy objektumot kell kreálni
                add(new SameTiles(convert(tile.getValue()), tile));
            }
        }
        for (int i = size() - 1; i >= 0; i--) {
            SameTiles sameTiles = (SameTiles) get(i);
            if (sameTiles.size() < 2) // amelyiknek nincs párja azt töröljük
                remove(sameTiles);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a kapott értékkel azonos sorszámú azonos köveket
     */
    public SameTiles getSameTiles(int number) {
        for (int i = 0; i < size(); i++) {
            SameTiles sameTiles = (SameTiles) get(i);
            if (sameTiles.getNumber() == number)
                return sameTiles;
        }
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Sorszámmá konvertálja a kapott kőértéket
     */
    private int convert(int value) {
        if (dataModule.isSeason(value)) // az évszakok 34 es sorszámúak lesznek
            value = 34;
        else if (dataModule.isFlower(value)) // a virágok pedig 35-ösek
            value = 35;
        return value;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy az azonos értékkel rendelkező kövekből hány pár
     * van összesen
     */
    public int pairs() {
        int pairs = 0;
        for (int i = 0; i < size(); i++) {
            SameTiles sameTiles = (SameTiles) get(i);
            pairs += sameTiles.pairs();
        }
        return pairs;
    }

    //----------------------------------------------------------------------

    /**
     * Az első elemet leghátulra teszi
     */
    public void moveToBack() {
        add(remove(0));
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott kő nyílván van-e tartva levehető
     * kőként. Ha igen, akkor az azt jelenti, hogy van párja
     */
    public boolean inPairs(Tile tile) {
        for (int i = 0; i < size(); i++) {
            SameTiles sameTiles = (SameTiles) get(i);
            if (sameTiles.contains(tile))
                return true;
        }
        return false;
    }


}











