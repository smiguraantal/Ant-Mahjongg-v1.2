package org.example.entity;

import java.io.Serializable;
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
 * Az elmentett játékokat tároló osztály
 */
public class GameStates extends Vector implements Serializable {

    /**
     * Visszaadja a névhez tartozó elmentett állapotot
     */
    public GameState getGameState(String name) {
        for (int i = 0; i < size(); i++) {
            GameState gameState = (GameState) get(i);
            if (gameState.getName().equals(name))
                return gameState;
        }
        return null;
    }

}








