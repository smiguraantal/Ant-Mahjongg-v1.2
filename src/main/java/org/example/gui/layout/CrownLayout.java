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

public class CrownLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(7, 0, 0));

        // 0,5. sor
        places.add(new Place(6, 0.5, 0));
        places.add(new Place(8, 0.5, 0));

        // 1. sor
        places.add(new Place(7, 1, 0));

        // 2. sor
        places.add(new Place(4, 2, 0));
        places.add(new Place(5, 2, 0));
        places.add(new Place(6, 2, 0));
        places.add(new Place(7, 2, 0));
        places.add(new Place(8, 2, 0));
        places.add(new Place(9, 2, 0));
        places.add(new Place(10, 2, 0));

        // 2,5. sor
        places.add(new Place(3, 2.5, 0));

        places.add(new Place(11, 2.5, 0));

        // 3. sor
        places.add(new Place(1, 3, 0));
        places.add(new Place(2, 3, 0));

        places.add(new Place(7, 3, 0));

        places.add(new Place(12, 3, 0));
        places.add(new Place(13, 3, 0));

        // 4. sor
        places.add(new Place(0, 4, 0));
        places.add(new Place(1, 4, 0));

        places.add(new Place(5, 4, 0));
        places.add(new Place(6, 4, 0));
        places.add(new Place(7, 4, 0));
        places.add(new Place(8, 4, 0));
        places.add(new Place(9, 4, 0));

        places.add(new Place(13, 4, 0));
        places.add(new Place(14, 4, 0));

        // 5. sor
        places.add(new Place(0, 5, 0));
        places.add(new Place(1, 5, 0));

        places.add(new Place(4, 5, 0));
        places.add(new Place(5, 5, 0));
        places.add(new Place(6, 5, 0));
        places.add(new Place(7, 5, 0));
        places.add(new Place(8, 5, 0));
        places.add(new Place(9, 5, 0));
        places.add(new Place(10, 5, 0));

        places.add(new Place(13, 5, 0));
        places.add(new Place(14, 5, 0));

        // 6. sor
        places.add(new Place(0, 6, 0));
        places.add(new Place(1, 6, 0));
        places.add(new Place(2, 6, 0));
        places.add(new Place(3, 6, 0));
        places.add(new Place(4, 6, 0));
        places.add(new Place(5, 6, 0));
        places.add(new Place(6, 6, 0));
        places.add(new Place(7, 6, 0));
        places.add(new Place(8, 6, 0));
        places.add(new Place(9, 6, 0));
        places.add(new Place(10, 6, 0));
        places.add(new Place(11, 6, 0));
        places.add(new Place(12, 6, 0));
        places.add(new Place(13, 6, 0));
        places.add(new Place(14, 6, 0));

        // 7. sor
        places.add(new Place(0, 7, 0));
        places.add(new Place(1, 7, 0));
        places.add(new Place(2, 7, 0));
        places.add(new Place(3, 7, 0));
        places.add(new Place(4, 7, 0));
        places.add(new Place(5, 7, 0));
        places.add(new Place(6, 7, 0));
        places.add(new Place(7, 7, 0));
        places.add(new Place(8, 7, 0));
        places.add(new Place(9, 7, 0));
        places.add(new Place(10, 7, 0));
        places.add(new Place(11, 7, 0));
        places.add(new Place(12, 7, 0));
        places.add(new Place(13, 7, 0));
        places.add(new Place(14, 7, 0));

        // 1. réteg
        // 2. sor
        places.add(new Place(4, 2, 1));
        places.add(new Place(5, 2, 1));
        places.add(new Place(6, 2, 1));
        places.add(new Place(7, 2, 1));
        places.add(new Place(8, 2, 1));
        places.add(new Place(9, 2, 1));
        places.add(new Place(10, 2, 1));

        // 2,5. sor
        places.add(new Place(3, 2.5, 1));

        places.add(new Place(11, 2.5, 1));

        // 3. sor
        places.add(new Place(2, 3, 1));

        places.add(new Place(7, 3, 1));

        places.add(new Place(12, 3, 1));

        // 4. sor
        places.add(new Place(0, 4, 1));
        places.add(new Place(1, 4, 1));

        places.add(new Place(6, 4, 1));
        places.add(new Place(7, 4, 1));
        places.add(new Place(8, 4, 1));

        places.add(new Place(13, 4, 1));
        places.add(new Place(14, 4, 1));

        // 5. sor
        places.add(new Place(0, 5, 1));
        places.add(new Place(1, 5, 1));

        places.add(new Place(5, 5, 1));
        places.add(new Place(6, 5, 1));
        places.add(new Place(7, 5, 1));
        places.add(new Place(8, 5, 1));
        places.add(new Place(9, 5, 1));

        places.add(new Place(13, 5, 1));
        places.add(new Place(14, 5, 1));

        // 6. sor
        places.add(new Place(0, 6, 1));
        places.add(new Place(1, 6, 1));
        places.add(new Place(2, 6, 1));

        places.add(new Place(4, 6, 1));
        places.add(new Place(5, 6, 1));
        places.add(new Place(6, 6, 1));
        places.add(new Place(7, 6, 1));
        places.add(new Place(8, 6, 1));
        places.add(new Place(9, 6, 1));
        places.add(new Place(10, 6, 1));

        places.add(new Place(12, 6, 1));
        places.add(new Place(13, 6, 1));
        places.add(new Place(14, 6, 1));

        // 7. sor
        places.add(new Place(0, 7, 1));
        places.add(new Place(1, 7, 1));
        places.add(new Place(2, 7, 1));
        places.add(new Place(3, 7, 1));
        places.add(new Place(4, 7, 1));
        places.add(new Place(5, 7, 1));
        places.add(new Place(6, 7, 1));
        places.add(new Place(7, 7, 1));
        places.add(new Place(8, 7, 1));
        places.add(new Place(9, 7, 1));
        places.add(new Place(10, 7, 1));
        places.add(new Place(11, 7, 1));
        places.add(new Place(12, 7, 1));
        places.add(new Place(13, 7, 1));
        places.add(new Place(14, 7, 1));

        // 2. réteg
        // 4. sor
        places.add(new Place(7, 4, 2));

        // 5. sor
        places.add(new Place(0, 5, 2));

        places.add(new Place(6, 5, 2));
        places.add(new Place(7, 5, 2));
        places.add(new Place(8, 5, 2));

        places.add(new Place(14, 5, 2));

        // 6. sor
        places.add(new Place(0, 6, 2));
        places.add(new Place(1, 6, 2));

        places.add(new Place(7, 6, 2));

        places.add(new Place(13, 6, 2));
        places.add(new Place(14, 6, 2));

        // 7. sor
        places.add(new Place(0, 7, 2));
        places.add(new Place(1, 7, 2));
        places.add(new Place(2, 7, 2));
        places.add(new Place(3, 7, 2));

        places.add(new Place(11, 7, 2));
        places.add(new Place(12, 7, 2));
        places.add(new Place(13, 7, 2));
        places.add(new Place(14, 7, 2));

        // 3. réteg
        // 5. sor
        places.add(new Place(7, 5, 3));

        // méret
        layoutWidth = 15;
        layoutHeight = 8;
    }

    public String getName() {
        return "Crown";
    }
}