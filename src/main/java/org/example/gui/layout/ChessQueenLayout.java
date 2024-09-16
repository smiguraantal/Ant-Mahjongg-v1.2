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

public class ChessQueenLayout extends Layout {

    public void init() {
        // 0. réteg
        // 0. sor
        places.add(new Place(0, 0, 0));
        places.add(new Place(2.5, 0, 0));
        places.add(new Place(5.5, 0, 0));
        places.add(new Place(8.5, 0, 0));
        places.add(new Place(11, 0, 0));

        // 1. sor
        places.add(new Place(0.5, 1, 0));
        places.add(new Place(3, 1, 0));
        places.add(new Place(5.5, 1, 0));
        places.add(new Place(8, 1, 0));
        places.add(new Place(10.5, 1, 0));

        // 2. sor
        places.add(new Place(1, 2, 0));
        places.add(new Place(3.5, 2, 0));
        places.add(new Place(5.5, 2, 0));
        places.add(new Place(7.5, 2, 0));
        places.add(new Place(10, 2, 0));

        // 3. sor
        places.add(new Place(1.5, 3, 0));
        places.add(new Place(2.5, 3, 0));
        places.add(new Place(3.5, 3, 0));
        places.add(new Place(4.5, 3, 0));
        places.add(new Place(5.5, 3, 0));
        places.add(new Place(6.5, 3, 0));
        places.add(new Place(7.5, 3, 0));
        places.add(new Place(8.5, 3, 0));
        places.add(new Place(9.5, 3, 0));

        // 4. sor
        places.add(new Place(1.5, 4, 0));
        places.add(new Place(2.5, 4, 0));
        places.add(new Place(3.5, 4, 0));
        places.add(new Place(4.5, 4, 0));
        places.add(new Place(5.5, 4, 0));
        places.add(new Place(6.5, 4, 0));
        places.add(new Place(7.5, 4, 0));
        places.add(new Place(8.5, 4, 0));
        places.add(new Place(9.5, 4, 0));

        // 5. sor
        places.add(new Place(2.5, 5, 0));
        places.add(new Place(3.5, 5, 0));
        places.add(new Place(4.5, 5, 0));
        places.add(new Place(5.5, 5, 0));
        places.add(new Place(6.5, 5, 0));
        places.add(new Place(7.5, 5, 0));
        places.add(new Place(8.5, 5, 0));

        // 6. sor
        places.add(new Place(2.5, 6, 0));
        places.add(new Place(3.5, 6, 0));
        places.add(new Place(4.5, 6, 0));
        places.add(new Place(5.5, 6, 0));
        places.add(new Place(6.5, 6, 0));
        places.add(new Place(7.5, 6, 0));
        places.add(new Place(8.5, 6, 0));

        // 1. réteg
        // 0. sor
        places.add(new Place(0, 0, 1));
        places.add(new Place(2.5, 0, 1));
        places.add(new Place(5.5, 0, 1));
        places.add(new Place(8.5, 0, 1));
        places.add(new Place(11, 0, 1));

        // 1. sor
        places.add(new Place(0.5, 1, 1));
        places.add(new Place(3, 1, 1));
        places.add(new Place(5.5, 1, 1));
        places.add(new Place(8, 1, 1));
        places.add(new Place(10.5, 1, 1));

        // 2. sor
        places.add(new Place(1, 2, 1));
        places.add(new Place(3.5, 2, 1));
        places.add(new Place(5.5, 2, 1));
        places.add(new Place(7.5, 2, 1));
        places.add(new Place(10, 2, 1));

        // 3. sor
        places.add(new Place(1.5, 3, 1));
        places.add(new Place(3.5, 3, 1));
        places.add(new Place(5.5, 3, 1));
        places.add(new Place(7.5, 3, 1));
        places.add(new Place(9.5, 3, 1));

        // 4. sor
        places.add(new Place(1.5, 4, 1));
        places.add(new Place(2.5, 4, 1));
        places.add(new Place(3.5, 4, 1));
        places.add(new Place(4.5, 4, 1));
        places.add(new Place(5.5, 4, 1));
        places.add(new Place(6.5, 4, 1));
        places.add(new Place(7.5, 4, 1));
        places.add(new Place(8.5, 4, 1));
        places.add(new Place(9.5, 4, 1));

        // 5. sor
        places.add(new Place(2.5, 5, 1));
        places.add(new Place(3.5, 5, 1));
        places.add(new Place(4.5, 5, 1));
        places.add(new Place(5.5, 5, 1));
        places.add(new Place(6.5, 5, 1));
        places.add(new Place(7.5, 5, 1));
        places.add(new Place(8.5, 5, 1));

        // 6. sor
        places.add(new Place(2.5, 6, 1));
        places.add(new Place(3.5, 6, 1));
        places.add(new Place(4.5, 6, 1));
        places.add(new Place(5.5, 6, 1));
        places.add(new Place(6.5, 6, 1));
        places.add(new Place(7.5, 6, 1));
        places.add(new Place(8.5, 6, 1));

        // 2. réteg
        // 0. sor
        places.add(new Place(0, 0, 2));
        places.add(new Place(2.5, 0, 2));
        places.add(new Place(5.5, 0, 2));
        places.add(new Place(8.5, 0, 2));
        places.add(new Place(11, 0, 2));

        // 1. sor
        places.add(new Place(0.5, 1, 2));
        places.add(new Place(3, 1, 2));
        places.add(new Place(5.5, 1, 2));
        places.add(new Place(8, 1, 2));
        places.add(new Place(10.5, 1, 2));

        // 2. sor
        places.add(new Place(1, 2, 2));
        places.add(new Place(3.5, 2, 2));
        places.add(new Place(5.5, 2, 2));
        places.add(new Place(7.5, 2, 2));
        places.add(new Place(10, 2, 2));

        // 3. sor
        places.add(new Place(1.5, 3, 2));
        places.add(new Place(3.5, 3, 2));
        places.add(new Place(5.5, 3, 2));
        places.add(new Place(7.5, 3, 2));
        places.add(new Place(9.5, 3, 2));

        // 4. sor
        places.add(new Place(2.5, 4, 2));
        places.add(new Place(3.5, 4, 2));
        places.add(new Place(4.5, 4, 2));
        places.add(new Place(5.5, 4, 2));
        places.add(new Place(6.5, 4, 2));
        places.add(new Place(7.5, 4, 2));
        places.add(new Place(8.5, 4, 2));

        // 5. sor
        places.add(new Place(3.5, 5, 2));
        places.add(new Place(5.5, 5, 2));
        places.add(new Place(7.5, 5, 2));

        // 6. sor
        places.add(new Place(3.5, 6, 2));
        places.add(new Place(4.5, 6, 2));
        places.add(new Place(5.5, 6, 2));
        places.add(new Place(6.5, 6, 2));
        places.add(new Place(7.5, 6, 2));

        // 3. réteg
        // 3. sor
        places.add(new Place(1.5, 3, 3));
        places.add(new Place(3.5, 3, 3));
        places.add(new Place(5.5, 3, 3));
        places.add(new Place(7.5, 3, 3));
        places.add(new Place(9.5, 3, 3));

        // 4. sor
        places.add(new Place(2.5, 4, 3));
        places.add(new Place(3.5, 4, 3));
        places.add(new Place(4.5, 4, 3));
        places.add(new Place(5.5, 4, 3));
        places.add(new Place(6.5, 4, 3));
        places.add(new Place(7.5, 4, 3));
        places.add(new Place(8.5, 4, 3));

        // 5. sor
        places.add(new Place(3.5, 5, 3));
        places.add(new Place(7.5, 5, 3));

        // 6. sor
        places.add(new Place(3.5, 6, 3));
        places.add(new Place(4.5, 6, 3));
        places.add(new Place(5.5, 6, 3));
        places.add(new Place(6.5, 6, 3));
        places.add(new Place(7.5, 6, 3));

        // méret
        layoutWidth = 12; // ha szimmetrikus, akkor 12 (az eredetin nem szimmetrikus, ott csak 11,5)
        layoutHeight = 7;
    }

    public String getName() {
        return "Chess-Queen";
    }

}