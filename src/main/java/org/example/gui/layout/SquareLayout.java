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

public class SquareLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0,5. sor
        places.add(new Place(0.5, 0.5, 0));

        places.add(new Place(2.5, 0.5, 0));

        places.add(new Place(4.5, 0.5, 0));

        places.add(new Place(6.5, 0.5, 0));

        places.add(new Place(8.5, 0.5, 0));

        // 2,5. sor
        places.add(new Place(0.5, 2.5, 0));

        places.add(new Place(8.5, 2.5, 0));

        // 4,5. sor
        places.add(new Place(0.5, 4.5, 0));

        places.add(new Place(8.5, 4.5, 0));

        // 6,5. sor
        places.add(new Place(0.5, 6.5, 0));

        places.add(new Place(2.5, 6.5, 0));

        places.add(new Place(4.5, 6.5, 0));

        places.add(new Place(6.5, 6.5, 0));

        places.add(new Place(8.5, 6.5, 0));

        // 1. sor
        places.add(new Place(0, 0, 1));
        places.add(new Place(1, 0, 1));
        places.add(new Place(2, 0, 1));
        places.add(new Place(3, 0, 1));
        places.add(new Place(4, 0, 1));
        places.add(new Place(5, 0, 1));
        places.add(new Place(6, 0, 1));
        places.add(new Place(7, 0, 1));
        places.add(new Place(8, 0, 1));
        places.add(new Place(9, 0, 1));

        // 1. sor
        places.add(new Place(0, 1, 1));
        places.add(new Place(1, 1, 1));
        places.add(new Place(2, 1, 1));
        places.add(new Place(3, 1, 1));
        places.add(new Place(4, 1, 1));
        places.add(new Place(5, 1, 1));
        places.add(new Place(6, 1, 1));
        places.add(new Place(7, 1, 1));
        places.add(new Place(8, 1, 1));
        places.add(new Place(9, 1, 1));

        // 2. sor
        places.add(new Place(0, 2, 1));
        places.add(new Place(1, 2, 1));

        places.add(new Place(8, 2, 1));
        places.add(new Place(9, 2, 1));

        // 3. sor
        places.add(new Place(0, 3, 1));
        places.add(new Place(1, 3, 1));

        places.add(new Place(8, 3, 1));
        places.add(new Place(9, 3, 1));

        // 4. sor
        places.add(new Place(0, 4, 1));
        places.add(new Place(1, 4, 1));

        places.add(new Place(8, 4, 1));
        places.add(new Place(9, 4, 1));

        // 5. sor
        places.add(new Place(0, 5, 1));
        places.add(new Place(1, 5, 1));

        places.add(new Place(8, 5, 1));
        places.add(new Place(9, 5, 1));

        // 6. sor
        places.add(new Place(0, 6, 1));
        places.add(new Place(1, 6, 1));
        places.add(new Place(2, 6, 1));
        places.add(new Place(3, 6, 1));
        places.add(new Place(4, 6, 1));
        places.add(new Place(5, 6, 1));
        places.add(new Place(6, 6, 1));
        places.add(new Place(7, 6, 1));
        places.add(new Place(8, 6, 1));
        places.add(new Place(9, 6, 1));

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

        // 2. réteg
        // 0,5. sor
        places.add(new Place(0.5, 0.5, 2));

        places.add(new Place(2.5, 0.5, 2));

        places.add(new Place(4.5, 0.5, 2));

        places.add(new Place(6.5, 0.5, 2));

        places.add(new Place(8.5, 0.5, 2));

        // 2,5. sor
        places.add(new Place(0.5, 2.5, 2));

        places.add(new Place(8.5, 2.5, 2));

        // 4,5. sor
        places.add(new Place(0.5, 4.5, 2));

        places.add(new Place(8.5, 4.5, 2));

        // 6,5. sor
        places.add(new Place(0.5, 6.5, 2));

        places.add(new Place(2.5, 6.5, 2));

        places.add(new Place(4.5, 6.5, 2));

        places.add(new Place(6.5, 6.5, 2));

        places.add(new Place(8.5, 6.5, 2));

        // 3. réteg
        // 0. sor
        places.add(new Place(0, 0, 3));
        places.add(new Place(1, 0, 3));
        places.add(new Place(2, 0, 3));
        places.add(new Place(3, 0, 3));
        places.add(new Place(4, 0, 3));
        places.add(new Place(5, 0, 3));
        places.add(new Place(6, 0, 3));
        places.add(new Place(7, 0, 3));
        places.add(new Place(8, 0, 3));
        places.add(new Place(9, 0, 3));

        // 1. sor
        places.add(new Place(0, 1, 3));
        places.add(new Place(1, 1, 3));
        places.add(new Place(2, 1, 3));
        places.add(new Place(3, 1, 3));
        places.add(new Place(4, 1, 3));
        places.add(new Place(5, 1, 3));
        places.add(new Place(6, 1, 3));
        places.add(new Place(7, 1, 3));
        places.add(new Place(8, 1, 3));
        places.add(new Place(9, 1, 3));

        // 2. sor
        places.add(new Place(0, 2, 3));
        places.add(new Place(1, 2, 3));

        places.add(new Place(8, 2, 3));
        places.add(new Place(9, 2, 3));

        // 3. sor
        places.add(new Place(0, 3, 3));
        places.add(new Place(1, 3, 3));

        places.add(new Place(8, 3, 3));
        places.add(new Place(9, 3, 3));

        // 4. sor
        places.add(new Place(0, 4, 3));
        places.add(new Place(1, 4, 3));

        places.add(new Place(8, 4, 3));
        places.add(new Place(9, 4, 3));

        // 5. sor
        places.add(new Place(0, 5, 3));
        places.add(new Place(1, 5, 3));

        places.add(new Place(8, 5, 3));
        places.add(new Place(9, 5, 3));

        // 6. sor
        places.add(new Place(0, 6, 3));
        places.add(new Place(1, 6, 3));
        places.add(new Place(2, 6, 3));
        places.add(new Place(3, 6, 3));
        places.add(new Place(4, 6, 3));
        places.add(new Place(5, 6, 3));
        places.add(new Place(6, 6, 3));
        places.add(new Place(7, 6, 3));
        places.add(new Place(8, 6, 3));
        places.add(new Place(9, 6, 3));

        // 7. sor
        places.add(new Place(0, 7, 3));
        places.add(new Place(1, 7, 3));
        places.add(new Place(2, 7, 3));
        places.add(new Place(3, 7, 3));
        places.add(new Place(4, 7, 3));
        places.add(new Place(5, 7, 3));
        places.add(new Place(6, 7, 3));
        places.add(new Place(7, 7, 3));
        places.add(new Place(8, 7, 3));
        places.add(new Place(9, 7, 3));

        // 4. réteg
        // 0,5. sor
        places.add(new Place(0.5, 0.5, 4));

        places.add(new Place(8.5, 0.5, 4));

        // 6,5. sor
        places.add(new Place(0.5, 6.5, 4));

        places.add(new Place(8.5, 6.5, 4));

        // méret
        layoutWidth = 10;
        layoutHeight = 8;
    }

    public String getName() {
        return "Square";
    }
}