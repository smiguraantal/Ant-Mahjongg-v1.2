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

public class NumberedGames extends Vector implements Constants, Serializable {

    /**
     * Az értékek előre legyártott kollekciója
     */
    private Vector valuesCollection = new Vector();

    public Vector getValuesCollection() {
        return valuesCollection;
    }
}























