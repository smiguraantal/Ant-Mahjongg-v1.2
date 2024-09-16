package org.example.entity;

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
 * A háttérdialógus beállításait tartalmazó osztály. Ez az interfész a főablak
 * és a háttérdialógus között. A dialógus meghívásakor ezen értékek szerint
 * lesznek beállítva a komponensei. bezárásakor pedig a játékpanel ezen objek-
 * tum adatai alapján állítja be a hátteret.
 */
public class BackgroundProperties implements Constants, Serializable {

    /**
     * A háttér típusa (kép, textúra vagy kitöltési effektus)
     */
    private int backgroundType;

    /**
     * A kiválasztott színátmenet
     */
    private Gradient gradient;

    /**
     * A kiválasztott színséma
     */
    private ColorTheme colorTheme;

    /**
     * A háttérkép elérési útja
     */
    private Background pictureBackground;

    /**
     * A háttérmintázat képének elérési útja
     */
    private Background textureBackground;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public BackgroundProperties(int backgroundType,
                                Background pictureBackground,
                                Background textureBackground,
                                Gradient gradient,
                                ColorTheme colorTheme) {
        this.backgroundType = backgroundType;
        this.pictureBackground = pictureBackground;
        this.textureBackground = textureBackground;
        this.gradient = gradient;
        this.colorTheme = colorTheme;
    }

    //----------------------------------------------------------------------

    /**
     * Konstruktor alapértelmezett adatokkal
     */
    public BackgroundProperties() {
        this(BACKGROUND_PICTURE,
                BACKGROUND_24,
                BACKGROUND_13,
                GRADIENT_01,
                BAMBOO);
    }

    //----------------------------------------------------------------------

    public int getBackgroundType() {
        return backgroundType;
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public Gradient getGradient() {
        return gradient;
    }

    public void setBackgroundType(int backgroundType) {
        this.backgroundType = backgroundType;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public void setGradient(Gradient gradient) {
        this.gradient = gradient;
    }

    public Background getPictureBackground() {
        return pictureBackground;
    }

    public Background getTextureBackground() {
        return textureBackground;
    }

    public void setPictureBackground(Background pictureBackground) {
        this.pictureBackground = pictureBackground;
    }

    public void setTextureBackground(Background textureBackground) {
        this.textureBackground = textureBackground;
    }
}





















