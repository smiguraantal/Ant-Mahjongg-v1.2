package org.example.gui.panel;

import org.example.entity.ColorTheme;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.GameState;
import org.example.entity.Gradient;
import org.example.entity.Place;
import org.example.entity.TilePaletteProperty;
import org.example.entity.TileProperties;
import org.example.entity.TwoTileProperties;
import org.example.gui.Builder;
import org.example.gui.Flash;
import org.example.gui.MainFrame;
import org.example.gui.OpenTileSelector;
import org.example.gui.SameTiles;
import org.example.gui.TilePalette;
import org.example.gui.TileSwapper;
import org.example.gui.animation.Animation;
import org.example.gui.animation.SkyPanel;
import org.example.gui.manager.HideManager;
import org.example.gui.popupmenu.GamePanelPopupMenu;
import org.example.gui.tile.BasicTile;
import org.example.gui.tile.Tile;

import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.Stack;
import java.util.TreeSet;
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
 * A játék "táblája", melyen a kövek vannak.
 */
public class GamePanel extends JLayeredPane implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Kövek
     */
    private Vector tiles = new Vector();

    /**
     * A főablak
     */
    private MainFrame mainFrame;

    /**
     * Háttérkép
     */
    private Image backgroundImage;

    /**
     * Levett kőpárok verme
     */
    private Stack undo = new Stack();

    /**
     * Visszatett kőpárok verme
     */
    private Stack redo = new Stack();

    /**
     * A párokat kigyűjtő osztály
     */
    private OpenTileSelector openTileSelector;

    /**
     * A villogtató
     */
    private Flash flash;

    /**
     * Helyi menü
     */
    private GamePanelPopupMenu gamePanelPopupMenu;

    /**
     * A panel mérete
     */
    private Rectangle rectangle;

    /**
     * A kőpaletta
     */
    private TilePalette tilePalette;

    /**
     * Egy betöltött játék állapota
     */
    private GameState gameState;

    /**
     * A kövek helyét meghatározó objektum
     */
    private Builder builder;

    /**
     * A csillagos ég panel
     */
    private SkyPanel skyPanel = new SkyPanel(this);

    /**
     * Az aktuális animáció
     */
    private Animation animation = skyPanel;


    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public GamePanel(MainFrame mainFrame,
                     Rectangle rectangle,
                     GameState gameState) {
        this.mainFrame = mainFrame;
        this.rectangle = rectangle;
        this.gameState = gameState;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Konstruktor a panel méretének megállapításához
     */
    public GamePanel() {
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        setPreferredSize(new Dimension(rectangle.width, rectangle.height));
        gamePanelPopupMenu = new GamePanelPopupMenu(mainFrame);
        this.setLayout(null);
        this.addMouseListener(new GamePanel_this_mouseAdapter(this));

        if (gameState == null) { // nem betöltött játék
            if (dataModule.getGameNumber() == 0) { // új (nem betöltött)
                dataModule.createValues();
                buildGoodSolution(dataModule.getLayout().getPlaces());
                dataModule.setPlaces(builder.getOrderedPlaces());
                dealTiles(builder.getOrderedPlaces(), dataModule.getValues());
            } else { // számozott (nem betöltött)
                dealTiles(dataModule.getPlaces(), dataModule.getValues());
            }
        } else { // betöltött játék
            dealTiles(gameState.getActualPlaces(), gameState.getActualValues());
            this.undo = copyStack(gameState.getUndo());
            this.redo = copyStack(gameState.getRedo());
            dataModule.setShuffleable(shuffleAvailability());
        }

        add(tilePalette = new TilePalette(this), TILE_PALETTE_LAYER);
        loadImage();
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza a kövek helyeit úgy, hogy mindenképpen le tudjuk venni
     * a köveket.
     */
    private void buildGoodSolution(Vector places) {
        do {
            builder = new Builder(places);
        } while (!builder.succesBuilding()); // amíg nem sikerül felépíteni az elrendezést
    }


    //----------------------------------------------------------------------

    /**
     * Egy meghatározott számú próbálkozást tesz a kövek felépítésére.
     * Ha sikerül felépítenie a kapott kövekből az alakzatot, akkor a
     * visszatérési érték true, ha nem sikerül, akkor false. Abban az
     * esetben ha nem sikerült felépíteni az alakzatot, az azt jelenti, hogy
     * valószínüleg előállt a "zsákutca szituáció", vagyis nem lehet több
     * párt levenni. Fontos, hogy kellő számú próbálkozást tegyen a kövek
     * felépítésére, mert csak így lesz "biztos", hogy a kövek levétele
     * zsákutcába került. Ez a módszer egyelőre a nagy számok törvényén
     * alapul, így nem egy százszázalékos megoldás.
     */
    public boolean shuffleAvailability() {
        for (int i = 0; i < 50; i++) { // 100 ??? vagy elég 50 ???
            builder = new Builder(createActualPlaces());
            if (builder.succesBuilding())
                return true;
        }
        return false;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a verem klózozott változatát
     */
    private Stack copyStack(Stack stack) {
        Stack copyStack = new Stack();
        for (int i = 0; i < stack.size(); i++) {
            copyStack.add(createCloneTwoTileProperties((TwoTileProperties) stack.get(i)));
        }
        return copyStack;
    }

    //----------------------------------------------------------------------

    /**
     * Betölti a képet egy fáljból
     */
    public void loadImage() {
        MediaTracker tr = new MediaTracker(this);
        String path = dataModule.getBackgroundProperties().getBackgroundType() ==
                BACKGROUND_PICTURE ?
                dataModule.getBackgroundProperties().getPictureBackground().getPath() :
                dataModule.getBackgroundProperties().getTextureBackground().getPath();

        backgroundImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource(
                RESOURCE_PATH + path));

        tr.addImage(backgroundImage, 0);
        try {
            tr.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**
     * A kapott helyek és értékek alapján hoz létre köveket, melyeket
     * el is helyez a pályán. Ha vannak kövek a panelon, akkor azokat
     * nem veszi le, hanem csak hozzáadja az újakat
     */
    public void dealTiles(Vector places, Vector values) {
        for (int i = 0; i < places.size(); i++) {
            Place place = (Place) places.get(i);
            int value = ((Integer) values.get(i)).intValue();
            Tile tile = new Tile(this, place, value);
            setNeihbours(tile);
            tiles.add(tile);
            add(tile, new Integer(place.getLayer()));
        }
        clearChecked();
        new HideManager(this, tiles);
        createOpenTileSelector();
    }

    //----------------------------------------------------------------------

    /**
     * A kövek vizsgáltságát hamisra állítja
     */
    private void clearChecked() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            tile.setChecked(false);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Továbbadja a bal klikkelés tényét, mely valamelyik kövön történt
     * (a köveknek nincs mainFrame referenciájuk)
     */
    public void leftClickInATile(Tile tile) {
        if (dataModule.getNumberOfSelectedTiles() == 2) { // ha már kettő van kijelölve
            compareSelectedTiles(tile);
        }
        stopFlash();
        clearFlashStates();
        mainFrame.leftClick();
        if (tiles.isEmpty()) { // ha elfogytak a kövek
            clearUndoRedo();
            refreshTilePalette(null);
            mainFrame.endOfGame();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Bal klikkelés lekezelése a táblán
     */
    public void leftClick() {
        if (!dataModule.isPause()) { // csak ha nincs felfüggesztve a játék
            stopFlash();
            clearFlashStates();
            clearSelection();
            mainFrame.leftClick();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy hány kőpár vehető le a pályáról
     */
    public int opens() {
        createOpenTileSelector();
        return openTileSelector.pairs();
    }

    //----------------------------------------------------------------------

    /**
     * Sorban megvillogtatja a levehető köveket
     */
    public void help() {
        if (openTileSelector.isEmpty()) // nincs egyetlen levehető pár sem
            return;
        stopFlash();
        clearSelection();
        clearFlashStates();
        flash = new Flash((SameTiles) openTileSelector.firstElement());
        flash.start();
        openTileSelector.moveToBack();
    }

    //----------------------------------------------------------------------

    /**
     * Nullára állítja minden kő villogási állapotát
     */
    private void clearFlashStates() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            if (tile.getFlashState() == Flash.SELECTED) {
                tile.setFlashState(Flash.BASE);
                tile.repaint(); // csak azokat kell újrarajzolni, amelyek meg voltak villantva
            }
            tile.setFlashState(0);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megsemmisíti a villogtatót
     */
    public void stopFlash() {
        if (flash != null)
            flash.stop();
    }

    //----------------------------------------------------------------------

    /**
     * Alulra küldi a kijelölt követ
     */
    public void swapTiles() {
        clearUndoRedo();
        new TileSwapper(tiles, getSelectedTile()).swapTiles();
        dataModule.setShuffleable(shuffleAvailability());
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy van-e lehetőség a cserére.
     */
    public boolean swapAvailability() {
        if (dataModule.getNumberOfSelectedTiles() == 0)
            return false;
        return new TileSwapper(tiles, getSelectedTile()).getSwappingTiles().size() > 1;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja az első kijelölt cserepet
     */
    public Tile getSelectedTile() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            if (tile.isSelected())
                return tile;
        }
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Leveszi az összes követ, megkeveri a helyeiket, majd új köveket
     * helyez el a pályán
     */
    public void shuffle() {
        if (tiles.isEmpty()) // nincs mit keverni
            return;
        clearUndoRedo();

        Vector places = createActualPlaces();
        Vector values = createActualValues();

        buildGoodSolution(places);
        dataModule.orderByPair(values);

        removeAndDealTiles(builder.getOrderedPlaces(), values);
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja egy vektorban a pályán található összes kő helyét
     */
    private Vector createActualPlaces() {
        Vector places = new Vector();
        for (int i = 0; i < tiles.size(); i++) {
            BasicTile tile = (BasicTile) tiles.get(i);
            places.add(tile.getPlace());
        }
        return places;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja egy vektorban a pályán található összes kő értékét
     */
    private Vector createActualValues() {
        Vector values = new Vector();
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            values.add(new Integer(tile.getValue()));
        }
        return values;
    }

    //----------------------------------------------------------------------

    /**
     * Törli a köveket majd újakat készít a kapott helyek és értékek
     * alapján
     */
    public void removeAndDealTiles(Vector places, Vector values) {
        dataModule.setNumberOfSelectedTiles(0);
        removeAll();
        tiles = new Vector();
        dealTiles(places, values);
        add(tilePalette = new TilePalette(this), TILE_PALETTE_LAYER);
        repaint();
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza, hogy a kapott kő melyikkel szomszédos
     */
    private void setNeihbours(BasicTile newTile) {
        for (int i = 0; i < tiles.size(); i++) {
            BasicTile tile = (BasicTile) tiles.get(i);
            tile.setNeighbours(newTile);
        }
    }

    //----------------------------------------------------------------------

    /**
     * Összehasonlítja a két kijelölt követ
     */
    public void compareSelectedTiles(Tile second) {
        Tile first = getFirstSelectedTile(second);
        if (dataModule.match(first.getValue(), second.getValue())) {
            stateChanged(first, second);
            removeTwoTiles(first, second);
            dataModule.setShuffleable(shuffleAvailability());
            if (opens() == 0 && !tiles.isEmpty()) {
                Toolkit.getDefaultToolkit().beep();
            }
        } else { // a két kő nem illik egymáshoz
            first.setSelected(false);
            first.repaint();
            dataModule.decreaseNumberOfSelectedTiles();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Megkeresi azt a követ, amelyik elsőként lett kijelölve
     */
    private Tile getFirstSelectedTile(Tile second) {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            if (tile.isSelected())
                if (!tile.equals(second))
                    return tile;
        }
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Törli mind a két vermet. A clear utasítás nem jó, új referencia kell!
     */
    public void clearUndoRedo() {
        undo = new Stack();
        redo = new Stack();
    }

    //----------------------------------------------------------------------

    /**
     * Levettek két követ
     */
    private void stateChanged(Tile tile_1, Tile tile_2) {
        undo.push(new TwoTileProperties(
                new TileProperties(tile_1.getPlace(), tile_1.getValue()),
                new TileProperties(tile_2.getPlace(), tile_2.getValue())));

        redo = new Stack(); // redo üres lesz
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a két kő tulajdonságainak másolatát
     */
    private TwoTileProperties createCloneTwoTileProperties(
            TwoTileProperties twoTileProperties) {
        try {
            return (TwoTileProperties) twoTileProperties.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Visszatesz két követ, melyek milyenségét a undo-ból veszi ki
     */
    public void undo() {
        if (undo.empty()) // nincs visszavonható lépés
            return;
        stopFlash();
        clearFlashStates();

        TwoTileProperties twoTileProperties = (TwoTileProperties) undo.pop();
        redo.push(createCloneTwoTileProperties(twoTileProperties)); // elmentés az undo-ba

        Vector places = new Vector();
        Vector values = new Vector();

        places.add(twoTileProperties.getTileProperties_1().getPlace());
        places.add(twoTileProperties.getTileProperties_2().getPlace());
        values.add(new Integer(twoTileProperties.getTileProperties_1().getValue()));
        values.add(new Integer(twoTileProperties.getTileProperties_2().getValue()));

        dealTiles(places, values);
        clearSelection();
        dataModule.setNumberOfSelectedTiles(0);
        dataModule.setShuffleable(shuffleAvailability());
    }

    //----------------------------------------------------------------------

    /**
     * Leveszi azt a két követ, amelyek helyükben passzolnak a redo-ból
     * kivett kövekkel
     */
    public void redo() {
        if (redo.empty()) // nincs megismételhető lépés
            return;
        stopFlash();
        clearFlashStates();

        TwoTileProperties twoTileProperties = (TwoTileProperties) redo.pop();
        undo.push(createCloneTwoTileProperties(twoTileProperties)); // elmentés az undo-ba

        removeTwoTiles(getSimilarTile(twoTileProperties.getTileProperties_1()),
                getSimilarTile(twoTileProperties.getTileProperties_2()));
        clearSelection();
        dataModule.setShuffleable(shuffleAvailability());
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja azt a követ amelyik helyben megegyezik a tulaldonságokkal
     */
    private Tile getSimilarTile(TileProperties tileProperties) {
        for (int i = 0; i < tiles.size(); i++) {
            Tile similarTile = (Tile) tiles.get(i);
            if (similarTile.getPlace().equals(tileProperties.getPlace()))
                return similarTile;
        }
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Ha van olyan kő, amelyik ki van jelölve, akkor megszűnteti annak
     * kijelöltségét
     */
    public void clearSelection() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            if (tile.isSelected()) {
                tile.setSelected(false);
                tile.repaint();
            }
        }
        dataModule.setNumberOfSelectedTiles(0);
    }

    //----------------------------------------------------------------------

    /**
     * Leveszi a kapott két követ
     */
    private void removeTwoTiles(BasicTile tile_1, BasicTile tile_2) {
        removeTile(tile_1);
        removeTile(tile_2);

        dataModule.setNumberOfSelectedTiles(0);
    }

    //----------------------------------------------------------------------

    /**
     * Leveszi a kapott követ
     */
    public void removeTile(BasicTile tile) {
        tiles.remove(tile);
        tile.removeFromTable(); // == tile.finalize();
    }

    //----------------------------------------------------------------------

    /**
     * Az összes cserépnek új stílust ad
     */
    public void newStyle() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            tile.loadImages();
            tile.repaint();
        }
        tilePalette.refreshTiles();
    }

    //----------------------------------------------------------------------

    /**
     * Meghatározza a kövek új eltolását
     */
    public void newThreeDimensionalEffect() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            tile.setTileBounds();
        }
        clearChecked();
        new HideManager(this, tiles);
        tilePalette.refreshTiles();
    }

    //----------------------------------------------------------------------

    /**
     * Megváltoztatja a kövek mintázatát
     */
    public void newMarkings() {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            tile.repaint();
        }
        tilePalette.refreshTiles();
    }

    //----------------------------------------------------------------------

    /**
     * Előhívja a helyi menüt
     */
    public void showPopupMenu(MouseEvent e) {
        gamePanelPopupMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    //----------------------------------------------------------------------

    /**
     * Megrajzolja a hátteret
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // kép
        if (dataModule.getBackgroundProperties().getBackgroundType() == BACKGROUND_PICTURE) {
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, this);
            }
        }

        // textúra
//        if (dataModule.getBackgroundProperties().getBackgroundType() == BACKGROUND_TEXTURE) {
//            Graphics2D g2 = (Graphics2D) g;
//
//            BufferedImage bi = new BufferedImage(backgroundImage.getWidth(this),
//                    backgroundImage.getHeight(this),
//                    BufferedImage.TYPE_INT_RGB);
//            Graphics2D big = bi.createGraphics();
//
//            if (backgroundImage != null) {
//                big.drawImage(backgroundImage, 0, 0, this);
//                Rectangle r = new Rectangle(0,
//                        0,
//                        backgroundImage.getWidth(this),
//                        backgroundImage.getHeight(this));
//                TexturePaint tp = new TexturePaint(bi, r);
//                g2.setPaint(tp);
//                g2.fillRect(0, 0, getWidth(), getHeight());
//            }
//        }

        // textúra
        if (dataModule.getBackgroundProperties().getBackgroundType() == BACKGROUND_TEXTURE) {
            if (backgroundImage != null) {
                Graphics2D g2 = (Graphics2D) g;

                BufferedImage bi = new BufferedImage(backgroundImage.getWidth(this),
                        backgroundImage.getHeight(this),
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D big = bi.createGraphics();

                big.drawImage(backgroundImage, 0, 0, this);
                Rectangle r = new Rectangle(0, 0, backgroundImage.getWidth(this), backgroundImage.getHeight(this));
                TexturePaint tp = new TexturePaint(bi, r);
                g2.setPaint(tp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        }


        // gradient
        if (dataModule.getBackgroundProperties().getBackgroundType() == BACKGROUND_GRADIENT) {
            Graphics2D g2 = (Graphics2D) g;

            Gradient gradient = dataModule.getBackgroundProperties().getGradient();
            ColorTheme colorTheme = dataModule.getBackgroundProperties().
                    getColorTheme();

            g2.setPaint(new GradientPaint(calculatedValue(gradient.getX1()),
                    calculatedValue(gradient.getY1()),
                    colorTheme.getColor_2(),
                    calculatedValue(gradient.getX2()),
                    calculatedValue(gradient.getY2()),
                    colorTheme.getColor_1()));
            g2.fill(new Rectangle2D.Double(0,
                    0,
                    getWidth(),
                    getHeight()));
        }
    }

    // fehér háttér a képlopáshoz
    //g.setColor(Color.white);
    //g.fillRect(0, 0, 800, 600);

    public float calculatedValue(float value) {
        if (value == GRADIENT_WIDTH)
            return (float) getWidth();
        if (value == GRADIENT_HEIGHT)
            return (float) getHeight();
        return value;
    }

    //----------------------------------------------------------------------

    void this_mousePressed(MouseEvent e) {
        if (e.getModifiers() == e.BUTTON3_MASK) { // jobb egérkattintás
            showPopupMenu(e);
        }
        if (e.getModifiers() == e.BUTTON1_MASK) { // bal egérkattintás
            leftClick();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja a játék aktuális állapotát egy játékállapot objektumban
     */
    public GameState createGameState(String name) {
        return new GameState(name,
                dataModule.getLayout(),
                dataModule.getPlaces(),
                createActualPlaces(),
                dataModule.getValues(),
                createActualValues(),
                dataModule.getTime().getTime(),
                dataModule.getPenalty(),
                dataModule.getGameNumber(),
                copyStack(undo),
                copyStack(redo),
                dataModule.getRule(),
                tiles.size(),
                openTileSelector.pairs());
    }

    //----------------------------------------------------------------------

    /**
     * Létrehoz egy új párszámláló objektumot
     */
    public void createOpenTileSelector() {
        openTileSelector = new OpenTileSelector(tiles);
    }

    //----------------------------------------------------------------------

    /**
     * Megváltoztatja a kőpaletta láthatóságát
     */
    public void changeTilePaletteVisibility() {
        dataModule.getTilePaletteProperty().setVisible(
                !dataModule.getTilePaletteProperty().isVisible());
        dataModule.saveSettings();
        tilePalette.setVisible(dataModule.getTilePaletteProperty().isVisible());
    }

    //----------------------------------------------------------------------

    /**
     * Rétegszám szerint rendezi a kapott köveket
     */
    private Vector sortOverlappingTiles(Vector overlappingTiles) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            public int compare(Object object_1, Object object_2) {
                Tile tile_1 = (Tile) object_1;
                Tile tile_2 = (Tile) object_2;
                return tile_1.getPlace().getLayer() - tile_2.getPlace().getLayer();
            }
        });
        treeSet.addAll(overlappingTiles);
        return new Vector(treeSet);
    }

    //----------------------------------------------------------------------

    /**
     * A beállítások szerint frissíti a kőpalettát
     */
    public void refreshTilePalette(Tile selectedTile) {
        if (selectedTile == null)
            tilePalette.clearPalette(); // a paletta törlése
        else {
            Vector swappingTiles = new TileSwapper(tiles, selectedTile).getSwappingTiles();
            // csak a kijelölhetők
            if (dataModule.getTilePaletteProperty().getInfoType() == TilePaletteProperty.SELECTABLE) {
                if (selectedTile.selectable()) {
                    tilePalette.buildPalette(swappingTiles);
                } else
                    tilePalette.clearPalette();
            }
            // csak a levehetők
            else if (dataModule.getTilePaletteProperty().getInfoType() == TilePaletteProperty.PAIR) {
                if (new OpenTileSelector(tiles).inPairs(selectedTile)) {
                    tilePalette.buildPalette(swappingTiles);
                } else
                    tilePalette.clearPalette();
            }
            // minden felső kő
            else if (dataModule.getTilePaletteProperty().getInfoType() == TilePaletteProperty.ALL_TOP) {
                if (selectedTile.getAboveTiles().isEmpty()) {
                    tilePalette.buildPalette(swappingTiles);
                } else
                    tilePalette.clearPalette();
            }
            // minden létező kő
            else if (dataModule.getTilePaletteProperty().getInfoType() == TilePaletteProperty.ALL) {
                tilePalette.buildPalette(swappingTiles);
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Eltűnteti illetve megjeleníti az összes követ
     */
    public void pauseResume(boolean hide) {
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = (Tile) tiles.get(i);
            tile.setVisible(hide);
        }

        if (hide) { // ne legyenek elrejtve a kövek
            animation.stop();
            remove(animation);
            repaint();
        } else { // legyenek elrejtve a kövek, legyen animáció
            add(animation, ANIMATION_LAYER);
            animation.start();
        }

    }

    //----------------------------------------------------------------------

    /**
     * A kőpaletta elrejtését helyi menüből is el lehet rejteni, ezért ennek
     * a menüpontnak a beállítását el kell végezni
     */
    public void menuSetting() {
        mainFrame.settingMenuItems();
    }

    //----------------------------------------------------------------------

    public Vector getTiles() {
        return tiles;
    }

    public void setTiles(Vector tiles) {
        this.tiles = tiles;
    }

    public Stack getUndo() {
        return undo;
    }

    public Stack getRedo() {
        return redo;
    }

    public OpenTileSelector getOpenTileSelector() {
        return openTileSelector;
    }

    public TilePalette getTilePalette() {
        return tilePalette;
    }

    public GamePanelPopupMenu getGamePanelPopupMenu() {
        return gamePanelPopupMenu;
    }

    public Builder getBuilder() {
        return builder;
    }
}

class GamePanel_this_mouseAdapter extends java.awt.event.MouseAdapter {
    GamePanel adaptee;

    GamePanel_this_mouseAdapter(GamePanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.this_mousePressed(e);
    }
}







