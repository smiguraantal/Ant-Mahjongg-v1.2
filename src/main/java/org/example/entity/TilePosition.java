package org.example.entity;

import java.awt.Point;
import java.util.TreeMap;

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
 * A kőkészlet köveinek helyét meghatározó osztály. A kőkészletek képfájlok,
 * melyeken a kövek sorokban és oszlopokban helyezkednek el.
 */
public class TilePosition implements Constants {

    /**
     * Az egyes poziciókat érték szerint eltároló halmaz
     */
    static TreeMap tilePositions = new TreeMap();

    static {
        // körök
        tilePositions.put(new Integer(0), new Point(0, 0));
        tilePositions.put(new Integer(1), new Point(1, 0));
        tilePositions.put(new Integer(2), new Point(2, 0));
        tilePositions.put(new Integer(3), new Point(3, 0));
        tilePositions.put(new Integer(4), new Point(4, 0));
        tilePositions.put(new Integer(5), new Point(5, 0));
        tilePositions.put(new Integer(6), new Point(6, 0));
        tilePositions.put(new Integer(7), new Point(7, 0));
        tilePositions.put(new Integer(8), new Point(8, 0));

        // bambuszok
        tilePositions.put(new Integer(9), new Point(0, 1));
        tilePositions.put(new Integer(10), new Point(1, 1));
        tilePositions.put(new Integer(11), new Point(2, 1));
        tilePositions.put(new Integer(12), new Point(3, 1));
        tilePositions.put(new Integer(13), new Point(4, 1));
        tilePositions.put(new Integer(14), new Point(5, 1));
        tilePositions.put(new Integer(15), new Point(6, 1));
        tilePositions.put(new Integer(16), new Point(7, 1));
        tilePositions.put(new Integer(17), new Point(8, 1));

        // írások
        tilePositions.put(new Integer(18), new Point(0, 2));
        tilePositions.put(new Integer(19), new Point(1, 2));
        tilePositions.put(new Integer(20), new Point(2, 2));
        tilePositions.put(new Integer(21), new Point(3, 2));
        tilePositions.put(new Integer(22), new Point(4, 2));
        tilePositions.put(new Integer(23), new Point(5, 2));
        tilePositions.put(new Integer(24), new Point(6, 2));
        tilePositions.put(new Integer(25), new Point(7, 2));
        tilePositions.put(new Integer(26), new Point(8, 2));

        // évszakok
        tilePositions.put(new Integer(34), new Point(0, 3)); // évszak
        tilePositions.put(new Integer(35), new Point(1, 3)); // évszak
        tilePositions.put(new Integer(36), new Point(2, 3)); // évszak
        tilePositions.put(new Integer(37), new Point(3, 3)); // évszak

        // szelek
        tilePositions.put(new Integer(27), new Point(4, 3));
        tilePositions.put(new Integer(28), new Point(5, 3));
        tilePositions.put(new Integer(29), new Point(6, 3));
        tilePositions.put(new Integer(30), new Point(7, 3));

        // virágok
        tilePositions.put(new Integer(38), new Point(0, 4)); // virág
        tilePositions.put(new Integer(39), new Point(1, 4)); // virág
        tilePositions.put(new Integer(40), new Point(2, 4)); // virág
        tilePositions.put(new Integer(41), new Point(3, 4)); // virág

        // sárkányok
        tilePositions.put(new Integer(31), new Point(4, 4));
        tilePositions.put(new Integer(32), new Point(5, 4));
        tilePositions.put(new Integer(33), new Point(6, 4));
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja az értékhez tartozó pont x koordinátáját
     */
    public static int getCalculatedX(int value) {
        Point point = (Point) tilePositions.get(new Integer(value));
        return (int) (point.x * TILE_WIDTH * UNIT);
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja az értékhez tartozó pont y koordinátáját
     */
    public static int getCalculatedY(int value) {
        Point point = (Point) tilePositions.get(new Integer(value));
        return (int) (point.y * TILE_HEIGHT * UNIT);
    }

}




