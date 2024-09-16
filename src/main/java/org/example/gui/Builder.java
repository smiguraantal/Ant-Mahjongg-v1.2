package org.example.gui;

import org.example.entity.Place;
import org.example.gui.tile.BasicTile;

import java.util.Collections;
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
 * Az osztály egy olyan leszedési sorrendet határoz meg, amely alapján
 * a kövek fel leszenk építve.
 */
public class Builder {

    /**
     * Kövek, melyek logikailag vesznek részt a levételi-felépítési
     * sorrend kialakításában
     */
    private Vector tiles = new Vector();

    /**
     * Az eredeti helyekből felépíthető kövek száma
     */
    private int numberOfTiles;

    /**
     * A kövek eredeti helyei
     */
    private Vector originalPlaces;

    /**
     * A kövek helyei a felépítési sorrendben
     */
    private Vector orderedPlaces = new Vector();
    ;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Builder(Vector originalPlaces) {
        this.originalPlaces = originalPlaces;

        buildBasicTiles();
        buildOrderedPlaces();
    }

    /**
     * Felépíti az elrendezést az alapkövekből, hogy aztán késöbb a sorrend
     * meghatározásához le lehessen venni azokat.
     */
    private void buildBasicTiles() {
        for (int i = 0; i < originalPlaces.size(); i++) {
            Place place = (Place) originalPlaces.get(i);
            BasicTile tile = new BasicTile(place);
            setNeihbours(tile);
            tiles.add(tile);
        }
        numberOfTiles = tiles.size();
        Collections.shuffle(tiles);
    }

    //----------------------------------------------------------------------

    /**
     * Páronként leveszi a köveket elmenti helyeiket, majd megfordítja
     * a helyek sorrendjét. Ez alapján a sorrend alapján lesz felépítve
     * az elrendezés.
     */
    private void buildOrderedPlaces() {
        for (int i = 0; i < numberOfTiles / 2; i++) {
            chooseTwoTiles(); // mindig két követ választ (pl: 20 kő van, akkor 10-szer választ kettőt)
        }
        Collections.reverse(orderedPlaces);
    }

    //----------------------------------------------------------------------

    /**
     * Kiválaszt két levehető követ, majd hozzáadja helyeiket a levételi
     * sorrendhez, utána pedig megsemmisíti azokat
     */
    private void chooseTwoTiles() {
        BasicTile first = getSelectableTile();
        BasicTile second = getSelectableTile();

        if (first != null && second != null) {
            orderedPlaces.add(first.getPlace());
            orderedPlaces.add(second.getPlace());
            removeTile(first);
            removeTile(second);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Kiválaszt egy levehető követ és megjelöli azt
     */
    public BasicTile getSelectableTile() {
        for (int i = 0; i < tiles.size(); i++) {
            BasicTile tile = (BasicTile) tiles.get(i);
            if (tile.selectable() && !tile.isSelected()) {
                tile.setSelected(true);
                return tile;
            }
        }
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Leveszi a kapott követ
     */
    public void removeTile(BasicTile tile) {
        tiles.remove(tile);
        tile.removeFromTable(); // == tile.finalize();
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza, hogy a kapott kő melyikkel szomszédos
     */
    private void setNeihbours(BasicTile newTile) {
        for (int i = 0; i < tiles.size(); i++) {
            BasicTile tile = (BasicTile) tiles.get(i);
            tile.setNeighbours(newTile);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy sikerült-e meghatározni a kövek leszedési
     * sorrendjét
     */
    public boolean succesBuilding() {
        return orderedPlaces.size() == numberOfTiles;
    }

    //----------------------------------------------------------------------

    public Vector getOrderedPlaces() {
        return orderedPlaces;
    }

    public int getNumberOfTiles() {
        return numberOfTiles;
    }


}











