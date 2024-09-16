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

public class GayleLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(1, 0, 0));
        places.add(new Place(2, 0, 0));
        places.add(new Place(3, 0, 0));
        places.add(new Place(4, 0, 0));
        places.add(new Place(5, 0, 0));
        places.add(new Place(6, 0, 0));
        places.add(new Place(7, 0, 0));
        places.add(new Place(8, 0, 0));
        places.add(new Place(9, 0, 0));
        places.add(new Place(10, 0, 0));
        places.add(new Place(11, 0, 0));
        places.add(new Place(12, 0, 0));

        // 1. sor
        places.add(new Place(3, 1, 0));
        places.add(new Place(4, 1, 0));
        places.add(new Place(5, 1, 0));
        places.add(new Place(6, 1, 0));
        places.add(new Place(7, 1, 0));
        places.add(new Place(8, 1, 0));
        places.add(new Place(9, 1, 0));
        places.add(new Place(10, 1, 0));

        // 2. sor
        places.add(new Place(5, 2, 0));
        places.add(new Place(6, 2, 0));
        places.add(new Place(7, 2, 0));
        places.add(new Place(8, 2, 0));

        // 3. sor
        places.add(new Place(1, 3, 0));
        places.add(new Place(2, 3, 0));
        places.add(new Place(3, 3, 0));
        places.add(new Place(4, 3, 0));
        places.add(new Place(5, 3, 0));
        places.add(new Place(6, 3, 0));
        places.add(new Place(7, 3, 0));
        places.add(new Place(8, 3, 0));
        places.add(new Place(9, 3, 0));
        places.add(new Place(10, 3, 0));
        places.add(new Place(11, 3, 0));
        places.add(new Place(12, 3, 0));

        // 3,5. sor
        places.add(new Place(0, 3.5, 0));

        places.add(new Place(13, 3.5, 0));

        // 4. sor
        places.add(new Place(1, 4, 0));
        places.add(new Place(2, 4, 0));
        places.add(new Place(3, 4, 0));
        places.add(new Place(4, 4, 0));
        places.add(new Place(5, 4, 0));
        places.add(new Place(6, 4, 0));
        places.add(new Place(7, 4, 0));
        places.add(new Place(8, 4, 0));
        places.add(new Place(9, 4, 0));
        places.add(new Place(10, 4, 0));
        places.add(new Place(11, 4, 0));
        places.add(new Place(12, 4, 0));

        // 5. sor
        places.add(new Place(5, 5, 0));
        places.add(new Place(6, 5, 0));
        places.add(new Place(7, 5, 0));
        places.add(new Place(8, 5, 0));

        // 6. sor
        places.add(new Place(3, 6, 0));
        places.add(new Place(4, 6, 0));
        places.add(new Place(5, 6, 0));
        places.add(new Place(6, 6, 0));
        places.add(new Place(7, 6, 0));
        places.add(new Place(8, 6, 0));
        places.add(new Place(9, 6, 0));
        places.add(new Place(10, 6, 0));

        // 7. sor
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

        // 1. réteg
        // 0. sor
        places.add(new Place(1, 0, 1));
        places.add(new Place(2, 0, 1));
        places.add(new Place(3, 0, 1));

        places.add(new Place(10, 0, 1));
        places.add(new Place(11, 0, 1));
        places.add(new Place(12, 0, 1));

        // 1. sor
        places.add(new Place(4, 1, 1));
        places.add(new Place(5, 1, 1));
        places.add(new Place(6, 1, 1));
        places.add(new Place(7, 1, 1));
        places.add(new Place(8, 1, 1));
        places.add(new Place(9, 1, 1));

        // 2. sor
        places.add(new Place(6, 2, 1));
        places.add(new Place(7, 2, 1));

        // 3. sor
        places.add(new Place(4, 3, 1));
        places.add(new Place(5, 3, 1));
        places.add(new Place(6, 3, 1));
        places.add(new Place(7, 3, 1));
        places.add(new Place(8, 3, 1));
        places.add(new Place(9, 3, 1));

        // 4. sor
        places.add(new Place(4, 4, 1));
        places.add(new Place(5, 4, 1));
        places.add(new Place(6, 4, 1));
        places.add(new Place(7, 4, 1));
        places.add(new Place(8, 4, 1));
        places.add(new Place(9, 4, 1));

        // 5. sor
        places.add(new Place(6, 5, 1));
        places.add(new Place(7, 5, 1));

        // 6. sor
        places.add(new Place(4, 6, 1));
        places.add(new Place(5, 6, 1));
        places.add(new Place(6, 6, 1));
        places.add(new Place(7, 6, 1));
        places.add(new Place(8, 6, 1));
        places.add(new Place(9, 6, 1));

        // 7. sor
        places.add(new Place(1, 7, 1));
        places.add(new Place(2, 7, 1));
        places.add(new Place(3, 7, 1));

        places.add(new Place(10, 7, 1));
        places.add(new Place(11, 7, 1));
        places.add(new Place(12, 7, 1));

        // 2. réteg
        // 0. sor
        places.add(new Place(1, 0, 2));
        places.add(new Place(2, 0, 2));

        places.add(new Place(11, 0, 2));
        places.add(new Place(12, 0, 2));

        // 1. sor
        places.add(new Place(5, 1, 2));
        places.add(new Place(6, 1, 2));
        places.add(new Place(7, 1, 2));
        places.add(new Place(8, 1, 2));

        // 3,5. sor
        places.add(new Place(4.5, 3.5, 2));
        places.add(new Place(5.5, 3.5, 2));
        places.add(new Place(6.5, 3.5, 2));
        places.add(new Place(7.5, 3.5, 2));
        places.add(new Place(8.5, 3.5, 2));

        // 6. sor
        places.add(new Place(5, 6, 2));
        places.add(new Place(6, 6, 2));
        places.add(new Place(7, 6, 2));
        places.add(new Place(8, 6, 2));

        // 7. sor
        places.add(new Place(1, 7, 2));
        places.add(new Place(2, 7, 2));

        places.add(new Place(11, 7, 2));
        places.add(new Place(12, 7, 2));

        // 3. réteg
        // 0. sor
        places.add(new Place(1, 0, 3));

        places.add(new Place(12, 0, 3));

        // 1. sor
        places.add(new Place(6.5, 1, 3));

        // 3,5. sor
        places.add(new Place(6, 3.5, 3));
        places.add(new Place(7, 3.5, 3));

        // 6. sor
        places.add(new Place(6.5, 6, 3));

        // 7. sor
        places.add(new Place(1, 7, 3));

        places.add(new Place(12, 7, 3));

        // 4. réteg
        // 3,5. sor
        places.add(new Place(6.5, 3.5, 4));

        // méret
        layoutWidth = 14;
        layoutHeight = 8;
    }

    public String getName() {
        return "Gayle";
    }

}






