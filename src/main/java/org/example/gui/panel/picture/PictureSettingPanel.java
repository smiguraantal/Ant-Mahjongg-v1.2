package org.example.gui.panel.picture;

import org.example.entity.Background;
import org.example.entity.Constants;
import org.example.gui.dialog.BackgroundDialog;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

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
 * A háttérkép beállításához használt listát és képpanelt tartó panel.
 */
public class PictureSettingPanel extends JPanel implements Constants {

    /**
     * A háttérdialógus, melyen a panel elhelyezkedik
     */
    private BackgroundDialog backgroundDialog;

    /**
     * A háttérképek miniatűrjeit kártyás elrendezésben tartalmazó panel.
     * Azért van rá szükség, mert a listában lépkedve a képeket egyenként
     * betöltve a megjelenítés akadozik. Ha viszont előre betöltjük az összes
     * háttérképet egy-egy panelra, akkor csak azok között kell váltanunk,
     * így a képek megjelenítése is gyorsabb és a listában való mozgás sem
     * akadozik.
     */
    private PictureCardPanel pictureCardPanel = new PictureCardPanel();

    private JList listPictures = new JList(PICTURES);

    GridBagLayout gridBagLayout1 = new GridBagLayout();
    Border border1;
    Border border2;
    BorderLayout borderLayout2 = new BorderLayout();
    JScrollPane scrollPane = new JScrollPane();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();

    //----------------------------------------------------------------------

    /**
     * A képekből készült kártyaként elrendezett panelokat tartalmazó osztály
     */
    class PictureCardPanel extends JPanel {

        /**
         * A képpanelokat tartalmazó tömb
         */
        private PicturePanel[] picturePanels = new PicturePanel[PICTURES.length];

        /**
         * A kártyás elrendezés
         */
        private CardLayout cardLayout = new CardLayout();

        //----------------------------------------------------------------------

        /**
         * Konstruktor
         */
        public PictureCardPanel() {
            setLayout(cardLayout);
            for (int i = 0; i < picturePanels.length; i++) {
                picturePanels[i] = new PicturePanel(PICTURES[i]);
                add(picturePanels[i], PICTURES[i].getName());
            }
        }

        //----------------------------------------------------------------------

        public CardLayout getCardLayout() {
            return cardLayout;
        }
    }

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public PictureSettingPanel(BackgroundDialog backgroundDialog) {
        this.backgroundDialog = backgroundDialog;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        border1 = BorderFactory.createEmptyBorder(0, 5, 5, 5);
        border2 = new EtchedBorder(EtchedBorder.RAISED);
        this.setLayout(gridBagLayout2);
        this.setBorder(border1);
        pictureCardPanel.setBorder(border2);
        scrollPane.setPreferredSize(new Dimension(130, scrollPane.getPreferredSize().height));
        scrollPane.getViewport().add(listPictures, null);
        listPictures.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listPictures.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = listPictures.getSelectedIndex();
                pictureCardPanel.getCardLayout().show(pictureCardPanel, PICTURES[selectedIndex].getName());
            }
        });

        jLabel1.setText("Képek:");
        jLabel2.setText("Nézet:");
        this.add(scrollPane, new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0
                , GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        this.add(pictureCardPanel, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 0, 0), 0, 0));
        this.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 2, 0), 0, 0));
        this.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 2, 0), 0, 0));

        addKeyListening();
    }

    //----------------------------------------------------------------------

    /**
     * Kilépésfigyelés
     */
    private void addKeyListening() {
        Vector components = new Vector();

        components.add(scrollPane.getHorizontalScrollBar());
        components.add(scrollPane.getVerticalScrollBar());
        components.add(listPictures);

        for (int i = 0; i < components.size(); i++) {
            Component component = (Component) components.get(i);
            component.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    keyListening(e);
                }
            });
        }
    }

    //----------------------------------------------------------------------

    /**
     * Escape-re kilépés
     */
    private void keyListening(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            backgroundDialog.hide();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Kiválasztja a listából a kapott háttérrel egyezőt. A kiválasztás
     * előtt viszont kénytelen voltam kijelölni a 0. objektumot, mert ha
     * nincs egyetlen elem sem kijelölve, akkor hasonlításkor nullPointert
     * kapok
     */
    public void selectBackground(Background background) {
        listPictures.setSelectedIndex(0); // e nélkül nem működött !
        listPictures.setSelectedIndex(1); // e nélkül nem működött !
        listPictures.setSelectedValue(background, true);
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a kijelölt háttér objektumot
     */
    public Background getSelectedBackground() {
        return (Background) listPictures.getSelectedValue();
    }
}














