package com.example.marcgayraud.keybug;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.Vector;

/**
 * Created by MarcGAYRAUD on 01/04/2017.
 */

public class BDD{
    public List<Deck> mesDecks = new Vector<Deck>();

    private Deck tempDeck;

    public BDD()
    {

    }

    public void addDeck(String name)
    {
        tempDeck = new Deck(name);
        mesDecks.add(tempDeck);
    }

    public int getNumberDecks()
    {
        return mesDecks.size();
    }

    public String [] getListDeck()
    {
        int temp = this.getNumberDecks();
        String []retour = new String[temp];

        for(int i = 0; i < temp; i++)
        {
            retour[i] = mesDecks.get(i).getName();
        }
        return retour;
    }
}
