package com.example.marcgayraud.keybug;

/**
 * Created by MarcGAYRAUD on 01/04/2017.
 */

public class Fiche {
    String m_question;
    String m_reponse;
    String m_Name;

    public Fiche(String newName, String newQuestion, String newReponse)
    {
        m_Name = newName;
        m_question = newQuestion;
        m_reponse = newReponse;
    }

    public String getQuestion()
    {
        return m_question;
    }

    public String getName()
    {
        return m_Name;
    }

    public String getReponse()
    {
        return m_reponse;
    }

    public void setQuestion(String newQuestion)
    {
        m_question = newQuestion;
    }

    public void setReponse(String newReponse)
    {
        m_reponse = newReponse;
    }
}
