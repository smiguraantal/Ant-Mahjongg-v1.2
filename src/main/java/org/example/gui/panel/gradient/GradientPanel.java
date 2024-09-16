package org.example.gui.panel.gradient;

import org.example.entity.Constants;
import org.example.entity.Gradient;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

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
 * Egy kitöltési effektus kicsinyített képének kirajzolásához használt
 * osztály. Ezekből a panelokból nyolcat hoz létre a program, melyek a
 * háttér dialógusán kapnak helyet.
 */
public class GradientPanel extends JPanel implements Constants {

    /**
     * A kitöltési effektusok kiválasztásához használt panel, mely a miniatűr
     * effektusokat fogja össze.
     */
    private GradientSettingPanel gradientSettingPanel;

    /**
     * A kitöltési effektus adatait tartalazó objektum
     */
    private Gradient gradient;

    /**
     * A kitöltési effektus kiválasztottságát megadó adat. Egy kiválasztott
     * effektust egy négyzet keretez, míg a nem kiválasztott keret nélküli.
     */
    private boolean selected;

    /**
     * A miniatűr effektus szélessége
     */
    private final int WIDTH = 80;

    /**
     * A miniatűr effektus magassága
     */
    private final int HEIGHT = 80;

    /**
     * A miniatűrök közötti hézag, mely a keret kirajzolásához szükséges.
     */
    private final int GAP = 12;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public GradientPanel(GradientSettingPanel gradientSettingPanel,
                         Gradient gradient) {
        this.gradientSettingPanel = gradientSettingPanel;
        this.gradient = gradient;

        setPreferredSize(new Dimension((int) WIDTH + GAP,
                (int) HEIGHT + GAP));

        this.addMouseListener(new GradientPanel_this_mouseAdapter(this));
    }

    //----------------------------------------------------------------------

    /**
     * Egérkattintáskor a miniatűröket tartalmazó panel lesz megkérve, hogy
     * válassza ki a kijelöltet és rajzolja újra az összeset. Így lesz a
     * kijelölt miniatűr panel keretes, a többi pedig keret nélküli.
     */
    void this_mousePressed(MouseEvent e) {
        gradientSettingPanel.selectGradient(gradient);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a hátteret
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // kerete megrajzolása a színséma színeivel
        if (selected) {
            g.setColor(gradient.getColorTheme().getColor_1());
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(gradient.getColorTheme().getColor_2());
            g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
            g.setColor(gradient.getColorTheme().getColor_1());
            g.drawRect(2, 2, getWidth() - 5, getHeight() - 5);
        }

        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(new GradientPaint(calculatedValue(gradient.getX1()) + GAP / 2,
                calculatedValue(gradient.getY1()) + GAP / 2,
                gradient.getColorTheme().getColor_2(),
                calculatedValue(gradient.getX2()) + GAP / 2,
                calculatedValue(gradient.getY2()) + GAP / 2,
                gradient.getColorTheme().getColor_1()));

        g2.fill(new Rectangle2D.Double(0 + GAP / 2,
                0 + GAP / 2,
                getWidth() - GAP,
                getHeight() - GAP));
    }

    //----------------------------------------------------------------------

    /**
     * A kitöltési effektus rajzolásához minden esetben szükség van a
     * kitöltendő panel szélességére és magasságára. Ezeket az adatokat nem
     * lehet előre megadni a nyolc féle Gradient objektumban, ezért a
     * szélesség és magasság mindig a panel méretéből lesz megadva. Ha a
     * gradient objektum valamelyik koordinátája GRADIENT_WIDTH konstanst
     * tartalmaz, akkor annak értéke a panel szélességét veszi fel, ha
     * GRADIENT_HEIGHT konstanst, akkor a panel szélességét. Ha a koordináta
     * egyik konstanssal sem egyezik meg, akkor értéke változatlan marad.
     */
    public float calculatedValue(float value) {
        if (value == GRADIENT_WIDTH)
            return (float) getWidth() - GAP;
        if (value == GRADIENT_HEIGHT)
            return (float) getHeight() - GAP;
        return value;
    }

    //----------------------------------------------------------------------

    public Gradient getGradient() {
        return gradient;
    }

    public void setGradient(Gradient gradient) {
        this.gradient = gradient;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

class GradientPanel_this_mouseAdapter extends java.awt.event.MouseAdapter {
    GradientPanel adaptee;

    GradientPanel_this_mouseAdapter(GradientPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.this_mousePressed(e);
    }
}