package org.example.entity;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
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
 * Hang osztály
 */
public class Sound {

    /**
     * A lejátszani kívánt hang
     */
    private AudioClip sound = null;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public Sound(String path) {
        try {
            sound = Applet.newAudioClip(
                    new URL("file:///" + new File(path).getAbsolutePath()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**
     * Lejátsza a hangot.
     */
    public void play() {
        sound.play();
    }

    //----------------------------------------------------------------------

    /**
     * Folyamatosan szólaltatja a hangot.
     */
    public void loop() {
        sound.loop();
    }

    //----------------------------------------------------------------------

    /**
     * Elhallgattatja a hangot.
     */
    public void stop() {
        sound.stop();
    }
}









