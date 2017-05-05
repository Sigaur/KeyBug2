package com.example.marcgayraud.keybug; /**
 * Created by MarcGAYRAUD on 01/04/2017.
 */

import java.util.List;
import java.util.Vector;

public class Deck {

    public List<Fiche> mesFiches = new Vector<Fiche>();
    private String m_name;

    public Deck(String name)
    {
        m_name = name;
    }
    public int getNumberFiches()
    {
        return mesFiches.size();
    }

    public void addFiche(Fiche newFiche)
    {
        mesFiches.add(newFiche);
    }

    public String getName()
    {
        return m_name;
    }

    public String [] getListFiche()
    {
        int temp = this.getNumberFiches();
        String []retour = new String[temp];

        for(int i = 0; i < temp; i++)
        {
            retour[i] = mesFiches.get(i).getName();
        }
        return retour;
    }
}