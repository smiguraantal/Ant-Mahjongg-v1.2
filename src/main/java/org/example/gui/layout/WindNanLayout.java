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

public class WindNanLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(4, 0, 0));

        // 0,5 sor
        places.add(new Place(0, 0.5, 0));
        places.add(new Place(1, 0.5, 0));
        places.add(new Place(2, 0.5, 0));
        places.add(new Place(3, 0.5, 0));

        places.add(new Place(5, 0.5, 0));
        places.add(new Place(6, 0.5, 0));
        places.add(new Place(7, 0.5, 0));
        places.add(new Place(8, 0.5, 0));

        // 1. sor
        places.add(new Place(4, 1, 0));

        // 2. sor
        places.add(new Place(0, 2, 0));
        places.add(new Place(1, 2, 0));
        places.add(new Place(2, 2, 0));
        places.add(new Place(3, 2, 0));
        places.add(new Place(4, 2, 0));
        places.add(new Place(5, 2, 0));
        places.add(new Place(6, 2, 0));
        places.add(new Place(7, 2, 0));
        places.add(new Place(8, 2, 0));

        // 3. sor
        places.add(new Place(0, 3, 0));
        places.add(new Place(2.5, 3, 0));
        places.add(new Place(5.5, 3, 0));
        places.add(new Place(8, 3, 0));

        // 4. sor
        places.add(new Place(0, 4, 0));
        places.add(new Place(3, 4, 0));
        places.add(new Place(5, 4, 0));
        places.add(new Place(8, 4, 0));

        // 4,5. sor
        places.add(new Place(4, 4.5, 0));

        // 5. sor
        places.add(new Place(0, 5, 0));
        places.add(new Place(8, 5, 0));

        // 5,5. sor
        places.add(new Place(2, 5.5, 0));
        places.add(new Place(3, 5.5, 0));
        places.add(new Place(4, 5.5, 0));
        places.add(new Place(5, 5.5, 0));
        places.add(new Place(6, 5.5, 0));

        // 6. sor
        places.add(new Place(0, 6, 0));

        places.add(new Place(8, 6, 0));

        // 6,5. sor
        places.add(new Place(4, 6.5, 0));


        // 7. sor
        places.add(new Place(0, 7, 0));

        places.add(new Place(2, 7, 0));
        places.add(new Place(3, 7, 0));
        places.add(new Place(5, 7, 0));
        places.add(new Place(6, 7, 0));

        places.add(new Place(8, 7, 0));

        // 7,5. sor
        places.add(new Place(4, 7.5, 0));

        // 8. sor
        places.add(new Place(0, 8, 0));
        places.add(new Place(7.5, 8, 0));

        // 1. réteg
        // 0. sor
        places.add(new Place(4, 0, 1));

        // 0,5 sor
        places.add(new Place(0, 0.5, 1));
        places.add(new Place(1, 0.5, 1));
        places.add(new Place(2, 0.5, 1));
        places.add(new Place(3, 0.5, 1));

        places.add(new Place(5, 0.5, 1));
        places.add(new Place(6, 0.5, 1));
        places.add(new Place(7, 0.5, 1));
        places.add(new Place(8, 0.5, 1));

        // 1. sor
        places.add(new Place(4, 1, 1));

        // 2. sor
        places.add(new Place(0, 2, 1));
        places.add(new Place(1, 2, 1));
        places.add(new Place(2, 2, 1));
        places.add(new Place(3, 2, 1));
        places.add(new Place(4, 2, 1));
        places.add(new Place(5, 2, 1));
        places.add(new Place(6, 2, 1));
        places.add(new Place(7, 2, 1));
        places.add(new Place(8, 2, 1));

        // 3. sor
        places.add(new Place(0, 3, 1));
        places.add(new Place(2.5, 3, 1));
        places.add(new Place(5.5, 3, 1));
        places.add(new Place(8, 3, 1));

        // 4. sor
        places.add(new Place(0, 4, 1));
        places.add(new Place(3, 4, 1));
        places.add(new Place(5, 4, 1));
        places.add(new Place(8, 4, 1));

        // 4,5. sor
        places.add(new Place(4, 4.5, 1));

        // 5. sor
        places.add(new Place(0, 5, 1));
        places.add(new Place(8, 5, 1));

        // 5,5. sor
        places.add(new Place(2, 5.5, 1));
        places.add(new Place(3, 5.5, 1));
        places.add(new Place(4, 5.5, 1));
        places.add(new Place(5, 5.5, 1));
        places.add(new Place(6, 5.5, 1));

        // 6. sor
        places.add(new Place(0, 6, 1));

        places.add(new Place(8, 6, 1));

        // 6,5. sor
        places.add(new Place(4, 6.5, 1));


        // 7. sor
        places.add(new Place(0, 7, 1));

        places.add(new Place(2, 7, 1));
        places.add(new Place(3, 7, 1));
        places.add(new Place(5, 7, 1));
        places.add(new Place(6, 7, 1));

        places.add(new Place(8, 7, 1));

        // 7,5. sor
        places.add(new Place(4, 7.5, 1));

        // 8. sor
        places.add(new Place(0, 8, 1));
        places.add(new Place(7.5, 8, 1));

        // 2. réteg
        // 0. sor
        places.add(new Place(4, 0, 2));

        // 0,5 sor
        places.add(new Place(0, 0.5, 2));
        places.add(new Place(1, 0.5, 2));
        places.add(new Place(2, 0.5, 2));
        places.add(new Place(3, 0.5, 2));

        places.add(new Place(5, 0.5, 2));
        places.add(new Place(6, 0.5, 2));
        places.add(new Place(7, 0.5, 2));
        places.add(new Place(8, 0.5, 2));

        // 1. sor
        places.add(new Place(4, 1, 2));

        // 2. sor
        places.add(new Place(0, 2, 2));
        places.add(new Place(1, 2, 2));
        places.add(new Place(2, 2, 2));
        places.add(new Place(3, 2, 2));
        places.add(new Place(4, 2, 2));
        places.add(new Place(5, 2, 2));
        places.add(new Place(6, 2, 2));
        places.add(new Place(7, 2, 2));
        places.add(new Place(8, 2, 2));

        // 3. sor
        places.add(new Place(0, 3, 2));
        places.add(new Place(2.5, 3, 2));
        places.add(new Place(5.5, 3, 2));
        places.add(new Place(8, 3, 2));

        // 4. sor
        places.add(new Place(0, 4, 2));
        places.add(new Place(3, 4, 2));
        places.add(new Place(5, 4, 2));
        places.add(new Place(8, 4, 2));

        // 4,5. sor
        places.add(new Place(4, 4.5, 2));

        // 5. sor
        places.add(new Place(0, 5, 2));
        places.add(new Place(8, 5, 2));

        // 5,5. sor
        places.add(new Place(2, 5.5, 2));
        places.add(new Place(3, 5.5, 2));
        places.add(new Place(4, 5.5, 2));
        places.add(new Place(5, 5.5, 2));
        places.add(new Place(6, 5.5, 2));

        // 6. sor
        places.add(new Place(0, 6, 2));

        places.add(new Place(8, 6, 2));

        // 6,5. sor
        places.add(new Place(4, 6.5, 2));


        // 7. sor
        places.add(new Place(0, 7, 2));

        places.add(new Place(2, 7, 2));
        places.add(new Place(3, 7, 2));
        places.add(new Place(5, 7, 2));
        places.add(new Place(6, 7, 2));

        places.add(new Place(8, 7, 2));

        // 7,5. sor
        places.add(new Place(4, 7.5, 2));

        // 8. sor
        places.add(new Place(0, 8, 2));
        places.add(new Place(7.5, 8, 2));

        // 3. réteg
        // 0,5 sor
        places.add(new Place(4, 0.5, 3));

        // 4 sor
        places.add(new Place(4, 4, 3));

        // 7,5 sor
        places.add(new Place(4, 7.5, 3));

        // méret
        layoutWidth = 9;
        layoutHeight = 9;
    }

    public String getName() {
        return "Wind-Nan";
    }

}










