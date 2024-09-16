package org.example.entity;

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
 * A lejátszható hangokat tartalmazó osztály
 */
public class Sounds implements Constants {

    /**
     * A lejátszható hangok
     */
    public static Sound BUBBLE;
    public static Sound CHIRP;
    public static Sound UNDO;
    public static Sound REDO;


    /**
     * Az éppen játszott hang
     */
    public Sound actual;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Sounds() {
    /*
    BUBBLE = new Sound(getClass().getResource(RESOURCE_PATH + SOUND_BUBBLE).getPath());
    CHIRP = new Sound(getClass().getResource(RESOURCE_PATH + SOUND_CHIRP).getPath());
    UNDO = new Sound(getClass().getResource(RESOURCE_PATH + SOUND_UNDO).getPath());
    REDO = new Sound(getClass().getResource(RESOURCE_PATH + SOUND_REDO).getPath());
*/
    }

    //----------------------------------------------------------------------

    /**
     * Először megállítja az aktuálisan játszott hangot, majd elindítja
     * a kapottat
     */
    public void play(Sound sound) {
        if (actual != null)
            actual.stop();
        actual = sound;
        actual.play();
    }

}








