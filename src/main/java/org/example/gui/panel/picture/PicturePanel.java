package org.example.gui.panel.picture;

import org.example.entity.Background;
import org.example.entity.Constants;
import org.example.entity.DataModule;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;

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
 * Egy képet megjelenítő panel, mely a kapott képet lekicsinyíti
 */
public class PicturePanel extends JPanel implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A megjelenítendő kép
     */
    private Image image;

    /**
     * A lekicsinyített kép
     */
    private Image fittedImage = null;

    /**
     * Méretarány
     */
    private double ratio;

    /**
     * A háttér objektum, mely az eléréri utat tartalmazza
     */
    private Background background;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public PicturePanel(Background background) {
        this.background = background;
        this.addComponentListener(new PicturePanel_this_componentAdapter(this));
    }

    //----------------------------------------------------------------------

    /**
     * Betölti a képet egy fáljból, majd skálázza
     */
    public void loadImage(String picturePath) {
        MediaTracker tr = new MediaTracker(this);
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(
                RESOURCE_PATH + picturePath));
        tr.addImage(image, 0);
        try {
            tr.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ratio = 1.0 * image.getWidth(this) / image.getHeight(this);
        fittedImage = image.getScaledInstance((int) (getHeight() * ratio),
                getHeight(),
                Image.SCALE_FAST);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a hátteret a panel közepére
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fittedImage != null)
            g.drawImage(fittedImage,
                    (getWidth() - fittedImage.getWidth(this)) / 2,
                    0,
                    this);
    }

    //----------------------------------------------------------------------

    /**
     * A képet csak akkor tölti be és jeleníti meg, ha már van mérete a
     * panelnak
     */
    void this_componentShown(ComponentEvent e) {
        loadImage(background.getPath());
        repaint();
    }
}

class PicturePanel_this_componentAdapter extends java.awt.event.ComponentAdapter {
    PicturePanel adaptee;

    PicturePanel_this_componentAdapter(PicturePanel adaptee) {
        this.adaptee = adaptee;
    }

    public void componentShown(ComponentEvent e) {
        adaptee.this_componentShown(e);
    }
}











