package com.example.marcgayraud.keybug;

/**
 * Created by MarcGAYRAUD on 04/05/2017.
 */

public class Singleton {
    private static Singleton m_Instance = null;

    private BDD m_BDD;

    private Singleton()
    {
        System.out.println("Trace");
        m_BDD = new BDD();
        m_BDD.addDeck("DECK1");
        m_BDD.addDeck("DECK2");
        m_BDD.addDeck("DECK3");
        m_BDD.addDeck("DECK4");
    }

    public static Singleton getInstance()
    {
        if(m_Instance == null)
        {
            m_Instance = new Singleton();
        }
        return m_Instance;
    }

    public BDD getBDD()
    {
        return this.m_BDD;
    }

    public void setBDD(BDD newBDD)
    {
        m_BDD = newBDD;
    }
}
