package org.example.gui.panel.texture;

import org.example.entity.Constants;
import org.example.entity.DataModule;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

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
 * Egy képből előállított textúrát megjelenítő panel
 */
public class TexturePanel extends JPanel implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * A megjelenítendő kép
     */
    private Image image;

    private BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public TexturePanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    void jbInit() throws Exception {
        this.setLayout(borderLayout1);
        loadImage(dataModule.getBackgroundProperties().getTextureBackground().getPath());
    }

    //----------------------------------------------------------------------

    /**
     * Betölti a képet egy fáljból
     */
    public void loadImage(String texturePath) {
        MediaTracker tr = new MediaTracker(this);
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(
                RESOURCE_PATH + texturePath));
        tr.addImage(image, 0);
        try {
            tr.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**
     * A képből egy textúrát állít elő, mellyel a panel teljes területét
     * kitölti.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        BufferedImage bi = new BufferedImage(image.getWidth(this),
                image.getHeight(this),
                BufferedImage.TYPE_INT_RGB);
        Graphics2D big = bi.createGraphics();

        if (image != null) {
            big.drawImage(image, 0, 0, this);
            Rectangle r = new Rectangle(0,
                    0,
                    image.getWidth(this),
                    image.getHeight(this));
            TexturePaint tp = new TexturePaint(bi, r);
            g2.setPaint(tp);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}









