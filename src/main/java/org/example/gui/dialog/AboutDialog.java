package org.example.gui.dialog;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.WindowLocation;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;

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
 * Névjegy dialógus
 */
public class AboutDialog extends JDialog implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A képet tartó panel
     */
    ImagePanel panel1 = new ImagePanel();

    BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public AboutDialog(MainFrame mainFrame) {
        super(mainFrame, "Névjegy", true);
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
        panel1.setLayout(borderLayout1);
        panel1.setPreferredSize(new Dimension(192, 240));
        this.addKeyListener(new AboutDialog_this_keyAdapter(this));
        getContentPane().add(panel1);
    }

    //----------------------------------------------------------------------

    /**
     * Megjeleníti a dialógust
     */
    public void showDialog() {
        new WindowLocation(this, WindowLocation.CENTER);
        dataModule.setDialogShowing(true);
        show();
        dataModule.setDialogShowing(false);
    }

    //----------------------------------------------------------------------

    /**
     * Belső osztály, melyen a kép található
     */
    class ImagePanel extends JPanel {

        /**
         * A kép
         */
        private Image image;

        //----------------------------------------------------------------------

        /**
         * Konstruktor
         */
        public ImagePanel() {
            loadImage();
        }

        //----------------------------------------------------------------------

        /**
         * Betölti a képet egy fáljból
         */
        public void loadImage() {
            MediaTracker tr = new MediaTracker(this);
            image = Toolkit.getDefaultToolkit().getImage(
//                    getClass().getResource(RESOURCE_PATH + ABOUT_IMAGE));
                    getClass().getResource("/" + ABOUT_IMAGE));
            tr.addImage(image, 0);
            try {
                tr.waitForID(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //----------------------------------------------------------------------

        /**
         * Megrajzolja a képet
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null)
                g.drawImage(image,
                        0,
                        0,
                        192,
                        240,
                        this);

        }
    }

    //----------------------------------------------------------------------

    /**
     * Escape-re kilépés
     */
    void this_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            hide();
    }
}

class AboutDialog_this_keyAdapter extends java.awt.event.KeyAdapter {
    AboutDialog adaptee;

    AboutDialog_this_keyAdapter(AboutDialog adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
        adaptee.this_keyPressed(e);
    }
}







