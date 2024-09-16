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

public class BambooLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(5, 0, 0));

        // 0,5. sor
        places.add(new Place(4, 0.5, 0));
        places.add(new Place(6, 0.5, 0));

        // 1. sor
        places.add(new Place(5, 1, 0));

        // 1,5. sor
        places.add(new Place(4, 1.5, 0));
        places.add(new Place(6, 1.5, 0));

        // 2. sor
        places.add(new Place(0.5, 2, 0));
        places.add(new Place(1.5, 2, 0));
        places.add(new Place(2.5, 2, 0));

        places.add(new Place(5, 2, 0));

        places.add(new Place(7.5, 2, 0));
        places.add(new Place(8.5, 2, 0));
        places.add(new Place(9.5, 2, 0));

        // 3.sor
        places.add(new Place(0, 3, 0));
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

        // 4. sor
        places.add(new Place(0.5, 4, 0));
        places.add(new Place(1.5, 4, 0));
        places.add(new Place(2.5, 4, 0));

        places.add(new Place(5, 4, 0));

        places.add(new Place(7.5, 4, 0));
        places.add(new Place(8.5, 4, 0));
        places.add(new Place(9.5, 4, 0));

        // 4,5. sor
        places.add(new Place(4, 4.5, 0));
        places.add(new Place(6, 4.5, 0));

        // 5. sor
        places.add(new Place(5, 5, 0));

        // 5,5. sor
        places.add(new Place(4, 5.5, 0));
        places.add(new Place(6, 5.5, 0));

        // 6. sor
        places.add(new Place(5, 6, 0));

        // 1. réteg
        // 0. sor
        places.add(new Place(5, 0, 1));

        // 0,5. sor
        places.add(new Place(4, 0.5, 1));
        places.add(new Place(6, 0.5, 1));

        // 1. sor
        places.add(new Place(5, 1, 1));

        // 1,5. sor
        places.add(new Place(4, 1.5, 1));
        places.add(new Place(6, 1.5, 1));

        // 2. sor
        places.add(new Place(0.5, 2, 1));
        places.add(new Place(1.5, 2, 1));
        places.add(new Place(2.5, 2, 1));

        places.add(new Place(5, 2, 1));

        places.add(new Place(7.5, 2, 1));
        places.add(new Place(8.5, 2, 1));
        places.add(new Place(9.5, 2, 1));

        // 3.sor
        places.add(new Place(0, 3, 1));
        places.add(new Place(1, 3, 1));
        places.add(new Place(2, 3, 1));
        places.add(new Place(3, 3, 1));
        places.add(new Place(4, 3, 1));
        places.add(new Place(5, 3, 1));
        places.add(new Place(6, 3, 1));
        places.add(new Place(7, 3, 1));
        places.add(new Place(8, 3, 1));
        places.add(new Place(9, 3, 1));
        places.add(new Place(10, 3, 1));

        // 4. sor
        places.add(new Place(0.5, 4, 1));
        places.add(new Place(1.5, 4, 1));
        places.add(new Place(2.5, 4, 1));

        places.add(new Place(5, 4, 1));

        places.add(new Place(7.5, 4, 1));
        places.add(new Place(8.5, 4, 1));
        places.add(new Place(9.5, 4, 1));

        // 4,5. sor
        places.add(new Place(4, 4.5, 1));
        places.add(new Place(6, 4.5, 1));

        // 5. sor
        places.add(new Place(5, 5, 1));

        // 5,5. sor
        places.add(new Place(4, 5.5, 1));
        places.add(new Place(6, 5.5, 1));

        // 6. sor
        places.add(new Place(5, 6, 1));

        // 2. réteg
        // 0. sor
        places.add(new Place(5, 0, 2));

        // 0,5. sor
        places.add(new Place(4, 0.5, 2));
        places.add(new Place(6, 0.5, 2));

        // 1. sor
        places.add(new Place(5, 1, 2));

        // 1,5. sor
        places.add(new Place(4, 1.5, 2));
        places.add(new Place(6, 1.5, 2));

        // 2. sor
        places.add(new Place(0.5, 2, 2));
        places.add(new Place(1.5, 2, 2));
        places.add(new Place(2.5, 2, 2));

        places.add(new Place(5, 2, 2));

        places.add(new Place(7.5, 2, 2));
        places.add(new Place(8.5, 2, 2));
        places.add(new Place(9.5, 2, 2));

        // 3.sor
        places.add(new Place(0, 3, 2));
        places.add(new Place(1, 3, 2));
        places.add(new Place(2, 3, 2));
        places.add(new Place(3, 3, 2));
        places.add(new Place(4, 3, 2));
        places.add(new Place(5, 3, 2));
        places.add(new Place(6, 3, 2));
        places.add(new Place(7, 3, 2));
        places.add(new Place(8, 3, 2));
        places.add(new Place(9, 3, 2));
        places.add(new Place(10, 3, 2));

        // 4. sor
        places.add(new Place(0.5, 4, 2));
        places.add(new Place(1.5, 4, 2));
        places.add(new Place(2.5, 4, 2));

        places.add(new Place(5, 4, 2));

        places.add(new Place(7.5, 4, 2));
        places.add(new Place(8.5, 4, 2));
        places.add(new Place(9.5, 4, 2));

        // 4,5. sor
        places.add(new Place(4, 4.5, 2));
        places.add(new Place(6, 4.5, 2));

        // 5. sor
        places.add(new Place(5, 5, 2));

        // 5,5. sor
        places.add(new Place(4, 5.5, 2));
        places.add(new Place(6, 5.5, 2));

        // 6. sor
        places.add(new Place(5, 6, 2));

        // 3. réteg
        // 0. sor
        places.add(new Place(5, 0, 3));

        // 1. sor
        places.add(new Place(5, 1, 3));

        // 2. sor
        places.add(new Place(5, 2, 3));

        // 3.sor
        places.add(new Place(0, 3, 3));
        places.add(new Place(1, 3, 3));
        places.add(new Place(2, 3, 3));
        places.add(new Place(3, 3, 3));
        places.add(new Place(4, 3, 3));
        places.add(new Place(5, 3, 3));
        places.add(new Place(6, 3, 3));
        places.add(new Place(7, 3, 3));
        places.add(new Place(8, 3, 3));
        places.add(new Place(9, 3, 3));
        places.add(new Place(10, 3, 3));

        // 4. sor
        places.add(new Place(5, 4, 3));

        // 5. sor
        places.add(new Place(5, 5, 3));

        // 6. sor
        places.add(new Place(5, 6, 3));

        // 4. réteg
        // 0. sor
        places.add(new Place(5, 0, 4));

        // 1. sor
        places.add(new Place(5, 1, 4));

        // 2. sor
        places.add(new Place(5, 2, 4));

        // 3.sor
        places.add(new Place(0, 3, 4));
        places.add(new Place(1, 3, 4));
        places.add(new Place(2, 3, 4));
        places.add(new Place(3, 3, 4));
        places.add(new Place(4, 3, 4));

        places.add(new Place(6, 3, 4));
        places.add(new Place(7, 3, 4));
        places.add(new Place(8, 3, 4));
        places.add(new Place(9, 3, 4));
        places.add(new Place(10, 3, 4));

        // 4. sor
        places.add(new Place(5, 4, 4));

        // 5. sor
        places.add(new Place(5, 5, 4));

        // 6. sor
        places.add(new Place(5, 6, 4));

        // méret
        layoutWidth = 11;
        layoutHeight = 7;
    }

    public String getName() {
        return "Bamboo";
    }

}