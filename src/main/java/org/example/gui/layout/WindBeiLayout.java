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

public class WindBeiLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(4, 0, 0));
        places.add(new Place(5.5, 0, 0));

        // 1. sor
        places.add(new Place(4, 1, 0));
        places.add(new Place(5.5, 1, 0));

        places.add(new Place(10.5, 1, 0));

        // 1,5. sor
        places.add(new Place(0, 1.5, 0));
        places.add(new Place(1, 1.5, 0));
        places.add(new Place(9.5, 1.5, 0));

        // 2. sor
        places.add(new Place(2, 2, 0));
        places.add(new Place(3, 2, 0));

        places.add(new Place(4, 2, 0));
        places.add(new Place(5.5, 2, 0));

        places.add(new Place(8.5, 2, 0));

        // 2,5. sor
        places.add(new Place(7.5, 2.5, 0));
        places.add(new Place(6.5, 2.5, 0));

        // 3. sor
        places.add(new Place(4, 3, 0));
        places.add(new Place(5.5, 3, 0));

        // 4. sor
        places.add(new Place(4, 4, 0));
        places.add(new Place(5.5, 4, 0));

        // 5. sor
        places.add(new Place(3, 5, 0));

        places.add(new Place(4, 5, 0));
        places.add(new Place(5.5, 5, 0));

        places.add(new Place(10.5, 5, 0));

        // 5,5. sor
        places.add(new Place(2, 5.5, 0));

        // 6. sor
        places.add(new Place(1, 6, 0));

        places.add(new Place(4, 6, 0));
        places.add(new Place(6, 6, 0));

        places.add(new Place(10, 6, 0));

        // 6,5. sor
        places.add(new Place(0, 6.5, 0));

        // 7. sor
        places.add(new Place(4, 7, 0));

        places.add(new Place(6.5, 7, 0));
        places.add(new Place(7.5, 7, 0));
        places.add(new Place(8.5, 7, 0));
        places.add(new Place(9.5, 7, 0));

        // 1. réteg
        // 0. sor
        places.add(new Place(4, 0, 1));
        places.add(new Place(5.5, 0, 1));

        // 1. sor
        places.add(new Place(4, 1, 1));
        places.add(new Place(5.5, 1, 1));

        places.add(new Place(10.5, 1, 1));

        // 1,5. sor
        places.add(new Place(0, 1.5, 1));
        places.add(new Place(1, 1.5, 1));
        places.add(new Place(9.5, 1.5, 1));

        // 2. sor
        places.add(new Place(2, 2, 1));
        places.add(new Place(3, 2, 1));

        places.add(new Place(4, 2, 1));
        places.add(new Place(5.5, 2, 1));

        places.add(new Place(8.5, 2, 1));

        // 2,5. sor
        places.add(new Place(7.5, 2.5, 1));
        places.add(new Place(6.5, 2.5, 1));

        // 3. sor
        places.add(new Place(4, 3, 1));
        places.add(new Place(5.5, 3, 1));

        // 4. sor
        places.add(new Place(4, 4, 1));
        places.add(new Place(5.5, 4, 1));

        // 5. sor
        places.add(new Place(3, 5, 1));

        places.add(new Place(4, 5, 1));
        places.add(new Place(5.5, 5, 1));

        places.add(new Place(10.5, 5, 1));

        // 5,5. sor
        places.add(new Place(2, 5.5, 1));

        // 6. sor
        places.add(new Place(1, 6, 1));

        places.add(new Place(4, 6, 1));
        places.add(new Place(6, 6, 1));

        places.add(new Place(10, 6, 1));

        // 6,5. sor
        places.add(new Place(0, 6.5, 1));

        // 7. sor
        places.add(new Place(4, 7, 1));

        places.add(new Place(6.5, 7, 1));
        places.add(new Place(7.5, 7, 1));
        places.add(new Place(8.5, 7, 1));
        places.add(new Place(9.5, 7, 1));

        // 2. réteg
        // 0. sor
        places.add(new Place(4, 0, 2));
        places.add(new Place(5.5, 0, 2));

        // 1. sor
        places.add(new Place(4, 1, 2));
        places.add(new Place(5.5, 1, 2));

        places.add(new Place(10.5, 1, 2));

        // 1,5. sor
        places.add(new Place(0, 1.5, 2));
        places.add(new Place(1, 1.5, 2));
        places.add(new Place(9.5, 1.5, 2));

        // 2. sor
        places.add(new Place(2, 2, 2));
        places.add(new Place(3, 2, 2));

        places.add(new Place(4, 2, 2));
        places.add(new Place(5.5, 2, 2));

        places.add(new Place(8.5, 2, 2));

        // 2,5. sor
        places.add(new Place(7.5, 2.5, 2));
        places.add(new Place(6.5, 2.5, 2));

        // 3. sor
        places.add(new Place(4, 3, 2));
        places.add(new Place(5.5, 3, 2));

        // 4. sor
        places.add(new Place(4, 4, 2));
        places.add(new Place(5.5, 4, 2));

        // 5. sor
        places.add(new Place(3, 5, 2));

        places.add(new Place(4, 5, 2));
        places.add(new Place(5.5, 5, 2));

        places.add(new Place(10.5, 5, 2));

        // 5,5. sor
        places.add(new Place(2, 5.5, 2));

        // 6. sor
        places.add(new Place(1, 6, 2));

        places.add(new Place(4, 6, 2));
        places.add(new Place(6, 6, 2));

        places.add(new Place(10, 6, 2));

        // 6,5. sor
        places.add(new Place(0, 6.5, 2));

        // 7. sor
        places.add(new Place(4, 7, 2));

        places.add(new Place(6.5, 7, 2));
        places.add(new Place(7.5, 7, 2));
        places.add(new Place(8.5, 7, 2));
        places.add(new Place(9.5, 7, 2));

        // 3. réteg
        // 0. sor
        places.add(new Place(4, 0, 3));
        places.add(new Place(5.5, 0, 3));

        // 1. sor
        places.add(new Place(4, 1, 3));
        places.add(new Place(5.5, 1, 3));

        places.add(new Place(10.5, 1, 3));

        // 1,5. sor
        places.add(new Place(0, 1.5, 3));
        places.add(new Place(1, 1.5, 3));
        places.add(new Place(9.5, 1.5, 3));

        // 2. sor
        places.add(new Place(2, 2, 3));
        places.add(new Place(3, 2, 3));

        places.add(new Place(4, 2, 3));
        places.add(new Place(5.5, 2, 3));

        places.add(new Place(8.5, 2, 3));

        // 2,5. sor
        places.add(new Place(7.5, 2.5, 3));
        places.add(new Place(6.5, 2.5, 3));

        // 3. sor
        places.add(new Place(4, 3, 3));
        places.add(new Place(5.5, 3, 3));

        // 4. sor
        places.add(new Place(4, 4, 3));
        places.add(new Place(5.5, 4, 3));

        // 5. sor
        places.add(new Place(3, 5, 3));

        places.add(new Place(4, 5, 3));
        places.add(new Place(5.5, 5, 3));

        places.add(new Place(10.5, 5, 3));

        // 5,5. sor
        places.add(new Place(2, 5.5, 3));

        // 6. sor
        places.add(new Place(1, 6, 3));

        places.add(new Place(4, 6, 3));
        places.add(new Place(6, 6, 3));

        places.add(new Place(10, 6, 3));

        // 6,5. sor
        places.add(new Place(0, 6.5, 3));

        // 7. sor
        places.add(new Place(4, 7, 3));

        places.add(new Place(6.5, 7, 3));
        places.add(new Place(7.5, 7, 3));
        places.add(new Place(8.5, 7, 3));
        places.add(new Place(9.5, 7, 3));

        // 4. réteg
        // 0. sor
        places.add(new Place(4, 0, 4));
        places.add(new Place(5.5, 0, 4));

        // 1. sor
        places.add(new Place(10.5, 1, 4));

        // 1,5. sor
        places.add(new Place(0, 1.5, 4));

        // 2,5. sor
        places.add(new Place(5.5, 2.5, 4));

        // 5. sor
        places.add(new Place(10.5, 5, 4));

        // 6,5. sor
        places.add(new Place(0, 6.5, 4));

        // 7. sor
        places.add(new Place(4, 7, 4));

        // méret
        layoutWidth = 11.5;
        layoutHeight = 8;
    }

    public String getName() {
        return "Wind-Bei";
    }

}
