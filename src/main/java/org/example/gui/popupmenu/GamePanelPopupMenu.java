package org.example.gui.popupmenu;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.Sensitive;
import org.example.gui.manager.ImageIconManager;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

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
 * A tábla helyi menüje
 */
public class GamePanelPopupMenu extends JPopupMenu implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A főablak
     */
    MainFrame mainFrame;

    JMenuItem miUndo = new JMenuItem();
    JMenuItem miRedo = new JMenuItem();
    JMenuItem miSwap = new JMenuItem();
    //JCheckBoxMenuItem miRule = new JCheckBoxMenuItem();
    JMenuItem miShuffle = new JMenuItem();
    JMenuItem miRestart = new JMenuItem();
    JMenuItem miPause = new JMenuItem();
    JMenuItem miHelp = new JMenuItem();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public GamePanelPopupMenu(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        this.add(miRestart);
        this.add(miPause);
        this.addSeparator();
        this.add(miUndo);
        this.add(miRedo);
        this.addSeparator();
        //this.add(miRule);
        this.add(miSwap);
        this.add(miShuffle);
        this.add(miHelp);

        miRestart.setModel(mainFrame.getMiRestart().getModel());
        miPause.setModel(mainFrame.getMiPause().getModel());
        miUndo.setModel(mainFrame.getMiUndo().getModel());
        miRedo.setModel(mainFrame.getMiRedo().getModel());
        //miRule.setModel(mainFrame.getMiRule().getModel());
        miSwap.setModel(mainFrame.getMiSwap().getModel());
        miShuffle.setModel(mainFrame.getMiShuffle().getModel());
        miHelp.setModel(mainFrame.getMiHelp().getModel());

        miRestart.setText(mainFrame.getMiRestart().getText());
        miPause.setText(mainFrame.getMiPause().getText());
        miUndo.setText(mainFrame.getMiUndo().getText());
        miRedo.setText(mainFrame.getMiRedo().getText());
        //miRule.setText(mainFrame.getMiRule().getText());
        miSwap.setText(mainFrame.getMiSwap().getText());
        miShuffle.setText(mainFrame.getMiShuffle().getText());
        miHelp.setText(mainFrame.getMiHelp().getText());

        miRestart.setActionCommand(mainFrame.getMiRestart().getActionCommand());
        miPause.setActionCommand(mainFrame.getMiPause().getActionCommand());
        miUndo.setActionCommand(mainFrame.getMiUndo().getActionCommand());
        miRedo.setActionCommand(mainFrame.getMiRedo().getActionCommand());
        //miRule.setActionCommand(mainFrame.getMiRule().getActionCommand());
        miSwap.setActionCommand(mainFrame.getMiSwap().getActionCommand());
        miShuffle.setActionCommand(mainFrame.getMiShuffle().getActionCommand());
        miHelp.setActionCommand(mainFrame.getMiHelp().getActionCommand());

        miRestart.setAccelerator(mainFrame.getMiRestart().getAccelerator());
        miPause.setAccelerator(mainFrame.getMiPause().getAccelerator());
        miUndo.setAccelerator(mainFrame.getMiUndo().getAccelerator());
        miRedo.setAccelerator(mainFrame.getMiRedo().getAccelerator());
        //miRule.setAccelerator(mainFrame.getMiRule().getAccelerator());
        miSwap.setAccelerator(mainFrame.getMiSwap().getAccelerator());
        miShuffle.setAccelerator(mainFrame.getMiShuffle().getAccelerator());
        miHelp.setAccelerator(mainFrame.getMiHelp().getAccelerator());

        miRestart.setIcon(new ImageIconManager().createImageIcon("icons/restart.gif"));
        miPause.setIcon(new ImageIconManager().createImageIcon("icons/pause.gif"));
        miUndo.setIcon(new ImageIconManager().createImageIcon("icons/undo.gif"));
        miRedo.setIcon(new ImageIconManager().createImageIcon("icons/redo.gif"));
        //miRule.setIcon(new ImageIconManager().createImageIcon("icons/verticalrule.gif"));
        miSwap.setIcon(new ImageIconManager().createImageIcon("icons/swap.gif"));
        miShuffle.setIcon(new ImageIconManager().createImageIcon("icons/shuffle.gif"));
        miHelp.setIcon(new ImageIconManager().createImageIcon("icons/help.gif"));

        sensitiveMenuItem(miRestart);
        sensitiveMenuItem(miPause);
        sensitiveMenuItem(miUndo);
        sensitiveMenuItem(miRedo);
        //sensitiveMenuItem(miRule);
        sensitiveMenuItem(miSwap);
        sensitiveMenuItem(miShuffle);
        sensitiveMenuItem(miHelp);
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
     * Beállítja a pause menü tulajdonságait
     */
    public void setPauseMenu() {
        miPause.setIcon(dataModule.isPause() ?
                new ImageIconManager().createImageIcon("icons/resume.gif") :
                new ImageIconManager().createImageIcon("icons/pause.gif"));
        miPause.setText(mainFrame.getMiPause().getText());
        miPause.setActionCommand(mainFrame.getMiPause().getActionCommand());
    }

    public JMenuItem getMiPause() {
        return miPause;
    }

}








