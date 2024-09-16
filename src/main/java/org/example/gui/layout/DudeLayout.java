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

public class DudeLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(2.5, 0, 0));
        places.add(new Place(9.5, 0, 0));

        // 0,5. sor
        places.add(new Place(13.5, 0.5, 0));

        // 1. sor
        places.add(new Place(9.5, 1, 0));
        places.add(new Place(10.5, 1, 0));
        places.add(new Place(11.5, 1, 0));
        places.add(new Place(12.5, 1, 0));

        // 1,5. sor
        places.add(new Place(2, 1.5, 0));
        places.add(new Place(3, 1.5, 0));

        places.add(new Place(5.5, 1.5, 0));
        places.add(new Place(6.5, 1.5, 0));
        places.add(new Place(7.5, 1.5, 0));
        places.add(new Place(8.5, 1.5, 0));

        // 2. sor
        places.add(new Place(1, 2, 0));

        places.add(new Place(4.5, 2, 0));

        places.add(new Place(10, 2, 0));

        places.add(new Place(12, 2, 0));
        places.add(new Place(13, 2, 0));
        places.add(new Place(14, 2, 0));

        // 2,5. sor
        places.add(new Place(0, 2.5, 0));

        places.add(new Place(3.5, 2.5, 0));

        places.add(new Place(6, 2.5, 0));
        places.add(new Place(7, 2.5, 0));
        places.add(new Place(8, 2.5, 0));
        places.add(new Place(9, 2.5, 0));

        places.add(new Place(11, 2.5, 0));

        places.add(new Place(15, 2.5, 0));

        // 3. sor
        places.add(new Place(2.5, 3, 0));

        places.add(new Place(5, 3, 0));
        places.add(new Place(10, 3, 0));

        places.add(new Place(12, 3, 0));

        // 3,5. sor
        places.add(new Place(7.5, 3.5, 0));

        places.add(new Place(13, 3.5, 0));

        // 4. sor
        places.add(new Place(2, 4, 0));

        places.add(new Place(5, 4, 0));
        places.add(new Place(10, 4, 0));

        // 4,5. sor
        places.add(new Place(7.5, 4.5, 0));

        places.add(new Place(13.5, 4.5, 0));

        // 5. sor
        places.add(new Place(4.5, 5, 0));
        places.add(new Place(5.5, 5, 0));
        places.add(new Place(6.5, 5, 0));
        places.add(new Place(8.5, 5, 0));
        places.add(new Place(9.5, 5, 0));
        places.add(new Place(10.5, 5, 0));

        // 5,5. sor
        places.add(new Place(3.5, 0.5, 0));
        places.add(new Place(4.5, 0.5, 0));
        places.add(new Place(5.5, 0.5, 0));

        // 6. sor
        places.add(new Place(4.5, 6, 0));
        places.add(new Place(5.5, 6, 0));
        places.add(new Place(6.5, 6, 0));
        places.add(new Place(8.5, 6, 0));
        places.add(new Place(9.5, 6, 0));
        places.add(new Place(10.5, 6, 0));

        // 6,5. sor
        places.add(new Place(7.5, 6.5, 0));

        // 7. sor
        places.add(new Place(4.5, 7, 0));
        places.add(new Place(10.5, 7, 0));

        // 8. sor
        places.add(new Place(5, 8, 0));
        places.add(new Place(6, 8, 0));
        places.add(new Place(7, 8, 0));
        places.add(new Place(8, 8, 0));
        places.add(new Place(9, 8, 0));
        places.add(new Place(10, 8, 0));

        // 8,5. sor
        places.add(new Place(8.5, 0.5, 0));


        //----------------------------------------------------------------------

        // 1. réteg

        // 0. sor
        places.add(new Place(2.5, 0, 1));
        places.add(new Place(9.5, 0, 1));

        // 1,5. sor
        places.add(new Place(5.5, 1.5, 1));
        places.add(new Place(6.5, 1.5, 1));
        places.add(new Place(7.5, 1.5, 1));
        places.add(new Place(8.5, 1.5, 1));

        // 2. sor
        places.add(new Place(4.5, 2, 1));

        places.add(new Place(10, 2, 1));

        // 2,5. sor
        places.add(new Place(3.5, 2.5, 1));

        places.add(new Place(6, 2.5, 1));
        places.add(new Place(7, 2.5, 1));
        places.add(new Place(8, 2.5, 1));
        places.add(new Place(9, 2.5, 1));

        places.add(new Place(11, 2.5, 1));

        // 3. sor
        places.add(new Place(2.5, 3, 1));

        places.add(new Place(5, 3, 1));
        places.add(new Place(10, 3, 1));

        places.add(new Place(12, 3, 1));

        // 3,5. sor
        places.add(new Place(7.5, 3.5, 1));

        places.add(new Place(13, 3.5, 1));

        // 4. sor
        places.add(new Place(2, 4, 1));

        places.add(new Place(5, 4, 1));
        places.add(new Place(10, 4, 1));

        // 4,5. sor
        places.add(new Place(7.5, 4.5, 1));

        places.add(new Place(13.5, 4.5, 1));

        // 5. sor
        places.add(new Place(4.5, 5, 1));
        places.add(new Place(5.5, 5, 1));
        places.add(new Place(6.5, 5, 1));
        places.add(new Place(8.5, 5, 1));
        places.add(new Place(9.5, 5, 1));
        places.add(new Place(10.5, 5, 1));

        // 5,5. sor
        places.add(new Place(3.5, 0.5, 1));
        places.add(new Place(4.5, 0.5, 1));
        places.add(new Place(5.5, 0.5, 1));

        // 6. sor
        places.add(new Place(4.5, 6, 1));
        places.add(new Place(5.5, 6, 1));
        places.add(new Place(6.5, 6, 1));
        places.add(new Place(8.5, 6, 1));
        places.add(new Place(9.5, 6, 1));
        places.add(new Place(10.5, 6, 1));

        // 6,5. sor
        places.add(new Place(7.5, 6.5, 1));

        // 7. sor
        places.add(new Place(4.5, 7, 1));
        places.add(new Place(10.5, 7, 1));

        // 8. sor
        places.add(new Place(5, 8, 1));
        places.add(new Place(6, 8, 1));
        places.add(new Place(7, 8, 1));
        places.add(new Place(8, 8, 1));
        places.add(new Place(9, 8, 1));
        places.add(new Place(10, 8, 1));

        // 8,5. sor
        places.add(new Place(8.5, 0.5, 1));

        //----------------------------------------------------------------------

        // 2. réteg


        // 2,5. sor
        places.add(new Place(6, 2.5, 2));
        places.add(new Place(7, 2.5, 2));
        places.add(new Place(8, 2.5, 2));
        places.add(new Place(9, 2.5, 2));

        // 3. sor
        places.add(new Place(5, 3, 2));
        places.add(new Place(10, 3, 2));

        // 3,5. sor
        places.add(new Place(7.5, 3.5, 2));

        // 4. sor
        places.add(new Place(5, 4, 2));
        places.add(new Place(10, 4, 2));

        // 4,5. sor
        places.add(new Place(7.5, 4.5, 2));

        // 5. sor
        places.add(new Place(4.5, 5, 2));
        places.add(new Place(5.5, 5, 2));
        places.add(new Place(6.5, 5, 2));
        places.add(new Place(8.5, 5, 2));
        places.add(new Place(9.5, 5, 2));
        places.add(new Place(10.5, 5, 2));

        // 6. sor
        places.add(new Place(4.5, 6, 2));
        places.add(new Place(5.5, 6, 2));
        places.add(new Place(6.5, 6, 2));
        places.add(new Place(8.5, 6, 2));
        places.add(new Place(9.5, 6, 2));
        places.add(new Place(10.5, 6, 2));

        // 6,5. sor
        places.add(new Place(7.5, 6.5, 2));

        // 7. sor
        places.add(new Place(4.5, 7, 2));
        places.add(new Place(10.5, 7, 2));

        // 8. sor
        places.add(new Place(5, 8, 2));
        places.add(new Place(6, 8, 2));
        places.add(new Place(7, 8, 2));
        places.add(new Place(8, 8, 2));
        places.add(new Place(9, 8, 2));
        places.add(new Place(10, 8, 2));


        // méret
        layoutWidth = 16;
        layoutHeight = 9;
    }

    public String getName() {
        return "Dude";
    }

}
