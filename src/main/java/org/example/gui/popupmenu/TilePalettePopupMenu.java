package org.example.gui.popupmenu;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Location;
import org.example.entity.Orientation;
import org.example.entity.TilePaletteProperty;
import org.example.gui.Sensitive;
import org.example.gui.TilePalette;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Component;
import java.awt.event.ActionEvent;

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
 * A kőpaletta helyi menüje
 */
public class TilePalettePopupMenu extends JPopupMenu
        implements Location, Orientation, Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A kőpaletta
     */
    private TilePalette tilePalette;

    ButtonGroup bgOrientation = new ButtonGroup();
    ButtonGroup bgLocation = new ButtonGroup();
    ButtonGroup bgInfo = new ButtonGroup();
    ButtonGroup bgGap = new ButtonGroup();

    JMenu mOrientation = new JMenu();
    JMenu mLocation = new JMenu();
    JMenu mGap = new JMenu();
    JMenu mInfo = new JMenu();
    JMenuItem miHide = new JMenuItem();

    JRadioButtonMenuItem miHorizontal = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miVertical = new JRadioButtonMenuItem();

    JRadioButtonMenuItem miNorthWest = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miNorth = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miNorthEast = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miWest = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miCenter = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miEast = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSouthWest = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSouth = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miSouthEast = new JRadioButtonMenuItem();

    JRadioButtonMenuItem miGap_10 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miGap_20 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miGap_30 = new JRadioButtonMenuItem();

    JRadioButtonMenuItem miSelectable = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miPair = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miAllTop = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miAll = new JRadioButtonMenuItem();
    JCheckBoxMenuItem miShowUnderTiles = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miTDE = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miNonSkid = new JCheckBoxMenuItem();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TilePalettePopupMenu(TilePalette tilePalette) {
        this.tilePalette = tilePalette;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        miTDE.setActionCommand("A kövek három dimenziós megjelenítésének engedélyezése / tiltása");
        miGap_30.setActionCommand("30 képernyőpont");
        miGap_20.setActionCommand("20 képernyőpont");
        miGap_10.setActionCommand("10 képernyőpont");
        miShowUnderTiles.setActionCommand("A közvetlenül alatta elhelyezkedő köveket is jelenítse meg");
        miAll.setActionCommand("Mindegyik követ jelenítse meg");
        miAllTop.setActionCommand("Az összes felül lévő követ jelenítse meg");
        miPair.setActionCommand("Csak azokat a köveket jelenítse meg, melyek párjukkal együtt levehetők");
        miSelectable.setActionCommand("Csak a kijelölhető köveket jelenítse meg");
        miHorizontal.setText("Vízszintes");
        miHorizontal.addActionListener(new TilePalettePopupMenu_miHorizontal_actionAdapter(this));
        miVertical.setText("Függőleges");
        miVertical.addActionListener(new TilePalettePopupMenu_miVertical_actionAdapter(this));
        miNorthWest.setText("Bal-felső sarok");
        miNorthWest.addActionListener(new TilePalettePopupMenu_miNorthWest_actionAdapter(this));
        miNorth.setText("Fent");
        miNorth.addActionListener(new TilePalettePopupMenu_miNorth_actionAdapter(this));
        miNorthEast.setText("Jobb-felső sarok");
        miNorthEast.addActionListener(new TilePalettePopupMenu_miNorthEast_actionAdapter(this));
        miWest.setText("Bal oldal");
        miWest.addActionListener(new TilePalettePopupMenu_miWest_actionAdapter(this));
        miCenter.setText("Közép");
        miCenter.addActionListener(new TilePalettePopupMenu_miCenter_actionAdapter(this));
        miEast.setText("Jobb oldal");
        miEast.addActionListener(new TilePalettePopupMenu_miEast_actionAdapter(this));
        miSouthWest.setText("Bal-alsó sarok");
        miSouthWest.addActionListener(new TilePalettePopupMenu_miSouthWest_actionAdapter(this));
        miSouth.setText("Lent");
        miSouth.addActionListener(new TilePalettePopupMenu_miSouth_actionAdapter(this));
        miSouthEast.setText("Jobb-aló sarok");
        miSouthEast.addActionListener(new TilePalettePopupMenu_miSouthEast_actionAdapter(this));
        mOrientation.setActionCommand("Vízszintes illetve függőleges irányú fekvés kiválasztása");
        mOrientation.setText("Fekvés");
        mLocation.setActionCommand("A kőpaletta égtáj szerinti elhelyezése");
        mLocation.setText("Pozíció");
        mGap.setActionCommand("A kőpaletta távolsága a játékterület szélétől");
        mGap.setText("Távolság");
        miGap_30.setText("30");
        miGap_30.addActionListener(new TilePalettePopupMenu_miGap_30_actionAdapter(this));
        miGap_10.setText("10");
        miGap_10.addActionListener(new TilePalettePopupMenu_miGap_10_actionAdapter(this));
        miGap_20.setText("20");
        miGap_20.addActionListener(new TilePalettePopupMenu_miGap_20_actionAdapter(this));
        miHide.setActionCommand("A kőpaletta elrejtése");
        miHide.setText("Elrejtés");
        miHide.addActionListener(new TilePalettePopupMenu_miHide_actionAdapter(this));
        mInfo.setActionCommand("Kiválasztható, hogy mely tulajdonságú kövek jelenjenek meg a palettán");
        mInfo.setText("Kő információ");
        miSelectable.setText("Kijelölhetők");
        miSelectable.addActionListener(new TilePalettePopupMenu_miSelectable_actionAdapter(this));
        miPair.setText("Levehetők");
        miPair.addActionListener(new TilePalettePopupMenu_miPair_actionAdapter(this));
        miAllTop.setText("Felsők");
        miAllTop.addActionListener(new TilePalettePopupMenu_miAllTop_actionAdapter(this));
        miShowUnderTiles.setText("Mutassa az alatta lévőket");
        miShowUnderTiles.addActionListener(new TilePalettePopupMenu_miShowUnderTiles_actionAdapter(this));
        miAll.setText("Mindegyik");
        miAll.addActionListener(new TilePalettePopupMenu_miAll_actionAdapter(this));

        miTDE.setText("3D-s kövek");
        miTDE.addActionListener(new TilePalettePopupMenu_mi3D_actionAdapter(this));
        miNonSkid.setActionCommand("A paletta rajzolatának engedélyezése / tiltása");
        miNonSkid.setText("Csúszásgátló");
        miNonSkid.addActionListener(new TilePalettePopupMenu_miNonSkid_actionAdapter(this));
        this.add(mInfo);
        this.addSeparator();
        this.add(mLocation);
        this.add(mOrientation);
        this.add(mGap);
        this.addSeparator();
        this.add(miTDE);
        this.add(miNonSkid);
        this.addSeparator();
        this.add(miHide);

        mOrientation.add(miHorizontal);
        mOrientation.add(miVertical);

        mLocation.add(miNorthWest);
        mLocation.add(miWest);
        mLocation.add(miSouthWest);
        mLocation.add(miNorth);
        mLocation.add(miCenter);
        mLocation.add(miSouth);
        mLocation.add(miNorthEast);
        mLocation.add(miEast);
        mLocation.add(miSouthEast);

        bgOrientation.add(miHorizontal);
        bgOrientation.add(miVertical);

        bgLocation.add(miNorthWest);
        bgLocation.add(miNorth);
        bgLocation.add(miNorthEast);
        bgLocation.add(miWest);
        bgLocation.add(miCenter);
        bgLocation.add(miEast);
        bgLocation.add(miSouthWest);
        bgLocation.add(miSouth);
        bgLocation.add(miSouthEast);

        bgGap.add(miGap_10);
        bgGap.add(miGap_20);
        bgGap.add(miGap_30);

        bgInfo.add(miSelectable);
        bgInfo.add(miPair);
        bgInfo.add(miAllTop);
        bgInfo.add(miAll);

        mGap.add(miGap_10);
        mGap.add(miGap_20);
        mGap.add(miGap_30);

        mInfo.add(miSelectable);
        mInfo.add(miPair);
        mInfo.add(miAllTop);
        mInfo.add(miAll);
        mInfo.addSeparator();
        mInfo.add(miShowUnderTiles);

        settingMenuItems();
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a menük kijelöltségét és érzékennyé teszi azokat az
     * egérmozgásra
     */
    private void settingMenuItems() {
        miSelectable.setSelected(dataModule.getTilePaletteProperty().getInfoType() == TilePaletteProperty.SELECTABLE);
        miPair.setSelected(dataModule.getTilePaletteProperty().getInfoType() == TilePaletteProperty.PAIR);
        miAllTop.setSelected(dataModule.getTilePaletteProperty().getInfoType() == TilePaletteProperty.ALL_TOP);
        miAll.setSelected(dataModule.getTilePaletteProperty().getInfoType() == TilePaletteProperty.ALL);
        miShowUnderTiles.setSelected(dataModule.getTilePaletteProperty().isShowUnderTiles());

        miHorizontal.setSelected(dataModule.getTilePaletteProperty().getOrientation() == Orientation.HORIZONTAL);
        miVertical.setSelected(dataModule.getTilePaletteProperty().getOrientation() == Orientation.VERTICAL);

        miNorthWest.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.NORTH_WEST);
        miNorth.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.NORTH);
        miNorthEast.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.NORTH_EAST);
        miWest.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.WEST);
        miCenter.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.CENTER);
        miEast.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.EAST);
        miSouthWest.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.SOUTH_WEST);
        miSouth.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.SOUTH);
        miSouthEast.setSelected(dataModule.getTilePaletteProperty().getLocation() == Location.SOUTH_EAST);

        miGap_10.setSelected(dataModule.getTilePaletteProperty().getGap() == 10);
        miGap_20.setSelected(dataModule.getTilePaletteProperty().getGap() == 20);
        miGap_30.setSelected(dataModule.getTilePaletteProperty().getGap() == 30);

        miTDE.setSelected(dataModule.getTilePaletteProperty().isTde());
        miNonSkid.setSelected(dataModule.getTilePaletteProperty().isNonSkid());

        sensitiveMenuItem(mOrientation);
        sensitiveMenuItem(mLocation);
        sensitiveMenuItem(mGap);
        sensitiveMenuItem(mInfo);
        sensitiveMenuItem(miHide);
        sensitiveMenuItem(miHorizontal);
        sensitiveMenuItem(miVertical);

        sensitiveMenuItem(miNorthWest);
        sensitiveMenuItem(miNorth);
        sensitiveMenuItem(miNorthEast);
        sensitiveMenuItem(miWest);
        sensitiveMenuItem(miCenter);
        sensitiveMenuItem(miEast);
        sensitiveMenuItem(miSouthWest);
        sensitiveMenuItem(miSouth);
        sensitiveMenuItem(miSouthEast);

        sensitiveMenuItem(miGap_10);
        sensitiveMenuItem(miGap_20);
        sensitiveMenuItem(miGap_30);

        sensitiveMenuItem(miSelectable);
        sensitiveMenuItem(miPair);
        sensitiveMenuItem(miAllTop);
        sensitiveMenuItem(miAll);
        sensitiveMenuItem(miShowUnderTiles);

        sensitiveMenuItem(miTDE);
        sensitiveMenuItem(miNonSkid);
    }

    //----------------------------------------------------------------------

    /**
     * Érzékennyé teszi a menütételeket az egérmozgásra
     */
    public void sensitiveMenuItem(JMenuItem menuItem) {
        Sensitive.takeSensitive(menuItem);
    }

    //----------------------------------------------------------------------

    public void show(Component invoker, int x, int y) {
        settingMenuItems();
        super.show(invoker, x, y);
    }

    void miHorizontal_actionPerformed(ActionEvent e) {
        tilePalette.newOrientation(Orientation.HORIZONTAL);
    }

    void miVertical_actionPerformed(ActionEvent e) {
        tilePalette.newOrientation(Orientation.VERTICAL);
    }

    void miNorthWest_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.NORTH_WEST);
    }

    void miNorth_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.NORTH);
    }

    void miNorthEast_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.NORTH_EAST);
    }

    void miWest_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.WEST);
    }

    void miCenter_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.CENTER);
    }

    void miEast_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.EAST);
    }

    void miSouthWest_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.SOUTH_WEST);
    }

    void miSouth_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.SOUTH);
    }

    void miSouthEast_actionPerformed(ActionEvent e) {
        tilePalette.newLocation(Location.SOUTH_EAST);
    }

    void miGap_30_actionPerformed(ActionEvent e) {
        tilePalette.newGap(30);
    }

    void miGap_10_actionPerformed(ActionEvent e) {
        tilePalette.newGap(10);
    }

    void miGap_20_actionPerformed(ActionEvent e) {
        tilePalette.newGap(20);
    }

    void miSelectable_actionPerformed(ActionEvent e) {
        tilePalette.newInfoType(TilePaletteProperty.SELECTABLE);
    }

    void miPair_actionPerformed(ActionEvent e) {
        tilePalette.newInfoType(TilePaletteProperty.PAIR);
    }

    void miAllTop_actionPerformed(ActionEvent e) {
        tilePalette.newInfoType(TilePaletteProperty.ALL_TOP);
    }

    void miAll_actionPerformed(ActionEvent e) {
        tilePalette.newInfoType(TilePaletteProperty.ALL);
    }

    void miShowUnderTiles_actionPerformed(ActionEvent e) {
        dataModule.getTilePaletteProperty().setShowUnderTiles(
                !dataModule.getTilePaletteProperty().isShowUnderTiles());
        dataModule.saveSettings();
    }

    //----------------------------------------------------------------------

    /**
     * Az elrejtésről a játékpanelon keresztül a főablakot is értesíteni kell,
     * hogy változtassa meg a kőpaletta menü kijelöltségét
     */
    void miHide_actionPerformed(ActionEvent e) {
        dataModule.getTilePaletteProperty().setVisible(false);
        dataModule.saveSettings();
        tilePalette.setVisible(false);
        tilePalette.getGamePanel().menuSetting();
    }

    void mi3D_actionPerformed(ActionEvent e) {
        dataModule.getTilePaletteProperty().setTde(!dataModule.getTilePaletteProperty().isTde());
        dataModule.saveSettings();
        tilePalette.changeTDE();
    }

    void miNonSkid_actionPerformed(ActionEvent e) {
        dataModule.getTilePaletteProperty().setNonSkid(!dataModule.getTilePaletteProperty().isNonSkid());
        dataModule.saveSettings();
        tilePalette.repaint();
    }

}

class TilePalettePopupMenu_miHorizontal_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miHorizontal_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miHorizontal_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miVertical_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miVertical_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miVertical_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miNorthWest_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miNorthWest_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNorthWest_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miNorth_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miNorth_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNorth_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miNorthEast_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miNorthEast_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNorthEast_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miWest_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miWest_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWest_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miCenter_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miCenter_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miCenter_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miEast_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miEast_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miEast_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miSouthWest_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miSouthWest_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSouthWest_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miSouth_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miSouth_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSouth_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miSouthEast_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miSouthEast_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSouthEast_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miGap_30_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miGap_30_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGap_30_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miGap_10_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miGap_10_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGap_10_actionPerformed(e);
    }
}


class TilePalettePopupMenu_miGap_20_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miGap_20_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGap_20_actionPerformed(e);
    }
}


class TilePalettePopupMenu_miHide_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miHide_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miHide_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miSelectable_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miSelectable_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSelectable_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miPair_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miPair_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPair_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miAllTop_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miAllTop_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miAllTop_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miAll_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miAll_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miAll_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miShowUnderTiles_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miShowUnderTiles_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miShowUnderTiles_actionPerformed(e);
    }
}

class TilePalettePopupMenu_mi3D_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_mi3D_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mi3D_actionPerformed(e);
    }
}

class TilePalettePopupMenu_miNonSkid_actionAdapter implements java.awt.event.ActionListener {
    TilePalettePopupMenu adaptee;

    TilePalettePopupMenu_miNonSkid_actionAdapter(TilePalettePopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miNonSkid_actionPerformed(e);
    }
}








