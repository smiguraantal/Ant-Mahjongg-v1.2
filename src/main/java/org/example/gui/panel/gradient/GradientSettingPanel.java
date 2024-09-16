package org.example.gui.panel.gradient;

import org.example.entity.ColorTheme;
import org.example.entity.Constants;
import org.example.entity.Gradient;
import org.example.gui.dialog.BackgroundDialog;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
 * A kitöltési effektusok beállításához használt panel. Ezen helyezkednek el
 * a miniatűrök és a színséma listája.
 */
public class GradientSettingPanel extends JPanel implements Constants {

    /**
     * A háttérdialógus, melyen a panel elhelyezkedik
     */
    private BackgroundDialog backgroundDialog;

    /**
     * Miniatűr kitöltési effektusok egy-egy panelon
     */
    private GradientPanel gradientPanel_01 =
            new GradientPanel(this, GRADIENT_01);

    private GradientPanel gradientPanel_02 =
            new GradientPanel(this, GRADIENT_02);

    private GradientPanel gradientPanel_03 =
            new GradientPanel(this, GRADIENT_03);

    private GradientPanel gradientPanel_04 =
            new GradientPanel(this, GRADIENT_04);

    private GradientPanel gradientPanel_05 =
            new GradientPanel(this, GRADIENT_05);

    private GradientPanel gradientPanel_06 =
            new GradientPanel(this, GRADIENT_06);

    private GradientPanel gradientPanel_07 =
            new GradientPanel(this, GRADIENT_07);

    private GradientPanel gradientPanel_08 =
            new GradientPanel(this, GRADIENT_08);

    /**
     * A miniatűröket összefoglaló vektor
     */
    private Vector gradientPanels = new Vector();

    private JList listColorThemes = new JList(COLOR_THEMES);

    GridLayout gridLayout1 = new GridLayout();
    Border border1;
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JScrollPane scrollPane = new JScrollPane();
    Border border2;
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public GradientSettingPanel(BackgroundDialog backgroundDialog) {
        this.backgroundDialog = backgroundDialog;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        border1 = BorderFactory.createEmptyBorder(0, 3, 0, 2);
        border2 = BorderFactory.createEmptyBorder(0, 5, 5, 0);
        this.setLayout(gridBagLayout1);

        gridLayout1.setColumns(4);
        gridLayout1.setRows(2);

        scrollPane.setPreferredSize(new Dimension(130, scrollPane.getPreferredSize().height));
        this.setBorder(border2);
        jLabel1.setText("Színsémák:");
        jLabel2.setText("Nézet:");
        gradientPanels.add(gradientPanel_01);
        gradientPanels.add(gradientPanel_02);
        gradientPanels.add(gradientPanel_03);
        gradientPanels.add(gradientPanel_04);
        gradientPanels.add(gradientPanel_05);
        gradientPanels.add(gradientPanel_06);
        gradientPanels.add(gradientPanel_07);
        gradientPanels.add(gradientPanel_08);

        scrollPane.setPreferredSize(new Dimension(130, scrollPane.getPreferredSize().height));

        this.add(jPanel2, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        jPanel2.setLayout(gridLayout1);

        jPanel2.add(gradientPanel_01, null);
        jPanel2.add(gradientPanel_02, null);
        jPanel2.add(gradientPanel_06, null);
        jPanel2.add(gradientPanel_07, null);
        jPanel2.add(gradientPanel_03, null);
        jPanel2.add(gradientPanel_04, null);
        jPanel2.add(gradientPanel_08, null);
        jPanel2.add(gradientPanel_05, null);
        this.add(scrollPane, new GridBagConstraints(0, 1, 1, 1, 0.0, 1.0
                , GridBagConstraints.WEST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 2, 0), 0, 0));
        this.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 9, 2, 0), 0, 0));
        scrollPane.getViewport().add(listColorThemes, null);

        jPanel2.setBorder(border1);

        listColorThemes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listColorThemes.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                for (int i = 0; i < gradientPanels.size(); i++) {
                    GradientPanel gradientPanel = (GradientPanel) gradientPanels.get(i);
                    gradientPanel.getGradient().setColorTheme(getSelectedColorTheme());
                    gradientPanel.repaint();
                }
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
        components.add(listColorThemes);

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
     * Egyenként megvizsgálja a panelok gradient-jét és amelyik egyezik a
     * kapott objektummal azt kijelölté teszi. Az összes panel újrarajzolása
     * után a kijelölt lesz keretezve.
     */
    public void selectGradient(Gradient selectedGradient) {
        for (int i = 0; i < gradientPanels.size(); i++) {
            GradientPanel gradientPanel = (GradientPanel) gradientPanels.get(i);
            gradientPanel.setSelected(selectedGradient.equals(gradientPanel.getGradient()));
            gradientPanel.repaint();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Kiválasztja a listából a kapott színsémával egyezőt. A kiválasztás
     * előtt viszont kénytelen voltam kijelölni a 0. objektumot, mert ha
     * nincs egyetlen elem sem kijelölve, akkor hasonlításkor nullPointert
     * kapok
     */
    public void selectColorTheme(ColorTheme colorTheme) {
        listColorThemes.setSelectedIndex(0); // e nélkül nem működött !! ??
        listColorThemes.setSelectedValue(colorTheme, true);
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a kijelölt panel gradient objektumát
     */
    public Gradient getSelectedGradient() {
        for (int i = 0; i < gradientPanels.size(); i++) {
            GradientPanel gradientPanel = (GradientPanel) gradientPanels.get(i);
            if (gradientPanel.isSelected())
                return gradientPanel.getGradient();
        }
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a kijelölt színsémát
     */
    public ColorTheme getSelectedColorTheme() {
        return (ColorTheme) listColorThemes.getSelectedValue();
    }
}









