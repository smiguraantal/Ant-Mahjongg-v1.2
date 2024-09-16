package org.example;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.factory.NumberedGameFactory;
import org.example.gui.MainFrame;
import org.example.gui.WindowLocation;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

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
 * Indító osztály
 */
public class AntMahjongg implements Constants {

    /**
     * Konstruktor
     */
    public AntMahjongg() {

        MainFrame mainFrame = new MainFrame();
        new WindowLocation(mainFrame, DataModule.getDataModule().getWindowLocation());
        mainFrame.setVisible(true);

//        new NumberedGameFactory().createNumberedGames(COUNT_OF_NUMBERED_GAMES);
    }

    //----------------------------------------------------------------------

    /**
     * Main. (a kinézetek egyelőre nincsenek használva!)
     */
    public static void main(String[] args) {
        try {
            int lookAndFeel = DataModule.getDataModule().getLookAndFeel();
            if (lookAndFeel == WINDOWS_LOOK_AND_FEEL)
                UIManager.setLookAndFeel(new WindowsLookAndFeel());
            if (lookAndFeel == METAL_LOOK_AND_FEEL)
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            if (lookAndFeel == MOTIF_LOOK_AND_FEEL)
                UIManager.setLookAndFeel(new MotifLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AntMahjongg();
    }
}








