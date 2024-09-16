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

public class LabyrinthLayout extends Layout {

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
        places.add(new Place(11, 0, 0));
        places.add(new Place(12, 0, 0));
        places.add(new Place(13, 0, 0));
        places.add(new Place(14, 0, 0));
        places.add(new Place(15, 0, 0));

        // 1. sor
        places.add(new Place(0, 1, 0));

        places.add(new Place(5, 1, 0));

        places.add(new Place(7, 1, 0));

        places.add(new Place(10, 1, 0));

        places.add(new Place(15, 1, 0));

        // 2. sor
        places.add(new Place(0, 2, 0));
        places.add(new Place(1, 2, 0));
        places.add(new Place(2, 2, 0));
        places.add(new Place(3, 2, 0));

        places.add(new Place(5, 2, 0));

        places.add(new Place(7, 2, 0));

        places.add(new Place(9, 2, 0));
        places.add(new Place(10, 2, 0));

        places.add(new Place(12, 2, 0));
        places.add(new Place(13, 2, 0));
        places.add(new Place(15, 2, 0));

        // 3. sor
        places.add(new Place(0, 3, 0));

        places.add(new Place(5, 3, 0));

        places.add(new Place(12, 3, 0));

        places.add(new Place(15, 3, 0));

        // 4. sor
        places.add(new Place(0, 4, 0));

        places.add(new Place(2, 4, 0));

        places.add(new Place(4, 4, 0));
        places.add(new Place(5, 4, 0));

        places.add(new Place(7, 4, 0));
        places.add(new Place(8, 4, 0));
        places.add(new Place(9, 4, 0));
        places.add(new Place(10, 4, 0));
        places.add(new Place(11, 4, 0));
        places.add(new Place(12, 4, 0));
        places.add(new Place(13, 4, 0));

        places.add(new Place(15, 4, 0));

        // 5. sor
        places.add(new Place(0, 5, 0));

        places.add(new Place(2, 5, 0));

        places.add(new Place(7, 5, 0));

        places.add(new Place(11, 5, 0));

        places.add(new Place(15, 5, 0));

        // 6. sor
        places.add(new Place(0, 6, 0));

        places.add(new Place(2, 6, 0));
        places.add(new Place(3, 6, 0));
        places.add(new Place(4, 6, 0));
        places.add(new Place(5, 6, 0));

        places.add(new Place(7, 6, 0));
        places.add(new Place(8, 6, 0));
        places.add(new Place(9, 6, 0));

        places.add(new Place(11, 6, 0));

        places.add(new Place(13, 6, 0));
        places.add(new Place(14, 6, 0));
        places.add(new Place(15, 6, 0));

        // 7. sor
        places.add(new Place(0, 7, 0));

        places.add(new Place(5, 7, 0));

        places.add(new Place(11, 7, 0));

        places.add(new Place(15, 7, 0));

        // 8. sor
        places.add(new Place(0, 8, 0));
        places.add(new Place(1, 8, 0));
        places.add(new Place(2, 8, 0));
        places.add(new Place(3, 8, 0));

        places.add(new Place(5, 8, 0));
        places.add(new Place(6, 8, 0));
        places.add(new Place(7, 8, 0));
        places.add(new Place(8, 8, 0));
        places.add(new Place(9, 8, 0));
        places.add(new Place(10, 8, 0));
        places.add(new Place(11, 8, 0));
        places.add(new Place(12, 8, 0));

        places.add(new Place(14, 8, 0));
        places.add(new Place(15, 8, 0));

        // 1. réteg
        // 0. sor
        places.add(new Place(0, 0, 1));

        places.add(new Place(15, 0, 1));

        // 1. sor
        places.add(new Place(5, 1, 1));

        places.add(new Place(7, 1, 1));

        places.add(new Place(10, 1, 1));

        // 2. sor
        places.add(new Place(1, 2, 1));
        places.add(new Place(2, 2, 1));
        places.add(new Place(3, 2, 1));

        places.add(new Place(5, 2, 1));

        places.add(new Place(7, 2, 1));

        places.add(new Place(9, 2, 1));
        places.add(new Place(10, 2, 1));

        places.add(new Place(12, 2, 1));
        places.add(new Place(13, 2, 1));

        // 3. sor
        places.add(new Place(5, 3, 1));

        places.add(new Place(12, 3, 1));

        // 4. sor
        places.add(new Place(2, 4, 1));

        places.add(new Place(4, 4, 1));
        places.add(new Place(5, 4, 1));

        places.add(new Place(7, 4, 1));
        places.add(new Place(8, 4, 1));
        places.add(new Place(9, 4, 1));
        places.add(new Place(10, 4, 1));
        places.add(new Place(11, 4, 1));
        places.add(new Place(12, 4, 1));
        places.add(new Place(13, 4, 1));

        // 5. sor
        places.add(new Place(2, 5, 1));

        places.add(new Place(7, 5, 1));

        places.add(new Place(11, 5, 1));

        // 6. sor
        places.add(new Place(2, 6, 1));
        places.add(new Place(3, 6, 1));
        places.add(new Place(4, 6, 1));
        places.add(new Place(5, 6, 1));

        places.add(new Place(7, 6, 1));
        places.add(new Place(8, 6, 1));
        places.add(new Place(9, 6, 1));

        places.add(new Place(11, 6, 1));

        places.add(new Place(13, 6, 1));
        places.add(new Place(14, 6, 1));

        // 7. sor
        places.add(new Place(5, 7, 1));

        places.add(new Place(11, 7, 1));

        // 8. sor
        places.add(new Place(0, 8, 1));

        places.add(new Place(2, 8, 1));
        places.add(new Place(3, 8, 1));

        places.add(new Place(5, 8, 1));
        places.add(new Place(6, 8, 1));

        places.add(new Place(11, 8, 1));
        places.add(new Place(12, 8, 1));

        places.add(new Place(14, 8, 1));
        places.add(new Place(15, 8, 1));

        // 2. réteg
        // 0. sor
        places.add(new Place(0, 0, 2));

        places.add(new Place(15, 0, 2));

        // 8. sor
        places.add(new Place(0, 8, 2));

        places.add(new Place(3, 8, 2));

        places.add(new Place(5, 8, 2));

        places.add(new Place(12, 8, 2));

        places.add(new Place(14, 8, 2));

        // 3. réteg
        // 8. sor
        places.add(new Place(3, 8, 3));

        places.add(new Place(5, 8, 3));

        places.add(new Place(12, 8, 3));

        places.add(new Place(14, 8, 3));

        // méret
        layoutWidth = 16;
        layoutHeight = 9;
    }

    public String getName() {
        return "Labyrinth";
    }

}