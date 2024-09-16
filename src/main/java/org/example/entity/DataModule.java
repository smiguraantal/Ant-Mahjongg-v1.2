package org.example.entity;

import org.example.gui.MainFrame;
import org.example.gui.layout.Layout;

import javax.swing.JLabel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.GregorianCalendar;
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
 * Több osztály számára is fontos adatokat tartalamzó osztály
 */
public class DataModule implements Constants {

    /**
     * Adatmodul
     */
    private static DataModule dataModule;

    /**
     * Kijelölt kövek száma
     */
    private int numberOfSelectedTiles;

    /**
     * A kövek értékeit tartalamzó vektor.
     */
    private Vector values;

    /**
     * A helyeket tartalmazó vektor. Az aktuális elrendezés helyei
     * szerepelnek benne a felépítés sorrendjében.
     */
    private Vector places;

    /**
     * Elrendezés
     */
    private Layout layout;

    /**
     * A kövek stílusa
     */
    private Style style;

    /**
     * A háttérkép elérési útja
     */
    private String backgroundImagePath;

    /**
     * Látszik-e az eszköztár
     */
    private boolean toolBar;

    /**
     * Látszik-e az állapotsor
     */
    private boolean statusBar;

    /**
     * A legutoljára elért rekord
     */
    private Record lastRecord;

    /**
     * Rekordok
     */
    private Records records;

    /**
     * Az eltelt idő
     */
    private Time time = new Time();

    /**
     * A felület
     */
    private int lookAndFeel;

    /**
     * A térhatás
     */
    private ThreeDimensionalEffect threeDimensionalEffect;

    /**
     * Az játék száma. (ha nem számozott játék, akkor 0)
     */
    private int gameNumber;

    /**
     * Az elmentett játékok értékei
     */
    private NumberedGames numberedGames;

    /**
     * Az ablak elhelyezésének pozíciója
     */
    private int windowLocation;

    /**
     * Szabály
     */
    private int rule;

    /**
     * A mentett játékok
     */
    private GameStates gameStates;

    /**
     * A kőpaletta tulajtonságai
     */
    private TilePaletteProperty tilePaletteProperty;

    /**
     * A dialógusablakok a rajtuk keletkezett egérvonszolás esemény
     * után valamiért átadják az alatta elhelyezkedő köveknek a
     * mouseEntered és mouseExited eseményeket. Vagy a rétegek alkalmazása
     * miatt van így, vagy
     * java hiba! Minden dialógus megjelenésekor beállítok egy változót
     * igazra, majd a dialógus elrejtésekor visszaállítom. Ha igaz a
     * változó értéke az kövek egéreseményeit nem endedélyezem.
     */
    private boolean dialogShowing;

    /**
     * A státuszsor, melynek szövegét több helyi menü változtatja
     */
    private JLabel statusLabel;

    /**
     * Az állapotsor tulajdonságai
     */
    private StatusBarProperties statusBarProperties;

    /**
     * Büntetés
     */
    private int penalty;

    /**
     * A kő szélének színtémája
     */
    private ColorTheme colorTheme;

    /**
     * A hangokat tartalmazó objektum
     */
    private Sounds sounds = new Sounds();

    /**
     * Felfüggesztett-e a játék
     */
    private boolean pause;

    /**
     * Animált háttér van-e kiválasztva
     */
    private boolean animatedBackground;

    /**
     * A kiválasztott animáció
     */
    private int animation;

    /**
     * A háttér tulajdonságai
     */
    private BackgroundProperties backgroundProperties;

    /**
     * Visszaadja, hogy az aktuális állás keverhető-e. Ha nem építhető fel
     * egy alakzat, akkor nem is szedhető le, s így nem is keverhető meg.
     */
    private boolean shuffleable = true;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public DataModule() {
        Settings settings = readSettings();
        this.layout = settings.getLayout();
        //this.layout = new WavesLayout(); // új elrendezés írásának teszteléséhez
        this.style = settings.getStyle();
        this.backgroundImagePath = settings.getBackgroundImagePath();
        this.toolBar = settings.isToolBar();
        this.statusBar = settings.isStatusBar();
        this.lastRecord = settings.getLastRecord();
        this.records = settings.getRecords();
        this.lookAndFeel = settings.getLookAndFeel();
        this.threeDimensionalEffect = settings.getThreeDimensionalEffect();
        this.gameNumber = settings.getGameNumber();
        this.windowLocation = settings.getWindowLocation();
        this.rule = settings.getRule();
        this.gameStates = settings.getGameStates();
        this.tilePaletteProperty = settings.getTilePaletteProperty();
        this.statusBarProperties = settings.getStatusBarProperties();
        this.colorTheme = settings.getColorTheme();
        this.animatedBackground = settings.isAnimatedBackground();
        this.animation = settings.getAnimation();
        this.backgroundProperties = settings.getBackgroundProperties();
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja az adatmodult
     */
    public static DataModule getDataModule() {
        if (dataModule == null)
            dataModule = new DataModule();
        return dataModule;
    }

    //----------------------------------------------------------------------

    /**
     * Az osztályadatok alapján visszaad egy objektumot, mely a beállításokat
     * tartalmazza.
     */
    private Settings getSettings() {
        return new Settings(layout,
                style,
                backgroundImagePath,
                toolBar,
                statusBar,
                lastRecord,
                records,
                lookAndFeel,
                threeDimensionalEffect,
                gameNumber,
                windowLocation,
                rule,
                gameStates,
                tilePaletteProperty,
                statusBarProperties,
                colorTheme,
                animatedBackground,
                animation,
                backgroundProperties);
    }

    //----------------------------------------------------------------------

    /**
     * Kiírja a megadott beállításokat
     */
    public void writeSettings(Object object) {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("settings.dat"));
            os.writeObject(object);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //----------------------------------------------------------------------

    /**
     * Beolvassa a beállításokat
     */
    public Settings readSettings() {
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream("settings.dat"));
            Settings settings = (Settings) os.readObject();
            os.close();
            return settings;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Settings();
    }

    //----------------------------------------------------------------------

    /**
     * Menti az összes beállítást
     */
    public void saveSettings() {
        writeSettings(getSettings());
    }

    //----------------------------------------------------------------------

    /**
     * Átadja az időnek a főablak referenciáját, ugyanis azt kell értesítenie
     * minden egyes eltelt másodpercben
     */
    public void bindToTime(MainFrame mainFrame) {
        time.setMainFrame(mainFrame);
    }

    //----------------------------------------------------------------------

    /**
     * Növeli a kijelölt kövek számát
     */
    public void increaseNumberOfSelectedTiles() {
        ++numberOfSelectedTiles;
    }

    //----------------------------------------------------------------------

    /**
     * Csökkenti a kijelölt kövek számát
     */
    public void decreaseNumberOfSelectedTiles() {
        --numberOfSelectedTiles;
    }

    //----------------------------------------------------------------------

    /**
     * Hozzáadja a kapott bűntetőpontokat. Ha az bűntetés túllépné a maximális
     * értéket, akkor lekerekítjük
     */
    public void addPenalty(int seconds) {
        if (penalty < MAX_PENALTY) { // hozzáadás
            penalty += seconds * 100;
            time.addSeconds(seconds);
        }
        if (penalty > MAX_PENALTY) // ha túllépte a maximumot
            penalty = MAX_PENALTY;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott érték évszak-e
     */
    public boolean isSeason(int value) {
        return value >= 34 && value <= 37;
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy a kapott érték virág-e
     */
    public boolean isFlower(int value) {
        return value >= 38 && value <= 41;
    }

    //----------------------------------------------------------------------

    /**
     * Feltölt egy vektort számokkal, melyben a kövek értékei lesznek.
     * Az évszakok és a virágok családjához tartozó kövek egyszer, a többi
     * kő pedig négyszer fog szerepelni a táblán, így az értékek is ennek
     * megfelelően kerülnek be a vektorba.
     */
    public void createValues() {
        values = new Vector();

        for (int i = 0; i <= 33; i++) // körök, bambuszok, írások, szelek, sárkányok
            for (int j = 1; j <= 4; j++) // négyszer kerülnek bele
                values.add(new Integer(i));
        for (int i = 34; i <= 37; i++)  // évszakok
            values.add(new Integer(i));
        for (int i = 38; i <= 41; i++)  // virágok
            values.add(new Integer(i));
        orderByPair(values);
    }

    //----------------------------------------------------------------------

    /**
     * Párosítja az értékeket
     */
    public void orderByPair(Vector values) {
        Collections.shuffle(values);
        for (int i = 0; i < values.size() - 1; i += 2) { // kettőt lép
            for (int j = i + 1; j < values.size(); j++) {
                int first = ((Integer) values.get(i)).intValue();
                int second = ((Integer) values.get(j)).intValue();
                if (match(first, second)) { // ha talál az elsőhöz egy hozzáillőt, akkor mellé teszi
                    values.add(i + 1, values.remove(j));
                    break;
                }
            }
        }
    }

    //----------------------------------------------------------------------

    /**
     * Két kő értékbeli összeillését vizsgálja
     */
    public boolean match(int value_1, int value_2) {
        if (isSeason(value_1) && isSeason(value_2))
            return true;
        if (isFlower(value_1) && isFlower(value_2))
            return true;
        return value_1 == value_2;
    }

    //----------------------------------------------------------------------

    /**
     * Törli a rekordokat, menti a változtatást
     */
    public void resetRecords() {
        records = new Records();
        saveSettings();
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja, hogy született-e új rekord
     */
    public boolean newRecord() {
        // hasonlító objektum készítése
        return new Record("" + Character.MAX_VALUE,
                time.getTime(),
                penalty,
                new GregorianCalendar()).compareTo(
                getActualTopTen().getWorstRecord()) < 0;
    }

    //----------------------------------------------------------------------

    /**
     * Hozzáad egy új rekordot a tíz legjobbhoz a kapott név alapján
     */
    public void addRecord(String player, GregorianCalendar calendar) {
        lastRecord = new Record(player,
                time.getTime(),
                penalty,
                calendar);
        getActualTopTen().addRecord(lastRecord);
        saveSettings();
    }

    //----------------------------------------------------------------------

    /**
     * Visszaadja az aktuális elrendezéshez tartozó rekordot.
     */
    public TopTen getActualTopTen() {
        return records.getTopTen(rule, layout.getName());
    }


    //----------------------------------------------------------------------

    /**
     * Törli a megadott szabályrendszerhez és elrendezéshez tartozó legjobb
     * tíz rekordot.
     */
    public void resetTopTen(int rule, String layoutName) {
        records.getTopTen(rule, layoutName).clear();
        saveSettings();
    }

    //----------------------------------------------------------------------

    /**
     * Hozzáadja az elmentett játékokhoz a kapott játékot, majd kimenti
     * lemezre
     */
    public void addGameState(GameState gameState) {
        gameStates.add(gameState);
        saveSettings();
    }

    //----------------------------------------------------------------------


    /**
     * Felülírja a kapott indexű mentett játékot
     */
    public void overwriteGameState(GameState gameState) {
        for (int i = 0; i < gameStates.size(); i++) {
            if (((GameState) gameStates.get(i)).getName().equals(gameState.getName()))
                gameStates.set(i, gameState);
        }
        saveSettings();
    }

    //----------------------------------------------------------------------

    /**
     * Törli a megadott játékot
     */
    public void deleteGameState(GameState gameState) {
        gameStates.remove(gameState);
        saveSettings();
    }

    //----------------------------------------------------------------------

    /**
     * Törli az összes mentett játékot
     */
    public void deleteAllGameState() {
        gameStates.clear();
        saveSettings();
    }

    //----------------------------------------------------------------------

    /**
     * Az értékeket a számozott játék értékeiből állítja elő
     */
    public void loadNumberedGame() {
        for (int i = 0; i < numberedGames.size(); i++) {
            NumberedGame numberedGame = (NumberedGame) numberedGames.get(i);
            if (numberedGame.getRule() == rule &&
                    numberedGame.getLayoutName().equals(layout.getName()) &&
                    numberedGame.getNumber() == gameNumber - 1) {
                setPlaces(numberedGame.getPlaces());
                setValues((Vector) numberedGames.getValuesCollection().get(numberedGame.getValuesIndex()));
                return;
            }
        }
    }

    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // Beállítások mentéssel
    public void setLayout(Layout layout) {
        this.layout = layout;
        saveSettings();
    }

    public void setStyle(Style style) {
        this.style = style;
        saveSettings();
    }

    public void setBackgroundImagePath(String backgroundImagePath) {
        this.backgroundImagePath = backgroundImagePath;
        saveSettings();
    }

    public void setStatusBar(boolean statusBar) {
        this.statusBar = statusBar;
        saveSettings();
    }

    public void setToolBar(boolean toolBar) {
        this.toolBar = toolBar;
        saveSettings();
    }

    public void setLastRecord(Record lastRecord) {
        this.lastRecord = lastRecord;
        saveSettings();
    }

    public void setRecords(Records records) {
        this.records = records;
        saveSettings();
    }

    public void setLookAndFeel(int lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
        saveSettings();
    }

    public void setThreeDimensionalEffect(ThreeDimensionalEffect threeDimensionalEffect) {
        this.threeDimensionalEffect = threeDimensionalEffect;
        saveSettings();
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
        saveSettings();
    }

    public void setWindowLocation(int windowLocation) {
        this.windowLocation = windowLocation;
        saveSettings();
    }

    public void setRule(int rule) {
        this.rule = rule;
        saveSettings();
    }

    public void setGameStates(GameStates gameStates) {
        this.gameStates = gameStates;
        saveSettings();
    }

    public void setTilePaletteProperty(TilePaletteProperty tilePaletteProperty) {
        this.tilePaletteProperty = tilePaletteProperty;
        saveSettings();
    }

    public void setStatusBarProperties(StatusBarProperties statusBarProperties) {
        this.statusBarProperties = statusBarProperties;
        saveSettings();
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
        saveSettings();
    }

    public void setAnimatedBackground(boolean animatedBackground) {
        this.animatedBackground = animatedBackground;
        saveSettings();
    }

    public void setAnimation(int animation) {
        this.animation = animation;
        saveSettings();
    }

    public void setBackgroundProperties(BackgroundProperties backgroundProperties) {
        this.backgroundProperties = backgroundProperties;
        saveSettings();
    }

    //----------------------------------------------------------------------
    //----------------------------------------------------------------------

    public Layout getLayout() {
        return layout;
    }

    public int getNumberOfSelectedTiles() {
        return numberOfSelectedTiles;
    }

    public void setNumberOfSelectedTiles(int numberOfSelectedTiles) {
        this.numberOfSelectedTiles = numberOfSelectedTiles;
    }

    public Style getStyle() {
        return style;
    }

    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }

    public boolean isStatusBar() {
        return statusBar;
    }

    public boolean isToolBar() {
        return toolBar;
    }

    public Records getRecords() {
        return records;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getLookAndFeel() {
        return lookAndFeel;
    }

    public Vector getValues() {
        return values;
    }

    public void setValues(Vector values) {
        this.values = values;
    }

    public ThreeDimensionalEffect getThreeDimensionalEffect() {
        return threeDimensionalEffect;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public NumberedGames getNumberedGames() {
        return numberedGames;
    }

    public void setNumberedGames(NumberedGames numberedGames) {
        this.numberedGames = numberedGames;
    }

    public int getWindowLocation() {
        return windowLocation;
    }

    public int getRule() {
        return rule;
    }

    public GameStates getGameStates() {
        Collections.sort(gameStates);
        return gameStates;
    }

    public Record getLastRecord() {
        return lastRecord;
    }

    public TilePaletteProperty getTilePaletteProperty() {
        return tilePaletteProperty;
    }

    public boolean isDialogShowing() {
        return dialogShowing;
    }

    public void setDialogShowing(boolean dialogShowing) {
        this.dialogShowing = dialogShowing;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    public StatusBarProperties getStatusBarProperties() {
        return statusBarProperties;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public Sounds getSounds() {
        return sounds;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isAnimatedBackground() {
        return animatedBackground;
    }

    public int getAnimation() {
        return animation;
    }

    public Vector getPlaces() {
        return places;
    }

    public void setPlaces(Vector places) {
        this.places = places;
    }

    public BackgroundProperties getBackgroundProperties() {
        return backgroundProperties;
    }

    public boolean isShuffleable() {
        return shuffleable;
    }

    public void setShuffleable(boolean shuffleable) {
        this.shuffleable = shuffleable;
    }
}






