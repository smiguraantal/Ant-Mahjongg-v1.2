package org.example.gui.panel.texture;

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
import java.awt.Color;
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
 * A textúra beállításához használt listát és textúrapanel tartó panel.
 */
public class TextureSettingPanel extends JPanel implements Constants {

    /**
     * A háttérdialógus, melyen a panel elhelyezkedik
     */
    private BackgroundDialog backgroundDialog;

    /**
     * A textúrapanel
     */
    private TexturePanel texturePanel = new TexturePanel();

    private JList listTextures = new JList(TEXTURES);

    Border border1;
    Border border2;
    JScrollPane scrollPane = new JScrollPane();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TextureSettingPanel(BackgroundDialog backgroundDialog) {
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
        border2 = new EtchedBorder(EtchedBorder.RAISED, Color.white, new Color(148, 145, 140));
        this.setLayout(gridBagLayout1);
        this.setBorder(border1);
        texturePanel.setBorder(border2);
        scrollPane.setPreferredSize(new Dimension(130, scrollPane.getPreferredSize().height));

        jLabel1.setText("Textúrák:");
        jLabel2.setText("Nézet:");
        scrollPane.getViewport().add(listTextures, null);
        this.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 2, 0), 0, 0));
        this.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 2, 0), 0, 0));
        this.add(scrollPane, new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0
                , GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        this.add(texturePanel, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 0, 0), 0, 0));

        listTextures.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listTextures.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                texturePanel.loadImage(getSelectedBackground().getPath());
                texturePanel.repaint();
            }
        });

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
        components.add(listTextures);

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
     * Visszaadja a listán kiválasztott textúrát, mint háttér objektum
     */
    public Background getSelectedBackground() {
        return (Background) listTextures.getSelectedValue();
    }

    //----------------------------------------------------------------------

    /**
     * Kiválasztja a listából a kapott háttérrel egyezőt. A kiválasztás
     * előtt viszont kénytelen voltam kijelölni a 0. objektumot, mert ha
     * nincs egyetlen elem sem kijelölve, akkor hasonlításkor nullPointert
     * kapok
     */
    public void selectBackground(Background background) {
        listTextures.setSelectedIndex(0); // e nélkül nem működött !! ??
        listTextures.setSelectedValue(background, true);
    }
}















