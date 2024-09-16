package org.example.gui;

import org.example.entity.DataModule;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
 * Érzékennyé teszi a kapott menüket az egérmozgásra, mikoris az állapotsorban
 * kell megjelennie a parancsszövegüknek
 */
public class Sensitive {

    /**
     * Az egéresemények és a menük eltűnése befolyásolja az állapotsor
     * szövegét
     */
    public static void takeSensitive(JMenuItem menuItem) {
        final JLabel label = DataModule.getDataModule().getStatusLabel();
        final JMenuItem mi = menuItem;
        final JPopupMenu parent = (JPopupMenu) mi.getParent();

        mi.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                label.setText(mi.getActionCommand());
            }

            public void mouseExited(MouseEvent e) {
                label.setText(" ");
            }

            public void mouseClicked(MouseEvent e) {
                label.setText(" ");
            }

            public void mouseReleased(MouseEvent e) {
                label.setText(" ");
            }
        });


        if (parent != null) {  // csak ha van őse
            parent.addPopupMenuListener(new PopupMenuListener() {
                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                }

                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                    label.setText(" ");
                }

                public void popupMenuCanceled(PopupMenuEvent e) {
                }
            });
        }

    }
}
