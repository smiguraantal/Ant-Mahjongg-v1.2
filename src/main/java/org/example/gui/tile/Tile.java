package org.example.gui.tile;

import org.example.entity.Constants;
import org.example.entity.Place;
import org.example.entity.Style;
import org.example.gui.Flash;
import org.example.gui.SelectingListener;
import org.example.gui.drawer.ImageDrawer;
import org.example.gui.drawer.TDEDrawer;
import org.example.gui.panel.GamePanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

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
 * A játékban szereplő kő osztálya
 */
public class Tile extends BasicTile implements Constants, Cloneable {

    /**
     * Tábla
     */
    protected GamePanel gamePanel;

    /**
     * A kép, melyen a kövek kollekciója található
     */
    private Image image_1;

    /**
     * A kép megfordított színekkel
     */
    private Image image_2;

    /**
     * A kő értéke
     */
    private int value;

    /**
     * Erégfigyelés
     */
    private SelectingListener selectingListener = new SelectingListener(this);

    /**
     * A villogtatáshoz szükséges érték.
     * 0: nincs villogtatható állapotban
     * 1: villogtatható állapotban van, de nincs megvillatva
     * 2: villogtatható állapotban van, és meg van villantva
     */
    private int flashState;

    /**
     * Megadja, hogy volt-e már vizsgálva a réteg kiszámításánál
     */
    private boolean checked;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Tile(GamePanel gamePanel, Place place, int value) {
        super(place);
        this.gamePanel = gamePanel;
        this.value = value;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        this.addMouseListener(selectingListener);
        this.setOpaque(false);
        this.addMouseMotionListener(new Tile_this_mouseMotionAdapter(this));
        this.addMouseListener(new Tile_this_mouseAdapter(this));

        setTileBounds();
        loadImages();
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza és beállítja a kő helyzetét
     */
    public void setTileBounds() {
        double gamePanelWidth = gamePanel.getPreferredSize().getWidth(); // a tábla szélessége
        double gamePanelHeight = gamePanel.getPreferredSize().getHeight(); // a tábla magassága
        double layoutWidth = dataModule.getLayout().getLayoutWidth(); // az elrendezés szélessége kövekben kifejezve
        double layoutHeight = dataModule.getLayout().getLayoutHeight(); // az elrendezés magassága kövekben kifejezve
        double xTranslate = (gamePanelWidth - (layoutWidth * TILE_WIDTH * UNIT)) / 2; // a kövek a panelon középre való elhelyezéséhez szükséges vízszintes eltolása
        double yTranslate = (gamePanelHeight - (layoutHeight * TILE_HEIGHT * UNIT)) / 2; // a kövek a panelon középre való elhelyezéséhez szükséges függőleges eltolása
    /* // térhatás nélküli méret kiszámítása volt
    this.setBounds((int) (place.getX() * TILE_WIDTH * UNIT + place.getLayer() * dataModule.getThreeDimensionalEffect().getHorizontalTranslate() + xTranslate),
                   (int) (place.getY() * TILE_HEIGHT * UNIT + place.getLayer() * dataModule.getThreeDimensionalEffect().getVerticalTranslate() + yTranslate),
                   TILE_WIDTH * UNIT,
                   TILE_HEIGHT * UNIT);
     */

        this.setBounds((int) (place.getX() * TILE_WIDTH * UNIT + place.getLayer() * dataModule.getThreeDimensionalEffect().getHorizontalTranslate() + xTranslate),
                (int) (place.getY() * TILE_HEIGHT * UNIT + place.getLayer() * dataModule.getThreeDimensionalEffect().getVerticalTranslate() + yTranslate),
                TILE_WIDTH * UNIT + TILE_TRANSLATE,
                TILE_HEIGHT * UNIT + TILE_TRANSLATE);
    }

    //----------------------------------------------------------------------

    /**
     * Betölti a képeket egy fáljból
     */
    public void loadImages() {
        MediaTracker tr = new MediaTracker(this);
        Style style = dataModule.getStyle();
        image_1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource(
                RESOURCE_PATH + style.getImagePath_1()));
        image_2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource(
                RESOURCE_PATH + style.getImagePath_2()));
        tr.addImage(image_1, 0);
        tr.addImage(image_2, 0);
        try {
            tr.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Egérgomb lenyomása
     */
    public void mousePressed(MouseEvent e) {
        if (e.getModifiers() == e.BUTTON1_MASK) { // bal egérkattintás
            if (eventOnPicture(e)) { // ha kövön lévő képen történt a klikkelés
                leftClick();
                gamePanel.leftClickInATile(this);
            }
        }
        if (e.getModifiers() == e.BUTTON3_MASK) { // jobb egérkattintás
            rightClick(e);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy az egéresemény a kövön lévő képen történt-e
     */
    private boolean eventOnPicture(MouseEvent e) {
        if (dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_WEST))
            return new Rectangle(0, 0, TILE_WIDTH * UNIT, TILE_HEIGHT * UNIT).contains(e.getPoint());
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_NORTH_EAST))
            return new Rectangle(TILE_TRANSLATE, 0, TILE_WIDTH * UNIT, TILE_HEIGHT * UNIT).contains(e.getPoint());
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_WEST))
            return new Rectangle(0, TILE_TRANSLATE, TILE_WIDTH * UNIT, TILE_HEIGHT * UNIT).contains(e.getPoint());
        else if (dataModule.getThreeDimensionalEffect().equals(TDE_SOUTH_EAST))
            return new Rectangle(TILE_TRANSLATE, TILE_TRANSLATE, TILE_WIDTH * UNIT, TILE_HEIGHT * UNIT).contains(e.getPoint());
        return false;
    }

    //----------------------------------------------------------------------

    /**
     * Bal kattingás
     */
    public void leftClick() {
        if (!selectable())
            return;
        if (!selected) { // ha nem kijelölt
            selected = true;
            dataModule.increaseNumberOfSelectedTiles();
        } else { // ha kijelölt
            selected = false;
            dataModule.decreaseNumberOfSelectedTiles();
        }
        repaint();
    }

    //----------------------------------------------------------------------

    /**
     * Jobb kattintás
     */
    private void rightClick(MouseEvent e) {
        gamePanel.showPopupMenu(e);
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja az aktuális képet
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = selected ? image_2 : image_1; // inverz vagy normál (kijelölés)
        if (flashState == Flash.NON_SELECTED)
            image = image_1;
        else if (flashState == Flash.SELECTED)
            image = image_2;

        new ImageDrawer(this, image, g, value).drawImage();
        new TDEDrawer(g).drawTDE();
    }

    //----------------------------------------------------------------------

    void this_mouseMoved(MouseEvent e) {
        if (!dataModule.isDialogShowing()) {
            if (eventOnPicture(e))
                gamePanel.refreshTilePalette(this);
            else
                gamePanel.refreshTilePalette(null);
        }
    }

    //----------------------------------------------------------------------

    void this_mouseEntered(MouseEvent e) {
        if (eventOnPicture(e))
            if (!dataModule.isDialogShowing())
                gamePanel.refreshTilePalette(this);
    }

    //----------------------------------------------------------------------

    /**
     * A popup menü először egy mouseExited, aztán egy mouseEntered eseményt
     * generál, aminek a hatására újra lenne építve a kőpaletta. Ennek kivédé-
     * sére csak akkor engedélyezem a mouseExited eseményt ha az valóban a
     * komponensen kívül történt.
     */
    void this_mouseExited(MouseEvent e) {
        if (!dataModule.isDialogShowing())
            if (e.getX() < 0 || e.getX() > TILE_WIDTH * UNIT + TILE_TRANSLATE - 1 || // ha valós exit esemény
                    e.getY() < 0 || e.getY() > TILE_HEIGHT * UNIT + TILE_TRANSLATE - 1)
                gamePanel.refreshTilePalette(null);
    }

    //----------------------------------------------------------------------

    /**
     * Klózonható
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //----------------------------------------------------------------------

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFlashState() {
        return flashState;
    }

    public void setFlashState(int flashState) {
        this.flashState = flashState;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}

class Tile_this_mouseAdapter extends java.awt.event.MouseAdapter {
    Tile adaptee;

    Tile_this_mouseAdapter(Tile adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseEntered(MouseEvent e) {
        adaptee.this_mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        adaptee.this_mouseExited(e);
    }
}

class Tile_this_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
    Tile adaptee;

    Tile_this_mouseMotionAdapter(Tile adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseMoved(MouseEvent e) {
        adaptee.this_mouseMoved(e);
    }
}



