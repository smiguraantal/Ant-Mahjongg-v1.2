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

public class FivePyramidsLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(7, 0, 0));

        // 0,5. sor
        places.add(new Place(0, 0.5, 0));
        places.add(new Place(1, 0.5, 0));
        places.add(new Place(2, 0.5, 0));
        places.add(new Place(3, 0.5, 0));

        places.add(new Place(11, 0.5, 0));
        places.add(new Place(12, 0.5, 0));
        places.add(new Place(13, 0.5, 0));
        places.add(new Place(14, 0.5, 0));

        // 1. sor
        places.add(new Place(7, 1, 0));

        // 1,5. sor
        places.add(new Place(0, 1.5, 0));
        places.add(new Place(1, 1.5, 0));
        places.add(new Place(2, 1.5, 0));
        places.add(new Place(3, 1.5, 0));
        places.add(new Place(4, 1.5, 0));
        places.add(new Place(5, 1.5, 0));
        places.add(new Place(6, 1.5, 0));
        places.add(new Place(8, 1.5, 0));
        places.add(new Place(9, 1.5, 0));
        places.add(new Place(10, 1.5, 0));
        places.add(new Place(11, 1.5, 0));
        places.add(new Place(12, 1.5, 0));
        places.add(new Place(13, 1.5, 0));
        places.add(new Place(14, 1.5, 0));

        // 2. sor
        places.add(new Place(7, 2, 0));

        // 2,5. sor
        places.add(new Place(0, 2.5, 0));
        places.add(new Place(1, 2.5, 0));
        places.add(new Place(2, 2.5, 0));
        places.add(new Place(3, 2.5, 0));

        places.add(new Place(11, 2.5, 0));
        places.add(new Place(12, 2.5, 0));
        places.add(new Place(13, 2.5, 0));
        places.add(new Place(14, 2.5, 0));

        // 3. sor
        places.add(new Place(6, 3, 0));
        places.add(new Place(7, 3, 0));
        places.add(new Place(8, 3, 0));

        // 3,5. sor
        places.add(new Place(1.5, 3.5, 0));
        places.add(new Place(12.5, 3.5, 0));

        // 4. sor
        places.add(new Place(3, 4, 0));
        places.add(new Place(4, 4, 0));
        places.add(new Place(5, 4, 0));
        places.add(new Place(6, 4, 0));
        places.add(new Place(7, 4, 0));
        places.add(new Place(8, 4, 0));
        places.add(new Place(9, 4, 0));
        places.add(new Place(10, 4, 0));
        places.add(new Place(11, 4, 0));


        // 4,5. sor
        places.add(new Place(1.5, 4.5, 0));
        places.add(new Place(12.5, 4.5, 0));

        // 5. sor
        places.add(new Place(6, 5, 0));
        places.add(new Place(7, 5, 0));
        places.add(new Place(8, 5, 0));

        // 5,5. sor
        places.add(new Place(0, 5.5, 0));
        places.add(new Place(1, 5.5, 0));
        places.add(new Place(2, 5.5, 0));
        places.add(new Place(3, 5.5, 0));

        places.add(new Place(11, 5.5, 0));
        places.add(new Place(12, 5.5, 0));
        places.add(new Place(13, 5.5, 0));
        places.add(new Place(14, 5.5, 0));

        // 6. sor
        places.add(new Place(7, 6, 0));

        // 6,5. sor
        places.add(new Place(0, 6.5, 0));
        places.add(new Place(1, 6.5, 0));
        places.add(new Place(2, 6.5, 0));
        places.add(new Place(3, 6.5, 0));
        places.add(new Place(4, 6.5, 0));
        places.add(new Place(5, 6.5, 0));
        places.add(new Place(6, 6.5, 0));
        places.add(new Place(8, 6.5, 0));
        places.add(new Place(9, 6.5, 0));
        places.add(new Place(10, 6.5, 0));
        places.add(new Place(11, 6.5, 0));
        places.add(new Place(12, 6.5, 0));
        places.add(new Place(13, 6.5, 0));
        places.add(new Place(14, 6.5, 0));

        // 7. sor
        places.add(new Place(7, 7, 0));

        // 7,5. sor
        places.add(new Place(0, 7.5, 0));
        places.add(new Place(1, 7.5, 0));
        places.add(new Place(2, 7.5, 0));
        places.add(new Place(3, 7.5, 0));

        places.add(new Place(11, 7.5, 0));
        places.add(new Place(12, 7.5, 0));
        places.add(new Place(13, 7.5, 0));
        places.add(new Place(14, 7.5, 0));

        // 8. sor
        places.add(new Place(7, 8, 0));

        // 1. réteg
        // 1. sor
        places.add(new Place(0.5, 1, 1));
        places.add(new Place(1.5, 1, 1));
        places.add(new Place(2.5, 1, 1));

        places.add(new Place(7, 1, 1));

        places.add(new Place(11.5, 1, 1));
        places.add(new Place(12.5, 1, 1));
        places.add(new Place(13.5, 1, 1));

        // 2. sor
        places.add(new Place(0.5, 2, 1));
        places.add(new Place(1.5, 2, 1));
        places.add(new Place(2.5, 2, 1));

        places.add(new Place(7, 2, 1));

        places.add(new Place(11.5, 2, 1));
        places.add(new Place(12.5, 2, 1));
        places.add(new Place(13.5, 2, 1));

        // 3. sor
        places.add(new Place(7, 3, 1));

        // 4. sor
        places.add(new Place(4, 4, 1));
        places.add(new Place(5, 4, 1));
        places.add(new Place(6, 4, 1));
        places.add(new Place(7, 4, 1));
        places.add(new Place(8, 4, 1));
        places.add(new Place(9, 4, 1));
        places.add(new Place(10, 4, 1));

        // 5. sor
        places.add(new Place(7, 5, 1));

        // 6. sor
        places.add(new Place(0.5, 6, 1));
        places.add(new Place(1.5, 6, 1));
        places.add(new Place(2.5, 6, 1));

        places.add(new Place(7, 6, 1));

        places.add(new Place(11.5, 6, 1));
        places.add(new Place(12.5, 6, 1));
        places.add(new Place(13.5, 6, 1));

        // 7. sor
        places.add(new Place(0.5, 7, 1));
        places.add(new Place(1.5, 7, 1));
        places.add(new Place(2.5, 7, 1));

        places.add(new Place(7, 7, 1));

        places.add(new Place(11.5, 7, 1));
        places.add(new Place(12.5, 7, 1));
        places.add(new Place(13.5, 7, 1));

        // 2. réteg
        // 1.5. sor
        places.add(new Place(1, 1.5, 2));
        places.add(new Place(2, 1.5, 2));

        places.add(new Place(12, 1.5, 2));
        places.add(new Place(13, 1.5, 2));

        // 2. sor
        places.add(new Place(7, 2, 2));

        // 3. sor
        places.add(new Place(7, 3, 2));

        // 4. sor
        places.add(new Place(5, 4, 2));
        places.add(new Place(6, 4, 2));
        places.add(new Place(7, 4, 2));
        places.add(new Place(8, 4, 2));
        places.add(new Place(9, 4, 2));

        // 5. sor
        places.add(new Place(7, 5, 2));

        // 6. sor
        places.add(new Place(7, 6, 2));

        // 6.5. sor
        places.add(new Place(1, 6.5, 2));
        places.add(new Place(2, 6.5, 2));

        places.add(new Place(12, 6.5, 2));
        places.add(new Place(13, 6.5, 2));

        // 3. réteg
        // 3. sor
        places.add(new Place(7, 3, 3));

        // 4. sor
        places.add(new Place(6, 4, 3));
        places.add(new Place(7, 4, 3));
        places.add(new Place(8, 4, 3));

        // 5. sor
        places.add(new Place(7, 5, 3));

        // méret
        layoutWidth = 15;
        layoutHeight = 9;
    }

    public String getName() {
        return "Five Pyramids";
    }

}








