package org.example.gui.tile;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Place;

import javax.swing.JPanel;
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
 * A kő alaposztálya, mely csak azokat az adatokat és metódusokat tartamazza,
 * melyek az elrendezés felépítéséhez szükségesek. Ennek az osztálynak a
 * segítségével lesz felépítve úgy az elrendezés, hogy mindenképpen legyen
 * egy megoldása a játéknak, vagyis egy úton-modom mindenképpen le tudjuk
 * szedni a köveket.
 */
public class BasicTile extends JPanel implements Constants {

    /**
     * Adatmodul
     */
    protected DataModule dataModule = DataModule.getDataModule();

    /**
     * Kijelölt-e a kő
     */
    protected boolean selected;

    /**
     * A kő helye
     */
    protected Place place;

    /**
     * Bal szomszédok
     */
    protected Vector leftTiles = new Vector();

    /**
     * Jobb szomszédok
     */
    protected Vector rightTiles = new Vector();

    /**
     * Északi szomszédok
     */
    protected Vector northTiles = new Vector();

    /**
     * Déli szomszédok
     */
    protected Vector southTiles = new Vector();

    /**
     * Rétegszám szerint felette lévő szomszédok
     */
    protected Vector aboveTiles = new Vector();

    /**
     * Rétegszám szerint alatta lévő szomszédok
     */
    protected Vector underTiles = new Vector();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public BasicTile(Place place) {
        this.place = place;
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza a kő szomszédait
     */
    public void setNeighbours(BasicTile tile) {
        if (onTheLeft(tile)) {
            leftTiles.add(tile);
            tile.getRightTiles().add(this);
        }
        if (onTheRight(tile)) {
            rightTiles.add(tile);
            tile.getLeftTiles().add(this);
        }

        if (onTheNorthSide(tile)) {
            northTiles.add(tile);
            tile.getSouthTiles().add(this);
        }
        if (onTheSouthSide(tile)) {
            southTiles.add(tile);
            tile.getNorthTiles().add(this);
        }

        if (under(tile)) {
            underTiles.add(tile);
            tile.getAboveTiles().add(this);
        }
        if (above(tile)) {
            aboveTiles.add(tile);
            tile.getUnderTiles().add(this);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott kő érintkezik-e a bal oldalával
     */
    public boolean onTheLeft(BasicTile tile) {
        Place otherPlace = tile.getPlace();
        return otherPlace.getX() == place.getX() - 1 &&
                otherPlace.getY() >= place.getY() - 0.5 &&
                otherPlace.getY() <= place.getY() + 0.5 &&
                otherPlace.getLayer() == place.getLayer();
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott kő érintkezik-e a jobb oldalával
     */
    public boolean onTheRight(BasicTile tile) {
        Place otherPlace = tile.getPlace();
        return otherPlace.getX() == place.getX() + 1 &&
                otherPlace.getY() >= place.getY() - 0.5 &&
                otherPlace.getY() <= place.getY() + 0.5 &&
                otherPlace.getLayer() == place.getLayer();
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott kő érintkezik-e az északi oldalával
     */
    public boolean onTheNorthSide(BasicTile tile) {
        Place otherPlace = tile.getPlace();
        return otherPlace.getY() == place.getY() - 1 &&
                otherPlace.getX() >= place.getX() - 0.5 &&
                otherPlace.getX() <= place.getX() + 0.5 &&
                otherPlace.getLayer() == place.getLayer();
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott kő érintkezik-e a déli oldalával
     */
    public boolean onTheSouthSide(BasicTile tile) {
        Place otherPlace = tile.getPlace();
        return otherPlace.getY() == place.getY() + 1 &&
                otherPlace.getX() >= place.getX() - 0.5 &&
                otherPlace.getX() <= place.getX() + 0.5 &&
                otherPlace.getLayer() == place.getLayer();
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott kő alatta van-e
     */
    public boolean under(BasicTile tile) {
        Place otherPlace = tile.getPlace();
        return otherPlace.getX() >= place.getX() - 0.5 &&
                otherPlace.getX() <= place.getX() + 0.5 &&
                otherPlace.getY() >= place.getY() - 0.5 &&
                otherPlace.getY() <= place.getY() + 0.5 &&
                otherPlace.getLayer() == place.getLayer() - 1;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott kő felette van-e
     */
    public boolean above(BasicTile tile) {
        Place otherPlace = tile.getPlace();
        return otherPlace.getX() >= place.getX() - 0.5 &&
                otherPlace.getX() <= place.getX() + 0.5 &&
                otherPlace.getY() >= place.getY() - 0.5 &&
                otherPlace.getY() <= place.getY() + 0.5 &&
                otherPlace.getLayer() == place.getLayer() + 1;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy egy kő kijelölhető-e.
     */
    public boolean selectable() {
        if (dataModule.getRule() == RULE_HORIZONTAL) // vízszintes szabány
            return aboveTiles.isEmpty() && (leftTiles.isEmpty() || rightTiles.isEmpty());
        if (dataModule.getRule() == RULE_VERTICAL) // függőleges szabály
            return aboveTiles.isEmpty() && (northTiles.isEmpty() || southTiles.isEmpty());
        return aboveTiles.isEmpty(); // egyszerű szabály
    }

    //----------------------------------------------------------------------

    /**
     * Láthatatlanná teszi a követ és megkéri szomszédait, hogy többé ne
     * ismerjék
     */
    protected void finalize() {
        setVisible(false);
        // törlés a bal szomszédok nyilvántartásából
        for (int i = 0; i < leftTiles.size(); i++) {
            BasicTile tile = (BasicTile) leftTiles.get(i);
            tile.rightTiles.remove(this);
        }
        // törlés a jobb szomszédok nyilvántartásából
        for (int i = 0; i < rightTiles.size(); i++) {
            BasicTile tile = (BasicTile) rightTiles.get(i);
            tile.leftTiles.remove(this);
        }

        // törlés az északi szomszédok nyilvántartásából
        for (int i = 0; i < northTiles.size(); i++) {
            BasicTile tile = (BasicTile) northTiles.get(i);
            tile.southTiles.remove(this);
        }
        // törlés a déli szomszédok nyilvántartásából
        for (int i = 0; i < southTiles.size(); i++) {
            BasicTile tile = (BasicTile) southTiles.get(i);
            tile.northTiles.remove(this);
        }

        // törlés a felső szomszédok nyilvántartásából
        for (int i = 0; i < aboveTiles.size(); i++) {
            BasicTile tile = (BasicTile) aboveTiles.get(i);
            tile.underTiles.remove(this);
        }
        // törlés az alsó szomszédok nyilvántartásából
        for (int i = 0; i < underTiles.size(); i++) {
            BasicTile tile = (BasicTile) underTiles.get(i);
            tile.aboveTiles.remove(this);
        }
    }

    //----------------------------------------------------------------------

    /**
     * A metódus azért íródott, mert más csomagból nem tudtam meghívni a
     * finalize metódust, mivel védett.
     */
    public void removeFromTable() {
        finalize();
    }

    //----------------------------------------------------------------------

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Vector getLeftTiles() {
        return leftTiles;
    }

    public void setLeftTiles(Vector leftTiles) {
        this.leftTiles = leftTiles;
    }

    public Vector getRightTiles() {
        return rightTiles;
    }

    public void setRightTiles(Vector rightTiles) {
        this.rightTiles = rightTiles;
    }

    public Place getPlace() {
        return place;
    }

    public Vector getAboveTiles() {
        return aboveTiles;
    }

    public Vector getUnderTiles() {
        return underTiles;
    }

    public Vector getSouthTiles() {
        return southTiles;
    }

    public Vector getNorthTiles() {
        return northTiles;
    }

}











