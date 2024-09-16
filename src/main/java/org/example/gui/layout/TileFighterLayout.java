package org.example.gui.layout;

import org.example.entity.Place;

/**
 * <p>Title: Ant-Mahjongg</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004-2005</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.2
 */

public class TileFighterLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(2.5, 0, 0));
        places.add(new Place(3.5, 0, 0));

        places.add(new Place(9.5, 0, 0));
        places.add(new Place(10.5, 0, 0));

        // 1. sor
        places.add(new Place(1, 1, 0));
        places.add(new Place(2, 1, 0));

        places.add(new Place(5, 1, 0));
        places.add(new Place(6, 1, 0));
        places.add(new Place(7, 1, 0));
        places.add(new Place(8, 1, 0));

        places.add(new Place(11, 1, 0));
        places.add(new Place(12, 1, 0));

        // 2. sor
        places.add(new Place(0, 2, 0));
        places.add(new Place(1, 2, 0));

        places.add(new Place(4, 2, 0));
        places.add(new Place(5, 2, 0));
        places.add(new Place(6, 2, 0));
        places.add(new Place(7, 2, 0));
        places.add(new Place(8, 2, 0));
        places.add(new Place(9, 2, 0));

        places.add(new Place(12, 2, 0));
        places.add(new Place(13, 2, 0));

        // 3. sor
        places.add(new Place(0, 3, 0));

        places.add(new Place(4, 3, 0));
        places.add(new Place(5, 3, 0));
        places.add(new Place(6, 3, 0));
        places.add(new Place(7, 3, 0));
        places.add(new Place(8, 3, 0));
        places.add(new Place(9, 3, 0));

        places.add(new Place(13, 3, 0));

        // 3,5. sor
        places.add(new Place(1, 3.5, 0));
        places.add(new Place(2, 3.5, 0));
        places.add(new Place(3, 3.5, 0));

        places.add(new Place(10, 3.5, 0));
        places.add(new Place(11, 3.5, 0));
        places.add(new Place(12, 3.5, 0));

        // 4. sor
        places.add(new Place(0, 4, 0));

        places.add(new Place(4, 4, 0));
        places.add(new Place(5, 4, 0));
        places.add(new Place(6, 4, 0));
        places.add(new Place(7, 4, 0));
        places.add(new Place(8, 4, 0));
        places.add(new Place(9, 4, 0));

        places.add(new Place(13, 4, 0));

        // 5. sor
        places.add(new Place(0, 5, 0));
        places.add(new Place(1, 5, 0));

        places.add(new Place(4, 5, 0));
        places.add(new Place(5, 5, 0));
        places.add(new Place(6, 5, 0));
        places.add(new Place(7, 5, 0));
        places.add(new Place(8, 5, 0));
        places.add(new Place(9, 5, 0));

        places.add(new Place(12, 5, 0));
        places.add(new Place(13, 5, 0));

        // 6. sor
        places.add(new Place(1, 6, 0));
        places.add(new Place(2, 6, 0));

        places.add(new Place(5, 6, 0));
        places.add(new Place(6, 6, 0));
        places.add(new Place(7, 6, 0));
        places.add(new Place(8, 6, 0));

        places.add(new Place(11, 6, 0));
        places.add(new Place(12, 6, 0));

        // 7. sor
        places.add(new Place(2.5, 7, 0));
        places.add(new Place(3.5, 7, 0));

        places.add(new Place(9.5, 7, 0));
        places.add(new Place(10.5, 7, 0));

        // 1. réteg
        // 0. sor
        places.add(new Place(2.5, 0, 1));

        places.add(new Place(10.5, 0, 1));

        // 1. sor
        places.add(new Place(1, 1, 1));
        places.add(new Place(2, 1, 1));

        places.add(new Place(6, 1, 1));
        places.add(new Place(7, 1, 1));

        places.add(new Place(11, 1, 1));
        places.add(new Place(12, 1, 1));

        // 2. sor
        places.add(new Place(0, 2, 1));
        places.add(new Place(1, 2, 1));

        places.add(new Place(5, 2, 1));
        places.add(new Place(6, 2, 1));
        places.add(new Place(7, 2, 1));
        places.add(new Place(8, 2, 1));

        places.add(new Place(12, 2, 1));
        places.add(new Place(13, 2, 1));

        // 3. sor
        places.add(new Place(0, 3, 1));

        places.add(new Place(4, 3, 1));
        places.add(new Place(5, 3, 1));
        places.add(new Place(8, 3, 1));
        places.add(new Place(9, 3, 1));

        places.add(new Place(13, 3, 1));

        // 3,5. sor
        places.add(new Place(1, 3.5, 1));

        places.add(new Place(6.5, 3.5, 1));

        places.add(new Place(12, 3.5, 1));

        // 4. sor
        places.add(new Place(0, 4, 1));

        places.add(new Place(4, 4, 1));
        places.add(new Place(5, 4, 1));
        places.add(new Place(8, 4, 1));
        places.add(new Place(9, 4, 1));

        places.add(new Place(13, 4, 1));

        // 5. sor
        places.add(new Place(0, 5, 1));
        places.add(new Place(1, 5, 1));

        places.add(new Place(5, 5, 1));
        places.add(new Place(6, 5, 1));
        places.add(new Place(7, 5, 1));
        places.add(new Place(8, 5, 1));

        places.add(new Place(12, 5, 1));
        places.add(new Place(13, 5, 1));

        // 6. sor
        places.add(new Place(1, 6, 1));
        places.add(new Place(2, 6, 1));

        places.add(new Place(6, 6, 1));
        places.add(new Place(7, 6, 1));

        places.add(new Place(11, 6, 1));
        places.add(new Place(12, 6, 1));

        // 7. sor
        places.add(new Place(2.5, 7, 1));

        places.add(new Place(10.5, 7, 1));

        // 2. réteg
        // 1. sor
        places.add(new Place(1, 1, 2));

        places.add(new Place(12, 1, 2));

        // 2. sor
        places.add(new Place(1, 2, 2));

        places.add(new Place(6, 2, 2));
        places.add(new Place(7, 2, 2));

        places.add(new Place(12, 2, 2));

        // 2.5. sor
        places.add(new Place(0, 2.5, 2));

        places.add(new Place(13, 2.5, 2));

        // 3. sor
        places.add(new Place(5, 3, 2));

        places.add(new Place(8, 3, 2));

        // 3.5. sor
        places.add(new Place(0, 3.5, 2));
        places.add(new Place(1, 3.5, 2));

        places.add(new Place(6.5, 3.5, 2));

        places.add(new Place(12, 3.5, 2));
        places.add(new Place(13, 3.5, 2));

        // 4. sor
        places.add(new Place(5, 4, 2));

        places.add(new Place(8, 4, 2));

        // 4.5. sor
        places.add(new Place(0, 4.5, 2));

        places.add(new Place(13, 4.5, 2));

        // 5. sor
        places.add(new Place(1, 5, 2));

        places.add(new Place(6, 5, 2));
        places.add(new Place(7, 5, 2));

        places.add(new Place(12, 5, 2));

        // 6. sor
        places.add(new Place(1, 6, 2));

        places.add(new Place(12, 6, 2));

        // 3. réteg
        // 2.5. sor
        places.add(new Place(0, 2.5, 3));

        places.add(new Place(13, 2.5, 3));

        // 3.5. sor
        places.add(new Place(0, 3.5, 3));

        places.add(new Place(13, 3.5, 3));

        // 4.5. sor
        places.add(new Place(0, 4.5, 3));

        places.add(new Place(13, 4.5, 3));

        // méret
        layoutWidth = 14;
        layoutHeight = 8;
    }

    public String getName() {
        return "Tile Fighter";
    }

}







