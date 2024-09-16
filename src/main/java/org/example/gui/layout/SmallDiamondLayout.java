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

public class SmallDiamondLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(4, 0, 0));

        // 1. sor
        places.add(new Place(3, 1, 0));
        places.add(new Place(4, 1, 0));
        places.add(new Place(5, 1, 0));

        // 2. sor
        places.add(new Place(2, 2, 0));
        places.add(new Place(3, 2, 0));
        places.add(new Place(4, 2, 0));
        places.add(new Place(5, 2, 0));
        places.add(new Place(6, 2, 0));

        // 3. sor
        places.add(new Place(1, 3, 0));
        places.add(new Place(2, 3, 0));
        places.add(new Place(3, 3, 0));
        places.add(new Place(4, 3, 0));
        places.add(new Place(5, 3, 0));
        places.add(new Place(6, 3, 0));
        places.add(new Place(7, 3, 0));

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

        // 5. sor
        places.add(new Place(1, 5, 0));
        places.add(new Place(2, 5, 0));
        places.add(new Place(3, 5, 0));
        places.add(new Place(4, 5, 0));
        places.add(new Place(5, 5, 0));
        places.add(new Place(6, 5, 0));
        places.add(new Place(7, 5, 0));

        // 6. sor
        places.add(new Place(2, 6, 0));
        places.add(new Place(3, 6, 0));
        places.add(new Place(4, 6, 0));
        places.add(new Place(5, 6, 0));
        places.add(new Place(6, 6, 0));

        // 7. sor
        places.add(new Place(3, 7, 0));
        places.add(new Place(4, 7, 0));
        places.add(new Place(5, 7, 0));

        // 8. sor
        places.add(new Place(4, 8, 0));


        // 1. réteg
        // 1. sor
        places.add(new Place(4, 1, 1));

        // 2. sor
        places.add(new Place(3, 2, 1));
        places.add(new Place(4, 2, 1));
        places.add(new Place(5, 2, 1));

        // 3. sor
        places.add(new Place(2, 3, 1));
        places.add(new Place(3, 3, 1));
        places.add(new Place(4, 3, 1));
        places.add(new Place(5, 3, 1));
        places.add(new Place(6, 3, 1));

        // 4. sor
        places.add(new Place(1, 4, 1));
        places.add(new Place(2, 4, 1));
        places.add(new Place(3, 4, 1));
        places.add(new Place(4, 4, 1));
        places.add(new Place(5, 4, 1));
        places.add(new Place(6, 4, 1));
        places.add(new Place(7, 4, 1));

        // 5. sor
        places.add(new Place(2, 5, 1));
        places.add(new Place(3, 5, 1));
        places.add(new Place(4, 5, 1));
        places.add(new Place(5, 5, 1));
        places.add(new Place(6, 5, 1));

        // 6. sor
        places.add(new Place(3, 6, 1));
        places.add(new Place(4, 6, 1));
        places.add(new Place(5, 6, 1));

        // 7. sor
        places.add(new Place(4, 7, 1));


        // 2. réteg
        // 2. sor
        places.add(new Place(4, 2, 2));

        // 3. sor
        places.add(new Place(3, 3, 2));
        places.add(new Place(4, 3, 2));
        places.add(new Place(5, 3, 2));

        // 4. sor
        places.add(new Place(2, 4, 2));
        places.add(new Place(3, 4, 2));
        places.add(new Place(4, 4, 2));
        places.add(new Place(5, 4, 2));
        places.add(new Place(6, 4, 2));

        // 5. sor
        places.add(new Place(3, 5, 2));
        places.add(new Place(4, 5, 2));
        places.add(new Place(5, 5, 2));

        // 6. sor
        places.add(new Place(4, 6, 2));

        // 3. réteg
        // 3. sor
        places.add(new Place(4, 3, 3));

        // 4. sor
        places.add(new Place(3, 4, 3));
        places.add(new Place(4, 4, 3));
        places.add(new Place(5, 4, 3));

        // 5. sor
        places.add(new Place(4, 5, 3));

        // méret
        layoutWidth = 9;
        layoutHeight = 9;
    }

    public String getName() {
        return "Small Diamond";
    }

}
