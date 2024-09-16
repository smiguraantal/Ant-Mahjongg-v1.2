package org.example.entity;

import org.example.gui.layout.Layout;

import java.io.Serializable;

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
 * Az elmentendő illetve visszaolvasandó beállításokat tartalmazó osztály
 */
public class Settings implements Serializable, Constants, Location {

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
     * A felület
     */
    private int lookAndFeel;

    /**
     * A térhatás
     */
    private ThreeDimensionalEffect threeDimensionalEffect;

    /**
     * Az utolsóként kért játék száma
     */
    private int gameNumber;

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
     * Az állapotsor tulajdonságai
     */
    private StatusBarProperties statusBarProperties;

    /**
     * A kő szélének színtémája
     */
    private ColorTheme colorTheme;

    /**
     * Animált háttér van-e kiválasztva
     */
    private boolean animatedBackground;

    /**
     * A kiválasztott animáció
     */
    private int animation;

    /**
     * A háttér fajtája
     */
    private BackgroundProperties backgroundProperties;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Settings(Layout layout,
                    Style style,
                    String backgroundImagePath,
                    boolean toolBar,
                    boolean statusBar,
                    Record lastRecord,
                    Records records,
                    int lookAndFeel,
                    ThreeDimensionalEffect threeDimensionalEffect,
                    int gameNumber,
                    int windowLocation,
                    int rule,
                    GameStates gameStates,
                    TilePaletteProperty tilePaletteProperty,
                    StatusBarProperties statusBarProperties,
                    ColorTheme colorTheme,
                    boolean animatedBackground,
                    int animation,
                    BackgroundProperties backgroundProperties) {
        this.layout = layout;
        this.style = style;
        this.backgroundImagePath = backgroundImagePath;
        this.toolBar = toolBar;
        this.statusBar = statusBar;
        this.lastRecord = lastRecord;
        this.records = records;
        this.lookAndFeel = lookAndFeel;
        this.threeDimensionalEffect = threeDimensionalEffect;
        this.gameNumber = gameNumber;
        this.windowLocation = windowLocation;
        this.rule = rule;
        this.gameStates = gameStates;
        this.tilePaletteProperty = tilePaletteProperty;
        this.statusBarProperties = statusBarProperties;
        this.colorTheme = colorTheme;
        this.animatedBackground = animatedBackground;
        this.animation = animation;
        this.backgroundProperties = backgroundProperties;
    }

    //----------------------------------------------------------------------

    /**
     * Konstruktor alapértelmezett adatokkal
     */
    public Settings() {
        this(CLASSIC_LAYOUT, // elrendezés
                STYLE_PAPER, // stílus
                BACKGROUND_24.getPath(), // háttérkép
                true, // eszköztár
                true, // állapotsor
                new Record(), // utolsó rekorder
                new Records(), // rekordok
                WINDOWS_LOOK_AND_FEEL, // kinézet
                TDE_NORTH_EAST, // térhatás
                0, // számozott játék
                CENTER, // ablak eltolás
                RULE_HORIZONTAL, // szabály
                new GameStates(), // mentett játékok
                new TilePaletteProperty(), // kőpaletta tulajdonságai
                new StatusBarProperties(), // az állapotsor tulajdonságai
                MAHOGANY,  // a kő színsémája
                false, // Animált háttér
                NO_ANIMATION, // a kiválasztott animáció
                new BackgroundProperties()); // a háttér tulajdonságai
    }

    //----------------------------------------------------------------------

    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }

    public Layout getLayout() {
        return layout;
    }

    public Style getStyle() {
        return style;
    }

    public void setBackgroundImagePath(String backgroundImagePath) {
        this.backgroundImagePath = backgroundImagePath;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public boolean isStatusBar() {
        return statusBar;
    }

    public boolean isToolBar() {
        return toolBar;
    }

    public void setToolBar(boolean toolBar) {
        this.toolBar = toolBar;
    }

    public void setStatusBar(boolean statusBar) {
        this.statusBar = statusBar;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    public int getLookAndFeel() {
        return lookAndFeel;
    }

    public void setLookAndFeel(int lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public ThreeDimensionalEffect getThreeDimensionalEffect() {
        return threeDimensionalEffect;
    }

    public void setThreeDimensionalEffect(ThreeDimensionalEffect threeDimensionalEffect) {
        this.threeDimensionalEffect = threeDimensionalEffect;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getWindowLocation() {
        return windowLocation;
    }

    public void setWindowLocation(int windowLocation) {
        this.windowLocation = windowLocation;
    }

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }

    public GameStates getGameStates() {
        return gameStates;
    }

    public void setGameStates(GameStates gameStates) {
        this.gameStates = gameStates;
    }

    public Record getLastRecord() {
        return lastRecord;
    }

    public void setLastRecord(Record lastRecord) {
        this.lastRecord = lastRecord;
    }

    public TilePaletteProperty getTilePaletteProperty() {
        return tilePaletteProperty;
    }

    public void setTilePaletteProperty(TilePaletteProperty tilePaletteProperty) {
        this.tilePaletteProperty = tilePaletteProperty;
    }

    public StatusBarProperties getStatusBarProperties() {
        return statusBarProperties;
    }

    public void setStatusBarProperties(StatusBarProperties statusBarProperties) {
        this.statusBarProperties = statusBarProperties;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public boolean isAnimatedBackground() {
        return animatedBackground;
    }

    public void setAnimatedBackground(boolean animatedBackground) {
        this.animatedBackground = animatedBackground;
    }

    public int getAnimation() {
        return animation;
    }

    public void setAnimation(int animation) {
        this.animation = animation;
    }

    public BackgroundProperties getBackgroundProperties() {
        return backgroundProperties;
    }

    public void setBackgroundProperties(BackgroundProperties backgroundProperties) {
        this.backgroundProperties = backgroundProperties;
    }
}



















