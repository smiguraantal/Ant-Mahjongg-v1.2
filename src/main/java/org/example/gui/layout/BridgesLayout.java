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

public class BridgesLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(0, 0, 0));
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

        // 1. sor
        places.add(new Place(0, 1, 0));

        places.add(new Place(4, 1, 0));

        places.add(new Place(6, 1, 0));

        places.add(new Place(10, 1, 0));

        // 2. sor
        places.add(new Place(0, 2, 0));
        places.add(new Place(1, 2, 0));
        places.add(new Place(2, 2, 0));
        places.add(new Place(3, 2, 0));
        places.add(new Place(4, 2, 0));

        places.add(new Place(6, 2, 0));
        places.add(new Place(7, 2, 0));
        places.add(new Place(8, 2, 0));
        places.add(new Place(9, 2, 0));
        places.add(new Place(10, 2, 0));

        // 3. sor
        places.add(new Place(0, 3, 0));

        places.add(new Place(4, 3, 0));

        places.add(new Place(6, 3, 0));

        places.add(new Place(10, 3, 0));

        // 4. sor
        places.add(new Place(0, 4, 0));
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

        // 5. sor
        places.add(new Place(0, 5, 0));

        places.add(new Place(4, 5, 0));

        places.add(new Place(6, 5, 0));

        places.add(new Place(10, 5, 0));

        // 6. sor
        places.add(new Place(0, 6, 0));
        places.add(new Place(1, 6, 0));
        places.add(new Place(2, 6, 0));
        places.add(new Place(3, 6, 0));
        places.add(new Place(4, 6, 0));

        places.add(new Place(6, 6, 0));
        places.add(new Place(7, 6, 0));
        places.add(new Place(8, 6, 0));
        places.add(new Place(9, 6, 0));
        places.add(new Place(10, 6, 0));

        // 7. sor
        places.add(new Place(0, 7, 0));

        places.add(new Place(4, 7, 0));

        places.add(new Place(6, 7, 0));

        places.add(new Place(10, 7, 0));

        // 8. sor
        places.add(new Place(0, 8, 0));
        places.add(new Place(1, 8, 0));
        places.add(new Place(2, 8, 0));
        places.add(new Place(3, 8, 0));
        places.add(new Place(4, 8, 0));
        places.add(new Place(5, 8, 0));
        places.add(new Place(6, 8, 0));
        places.add(new Place(7, 8, 0));
        places.add(new Place(8, 8, 0));
        places.add(new Place(9, 8, 0));
        places.add(new Place(10, 8, 0));

        // 1. réteg
        // 0. sor
        places.add(new Place(0.5, 0, 1));
        places.add(new Place(1.5, 0, 1));
        places.add(new Place(2.5, 0, 1));
        places.add(new Place(3.5, 0, 1));

        places.add(new Place(5, 0, 1));

        places.add(new Place(6.5, 0, 1));
        places.add(new Place(7.5, 0, 1));
        places.add(new Place(8.5, 0, 1));
        places.add(new Place(9.5, 0, 1));

        // 2. sor
        places.add(new Place(0.5, 2, 1));
        places.add(new Place(1.5, 2, 1));
        places.add(new Place(2.5, 2, 1));
        places.add(new Place(3.5, 2, 1));

        places.add(new Place(6.5, 2, 1));
        places.add(new Place(7.5, 2, 1));
        places.add(new Place(8.5, 2, 1));
        places.add(new Place(9.5, 2, 1));

        // 4. sor
        places.add(new Place(0.5, 4, 1));
        places.add(new Place(1.5, 4, 1));
        places.add(new Place(2.5, 4, 1));
        places.add(new Place(3.5, 4, 1));

        places.add(new Place(5, 4, 1));

        places.add(new Place(6.5, 4, 1));
        places.add(new Place(7.5, 4, 1));
        places.add(new Place(8.5, 4, 1));
        places.add(new Place(9.5, 4, 1));

        // 6. sor
        places.add(new Place(0.5, 6, 1));
        places.add(new Place(1.5, 6, 1));
        places.add(new Place(2.5, 6, 1));
        places.add(new Place(3.5, 6, 1));

        places.add(new Place(6.5, 6, 1));
        places.add(new Place(7.5, 6, 1));
        places.add(new Place(8.5, 6, 1));
        places.add(new Place(9.5, 6, 1));

        // 8. sor
        places.add(new Place(0.5, 8, 1));
        places.add(new Place(1.5, 8, 1));
        places.add(new Place(2.5, 8, 1));
        places.add(new Place(3.5, 8, 1));

        places.add(new Place(5, 8, 1));

        places.add(new Place(6.5, 8, 1));
        places.add(new Place(7.5, 8, 1));
        places.add(new Place(8.5, 8, 1));
        places.add(new Place(9.5, 8, 1));

        // 2. réteg
        // 0. sor
        places.add(new Place(1, 0, 2));
        places.add(new Place(2, 0, 2));
        places.add(new Place(3, 0, 2));

        places.add(new Place(5, 0, 2));

        places.add(new Place(7, 0, 2));
        places.add(new Place(8, 0, 2));
        places.add(new Place(9, 0, 2));

        // 2. sor
        places.add(new Place(1, 2, 2));
        places.add(new Place(2, 2, 2));
        places.add(new Place(3, 2, 2));

        places.add(new Place(7, 2, 2));
        places.add(new Place(8, 2, 2));
        places.add(new Place(9, 2, 2));

        // 4. sor
        places.add(new Place(1, 4, 2));
        places.add(new Place(2, 4, 2));
        places.add(new Place(3, 4, 2));

        places.add(new Place(7, 4, 2));
        places.add(new Place(8, 4, 2));
        places.add(new Place(9, 4, 2));

        // 6. sor
        places.add(new Place(1, 6, 2));
        places.add(new Place(2, 6, 2));
        places.add(new Place(3, 6, 2));

        places.add(new Place(7, 6, 2));
        places.add(new Place(8, 6, 2));
        places.add(new Place(9, 6, 2));

        // 8. sor
        places.add(new Place(1, 8, 2));
        places.add(new Place(2, 8, 2));
        places.add(new Place(3, 8, 2));

        places.add(new Place(5, 8, 2));

        places.add(new Place(7, 8, 2));
        places.add(new Place(8, 8, 2));
        places.add(new Place(9, 8, 2));

        // méret
        layoutWidth = 12;
        layoutHeight = 9;
    }

    public String getName() {
        return "Bridges";
    }

}