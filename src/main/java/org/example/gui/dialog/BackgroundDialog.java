package org.example.gui.dialog;

import org.example.entity.Background;
import org.example.entity.BackgroundProperties;
import org.example.entity.ColorTheme;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Gradient;
import org.example.gui.MainFrame;
import org.example.gui.WindowLocation;
import org.example.gui.panel.gradient.GradientSettingPanel;
import org.example.gui.panel.picture.PictureSettingPanel;
import org.example.gui.panel.texture.TextureSettingPanel;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
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
 * A háttér beállításához használt dialógusablak, melyen háttérként egy
 * képek, egy textúrát, vagy egy kitöltési effektust lehet választani.
 * Megjelenésekor mindig az aktuálisan beállított háttérhez tartozó fülespanel
 * lesz kiválasztva.
 */
public class BackgroundDialog extends JDialog implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A fülespanel, melyen a képbeállítás panel, a textúrabeállítás panel,
     * illetve a kitöltési effektus beállításához használt panel van
     * elhelyezve.
     */
    private JTabbedPane tabbedPane = new JTabbedPane();

    /**
     * A kép kiválasztásához használt panel
     */
    private PictureSettingPanel pictureSettingPanel = new PictureSettingPanel(this);

    /**
     * A textúra beállításához használt panel
     */
    private TextureSettingPanel textureSettingPanel = new TextureSettingPanel(this);

    /**
     * A kitöltési effektusok beállításához használt panel
     */
    private GradientSettingPanel gradientSettingPanel = new GradientSettingPanel(this);

    /**
     * A háttérre vonatkozó beállításokat tartalmazó tulajdonságok
     * összessége
     */
    private BackgroundProperties backgroundProperties;

    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JButton btCancel = new JButton();
    JButton btSave = new JButton();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public BackgroundDialog(MainFrame mainFrame) {
        super(mainFrame, "Háttér beállítása", true);
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        setResizable(false);
        btCancel.setText("Mégse");
        btCancel.addActionListener(new BackgroundDialog_btCancel_actionAdapter(this));
        btSave.setText("Mentés");
        btSave.addActionListener(new BackgroundDialog_btSave_actionAdapter(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        this.getContentPane().add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(btSave, null);
        jPanel1.add(btCancel, null);

        tabbedPane.addTab("Képek", pictureSettingPanel);
        tabbedPane.addTab("Textúrák", textureSettingPanel);
        tabbedPane.addTab("Kitöltési effektusok", gradientSettingPanel);

        addKeyListening();
    }

    //----------------------------------------------------------------------

    /**
     * Megjeleníti a dialógust
     */
    public BackgroundProperties showDialog(BackgroundProperties backgroundProperties) {
        this.backgroundProperties = backgroundProperties;

        tabbedPane.setSelectedIndex(backgroundProperties.getBackgroundType());
        pictureSettingPanel.selectBackground(backgroundProperties.getPictureBackground());
        textureSettingPanel.selectBackground(backgroundProperties.getTextureBackground());
        gradientSettingPanel.selectColorTheme(backgroundProperties.getColorTheme());
        gradientSettingPanel.selectGradient(backgroundProperties.getGradient());

        new WindowLocation(this, WindowLocation.CENTER);
        dataModule.setDialogShowing(true);
        show();
        dataModule.setDialogShowing(false);

        return this.backgroundProperties;
    }

    //----------------------------------------------------------------------

    /**
     * Kilépésfigyelés
     */
    private void addKeyListening() {
        Vector components = new Vector();

        components.add(tabbedPane);
        components.add(btSave);
        components.add(btCancel);

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
            hide();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Mentéskor a háttér tulajdonságait tároló objektum felveszi a dialóguson
     * lévő összes beállítás értékeit. Legközelebbi megjelenésekor ezen értékek
     * szerint lesznek beállítva a komponensei.
     */
    void btSave_actionPerformed(ActionEvent e) {
        int backgroundType = tabbedPane.getSelectedIndex();
        Background picturePath = pictureSettingPanel.getSelectedBackground();
        Background textureImagePath = textureSettingPanel.getSelectedBackground();
        Gradient gradient = gradientSettingPanel.getSelectedGradient();
        ColorTheme colorTheme = gradientSettingPanel.getSelectedColorTheme();

        this.backgroundProperties =
                new BackgroundProperties(backgroundType,
                        picturePath,
                        textureImagePath,
                        gradient,
                        colorTheme);
        hide();
    }

    //----------------------------------------------------------------------

    /**
     * Kilépés mentés nélkül
     */
    void btCancel_actionPerformed(ActionEvent e) {
        hide();
    }
}

class BackgroundDialog_btSave_actionAdapter implements java.awt.event.ActionListener {
    BackgroundDialog adaptee;

    BackgroundDialog_btSave_actionAdapter(BackgroundDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btSave_actionPerformed(e);
    }
}

class BackgroundDialog_btCancel_actionAdapter implements java.awt.event.ActionListener {
    BackgroundDialog adaptee;

    BackgroundDialog_btCancel_actionAdapter(BackgroundDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.btCancel_actionPerformed(e);
    }
}









