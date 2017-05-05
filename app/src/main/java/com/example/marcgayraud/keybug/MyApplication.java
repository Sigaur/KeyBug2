package com.example.marcgayraud.keybug;

import android.app.Application;

/**
 * Created by MarcGAYRAUD on 04/05/2017.
 */

public class MyApplication extends Application{
    //private static final Singleton mInstance = new Singleton();

    private BDD m_BDD;
    /*
    private Singleton(){
        m_BDD = new BDD();
    }
    */
    //public static Singleton getInstance(){
        //return mInstance;
    //}

    public BDD getBDD(){
        return m_BDD;
    }

    public void setBDD(BDD bdd){
        this.m_BDD = bdd;
    }
}
