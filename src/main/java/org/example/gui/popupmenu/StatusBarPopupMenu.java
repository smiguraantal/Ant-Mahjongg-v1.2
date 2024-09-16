package org.example.gui.popupmenu;

import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.Sensitive;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
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
 * Az állapotsor helyi menüje
 */
public class StatusBarPopupMenu extends JPopupMenu {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Főablak
     */
    private MainFrame mainFrame;

    JCheckBoxMenuItem miGameNumber = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miTime = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miPenalty = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miTiles = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miOpens = new JCheckBoxMenuItem();
    JMenuItem miHide = new JMenuItem();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public StatusBarPopupMenu(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        miOpens.setActionCommand("A levehető párok számának megjelenítése / elrejtése");
        miTiles.setActionCommand("A táblán található kövek számának megjelenítése / elrejtése");
        miPenalty.setActionCommand("Büntetés megjelenítése / elrejtése");
        miTime.setActionCommand("Az idő megjelenítése / elrejtése");
        miGameNumber.setActionCommand("A kiválasztott játék számának megjelenítése / elrejtése");
        miGameNumber.setText("Játék");
        miGameNumber.addActionListener(new StatusBarPopupMenu_miGameNumber_actionAdapter(this));
        miTime.setText("Idő");
        miTime.addActionListener(new StatusBarPopupMenu_miTime_actionAdapter(this));
        miPenalty.setText("Bűntetés");
        miPenalty.addActionListener(new StatusBarPopupMenu_miPenalty_actionAdapter(this));
        miTiles.setText("Kövek");
        miTiles.addActionListener(new StatusBarPopupMenu_miTiles_actionAdapter(this));
        miOpens.setText("Párok");
        miOpens.addActionListener(new StatusBarPopupMenu_miOpens_actionAdapter(this));
        miHide.setActionCommand("Az állapotsor elrejtése");
        miHide.setText("Elrejtés");
        miHide.addActionListener(new StatusBarPopupMenu_miHide_actionAdapter(this));
        this.add(miGameNumber);
        this.add(miTime);
        this.add(miPenalty);
        this.add(miTiles);
        this.add(miOpens);
        this.addSeparator();
        this.add(miHide);

        settingMenuItems();
    }

    //----------------------------------------------------------------------

    /**
     * Beállítja a menük kijelöltségét és érzékennyé teszi azokat az
     * egérmozgásra
     */
    private void settingMenuItems() {
        miGameNumber.setSelected(dataModule.getStatusBarProperties().isGameNumber());
        miTime.setSelected(dataModule.getStatusBarProperties().isTime());
        miPenalty.setSelected(dataModule.getStatusBarProperties().isPenalty());
        miTiles.setSelected(dataModule.getStatusBarProperties().isTiles());
        miOpens.setSelected(dataModule.getStatusBarProperties().isOpens());

        sensitiveMenuItem(miGameNumber);
        sensitiveMenuItem(miTime);
        sensitiveMenuItem(miPenalty);
        sensitiveMenuItem(miTiles);
        sensitiveMenuItem(miOpens);
        sensitiveMenuItem(miHide);
    }

    //----------------------------------------------------------------------

    /**
     * Érzékennyé teszi a menütételeket az egérmozgásra
     */
    public void sensitiveMenuItem(JMenuItem menuItem) {
        Sensitive.takeSensitive(menuItem);
    }

    //----------------------------------------------------------------------

    /**
     * Az állapotsor beállításainak mentése és alkalmazása
     */
    private void newStatusBarProperties() {
        dataModule.saveSettings();
        mainFrame.setStatusBar();
    }

    //----------------------------------------------------------------------

    void miGameNumber_actionPerformed(ActionEvent e) {
        dataModule.getStatusBarProperties().setGameNumber(
                !dataModule.getStatusBarProperties().isGameNumber());
        newStatusBarProperties();
    }

    void miTime_actionPerformed(ActionEvent e) {
        dataModule.getStatusBarProperties().setTime(
                !dataModule.getStatusBarProperties().isTime());
        newStatusBarProperties();
    }

    void miPenalty_actionPerformed(ActionEvent e) {
        dataModule.getStatusBarProperties().setPenalty(
                !dataModule.getStatusBarProperties().isPenalty());
        newStatusBarProperties();
    }

    void miTiles_actionPerformed(ActionEvent e) {
        dataModule.getStatusBarProperties().setTiles(
                !dataModule.getStatusBarProperties().isTiles());
        newStatusBarProperties();
    }

    void miOpens_actionPerformed(ActionEvent e) {
        dataModule.getStatusBarProperties().setOpens(
                !dataModule.getStatusBarProperties().isOpens());
        newStatusBarProperties();
    }

    void miHide_actionPerformed(ActionEvent e) {
        dataModule.setStatusBar(false);
        mainFrame.getStatusBar().setVisible(false);
        mainFrame.settingMenuItems();
        mainFrame.pack();
    }
}


class StatusBarPopupMenu_miGameNumber_actionAdapter implements java.awt.event.ActionListener {
    StatusBarPopupMenu adaptee;

    StatusBarPopupMenu_miGameNumber_actionAdapter(StatusBarPopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGameNumber_actionPerformed(e);
    }
}

class StatusBarPopupMenu_miTime_actionAdapter implements java.awt.event.ActionListener {
    StatusBarPopupMenu adaptee;

    StatusBarPopupMenu_miTime_actionAdapter(StatusBarPopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miTime_actionPerformed(e);
    }
}

class StatusBarPopupMenu_miPenalty_actionAdapter implements java.awt.event.ActionListener {
    StatusBarPopupMenu adaptee;

    StatusBarPopupMenu_miPenalty_actionAdapter(StatusBarPopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miPenalty_actionPerformed(e);
    }
}

class StatusBarPopupMenu_miTiles_actionAdapter implements java.awt.event.ActionListener {
    StatusBarPopupMenu adaptee;

    StatusBarPopupMenu_miTiles_actionAdapter(StatusBarPopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miTiles_actionPerformed(e);
    }
}

class StatusBarPopupMenu_miOpens_actionAdapter implements java.awt.event.ActionListener {
    StatusBarPopupMenu adaptee;

    StatusBarPopupMenu_miOpens_actionAdapter(StatusBarPopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miOpens_actionPerformed(e);
    }
}

class StatusBarPopupMenu_miHide_actionAdapter implements java.awt.event.ActionListener {
    StatusBarPopupMenu adaptee;

    StatusBarPopupMenu_miHide_actionAdapter(StatusBarPopupMenu adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miHide_actionPerformed(e);
    }
}








