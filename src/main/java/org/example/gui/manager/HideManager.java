package org.example.gui.manager;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.Layer;
import org.example.gui.panel.GamePanel;
import org.example.gui.tile.Tile;

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
 * A kövek rétegét meghatározó osztály, mely a rétegszámokat a kövek
 * egymáshoz képesti takarásából számolja ki.
 */
public class HideManager extends Vector implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A tábla
     */
    private GamePanel gamePanel;

    /**
     * Kövek
     */
    private Vector tiles = new Vector();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public HideManager(GamePanel gamePanel, Vector tiles) {
        this.gamePanel = gamePanel;
        this.tiles = tiles;
        selectByLayer();
        Collections.sort(this);
        setLayers();
    }

    //----------------------------------------------------------------------

    /**
     * Rétegenként beállítja a kövek rétegét a takarás alapján
     */
    private void setLayers() {
        for (int i = 0; i < size(); i++) { // rétegenként
            Layer layer = (Layer) get(i);
            for (int j = 0; j < layer.size(); j++) { // kövenként
                Tile tile = (Tile) layer.get(j);
                if (!tile.isChecked()) { // ha még nem volt vizsgálva
                    if (dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_WEST)) {
                        calculateHidingNW(tile, i * 1000); // rétegenként ezret ugrik
                    } else if (dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_EAST)) {
                        calculateHidingNE(tile, i * 1000);
                    } else if (dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_WEST)) {
                        calculateHidingSW(tile, i * 1000);
                    } else if (dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_EAST)) {
                        calculateHidingSE(tile, i * 1000);
                    }
                }
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza a táblán való elhelyezéshez szükséges réteget. NW = NorthWest
     */
    private void calculateHidingNW(Tile tile, int layer) {
        tile.setChecked(true);
        gamePanel.setLayer(tile, layer);

        double tileX = tile.getPlace().getX();
        double tileY = tile.getPlace().getY();

        for (int i = 0; i < tiles.size(); i++) {
            Tile cornerTile = (Tile) tiles.get(i);
            if (!cornerTile.isChecked() &&
                    cornerTile.getPlace().getLayer() == tile.getPlace().getLayer()) {
                double cornerTileX = cornerTile.getPlace().getX();
                double cornerTileY = cornerTile.getPlace().getY();

                if (cornerTileX == tileX - 1 && cornerTileY == tileY - 1) // bal felső sarok
                    calculateHidingNW(cornerTile, layer - 4);
                if (cornerTileX == tileX + 1 && cornerTileY == tileY - 1) // jobb felső sarok
                    calculateHidingNW(cornerTile, layer);
                if (cornerTileX == tileX - 1 && cornerTileY == tileY + 1) // bal alsó sarok
                    calculateHidingNW(cornerTile, layer);
                if (cornerTileX == tileX + 1 && cornerTileY == tileY + 1) // jobb alsó sarok
                    calculateHidingNW(cornerTile, layer + 4);
            }
        }

        for (int i = 0; i < tile.getLeftTiles().size(); i++) { // bal szomszédok
            Tile leftTile = (Tile) tile.getLeftTiles().get(i);
            if (!leftTile.isChecked()) {
                double leftTileX = leftTile.getPlace().getX();
                double leftTileY = leftTile.getPlace().getY();
                // északról délre haladva
                if (leftTileX == tileX - 1 && leftTileY == tileY - 0.5)
                    calculateHidingNW(leftTile, layer - 3);
                if (leftTileX == tileX - 1 && leftTileY == tileY)
                    calculateHidingNW(leftTile, layer - 2);
                if (leftTileX == tileX - 1 && leftTileY == tileY + 0.5)
                    calculateHidingNW(leftTile, layer - 1);
            }
        }

        for (int i = 0; i < tile.getRightTiles().size(); i++) { // jobb szomszédok
            Tile rightTile = (Tile) tile.getRightTiles().get(i);
            if (!rightTile.isChecked()) {
                double rightTileX = rightTile.getPlace().getX();
                double rightTileY = rightTile.getPlace().getY();
                // északról délre haladva
                if (rightTileX == tileX + 1 && rightTileY == tileY - 0.5)
                    calculateHidingNW(rightTile, layer + 1);
                if (rightTileX == tileX + 1 && rightTileY == tileY)
                    calculateHidingNW(rightTile, layer + 2);
                if (rightTileX == tileX + 1 && rightTileY == tileY + 0.5)
                    calculateHidingNW(rightTile, layer + 3);
            }
        }

        for (int i = 0; i < tile.getNorthTiles().size(); i++) { // északi szomszédok
            Tile northTile = (Tile) tile.getNorthTiles().get(i);
            if (!northTile.isChecked()) {
                double northTileX = northTile.getPlace().getX();
                double northTileY = northTile.getPlace().getY();
                // balról jobbra haladva
                if (northTileX == tileX - 0.5 && northTileY == tileY - 1)
                    calculateHidingNW(northTile, layer - 3);
                if (northTileX == tileX && northTileY == tileY - 1)
                    calculateHidingNW(northTile, layer - 2);
                if (northTileX == tileX + 0.5 && northTileY == tileY - 1)
                    calculateHidingNW(northTile, layer - 1);
            }
        }

        for (int i = 0; i < tile.getSouthTiles().size(); i++) { // déli szomszédok
            Tile southTile = (Tile) tile.getSouthTiles().get(i);
            if (!southTile.isChecked()) {
                double southTileX = southTile.getPlace().getX();
                double southTileY = southTile.getPlace().getY();
                // balról jobbra haladva
                if (southTileX == tileX - 0.5 && southTileY == tileY + 1)
                    calculateHidingNW(southTile, layer + 1);
                if (southTileX == tileX && southTileY == tileY + 1)
                    calculateHidingNW(southTile, layer + 2);
                if (southTileX == tileX + 0.5 && southTileY == tileY + 1)
                    calculateHidingNW(southTile, layer + 3);
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza a táblán való elhelyezéshez szükséges réteget. NE = NorthEast
     */
    private void calculateHidingNE(Tile tile, int layer) {
        tile.setChecked(true);
        gamePanel.setLayer(tile, layer);

        double tileX = tile.getPlace().getX();
        double tileY = tile.getPlace().getY();

        for (int i = 0; i < tiles.size(); i++) {
            Tile cornerTile = (Tile) tiles.get(i);
            if (!cornerTile.isChecked() &&
                    cornerTile.getPlace().getLayer() == tile.getPlace().getLayer()) {
                double cornerTileX = cornerTile.getPlace().getX();
                double cornerTileY = cornerTile.getPlace().getY();

                if (cornerTileX == tileX - 1 && cornerTileY == tileY - 1) // bal felső sarok
                    calculateHidingNE(cornerTile, layer);
                if (cornerTileX == tileX + 1 && cornerTileY == tileY - 1) // jobb felső sarok
                    calculateHidingNE(cornerTile, layer - 4);
                if (cornerTileX == tileX - 1 && cornerTileY == tileY + 1) // bal alsó sarok
                    calculateHidingNE(cornerTile, layer + 4);
                if (cornerTileX == tileX + 1 && cornerTileY == tileY + 1) // jobb alsó sarok
                    calculateHidingNE(cornerTile, layer);
            }
        }

        for (int i = 0; i < tile.getLeftTiles().size(); i++) { // bal szomszédok
            Tile leftTile = (Tile) tile.getLeftTiles().get(i);
            if (!leftTile.isChecked()) {
                double leftTileX = leftTile.getPlace().getX();
                double leftTileY = leftTile.getPlace().getY();
                // északról délre haladva
                if (leftTileX == tileX - 1 && leftTileY == tileY - 0.5)
                    calculateHidingNE(leftTile, layer + 1);
                if (leftTileX == tileX - 1 && leftTileY == tileY)
                    calculateHidingNE(leftTile, layer + 2);
                if (leftTileX == tileX - 1 && leftTileY == tileY + 0.5)
                    calculateHidingNE(leftTile, layer + 3);
            }
        }

        for (int i = 0; i < tile.getRightTiles().size(); i++) { // jobb szomszédok
            Tile rightTile = (Tile) tile.getRightTiles().get(i);
            if (!rightTile.isChecked()) {
                double rightTileX = rightTile.getPlace().getX();
                double rightTileY = rightTile.getPlace().getY();
                // északról délre haladva
                if (rightTileX == tileX + 1 && rightTileY == tileY - 0.5)
                    calculateHidingNE(rightTile, layer - 3);
                if (rightTileX == tileX + 1 && rightTileY == tileY)
                    calculateHidingNE(rightTile, layer - 2);
                if (rightTileX == tileX + 1 && rightTileY == tileY + 0.5)
                    calculateHidingNE(rightTile, layer - 1);
            }
        }

        for (int i = 0; i < tile.getNorthTiles().size(); i++) { // északi szomszédok
            Tile northTile = (Tile) tile.getNorthTiles().get(i);
            if (!northTile.isChecked()) {
                double northTileX = northTile.getPlace().getX();
                double northTileY = northTile.getPlace().getY();
                // balról jobbra haladva
                if (northTileX == tileX - 0.5 && northTileY == tileY - 1)
                    calculateHidingNE(northTile, layer - 1);
                if (northTileX == tileX && northTileY == tileY - 1)
                    calculateHidingNE(northTile, layer - 2);
                if (northTileX == tileX + 0.5 && northTileY == tileY - 1)
                    calculateHidingNE(northTile, layer - 3);
            }
        }

        for (int i = 0; i < tile.getSouthTiles().size(); i++) { // déli szomszédok
            Tile southTile = (Tile) tile.getSouthTiles().get(i);
            if (!southTile.isChecked()) {
                double southTileX = southTile.getPlace().getX();
                double southTileY = southTile.getPlace().getY();
                // balról jobbra haladva
                if (southTileX == tileX - 0.5 && southTileY == tileY + 1)
                    calculateHidingNE(southTile, layer + 3);
                if (southTileX == tileX && southTileY == tileY + 1)
                    calculateHidingNE(southTile, layer + 2);
                if (southTileX == tileX + 0.5 && southTileY == tileY + 1)
                    calculateHidingNE(southTile, layer + 1);
            }
        }
    }

    /**
     * Meghatározza a táblán való elhelyezéshez szükséges réteget. SW = SouthWest
     */
    private void calculateHidingSW(Tile tile, int layer) {
        tile.setChecked(true);
        gamePanel.setLayer(tile, layer);

        double tileX = tile.getPlace().getX();
        double tileY = tile.getPlace().getY();

        for (int i = 0; i < tiles.size(); i++) {
            Tile cornerTile = (Tile) tiles.get(i);
            if (!cornerTile.isChecked() &&
                    cornerTile.getPlace().getLayer() == tile.getPlace().getLayer()) {
                double cornerTileX = cornerTile.getPlace().getX();
                double cornerTileY = cornerTile.getPlace().getY();

                if (cornerTileX == tileX - 1 && cornerTileY == tileY - 1) // bal felső sarok
                    calculateHidingSW(cornerTile, layer);
                if (cornerTileX == tileX + 1 && cornerTileY == tileY - 1) // jobb felső sarok
                    calculateHidingSW(cornerTile, layer + 4);
                if (cornerTileX == tileX - 1 && cornerTileY == tileY + 1) // bal alsó sarok
                    calculateHidingSW(cornerTile, layer - 4);
                if (cornerTileX == tileX + 1 && cornerTileY == tileY + 1) // jobb alsó sarok
                    calculateHidingSW(cornerTile, layer);
            }
        }

        for (int i = 0; i < tile.getLeftTiles().size(); i++) { // bal szomszédok
            Tile leftTile = (Tile) tile.getLeftTiles().get(i);
            if (!leftTile.isChecked()) {
                double leftTileX = leftTile.getPlace().getX();
                double leftTileY = leftTile.getPlace().getY();
                // északról délre haladva
                if (leftTileX == tileX - 1 && leftTileY == tileY - 0.5)
                    calculateHidingSW(leftTile, layer - 1);
                if (leftTileX == tileX - 1 && leftTileY == tileY)
                    calculateHidingSW(leftTile, layer - 2);
                if (leftTileX == tileX - 1 && leftTileY == tileY + 0.5)
                    calculateHidingSW(leftTile, layer - 3);
            }
        }

        for (int i = 0; i < tile.getRightTiles().size(); i++) { // jobb szomszédok
            Tile rightTile = (Tile) tile.getRightTiles().get(i);
            if (!rightTile.isChecked()) {
                double rightTileX = rightTile.getPlace().getX();
                double rightTileY = rightTile.getPlace().getY();
                // északról délre haladva
                if (rightTileX == tileX + 1 && rightTileY == tileY - 0.5)
                    calculateHidingSW(rightTile, layer + 3);
                if (rightTileX == tileX + 1 && rightTileY == tileY)
                    calculateHidingSW(rightTile, layer + 2);
                if (rightTileX == tileX + 1 && rightTileY == tileY + 0.5)
                    calculateHidingSW(rightTile, layer + 1);
            }
        }

        for (int i = 0; i < tile.getNorthTiles().size(); i++) { // északi szomszédok
            Tile northTile = (Tile) tile.getNorthTiles().get(i);
            if (!northTile.isChecked()) {
                double northTileX = northTile.getPlace().getX();
                double northTileY = northTile.getPlace().getY();
                // balról jobbra haladva
                if (northTileX == tileX - 0.5 && northTileY == tileY - 1)
                    calculateHidingSW(northTile, layer + 1);
                if (northTileX == tileX && northTileY == tileY - 1)
                    calculateHidingSW(northTile, layer + 2);
                if (northTileX == tileX + 0.5 && northTileY == tileY - 1)
                    calculateHidingSW(northTile, layer + 3);
            }
        }

        for (int i = 0; i < tile.getSouthTiles().size(); i++) { // déli szomszédok
            Tile southTile = (Tile) tile.getSouthTiles().get(i);
            if (!southTile.isChecked()) {
                double southTileX = southTile.getPlace().getX();
                double southTileY = southTile.getPlace().getY();
                // balról jobbra haladva
                if (southTileX == tileX - 0.5 && southTileY == tileY + 1)
                    calculateHidingSW(southTile, layer - 3);
                if (southTileX == tileX && southTileY == tileY + 1)
                    calculateHidingSW(southTile, layer - 2);
                if (southTileX == tileX + 0.5 && southTileY == tileY + 1)
                    calculateHidingSW(southTile, layer - 1);
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza a táblán való elhelyezéshez szükséges réteget. SE = SouthEast
     */
    private void calculateHidingSE(Tile tile, int layer) {
        tile.setChecked(true);
        gamePanel.setLayer(tile, layer);

        double tileX = tile.getPlace().getX();
        double tileY = tile.getPlace().getY();

        for (int i = 0; i < tiles.size(); i++) {
            Tile cornerTile = (Tile) tiles.get(i);
            if (!cornerTile.isChecked() &&
                    cornerTile.getPlace().getLayer() == tile.getPlace().getLayer()) {
                double cornerTileX = cornerTile.getPlace().getX();
                double cornerTileY = cornerTile.getPlace().getY();

                if (cornerTileX == tileX - 1 && cornerTileY == tileY - 1) // bal felső sarok
                    calculateHidingSE(cornerTile, layer + 4);
                if (cornerTileX == tileX + 1 && cornerTileY == tileY - 1) // jobb felső sarok
                    calculateHidingSE(cornerTile, layer);
                if (cornerTileX == tileX - 1 && cornerTileY == tileY + 1) // bal alsó sarok
                    calculateHidingSE(cornerTile, layer);
                if (cornerTileX == tileX + 1 && cornerTileY == tileY + 1) // jobb alsó sarok
                    calculateHidingSE(cornerTile, layer - 4);
            }
        }

        for (int i = 0; i < tile.getLeftTiles().size(); i++) { // bal szomszédok
            Tile leftTile = (Tile) tile.getLeftTiles().get(i);
            if (!leftTile.isChecked()) {
                double leftTileX = leftTile.getPlace().getX();
                double leftTileY = leftTile.getPlace().getY();
                // északról délre haladva
                if (leftTileX == tileX - 1 && leftTileY == tileY - 0.5)
                    calculateHidingSE(leftTile, layer + 3);
                if (leftTileX == tileX - 1 && leftTileY == tileY)
                    calculateHidingSE(leftTile, layer + 2);
                if (leftTileX == tileX - 1 && leftTileY == tileY + 0.5)
                    calculateHidingSE(leftTile, layer + 1);
            }
        }

        for (int i = 0; i < tile.getRightTiles().size(); i++) { // jobb szomszédok
            Tile rightTile = (Tile) tile.getRightTiles().get(i);
            if (!rightTile.isChecked()) {
                double rightTileX = rightTile.getPlace().getX();
                double rightTileY = rightTile.getPlace().getY();
                // északról délre haladva
                if (rightTileX == tileX + 1 && rightTileY == tileY - 0.5)
                    calculateHidingSE(rightTile, layer - 1);
                if (rightTileX == tileX + 1 && rightTileY == tileY)
                    calculateHidingSE(rightTile, layer - 2);
                if (rightTileX == tileX + 1 && rightTileY == tileY + 0.5)
                    calculateHidingSE(rightTile, layer - 3);
            }
        }

        for (int i = 0; i < tile.getNorthTiles().size(); i++) { // északi szomszédok
            Tile northTile = (Tile) tile.getNorthTiles().get(i);
            if (!northTile.isChecked()) {
                double northTileX = northTile.getPlace().getX();
                double northTileY = northTile.getPlace().getY();
                // balról jobbra haladva
                if (northTileX == tileX - 0.5 && northTileY == tileY - 1)
                    calculateHidingSE(northTile, layer + 3);
                if (northTileX == tileX && northTileY == tileY - 1)
                    calculateHidingSE(northTile, layer + 2);
                if (northTileX == tileX + 0.5 && northTileY == tileY - 1)
                    calculateHidingSE(northTile, layer + 1);
            }
        }

        for (int i = 0; i < tile.getSouthTiles().size(); i++) { // déli szomszédok
            Tile southTile = (Tile) tile.getSouthTiles().get(i);
            if (!southTile.isChecked()) {
                double southTileX = southTile.getPlace().getX();
                double southTileY = southTile.getPlace().getY();
                // balról jobbra haladva
                if (southTileX == tileX - 0.5 && southTileY == tileY + 1)
                    calculateHidingSE(southTile, layer - 1);
                if (southTileX == tileX && southTileY == tileY + 1)
                    calculateHidingSE(southTile, layer - 2);
                if (southTileX == tileX + 0.5 && southTileY == tileY + 1)
                    calculateHidingSE(southTile, layer - 3);
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Szétválogatja az értékben egymáshoz passzoló köveket
     */
    private void selectByLayer() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            if (getLayer(tile.getPlace().getLayer()) != null) { // ha már van ilyen réteg, akkor csak hozzá kell adni
                getLayer(tile.getPlace().getLayer()).add(tile);
            } else { // ha még nincs, akkor egy objektumot kell kreálni
                add(new Layer(tile.getPlace().getLayer(), tile));
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a kapott sorszámú réteget
     */
    public Layer getLayer(int number) {
        for (int i = 0; i < size(); i++) {
            Layer layer = (Layer) get(i);
            if (layer.getNumber() == number)
                return layer;
        }
        return null;
    }
}






