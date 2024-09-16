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

public class CaravelLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(9.5, 0, 0));

        // 0,5. sor
        places.add(new Place(8.5, 0.5, 0));

        // 1. sor
        places.add(new Place(7.5, 1, 0));

        places.add(new Place(9.5, 1, 0));

        // 1,5. sor
        places.add(new Place(6.5, 1.5, 0));

        places.add(new Place(8.5, 1.5, 0));

        // 2. sor
        places.add(new Place(5.5, 2, 0));

        places.add(new Place(7.5, 2, 0));

        places.add(new Place(9.5, 2, 0));

        // 2,5. sor
        places.add(new Place(6.5, 2.5, 0));

        places.add(new Place(8.5, 2.5, 0));

        places.add(new Place(13.5, 2.5, 0));

        // 3. sor
        places.add(new Place(7.5, 3, 0));

        places.add(new Place(9.5, 3, 0));

        places.add(new Place(12.5, 3, 0));

        places.add(new Place(14.5, 3, 0));

        // 3,5. sor
        places.add(new Place(8.5, 3.5, 0));

        // 4. sor
        places.add(new Place(0, 4, 0));

        places.add(new Place(9.5, 4, 0));

        places.add(new Place(12, 4, 0));

        places.add(new Place(14, 4, 0));

        // 5. sor
        places.add(new Place(0, 5, 0));

        places.add(new Place(2.5, 5, 0));

        places.add(new Place(4, 5, 0));

        places.add(new Place(5.5, 5, 0));

        places.add(new Place(7, 5, 0));

        places.add(new Place(8.5, 5, 0));
        places.add(new Place(9.5, 5, 0));

        places.add(new Place(11.5, 5, 0));

        places.add(new Place(13.5, 5, 0));

        // 5,5. sor
        places.add(new Place(1, 5.5, 0));

        // 6. sor
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

        // 7. sor
        places.add(new Place(3, 7, 0));
        places.add(new Place(4, 7, 0));
        places.add(new Place(5, 7, 0));
        places.add(new Place(6, 7, 0));
        places.add(new Place(7, 7, 0));
        places.add(new Place(8, 7, 0));
        places.add(new Place(9, 7, 0));
        places.add(new Place(10, 7, 0));

        // 1. réteg
        // 0,5. sor
        places.add(new Place(9, 0.5, 1));

        // 1. sor
        places.add(new Place(8, 1, 1));

        // 1,5. sor
        places.add(new Place(7, 1.5, 1));

        places.add(new Place(9, 1.5, 1));

        // 2. sor
        places.add(new Place(6, 2, 1));

        places.add(new Place(8, 2, 1));

        // 2,5. sor
        places.add(new Place(7, 2.5, 1));

        places.add(new Place(9, 2.5, 1));

        places.add(new Place(13.5, 2.5, 1));

        // 3. sor
        places.add(new Place(8, 3, 1));

        places.add(new Place(12.5, 3, 1));

        places.add(new Place(14.5, 3, 1));

        // 3,5. sor
        places.add(new Place(9, 3.5, 1));

        // 4. sor
        places.add(new Place(0, 4, 1));

        places.add(new Place(12, 4, 1));

        places.add(new Place(14, 4, 1));

        // 4,5. sor
        places.add(new Place(9.5, 4.5, 1));

        // 5. sor
        places.add(new Place(0, 5, 1));

        places.add(new Place(2.5, 5, 1));

        places.add(new Place(4, 5, 1));

        places.add(new Place(5.5, 5, 1));

        places.add(new Place(7, 5, 1));

        places.add(new Place(8.5, 5, 1));

        places.add(new Place(11.5, 5, 1));

        places.add(new Place(13.5, 5, 1));

        // 5,5. sor
        places.add(new Place(1, 5.5, 1));

        // 6. sor
        places.add(new Place(2, 6, 1));
        places.add(new Place(3, 6, 1));
        places.add(new Place(4, 6, 1));
        places.add(new Place(5, 6, 1));
        places.add(new Place(6, 6, 1));
        places.add(new Place(7, 6, 1));
        places.add(new Place(8, 6, 1));
        places.add(new Place(9, 6, 1));
        places.add(new Place(10, 6, 1));
        places.add(new Place(11, 6, 1));

        // 7. sor
        places.add(new Place(3, 7, 1));
        places.add(new Place(4, 7, 1));
        places.add(new Place(5, 7, 1));
        places.add(new Place(6, 7, 1));
        places.add(new Place(7, 7, 1));
        places.add(new Place(8, 7, 1));
        places.add(new Place(9, 7, 1));
        places.add(new Place(10, 7, 1));

        // 2. réteg
        // 1. sor
        places.add(new Place(8.5, 1, 2));

        // 1,5. sor
        places.add(new Place(7.5, 1.5, 2));

        // 2. sor
        places.add(new Place(6.5, 2, 2));

        places.add(new Place(8.5, 2, 2));

        // 2,5. sor
        places.add(new Place(7.5, 2.5, 2));

        places.add(new Place(13.5, 2.5, 2));

        // 3. sor
        places.add(new Place(8.5, 3, 2));

        places.add(new Place(12.5, 3, 2));

        places.add(new Place(14.5, 3, 2));

        // 4. sor
        places.add(new Place(0, 4, 2));

        places.add(new Place(12, 4, 2));

        places.add(new Place(14, 4, 2));

        // 5. sor
        places.add(new Place(0, 5, 2));

        places.add(new Place(11.5, 5, 2));

        places.add(new Place(13.5, 5, 2));

        // 5,5. sor
        places.add(new Place(1, 5.5, 2));

        // 6. sor
        places.add(new Place(2, 6, 2));
        places.add(new Place(3, 6, 2));
        places.add(new Place(4, 6, 2));
        places.add(new Place(5, 6, 2));
        places.add(new Place(6, 6, 2));
        places.add(new Place(7, 6, 2));
        places.add(new Place(8, 6, 2));
        places.add(new Place(9, 6, 2));
        places.add(new Place(10, 6, 2));
        places.add(new Place(11, 6, 2));

        // 7. sor
        places.add(new Place(3, 7, 2));
        places.add(new Place(4, 7, 2));
        places.add(new Place(5, 7, 2));
        places.add(new Place(6, 7, 2));
        places.add(new Place(7, 7, 2));
        places.add(new Place(8, 7, 2));
        places.add(new Place(9, 7, 2));
        places.add(new Place(10, 7, 2));

        // 3. réteg
        // 1,5. sor
        places.add(new Place(8, 1.5, 3));

        // 2. sor
        places.add(new Place(7, 2, 3));

        // 2,5. sor
        places.add(new Place(8, 2.5, 3));

        places.add(new Place(13.5, 2.5, 3));

        // 3. sor
        places.add(new Place(12.5, 3, 3));

        places.add(new Place(14.5, 3, 3));

        // 4. sor
        places.add(new Place(0, 4, 3));

        places.add(new Place(12, 4, 3));

        places.add(new Place(14, 4, 3));

        // 5. sor
        places.add(new Place(0, 5, 3));

        places.add(new Place(11.5, 5, 3));

        places.add(new Place(13.5, 5, 3));

        // 5,5. sor
        places.add(new Place(1, 5.5, 3));

        // 6,5. sor
        places.add(new Place(4.5, 6.5, 3));

        places.add(new Place(8.5, 6.5, 3));

        // 4. réteg
        // 2. sor
        places.add(new Place(7.5, 2, 4));

        // 4,5. sor
        places.add(new Place(0, 4.5, 4));


        // méret
        layoutWidth = 15.5;
        layoutHeight = 8;
    }

    public String getName() {
        return "Caravel";
    }

}