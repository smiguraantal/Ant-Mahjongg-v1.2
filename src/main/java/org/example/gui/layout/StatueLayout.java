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

public class StatueLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(0, 0, 0));
        places.add(new Place(1, 0, 0));
        places.add(new Place(2, 0, 0));

        places.add(new Place(6, 0, 0));

        // 1. sor
        places.add(new Place(2, 1, 0));

        places.add(new Place(5, 1, 0));
        places.add(new Place(6, 1, 0));
        places.add(new Place(7, 1, 0));

        // 2. sor
        places.add(new Place(2, 2, 0));

        places.add(new Place(4, 2, 0));
        places.add(new Place(5, 2, 0));
        places.add(new Place(6, 2, 0));
        places.add(new Place(7, 2, 0));
        places.add(new Place(8, 2, 0));

        // 2,5. sor
        places.add(new Place(3, 2.5, 0));

        places.add(new Place(9, 2.5, 0));

        // 3. sor
        places.add(new Place(2, 3, 0));

        places.add(new Place(5, 3, 0));
        places.add(new Place(6, 3, 0));
        places.add(new Place(7, 3, 0));

        // 3,5. sor
        places.add(new Place(3, 3.5, 0));

        places.add(new Place(9, 3.5, 0));

        // 4. sor
        places.add(new Place(2, 4, 0));

        places.add(new Place(5, 4, 0));
        places.add(new Place(6, 4, 0));
        places.add(new Place(7, 4, 0));

        // 5. sor
        places.add(new Place(2, 5, 0));

        places.add(new Place(5, 5, 0));

        places.add(new Place(7, 5, 0));

        // 6. sor
        places.add(new Place(2, 6, 0));

        places.add(new Place(4, 6, 0));
        places.add(new Place(5, 6, 0));

        places.add(new Place(7, 6, 0));
        places.add(new Place(8, 6, 0));

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

        // 1. réteg
        // 0. sor
        places.add(new Place(1, 0, 1));
        places.add(new Place(2, 0, 1));

        places.add(new Place(6, 0, 1));

        // 1. sor
        places.add(new Place(2, 1, 1));

        places.add(new Place(5, 1, 1));
        places.add(new Place(6, 1, 1));
        places.add(new Place(7, 1, 1));

        // 2. sor
        places.add(new Place(2, 2, 1));

        places.add(new Place(4, 2, 1));
        places.add(new Place(5, 2, 1));
        places.add(new Place(6, 2, 1));
        places.add(new Place(7, 2, 1));
        places.add(new Place(8, 2, 1));

        // 2,5. sor
        places.add(new Place(3, 2.5, 1));

        places.add(new Place(9, 2.5, 1));

        // 3. sor
        places.add(new Place(2, 3, 1));

        places.add(new Place(5, 3, 1));
        places.add(new Place(6, 3, 1));
        places.add(new Place(7, 3, 1));

        // 3,5. sor
        places.add(new Place(3, 3.5, 1));

        places.add(new Place(9, 3.5, 1));

        // 4. sor
        places.add(new Place(2, 4, 1));

        places.add(new Place(5, 4, 1));
        places.add(new Place(6, 4, 1));
        places.add(new Place(7, 4, 1));

        // 5. sor
        places.add(new Place(2, 5, 1));

        places.add(new Place(5, 5, 1));

        places.add(new Place(7, 5, 1));

        // 6. sor
        places.add(new Place(2, 6, 1));

        places.add(new Place(4, 6, 1));
        places.add(new Place(5, 6, 1));

        places.add(new Place(7, 6, 1));
        places.add(new Place(8, 6, 1));

        // 7. sor
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

        // 2. réteg
        // 0. sor
        places.add(new Place(2, 0, 2));

        places.add(new Place(6, 0, 2));

        // 1. sor
        places.add(new Place(2, 1, 2));

        places.add(new Place(5, 1, 2));

        places.add(new Place(7, 1, 2));

        // 2. sor
        places.add(new Place(2, 2, 2));

        places.add(new Place(4, 2, 2));
        places.add(new Place(5, 2, 2));
        places.add(new Place(6, 2, 2));
        places.add(new Place(7, 2, 2));
        places.add(new Place(8, 2, 2));

        // 3. sor
        places.add(new Place(2, 3, 2));

        places.add(new Place(5, 3, 2));
        places.add(new Place(6, 3, 2));
        places.add(new Place(7, 3, 2));

        // 4. sor
        places.add(new Place(2, 4, 2));

        places.add(new Place(5, 4, 2));
        places.add(new Place(6, 4, 2));
        places.add(new Place(7, 4, 2));

        // 5. sor
        places.add(new Place(2, 5, 2));

        places.add(new Place(5, 5, 2));

        places.add(new Place(7, 5, 2));

        // 6. sor
        places.add(new Place(2, 6, 2));

        places.add(new Place(4, 6, 2));
        places.add(new Place(5, 6, 2));

        places.add(new Place(7, 6, 2));
        places.add(new Place(8, 6, 2));

        // 7. sor
        places.add(new Place(2, 7, 2));
        places.add(new Place(3, 7, 2));
        places.add(new Place(4, 7, 2));
        places.add(new Place(5, 7, 2));
        places.add(new Place(6, 7, 2));
        places.add(new Place(7, 7, 2));
        places.add(new Place(8, 7, 2));
        places.add(new Place(9, 7, 2));

        // 3. réteg
        // 0. sor
        places.add(new Place(6, 0, 3));

        // 1. sor
        places.add(new Place(5, 1, 3));

        places.add(new Place(7, 1, 3));

        // 2. sor
        places.add(new Place(4, 2, 3));
        places.add(new Place(5, 2, 3));
        places.add(new Place(6, 2, 3));
        places.add(new Place(7, 2, 3));
        places.add(new Place(8, 2, 3));

        // 3. sor
        places.add(new Place(5, 3, 3));
        places.add(new Place(6, 3, 3));
        places.add(new Place(7, 3, 3));

        // 4. sor
        places.add(new Place(6, 4, 3));

        // 5. sor
        places.add(new Place(5, 5, 3));

        places.add(new Place(7, 5, 3));

        // 6. sor
        places.add(new Place(4, 6, 3));
        places.add(new Place(5, 6, 3));

        places.add(new Place(7, 6, 3));
        places.add(new Place(8, 6, 3));

        // 4. réteg
        // 2. sor
        places.add(new Place(5, 2, 4));
        places.add(new Place(6, 2, 4));
        places.add(new Place(7, 2, 4));

        // 3. sor
        places.add(new Place(6, 3, 4));

        // méret
        layoutWidth = 11;
        layoutHeight = 8;
    }

    public String getName() {
        return "Statue";
    }

}