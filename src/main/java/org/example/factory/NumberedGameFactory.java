package org.example.factory;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.NumberedGame;
import org.example.entity.NumberedGames;
import org.example.gui.Builder;
import org.example.gui.layout.Layout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
 * A számozott játékokat legyártó osztály. A program nem használja, hanem
 * én hívom meg a fejlesztés során.
 */
public class NumberedGameFactory implements Constants {

    /**
     * Adatmodul
     */
    private DataModule dataModule = DataModule.getDataModule();

    /**
     * Az elrendezést felépítő objektum
     */
    private Builder builder;

    /**
     * A számozott játékok
     */
    private NumberedGames numberedGames = new NumberedGames();

    /**
     * Ötven darab leosztás készül, melyekből az előredefiniált játékok
     * lesznek elkészítve
     */
    public static int NUMBER_OF_VALUES_COLLECTION = 50;

    //----------------------------------------------------------------------

    /**
     * Konstruktor
     */
    public NumberedGameFactory() {
        for (int i = 0; i < NUMBER_OF_VALUES_COLLECTION; i++) {
            dataModule.createValues();
            numberedGames.getValuesCollection().add(dataModule.getValues());
        }
    }

    //----------------------------------------------------------------------

    /**
     * Létrehoz annyi játékot, amennyit a paraméterében kapott
     */
    public void createNumberedGames(int howMany) {
        for (int rule = 0; rule <= 2; rule++) { // szabályok

            for (int j = 0; j < LAYOUTS.length; j++) { // elrendezésenként
                Layout layout = LAYOUTS[j];

                for (int k = 0; k < howMany; k++) { // ennyi számozott játék lesz mentve elrendezésenként

                    do { // helyek létrehozása
                        builder = new Builder(layout.getPlaces());
                    }
                    while (!builder.succesBuilding()); // amíg nem sikerül felépíteni az elrendezést

                    numberedGames.add(new NumberedGame(rule,
                            layout.getName(),
                            k,
                            builder.getOrderedPlaces(),
                            rnd(NUMBER_OF_VALUES_COLLECTION)));
                }
            }
        }

        writeNumberedGames(numberedGames);
    }

    //----------------------------------------------------------------------

    /**
     * Véletlenszám 0 és max között
     */
    private int rnd(int max) {
        return (int) (Math.random() * max);
    }

    //----------------------------------------------------------------------

    /**
     * Kiírja a megadott beállításokat
     */
    public void writeNumberedGames(Object object) {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("games.dat"));
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
    public NumberedGames readNumberedGames() {
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream("games.dat"));
                NumberedGames numberedGames = (NumberedGames) os.readObject();
            os.close();
            return numberedGames;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    //----------------------------------------------------------------------

    public NumberedGames getNumberedGames() {
        return numberedGames;
    }

}


















