package org.example.gui.layout;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;

/**
 * <p>Title: Ant-Mahjongg</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004-2005</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.2
 */

/**
 * A túl nagy elemszámú menüt úgy vágja el, hogy a menütételek abc sorrendben
 * felülről lefelé helyezkedjenek el
 */
public class MenuLayout extends GridLayout {

    /**
     * Konstruktor
     */
    public MenuLayout(int rows, int cols) {
        super(rows, cols);
    }

    //----------------------------------------------------------------------

    /**
     * Elrendezi az elemeket
     */
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            Insets insets = parent.getInsets();
            int ncomponents = parent.getComponentCount();
            int nrows = getRows();
            int ncols = getColumns();
            boolean ltr = parent.getComponentOrientation().isLeftToRight();

            if (ncomponents == 0) {
                return;
            }
            if (nrows > 0) {
                ncols = (ncomponents + nrows - 1) / nrows;
            } else {
                nrows = (ncomponents + ncols - 1) / ncols;
            }
            int w = parent.getWidth() - (insets.left + insets.right);
            int h = parent.getHeight() - (insets.top + insets.bottom);
            w = (w - (ncols - 1) * getHgap()) / ncols;
            h = (h - (nrows - 1) * getVgap()) / nrows;
            // nincs left to right, és nincs right to left feltétel
            for (int c = 0, x = insets.left; c < ncols; c++, x += w + getHgap()) {
                for (int r = 0, y = insets.top; r < nrows; r++, y += h + getVgap()) {
                    int i = c * nrows + r; // ez módosult
                    if (i < ncomponents) {
                        parent.getComponent(i).setBounds(x, y, w, h);
                    }
                }
            }
        }
    }
}











